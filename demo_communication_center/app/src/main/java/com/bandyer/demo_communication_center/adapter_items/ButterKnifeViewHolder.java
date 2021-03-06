package com.bandyer.demo_communication_center.adapter_items;

import android.view.View;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;

import butterknife.ButterKnife;

/**
 * @author kristiyan
 */
abstract class ButterKnifeViewHolder<T extends IItem> extends FastAdapter.ViewHolder<T> {

    ButterKnifeViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}