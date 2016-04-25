package com.app.androidtestapp.androidtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

// to display description and image
public class DetailFragment extends Fragment {

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.iv_image);
        TextView description = (TextView) view.findViewById(R.id.tv_description);
        //displays the text and image in the view
        description.setText(getArguments().getString("desc"));
        Glide.with(getActivity())
                .load(getArguments().getString("image"))
                .into(image);
        return view;
    }

}
