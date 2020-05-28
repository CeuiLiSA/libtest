package ceui.lisa.libtest;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ceui.lisa.base.TActivity;

public class TempActivity extends TActivity {

    @Override
    public Fragment createFragment(@NonNull String fragmentType, @NonNull Intent intent) {
        if(fragmentType.equals("主页")){
            return new TopFragment();
        }
        return null;
    }
}
