package ceui.lisa.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseFragment<Layout extends ViewDataBinding> extends Fragment {

    protected View rootView;
    protected Layout bind;
    protected String className = getClass().getSimpleName();

    protected int mLayoutID = -1;

    protected FragmentActivity mActivity;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Common.log(className + " onCreate");

        mActivity = requireActivity();
        mContext = requireContext();

        Bundle bundle = getArguments();
        if (bundle != null) {
            initBundle(bundle);
        }

        Intent intent = mActivity.getIntent();
        if (intent != null) {
            Bundle activityBundle = intent.getExtras();
            if (activityBundle != null) {
                initActivityBundle(activityBundle);
            }
        }

        if (eventEnable()) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Common.log(className + " onCreateView");

        initLayout();

        if (mLayoutID != -1) {
            bind = DataBindingUtil.inflate(inflater, mLayoutID, container, false);
            if (bind != null) {
                rootView = bind.getRoot();
                return rootView;
            } else {
                return inflater.inflate(mLayoutID, container, false);
            }
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Common.log(className + " onViewCreated");

        initView();
        initData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Common.log(className + " onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Common.log(className + " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Common.log(className + " onDestroy");

        if (eventEnable()) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected abstract void initLayout();

    protected void initBundle(Bundle bundle) {

    }

    protected void initActivityBundle(Bundle bundle) {

    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected boolean eventEnable() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dispatchEvent(Event event) {
        if (className.equals(event.getReceiver())) {
            onEvent(event);
        }
    }

    public void onEvent(Event event) {

    }
}
