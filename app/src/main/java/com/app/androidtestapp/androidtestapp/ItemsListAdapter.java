package com.app.androidtestapp.androidtestapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ItemsListAdapter extends ArrayAdapter<JSONItems> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<JSONItems> mProducts;
    InformationInterface informationInterface;

    public ItemsListAdapter(Context context, int resource, List<JSONItems> objects) {
        super(context, resource, objects);
        mContext = context;
        mProducts = objects;
        informationInterface = (InformationInterface) mContext;
        //creating layout inflater
        mInflater = (LayoutInflater) mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        View rowView = convertView;
        //applying viewholder pattern for better performance
        if(rowView == null){
            rowView = mInflater.inflate(R.layout.listview_item_product_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.description = (TextView) rowView.findViewById(R.id.tv_description);
            viewHolder.imageView = (ImageView) rowView.findViewById(R.id.iv_image);
            //store the holder with the view.
            rowView.setTag(viewHolder);
        }else{
             // we've just avoided calling findViewById() on resource everytime
            viewHolder = (ViewHolder) rowView.getTag();
        }

        viewHolder.description.setText(mProducts.get(position).getDescription());
        //imageloader for loading image from url
        Glide.with(mContext)
                .load(mProducts.get(position).getThumbnail())
                .into(viewHolder.imageView);



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informationInterface.getPositon(position);
            }
        });


        return  rowView;
    }

    class ViewHolder{
        TextView description;
        ImageView imageView;
    }

    public  interface InformationInterface{
        public void getPositon(int position);
    }
}
