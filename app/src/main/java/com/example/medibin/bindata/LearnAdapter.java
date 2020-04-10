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

import com.example.medibin.DataModel;
import com.example.medibin.R;
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

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

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

                ZoomAnimation zoomAnimation = new ZoomAnimation(activity);
                zoomAnimation.zoom(holder.thumbnail, 100);

            }
        });

    }

/*
    private void openDialogue(ClientRatingModel.Datum item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.instagram_layout, null);

        final int[] count = {0};
        final float[] startXValue = {1};

        PhotoView imageZoomHelper = (PhotoView)view.findViewById(R.id.dialog_three_dot3);
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView type = (TextView)view.findViewById(R.id.apptype);
        RatingBar rating = (RatingBar)view.findViewById(R.id.ratingBar);
        CircleImageView profile = (CircleImageView)view.findViewById(R.id.profilePic);
        name.setText(item.getClientName());
        rating.setRating(item.getRating());

        if (item.getAppointmentType().equalsIgnoreCase("USER_LOCATION"))
        {
            type.setText("Concierge service");
        }
        else
        {
            type.setText("Barbershop service");
        }

        Glide.with(context)
                .load(item.getClientProfilePic()).placeholder(R.mipmap.profile_empty_avatar)
                .into(profile);
        if (item.getImages().size()>0) {
            Glide.with(context)
                    .load(item.getImages().get(0).getDocuemntPath()).placeholder(R.mipmap.img_placeholder)
                    .into(imageZoomHelper);
        }
        //ImageZoomHelper.setViewZoomable(imageZoomHelper);

        alertDialog = builder.create();
        alertDialog.setView(view);
        alertDialog.show();
    }
*/


    private static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static long getTime(Date date) {
        long time = date.getTime();

        System.out.println("----------------------------------"+time);
        if (time < 1000000000000L) {
            time *= 1000;
        }

        long now = currentDate().getTime();
        if (time > now || time <= 0) {
            return 1;
        }

        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return 1;
        } else if (diff < 2 * MINUTE_MILLIS) {
            return 1;
        } else if (diff < 60 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS ;
        } else if (diff < 2 * HOUR_MILLIS) {
            return 60;
        }else {
            return 60;
        }
    }
    public static String getTimeAgo(Date date) {
        long time = date.getTime();

        System.out.println("----------------------------------"+time);
        if (time < 1000000000000L) {
            time *= 1000;
        }

        long now = currentDate().getTime();
        if (time > now || time <= 0) {
            return "moments ago";
        }

        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "moments ago";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 60 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 2 * HOUR_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return diff / DAY_MILLIS + " days ago";
        }
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
}
