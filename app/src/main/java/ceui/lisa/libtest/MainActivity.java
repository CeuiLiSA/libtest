package ceui.lisa.libtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

import ceui.lisa.base.BaseActivity;
import ceui.lisa.base.Event;

public class MainActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.activity_main;
    }

    @Override
    protected void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new TopFragment())
                .commitNow();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Event event = new Event();
                event.setReceiver(TopFragment.class.getSimpleName());
                event.setContent("希望看到啊");
                EventBus.getDefault().post(event);
            }
        }, 3000L);
    }
}
