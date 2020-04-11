package com.example.medibin.bindata;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.medibin.DataModel;
import com.example.medibin.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vatsal.imagezoomer.ZoomAnimation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;


public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.MyViewHolder> {

    private static ArrayList<DataModel> data;
    private Context context;
    DisplayImageOptions options;
    AlertDialog alertDialog;
    private ArrayList<DataModel> cartList;

    Activity activity;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price,timeStamp;
        public FrameLayout frameLayout;
        public ImageButton thumbnail;
        public RelativeLayout viewBackground, viewForeground;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            frameLayout= view.findViewById(R.id.rel_appintment);
            thumbnail = view.findViewById(R.id.thumbnail);

        }
    }



    public LearnAdapter(Context context, ArrayList<DataModel> cartList, Activity activity) {
        options = new DisplayImageOptions.Builder().showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true).considerExifParams(true).build();
        this.context = context;
        this.activity = activity;
        this.cartList = cartList;
    }

    @Override
    public LearnAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new LearnAdapter.MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final LearnAdapter.MyViewHolder holder, final int position) {
        final DataModel item = cartList.get(position);
        System.out.println("--------position---------"+position);
        System.out.println("-----------------"+position);
        holder.name.setText(item.getName());
        holder.thumbnail.setImageResource(item.getImage());

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomAnimation zoomAnimation = new ZoomAnimation(activity);
                zoomAnimation.zoom(holder.thumbnail, 100);
            }
        });
       // ImageLoader.getInstance().displayImage(item.getImage(), holder.thumbnail, options);





        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialogue(item.getName(),item.getImage());

              /*  ZoomAnimation zoomAnimation = new ZoomAnimation(activity);
                zoomAnimation.zoom(holder.thumbnail, 100);
*/
            }
        });

    }


    @Override
    public int getItemCount() {

        return cartList.size();
    }

    public void removeItem(int position) {
        cartList.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(DataModel item, int position) {
        cartList.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }
    private void openDialogue(String name1, int image) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.zooming_layout, null);

        final int[] count = {0};
        final float[] startXValue = {1};

        PhotoView imageZoomHelper = (PhotoView)view.findViewById(R.id.dialog_three_dot3);
        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(name1);



            Glide.with(activity)
                    .load(image)
                    .into(imageZoomHelper);

        //ImageZoomHelper.setViewZoomable(imageZoomHelper);

        alertDialog = builder.create();
        alertDialog.setView(view);
        alertDialog.show();
    }

}
