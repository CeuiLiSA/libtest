package ceui.lisa.base;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

public class Common {

    public static void log(Object object) {
        Log.d(" ==> ", String.valueOf(object));
    }

    public static void sendEvent(Event e) {
        EventBus.getDefault().post(e);
    }
}
