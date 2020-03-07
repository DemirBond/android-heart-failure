package com.szg_tech.hearthfailure.fragments.auth;

import androidx.recyclerview.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;

/**
 * Created by Simple Design on 3/13/2018.
 */

public interface AuthView extends MVPView{
    RecyclerView getRecyclerView();
}
