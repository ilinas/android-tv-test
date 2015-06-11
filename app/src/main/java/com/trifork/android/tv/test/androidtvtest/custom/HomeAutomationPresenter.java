package com.trifork.android.tv.test.androidtvtest.custom;

import android.graphics.Color;
import android.support.v17.leanback.widget.Presenter;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trifork.android.tv.test.androidtvtest.R;

public class HomeAutomationPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        TextView view = new TextView(parent.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(300, 150));
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setBackgroundColor(parent.getContext().getResources().getColor(R.color.default_background));
        view.setTextColor(Color.GREEN);
        view.setGravity(Gravity.CENTER);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        Device device = (Device) item;
        ((TextView) viewHolder.view).setText(device.getName());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
