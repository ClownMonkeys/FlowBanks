package com.tydk.ljyh.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
* <b>类名称：</b>ActivityCollector<br/>
* <b>类描述：</b><br/>
* <b>创建人：</b>qudapeng<br/>
* <b>修改人：</b>qudapeng<br/>
* <b>修改时间：</b>2016-1-8 下午1:27:07<br/>
* <b>修改备注：</b><br/>
* @version 1.0.0<br/>
*/
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    //添加一个活动
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //清除一个活动
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //销毁所有活动
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
