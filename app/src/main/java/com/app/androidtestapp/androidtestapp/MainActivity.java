package com.app.androidtestapp.androidtestapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ResponseService, ItemsListAdapter.InformationInterface {

    private MainActivityFragment listFragment;
    private ArrayList<JSONItems> itemsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebInterfaceManager webInterfaceManager = new WebInterfaceManager(this);
        listFragment = new MainActivityFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_fragmentArea, listFragment).commit();
        webInterfaceManager.getProductData();
    }

    @Override
    public void onResponseReceived(String string, boolean status) {
        if(!status){
            Toast.makeText(this, getResources().getString(R.string.message_network_error),
                    Toast.LENGTH_LONG).show();
            return;
        }

        //call for processing the data and updating the listview
        DataProcessor processor = new DataProcessor(string);
        itemsArrayList = processor.processData();
        FragmentInterface fragmentInterface = listFragment;
        fragmentInterface.passData(itemsArrayList);
    }

    @Override
    public void getPositon(int position) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("image", itemsArrayList.get(position).getImage());
        bundle.putString("desc", itemsArrayList.get(position).getDescription());
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_fragmentArea, fragment).commit();
    }
    //interface to pass data to fragment
    public  interface FragmentInterface{
        public void passData(ArrayList<JSONItems> items);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
