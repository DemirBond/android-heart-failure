package com.szg_tech.hearthfailure.fragments.output;

import androidx.recyclerview.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;

interface OutputView extends MVPView {
    RecyclerView getRecyclerView();

}
