package ceui.lisa.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected int mLayoutID = -1;
    protected FragmentActivity mActivity;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
        mContext = this;

        initLayout();

        if (mLayoutID != -1) {
            setContentView(mLayoutID);
        }

        initView();
        initData();
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected abstract void initLayout();
}
