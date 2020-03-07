package com.szg_tech.hearthfailure.fragments.saved_evaluation_list;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.szg_tech.hearthfailure.core.MVPView;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public interface SavedEvaluationView extends MVPView {
    RecyclerView getRecyclerView();

    View getNoDataView();
}
