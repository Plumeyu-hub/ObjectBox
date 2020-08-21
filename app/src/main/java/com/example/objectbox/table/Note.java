package com.example.objectbox.table;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Note数据表
 *
 * @author wangshy
 * @date 2020/08/19
 */
//序列化实体类 Entity必加
@Entity
public class Note {
    //ObjectBox的实体必须要有一个long类型的@Id属性，
    // 为了方便获取和引用对象，
    // 当然也可以使用java.lang.Long,但是官方不推荐使用。
    // 默认的情况下，一旦entity持久化，
    // Objectbox就会分配一个ID给这个实体，可以不用管。
    @Id
    public long id;
    //ObjectBox获取实体属性的数据，不用加注解
    //@Index：这个对象中的索引。对经常大量进行查询的字段创建索引，会提高你的查询性能。
    //@Transient:如果你有某个字段不想被持久化，可以使用此注解,那么该字段将不会保存到数据库
    //@NameInDb("")：有的时候数据库中的字段跟你的对象字段不匹配的时候，可以使用此注解。这个定义在数据库当中该属性的名称,定义这个之后，后面更改Java层面的属性名并不影响数据库
    public String text;
    public Date createAt;
}
