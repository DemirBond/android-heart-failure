package com.szg_tech.hearthfailure.fragments.tab_fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurableFragment;
import com.szg_tech.hearthfailure.core.views.ButtonWithChevron;

public class TabFragment extends ConfigurableFragment implements TabFragmentView {
    TabFragmentPresenter presenter = createPresenter();
    TabLayout tabLayout;
    ViewPager viewPager;
    ButtonWithChevron bottomButton;

    @Override
    public TabFragmentPresenter createPresenter() {
        return new TabFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        bottomButton = (ButtonWithChevron) view.findViewById(R.id.bottom_button);
        bottomButton.setOnClickListener(v -> presenter.onBottomButtonClick());
        presenter.onCreate();
    }

    @Override
    public TabLayout getTabLayout() {
        return tabLayout;
    }

    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }

    public ButtonWithChevron getBottomButton() {
        return bottomButton;
    }
}
