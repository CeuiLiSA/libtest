package ceui.lisa.libtest;


import org.greenrobot.eventbus.EventBus;

import ceui.lisa.base.BaseFragment;
import ceui.lisa.base.Event;
import ceui.lisa.libtest.databinding.FragmentFuckBinding;

public class TopFragment extends BaseFragment<FragmentFuckBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_fuck;
    }

    @Override
    public void onEvent(Event event) {
        super.onEvent(event);
        bind.contentText.setText(String.valueOf(event.getContent()));
    }

    @Override
    protected boolean eventEnable() {
        return true;
    }
}
