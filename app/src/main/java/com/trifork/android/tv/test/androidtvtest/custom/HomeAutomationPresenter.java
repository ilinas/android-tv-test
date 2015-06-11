package com.trifork.android.tv.test.androidtvtest.custom;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trifork.android.tv.test.androidtvtest.R;

public class HomeAutomationPresenter extends Presenter {

    private ImageView img;
    private TextView text;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View deviceCard = inflater.inflate(R.layout.device_card, null);

        img = (ImageView) deviceCard.findViewById(R.id.device_img);
        text = (TextView) deviceCard.findViewById(R.id.device_text);

        return new ViewHolder(deviceCard);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {

        Device device = (Device) item;

        img.setImageDrawable(viewHolder.view.getResources().getDrawable(device.getImageId()));
        text.setText(device.getName());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
