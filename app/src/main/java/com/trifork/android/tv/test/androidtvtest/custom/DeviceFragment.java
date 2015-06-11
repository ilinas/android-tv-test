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
        TextView textMinValue = (TextView) mainView.findViewById(R.id.txt_min_value);
        TextView textMaxValue = (TextView) mainView.findViewById(R.id.txt_max_value);
        final TextView textValue = (TextView) mainView.findViewById(R.id.txt_value_field);
        SeekBar slider = (SeekBar) mainView.findViewById(R.id.device_control_slider);

        Device device = (Device) getActivity().getIntent().getSerializableExtra(DeviceActivity.DEVICE_EXTRA);

        text.setText(device.getName());
        slider.setProgress(device.getValue());
        slider.setMax(device.getMaxVal());
        textValue.setText(String.valueOf(slider.getProgress()));
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        textMinValue.setText(String.valueOf(device.getMinVal()));
        textMaxValue.setText(String.valueOf(device.getMaxVal()));

        return mainView;
    }
}
