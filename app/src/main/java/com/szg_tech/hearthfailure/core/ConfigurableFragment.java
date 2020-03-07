package com.szg_tech.hearthfailure.core;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;

public class ConfigurableFragment extends Fragment implements MVPView {
    @Override
    public Presenter createPresenter() {
        return null;
    }

    @Override
    public void startActivity(Class<? extends Activity> activityClass) {
        Activity activity = getActivity();
        if (activity instanceof MVPView) {
            ((MVPView) activity).startActivity(activityClass);
        } else {
            activity.startActivity(new Intent(activity, activityClass));
        }
    }
}
