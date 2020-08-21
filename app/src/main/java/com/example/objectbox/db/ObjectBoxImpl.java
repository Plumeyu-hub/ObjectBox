package com.example.objectbox.db;

import com.example.objectbox.ObjectBox;
import com.example.objectbox.table.Note;
import com.example.objectbox.table.Note_;

import java.util.Date;
import java.util.List;

import io.objectbox.Box;

/**
 * ObjectBox实现类
 *
 * @author wangshy
 * @date 2020/08/21
 */
public class ObjectBoxImpl implements DbHelper {
    /**
     * 保存信息（成功返回true，失败返回false）
     */
    @Override
    public boolean saveInfo(String text) {
        Box<Note> noteBox = ObjectBox.getmBoxStore().boxFor(Note.class);
        Note note = new Note();
        note.text = text;
        note.createAt = new Date();
        noteBox.put(note);
        return true;
    }

    /**
     * 删除指定信息（成功返回true，失败返回false）
     */
    @Override
    public boolean deleteInfo(Note note) {
        Box<Note> noteBox = ObjectBox.getmBoxStore().boxFor(Note.class);
        noteBox.remove(note);
        return true;
    }

    /**
     * 查询所有信息（插入成功返回true，失败返回false）
     */
    @Override
    public List<Note> getAllInfo() {
        Box<Note> noteBox = ObjectBox.getmBoxStore().boxFor(Note.class);

        return noteBox.query().order(Note_.text).build().find();
    }
}
