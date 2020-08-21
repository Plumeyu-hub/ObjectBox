package com.example.objectbox.db;

/**
 * 数据工厂
 *
 * @author wangshy
 * @date 2020/08/21
 */
public class DbFactory {
    private DbFactory() {
    }

    public static DbHelper create() {
        return new ObjectBoxImpl();
    }
}
