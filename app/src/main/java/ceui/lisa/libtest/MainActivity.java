package ceui.lisa.libtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ceui.lisa.base.BaseActivity;
import ceui.lisa.base.Common;
import ceui.lisa.base.Event;
import ceui.lisa.base.Params;

public class MainActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.activity_main;
    }

    @Override
    protected void initData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, TempActivity.class);
                intent.putExtra(Params.FRAG_TYPE, "主页");
                startActivity(intent);
            }
        }, 3000L);
    }
}
