package com.app.androidtestapp.androidtestapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment implements MainActivity.FragmentInterface {

    private ListView listView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_main, container, false);
        listView= (ListView) view.findViewById(R.id.lv_listview);
        return view;
    }

    @Override
    public void passData(ArrayList<JSONItems> items) {
        ItemsListAdapter listAdapter = new ItemsListAdapter(getActivity(), R.layout.listview_item_product_list, items);
        listView.setAdapter(listAdapter);
    }
}
