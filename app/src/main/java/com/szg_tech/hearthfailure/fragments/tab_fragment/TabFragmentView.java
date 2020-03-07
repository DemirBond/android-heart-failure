package com.szg_tech.hearthfailure.fragments.tab_fragment;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.szg_tech.hearthfailure.core.MVPView;
import com.szg_tech.hearthfailure.core.views.ButtonWithChevron;

interface TabFragmentView extends MVPView {
    TabLayout getTabLayout();

    Bundle getArguments();

    ViewPager getViewPager();

    FragmentManager getChildFragmentManager();

    ButtonWithChevron getBottomButton();
}
