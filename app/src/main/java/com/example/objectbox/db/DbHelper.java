package com.example.objectbox.db;

import com.example.objectbox.table.Note;

import java.util.List;

/**
 * 数据库业务接口
 *
 * @author wangshy
 * @date 2020/08/21
 */
public interface DbHelper {
    /**
     * 保存信息（成功返回true，失败返回false）
     */
    boolean saveInfo(String text);

    /**
     * 删除指定信息（成功返回true，失败返回false）
     */
    boolean deleteInfo(Note note);

    /**
     * 查询所有信息
     */
    List<Note> getAllInfo();
}
