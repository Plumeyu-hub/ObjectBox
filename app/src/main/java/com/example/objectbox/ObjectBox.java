package com.example.objectbox;

import android.content.Context;
import android.util.Log;

import com.example.objectbox.table.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

/**
 * @author wangshy
 * @date 2020/08/20
 */
public class ObjectBox {
    private static BoxStore mBoxStore;

    public static void init(Context context) {
        //第一次没运行之前，MyObjectBox默认会有报错提示，可以忽略。
        //先创建数据库映射的实体类，然后点击Make Project(小锤子)之后，报错就会不提示
        mBoxStore = MyObjectBox.builder().androidContext(context.getApplicationContext()).build();
        //支持浏览器查看数据库数据，添加以下代码
        if (BuildConfig.DEBUG) {//开启浏览器访问ObjectBox
            new AndroidObjectBrowser(ObjectBox.mBoxStore).start(context.getApplicationContext());
            //手机连接adb，使用电脑浏览器访问：http://localhost:8090/index.html
            //或者运行程序找到 logcat 输入关键字ObjectBrowser，点击网站打开即可
            //如果打开失败执行在 Terminal的Local执行如下命令：
            //adb forward tcp：8090 tcp：8090，然后再刷新浏览器
            Log.d("ObjectBrowser", "Started: $started");
        }
    }

    public static BoxStore getmBoxStore() {
        return mBoxStore;
    }
}
