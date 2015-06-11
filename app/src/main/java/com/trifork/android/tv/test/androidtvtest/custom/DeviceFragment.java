package com.trifork.android.tv.test.androidtvtest.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.trifork.android.tv.test.androidtvtest.R;

public class DeviceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.device_control, container, false);
        TextView text = (TextView) mainView.findViewById(R.id.device_control_text);
        SeekBar slider = (SeekBar) mainView.findViewById(R.id.device_control_slider);

        Device device = (Device) getActivity().getIntent().getSerializableExtra(DeviceActivity.DEVICE_EXTRA);

        text.setText(device.getName());
        slider.setProgress(device.getValue());
        slider.setMax(device.getMaxVal());

        return mainView;
    }
}
