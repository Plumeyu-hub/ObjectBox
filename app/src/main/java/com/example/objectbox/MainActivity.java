package com.example.objectbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.objectbox.daapter.NoteAdapter;
import com.example.objectbox.db.DbFactory;
import com.example.objectbox.table.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.note_edit)
    EditText mNoteEdit;
    @BindView(R.id.add_note_btn)
    Button mAddNoteBtn;
    @BindView(R.id.note_rv)
    RecyclerView mNoteRv;
    private NoteAdapter mNoteAdapter;
    private List<Note> mNoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        setListeners();
    }

    private void initView() {
        mNoteList = new ArrayList<>();
        mNoteAdapter = new NoteAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mNoteRv.setLayoutManager(layoutManager);
        mNoteRv.setHasFixedSize(true);
        mNoteRv.setAdapter(mNoteAdapter);
        update();
    }

    private void setListeners() {
        mAddNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
            }
        });

        mNoteAdapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                removeNote(mNoteList.get(position));
            }
        });
    }

    //增
    public void addNote() {
        String text = mNoteEdit.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mNoteEdit.setText("");

        boolean isSaveSuccess = DbFactory.create().saveInfo(text);
        if (!isSaveSuccess) {
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();

        update();
    }

    //删
    public void removeNote(Note note) {
        boolean isDeleteSuccess = DbFactory.create().deleteInfo(note);
        if (!isDeleteSuccess) {
            Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();

        update();
    }

    //更新
    private void update() {
        mNoteList.clear();
        mNoteList = DbFactory.create().getAllInfo();
        mNoteAdapter.setmNoteList(mNoteList);
        mNoteAdapter.notifyDataSetChanged();
    }

}