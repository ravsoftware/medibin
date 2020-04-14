package com.example.medibin.bindata;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.medibin.DataModel;
import com.example.medibin.Preference;
import com.example.medibin.R;

import net.crosp.libs.android.circletimeview.CircleTimeView;

import java.util.ArrayList;

public class BlueDustBinNew extends AppCompatActivity implements View.OnClickListener {


    private RelativeLayout blue,red,yellow,white;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    ImageView removeView;


    CircleTimeView circleTimeView;
    Preference socitreepreference;

    private int started = 0;
    private Boolean timeOut = false;

    private Boolean nextQuestian = false;

    Button nextBtn;

    ImageView green1,red1,green2,red2,green3,red3,green4,red4,item1,item2,item3,item4;

    private static final String IMAGE_VIEW_TAG = "LAUNCHER LOGO";

    private static final String IMAGE_VIEW_TAG1 = "LAUNCHER LOGO1";

    private static final String IMAGE_VIEW_TAG2 = "LAUNCHER LOGO2";
    private static final String IMAGE_VIEW_TAG3 = "LAUNCHER LOGO2";

    Integer items = 0,displayedItems = 0,totalScore = 0, countItems = 0;

    private LearnAdapter mAdapter;


    private static TextView total, display, score, name;
    DonutProgress timer;
    Bundle bundle;
    Toolbar toolbar;

    String title = "";

    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;

    private final long startTime = 15 * 1000;
    private final long interval = 1 * 1000;

   /* MyCountDownTimer countDownTimer = new MyCountDownTimer(15000 *//* 20 Sec *//*,
            1000);*/

    //ImageView item1,item2,item3,item4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_dust_bin_new);


        socitreepreference = Preference.getInstance(this);
        bundle = getIntent().getExtras();
        //getting the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);



        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        green1 = (ImageView) findViewById(R.id.green1);
        green2 = (ImageView) findViewById(R.id.green2);
        green3 = (ImageView) findViewById(R.id.green3);
        green4 = (ImageView) findViewById(R.id.green4);

        red1 = (ImageView) findViewById(R.id.red1);
        red2 = (ImageView) findViewById(R.id.red2);
        red3 = (ImageView) findViewById(R.id.red3);
        red4 = (ImageView) findViewById(R.id.red4);

        item1 = (ImageView) findViewById(R.id.bluebin);
        item2 = (ImageView) findViewById(R.id.redbin);
        item3 = (ImageView) findViewById(R.id.yellowbin);
        item4 = (ImageView) findViewById(R.id.greenbin);

        blue = (RelativeLayout) findViewById(R.id.blue);
        red = (RelativeLayout) findViewById(R.id.red);
        yellow = (RelativeLayout) findViewById(R.id.yellow);
        white = (RelativeLayout) findViewById(R.id.green);

        blue.setBackgroundColor(Color.parseColor("#00BCD4"));
        red.setBackgroundColor(Color.TRANSPARENT);
        yellow.setBackgroundColor(Color.TRANSPARENT);
        white.setBackgroundColor(Color.TRANSPARENT);


        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);


//add or remove any layout view that you don't want to accept dragged view



        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        if (bundle != null)
        {


            toolbar.setTitle(bundle.getString("title"));

            data = new ArrayList<DataModel>();

            for (int i = 0; i < BlueBinData.nameArray.length; i++) {
                data.add(new DataModel(
                        BlueBinData.nameArray[i],
                        BlueBinData.versionArray[i],
                        i,
                        BlueBinData.drawableArray[i]
                ));
            }
              
        }



        mAdapter = new LearnAdapter(getApplicationContext(), data, this);
        recyclerView.setAdapter(mAdapter);

       /* adapter = new CustomAdapter(getApplicationContext(),data);
        recyclerView.setAdapter(adapter);
*/



        }





    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

        if (v == item1)
        {
            blue.setBackgroundColor(Color.parseColor("#00BCD4"));
            red.setBackgroundColor(Color.TRANSPARENT);
            yellow.setBackgroundColor(Color.TRANSPARENT);
            white.setBackgroundColor(Color.TRANSPARENT);


            data.clear();
            for (int i = 0; i < BlueBinData.nameArray.length; i++) {
                data.add(new DataModel(
                        BlueBinData.nameArray[i],
                        BlueBinData.versionArray[i],
                        i,
                        BlueBinData.drawableArray[i]
                ));
            }
            mAdapter.notifyDataSetChanged();

        }
        else if (v == item2)
        {

            blue.setBackgroundColor(Color.TRANSPARENT);
            red.setBackgroundColor(Color.parseColor("#00BCD4"));
            yellow.setBackgroundColor(Color.TRANSPARENT);
            white.setBackgroundColor(Color.TRANSPARENT);


            data.clear();
            for (int i = 0; i < RedBinData.nameArray.length; i++) {
                data.add(new DataModel(
                        RedBinData.nameArray[i],
                        RedBinData.versionArray[i],
                        i,
                        RedBinData.drawableArray[i]
                ));
            }
            mAdapter.notifyDataSetChanged();
        }
        else if (v == item3)
        {
            blue.setBackgroundColor(Color.TRANSPARENT);
            red.setBackgroundColor(Color.TRANSPARENT);
            yellow.setBackgroundColor(Color.parseColor("#00BCD4"));
            white.setBackgroundColor(Color.TRANSPARENT);

            data.clear();
            for (int i = 0; i < YellowBinData.nameArray.length; i++) {
                data.add(new DataModel(
                        YellowBinData.nameArray[i],
                        YellowBinData.versionArray[i],
                        i,
                        YellowBinData.drawableArray[i]
                ));
            }
            mAdapter.notifyDataSetChanged();
        }
        else if (v == item4)
        {

            blue.setBackgroundColor(Color.TRANSPARENT);
            red.setBackgroundColor(Color.TRANSPARENT);
            yellow.setBackgroundColor(Color.TRANSPARENT);
            white.setBackgroundColor(Color.parseColor("#00BCD4"));


            data.clear();
            for (int i = 0; i < WhitBinData.nameArray.length; i++) {
                data.add(new DataModel(
                        WhitBinData.nameArray[i],
                        WhitBinData.versionArray[i],
                        i,
                        WhitBinData.drawableArray[i]
                ));
            }
            mAdapter.notifyDataSetChanged();
        }

    }

    private void callClearTick() {
        green1.setVisibility(View.GONE);
        green2.setVisibility(View.GONE);
        green3.setVisibility(View.GONE);
        green4.setVisibility(View.GONE);
        red1.setVisibility(View.GONE);
        red2.setVisibility(View.GONE);
        red3.setVisibility(View.GONE);
        red4.setVisibility(View.GONE);
    }


}
