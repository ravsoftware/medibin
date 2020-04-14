package com.example.medibin;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medibin.bindata.InfoData;
import com.example.medibin.bindata.DonutProgress;

import net.crosp.libs.android.circletimeview.CircleTimeView;

import java.util.ArrayList;

public class BlueDustBin extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener, View.OnClickListener {


    private RelativeLayout parentLinearLayout;
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

    Integer items = 0,displayedItems = 1,totalScore = 0, countItems = 0;

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
        setContentView(R.layout.activity_blue_dust_bin);


        socitreepreference = Preference.getInstance(this);
        bundle = getIntent().getExtras();
        //getting the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        parentLinearLayout = (RelativeLayout) findViewById(R.id.toplayout);

        circleTimeView = (CircleTimeView) findViewById(R.id.circle_timer_view);


        total = (TextView) findViewById(R.id.items);
        display = (TextView) findViewById(R.id.display);
        score = (TextView) findViewById(R.id.score);

        nextBtn = (Button) findViewById(R.id.next);
        timer = (DonutProgress) findViewById(R.id.timer);

        timer.setProgress(15);
        name = (TextView) findViewById(R.id.name);

        timer.setTextColor(Color.parseColor("#ffffff"));
        //setting the title


        circleTimeView.setCurrentTime(600);



        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);
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


        nextBtn.setOnClickListener(this);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);


//add or remove any layout view that you don't want to accept dragged view

        findViewById(R.id.toplayout).setTag("main");
        findViewById(R.id.abovetop).setTag("above");

        findViewById(R.id.blue).setTag("blue");
        findViewById(R.id.red).setTag("red");
        findViewById(R.id.yellow).setTag("yellow");
        findViewById(R.id.green).setTag("green");

        findViewById(R.id.blue).setOnDragListener(this);
        findViewById(R.id.red).setOnDragListener(this);
        findViewById(R.id.yellow).setOnDragListener(this);
        findViewById(R.id.green).setOnDragListener(this);

        //findViewById(R.id.toplayout).setOnDragListener(this);
        findViewById(R.id.abovetop).setOnDragListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        DividerItemDecoration verticalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);
        Drawable verticalDivider = ContextCompat.getDrawable(getApplicationContext(), R.drawable.vertical_divider);
        verticalDecoration.setDrawable(verticalDivider);
        recyclerView.addItemDecoration(verticalDecoration);

        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getApplicationContext(), R.drawable.vertical_divider);
        horizontalDecoration.setDrawable(horizontalDivider);




        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        System.out.println("                   start                    "+ socitreepreference.getStart());
        System.out.println("                   end                    "+ socitreepreference.getEnd());

        if (bundle != null)
        {

            callSatrtEnd();



            title = bundle.getString("key");
           // toolbar.setTitle(bundle.getString("title"));

        }
        else {

        }

        items = data.size();
        //displayedItems = data.size();
        total.setText(items.toString());

        if (displayedItems == items)
        {
            nextBtn.setVisibility(View.GONE);
        }
        display.setText(displayedItems.toString());
        score.setText(totalScore.toString());
        removedItems = new ArrayList<Integer>();

        countItems = data.size();

        if (countItems > 0) {
            name.setText(data.get(countItems - 1).getName());
        }

        System.out.println("        data size     "+data.size());

        onAddField(data);

        showAlertDialogStart(R.layout.start_dialoque);

       /* adapter = new CustomAdapter(getApplicationContext(),data);
        recyclerView.setAdapter(adapter);
*/

        circleTimeView.setCircleTimeListener(new CircleTimeView.CircleTimeListener() {
            @Override
            public void onTimeManuallySet(long time) {
                Log.d("TIME LISTENER", "onTimeManuallySet " + time);
            }

            @Override
            public void onTimeManuallyChanged(long time) {
                Log.d("TIME LISTENER", "onTimeManuallyChanged " + time);
            }

            @Override
            public void onTimeUpdated(long time) {
                Log.d("TIME LISTENER", "onTimeUpdated " + time);
            }
        });

        circleTimeView.setCircleTimerListener(new CircleTimeView.CircleTimerListener() {
            @Override
            public void onTimerStop() {
                Log.d("TIMER LISTENER", "onTimerStop ");

                if (circleTimeView.getCurrentTimeInSeconds() == 0) {
                    showAlertDialog(R.layout.positive_dialoque);
                }



            }

            @Override
            public void onTimerStart(long time) {
                Log.d("TIMER LISTENER", "onTimerStart " + time);
            }

            @Override
            public void onTimerTimeValueChanged(long time) {
                Log.d("TIMER LISTENER", "onTimerTimeValueChanged " + time);




            }
        });


        }

    private void callSatrtEnd() {


        if (socitreepreference.getStart() == null)
        {
            socitreepreference.putStart("0");
            socitreepreference.putEnd("29");
            data = new ArrayList<DataModel>();
            for (int i = 0; i < 30; i++) {
                data.add(new DataModel(
                        InfoData.nameArray[i],
                        InfoData.versionArray[i],
                        i,
                        InfoData.drawableArray[i]
                ));
            }
        }
        else
        {

            int star = Integer.parseInt(socitreepreference.getStart());
            int end = Integer.parseInt(socitreepreference.getEnd());




            data = new ArrayList<DataModel>();


            for (int i = 0; i < 30; i++) {

                end = end +1;

                if (end >100)
                {
                    end =0;
                }

                if (i == 0) {

                    socitreepreference.putStart(String.valueOf(end));
                }

                if (i == 29) {

                    socitreepreference.putEnd(String.valueOf(end));
                }

                if (end >= 87 && end < 101)
                {

                    data.add(new DataModel(
                            InfoData.nameArray[end],
                            InfoData.versionArray[end],
                            end,
                            InfoData.drawableArray[end]
                    ));
                }
                else if (end < 88){
                    data.add(new DataModel(
                            InfoData.nameArray[end],
                            InfoData.versionArray[end],
                            end,
                            InfoData.drawableArray[end]
                    ));
                }


            }

        }
    }

    private String getDurationString(int seconds) {

       // int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        String totalString ="";
        String totalString1 ="";

        if (!twoDigitString(minutes).isEmpty()) {
            totalString =twoDigitString(minutes)+" Min ";
        }

        if (!twoDigitString(seconds).isEmpty())
        {
            totalString1 = twoDigitString(seconds)+" Sec ";
        }

        return totalString+totalString1;
    }

    private String twoDigitString(int number) {

        if (number == 0) {
            return "";
        }

        if (number / 10 == 0) {
            return String.valueOf(number);
        }

        return String.valueOf(number);
    }
    private void showAlertDialog(int layout){


        if (circleTimeView.getCurrentTimeInSeconds()> 2 )
        {
            circleTimeView.stopTimer();
        }
        dialogBuilder = new AlertDialog.Builder(BlueDustBin.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
       // Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        Button dialogButton1 = layoutView.findViewById(R.id.btnDialog1);
        ImageView img = layoutView.findViewById(R.id.imageView);
        TextView compl = layoutView.findViewById(R.id.textView);
        TextView right = layoutView.findViewById(R.id.textView2);
        TextView wrong = layoutView.findViewById(R.id.textView3);
        TextView total1 = layoutView.findViewById(R.id.textView4);
        TextView time = layoutView.findViewById(R.id.time);

        System.out.println(" 11111111111111111111  display   "+items);
        System.out.println("11111111111111111111111   display   "+displayedItems);
        if (displayedItems-1 == items && nextQuestian)
        {
            double amount = Double.parseDouble(totalScore.toString());
            double res = (amount / items) * 100;


            Toast.makeText(getApplicationContext(), "" + String.format("%.1f", res), Toast.LENGTH_SHORT).show();
            compl.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            wrong.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
            time.setVisibility(View.VISIBLE);
            right.setText(totalScore+" of "+items +" questions answered correctly");
            // right.setText("Right Answer : "+totalScore);
            wrong.setText("Overall score : "+String.format("%.0f", res)+"%");

            long tim = circleTimeView.getCurrentTimeInSeconds();
            long as = 600-tim;

            String[] data = getDurationString(Integer.parseInt(String.valueOf(as))).split(":");

            if (getDurationString(Integer.parseInt(String.valueOf(as))).substring(1,2).equalsIgnoreCase("00"))
            {
                time.setText("Your time : "+(getDurationString(Integer.parseInt(String.valueOf(as)))));
            }
            else {
                time.setText("Your time : "+(getDurationString(Integer.parseInt(String.valueOf(as)))));
            }
        }
       else {
            right.setVisibility(View.VISIBLE);
            right.setText("\n\nSession Expired \n\n");
        }

       // circleTimeView.getTimeFormat();

        System.out.println("  circleTimeView.getTimeFormat()   "+circleTimeView.getTimeFormat());
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
      /*  dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

                    callSatrtEnd();
                    if (parentLinearLayout.getChildCount()>0)
                    {
                        parentLinearLayout.removeAllViews();
                    }
                    callClearTick();
                    nextBtn.setVisibility(View.VISIBLE);
                    displayedItems=1;
                    display.setText(displayedItems.toString());
                    totalScore=0;
                total.setText("0");
                onAddField(data);
                circleTimeView.setCurrentTime(600);
                    circleTimeView.startTimer();
                item1.setOnClickListener(this);
                item2.setOnClickListener(this);
                item3.setOnClickListener(this);
                item4.setOnClickListener(this);
                removeView.setOnLongClickListener(this);
                removeView.setOnDragListener(this);
            }
        });*/

        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

                socitreepreference.putBlue(totalScore+"/"+items );
                socitreepreference.putBlueC("complete");


                finish();
            }
        });

        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialog) {

                finish();
                // finish activity
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void showAlertDialogStart(int layout){
        dialogBuilder = new AlertDialog.Builder(BlueDustBin.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);

        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                alertDialog.dismiss();
                circleTimeView.startTimer();

            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialog) {

                circleTimeView.startTimer();
                // finish activity
            }
        });
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);


    }

    @Override
    public boolean onLongClick(View view) {
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        System.out.println(item.getText());

        System.out.println(item.getHtmlText());
        System.out.println(item.getUri());


        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
        int h = view.getHeight()/2;
        int w = view.getWidth()/2;

        view.getLayoutParams().height = h;
        view.getLayoutParams().width = w;


        //view.setLayoutParams(ViewGroup.LayoutParams.);

        // Instantiates the drag shadow builder.
        //View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        View.DragShadowBuilder shadowBuilder = new MyDragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );

        //Set view visibility to INVISIBLE as we are going to drag the view
        //view.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onDrag(View view, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:

                System.out.println("                  started                      ");
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                    started = 1;


                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a YELLOW or any color tint to the View, when the dragged view entered into drag acceptable view



                view.invalidate();
                View v1 = (View) event.getLocalState();

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)v1.getLayoutParams();
                layoutParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;
                layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
                v1.setLayoutParams(layoutParams);

                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                started = 0;

                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DROP:

                started = 0;
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);

                // Gets the text data from the item.
                String dragData = item.getText().toString();



                view.invalidate();

                View v = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) v.getParent();
                if (v != null && owner != null) {

               //     owner.removeView(v);                    //remove the dragged view


                }

                if (!timeOut) {

                    if (view.getTag() != null) {


                        if (view.getTag().toString().equalsIgnoreCase("blue") || view.getTag().toString().equalsIgnoreCase("red") || view.getTag().toString().equalsIgnoreCase("yellow") || view.getTag().toString().equalsIgnoreCase("green")) {

                            nextQuestian = true;

                            item1.setOnClickListener(null);
                            item2.setOnClickListener(null);
                            item3.setOnClickListener(null);
                            item4.setOnClickListener(null);

                            v.setOnLongClickListener(null);
                            v.setOnDragListener(null);

                            System.out.println("      view     " + view.getTag());

                            System.out.println("       v       " + v.getTag());

                            String[] value = v.getTag().toString().split("_");

                            countItems--;



                            if (view.getTag().toString().equalsIgnoreCase("blue")) {
                                if (value[1].equalsIgnoreCase("1")) {
                                    displayedItems = displayedItems + 1;
                                    totalScore = totalScore + 1;

                                    score.setText(totalScore.toString());



                                    green1.setVisibility(View.VISIBLE);

                                    /*green1.postDelayed(new Runnable() {
                                        public void run() {
                                            green1.setVisibility(View.GONE);
                                        }
                                    }, 5000);*/
                                } else {
                                    displayedItems = displayedItems + 1;
                                    red1.setVisibility(View.VISIBLE);

                                    /*
                                    red1.postDelayed(new Runnable() {
                                        public void run() {
                                            red1.setVisibility(View.GONE);
                                        }
                                    }, 5000);*/

                                    callRed(value[1]);
                                }
                            } else if (view.getTag().toString().equalsIgnoreCase("red")) {
                                if (value[1].equalsIgnoreCase("2")) {
                                    displayedItems = displayedItems + 1;
                                    totalScore = totalScore + 1;


                                    green2.setVisibility(View.VISIBLE);
/*
                                    green2.postDelayed(new Runnable() {
                                        public void run() {
                                            green2.setVisibility(View.GONE);
                                        }
                                    }, 5000);*/

                                } else {
                                    displayedItems = displayedItems + 1;

                                    red2.setVisibility(View.VISIBLE);
                                  /*
                                    red2.postDelayed(new Runnable() {
                                        public void run() {
                                            red2.setVisibility(View.GONE);
                                        }
                                    }, 1000);*/

                                    callRed(value[1]);
                                }
                            } else if (view.getTag().toString().equalsIgnoreCase("yellow")) {
                                if (value[1].equalsIgnoreCase("3")) {
                                    displayedItems = displayedItems + 1;
                                    totalScore = totalScore + 1;


                                    green3.setVisibility(View.VISIBLE);

                                   /* green3.postDelayed(new Runnable() {
                                        public void run() {
                                            green3.setVisibility(View.GONE);
                                        }
                                    }, 5000);*/

                                } else {
                                    displayedItems = displayedItems + 1;


                                    red3.setVisibility(View.VISIBLE);
                                   /* red3.postDelayed(new Runnable() {
                                        public void run() {
                                            red3.setVisibility(View.GONE);
                                        }
                                    }, 5000);
*/
                                    callRed(value[1]);
                                }
                            } else if (view.getTag().toString().equalsIgnoreCase("green")) {
                                if (value[1].equalsIgnoreCase("4")) {
                                    displayedItems = displayedItems + 1;
                                    totalScore = totalScore + 1;


                                    green4.setVisibility(View.VISIBLE);

                                   /* green4.postDelayed(new Runnable() {
                                        public void run() {
                                            green4.setVisibility(View.GONE);
                                        }
                                    },5000);*/

                                } else {
                                    displayedItems = displayedItems + 1;

                                    red4.setVisibility(View.VISIBLE);
                                  /*  red4.postDelayed(new Runnable() {
                                        public void run() {
                                            red4.setVisibility(View.GONE);
                                        }
                                    }, 5000);*/

                                    callRed(value[1]);
                                }
                            }

                            System.out.println("      variable       " + value[1]);

                            if (parentLinearLayout.getChildCount() == 1) {
                                showAlertDialog(R.layout.positive_dialoque);
                            }
                        }
                        else if (view.getTag().toString().equalsIgnoreCase("main")) {
                            RelativeLayout container = (RelativeLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout

                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.MATCH_PARENT,
                                    RelativeLayout.LayoutParams.MATCH_PARENT
                            );
                           /* int h = v.getHeight();
                            int w = v.getWidth();
                            v.getLayoutParams().height= h*2;
                            v.getLayoutParams().width= w*2;*/

                            v.setLayoutParams(params);
                           // container.addView(v);//Add the dragged view


                            v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE

                        } else {
                            RelativeLayout container = (RelativeLayout) findViewById(R.id.toplayout);//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.MATCH_PARENT,
                                    RelativeLayout.LayoutParams.MATCH_PARENT
                            );
                           /* int h = v.getHeight();
                            int w = v.getWidth();
                            v.getLayoutParams().height= h*2;
                            v.getLayoutParams().width= w*2;*/

                            v.setLayoutParams(params);
                           // container.addView(v);//Add the dragged view
                            v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                        }
                    }


                }
                else {




                }
                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                started = 0;

                // Turns off any color tinting
                //view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();

                // Does a getResult(), and displays what happened.
                if (event.getResult())
                {
               }
                else
                   // Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();

                    Log.e("DragDrop Example", "The drop didn't work.");
                // returns true; the value is ignored.
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private void callRed(String version) {

        if (version.equalsIgnoreCase("1"))
        {
            green1.setVisibility(View.VISIBLE);

        }
        else  if (version.equalsIgnoreCase("2"))
        {
            green2.setVisibility(View.VISIBLE);

        }
        else  if (version.equalsIgnoreCase("3"))
        {
            green3.setVisibility(View.VISIBLE);

        }
        else  if (version.equalsIgnoreCase("4"))
        {
            green4.setVisibility(View.VISIBLE);

        }
    }

    public void onAddField(ArrayList<DataModel> data) {

        for (int i = 0;i<data.size();i++)
        {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           // final View rowView = inflater.inflate(R.layout.images_drog, null);
            ImageView imageView = new ImageView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //ImageView imageView = (ImageView)rowView.findViewById(R.id.bluebin1);
            // Add the new row before the add field button.

            System.out.println("                               "+i);
            imageView.setLayoutParams(layoutParams);
            imageView.setId(i);
            imageView.setImageResource(data.get(i).getImage());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setTag("tag_"+data.get(i).getVersion());
            parentLinearLayout.addView(imageView );

        }

        int ids = parentLinearLayout.getChildCount();
        System.out.println("                               "+ids);


        if (data.size() > 0) {


            removeView = (ImageView) findViewById(ids - 1);

            removeView.setOnLongClickListener(this);
            removeView.setOnDragListener(this);
        }



    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        if (v == nextBtn)
        {


            if (nextQuestian) {

                nextQuestian = false;

                callClearTick();
                item1.setOnClickListener(this);
                item2.setOnClickListener(this);
                item3.setOnClickListener(this);
                item4.setOnClickListener(this);

                if (parentLinearLayout.getChildCount() > 0) {


                    System.out.println("       child count      " + parentLinearLayout.getChildCount());


                    parentLinearLayout.removeViewAt(parentLinearLayout.getChildCount() - 1);

                    if (displayedItems == items)
                    {
                        nextBtn.setVisibility(View.GONE);
                    }
                    display.setText(displayedItems.toString());
                    score.setText(totalScore.toString());

                    if (parentLinearLayout.getChildCount() > 0) {
                        name.setText(data.get(countItems - 1).getName());
                        removeView = (ImageView) findViewById(parentLinearLayout.getChildCount() - 1);


                        removeView.setOnLongClickListener(this);
                        removeView.setOnDragListener(this);
                    }
                    else {
                        if (parentLinearLayout.getChildCount() == 0) {
                            showAlertDialog(R.layout.positive_dialoque);
                        }
                    }
                }
                if (parentLinearLayout.getChildCount() == 0) {

                    timer.setVisibility(View.GONE);
                    showAlertDialog(R.layout.positive_dialoque);
                }

            }
            else {
                Toast.makeText(getApplicationContext(),"Complete the answer",Toast.LENGTH_SHORT).show();

            }
        }
        if (v == item1)
        {
            nextQuestian = true;
            displayedItems = displayedItems + 1;
            item1.setOnClickListener(null);
            item2.setOnClickListener(null);
            item3.setOnClickListener(null);
            item4.setOnClickListener(null);
            removeView.setOnDragListener(null);
            removeView.setOnLongClickListener(null);




            if (data.get(countItems-1).getVersion().equalsIgnoreCase("1")) {
                totalScore = totalScore + 1;
                score.setText(totalScore.toString());



                green1.setVisibility(View.VISIBLE);
                countItems--;
            }
            else {
               red1.setVisibility(View.VISIBLE);


                callRed(data.get(countItems-1).getVersion());
                countItems--;
            }
            if (parentLinearLayout.getChildCount() == 1) {
                showAlertDialog(R.layout.positive_dialoque);
            }

        }
        else if (v == item2)
        {
            nextQuestian = true;
            displayedItems = displayedItems + 1;

            item1.setOnClickListener(null);
            item2.setOnClickListener(null);
            item3.setOnClickListener(null);
            item4.setOnClickListener(null);
            removeView.setOnDragListener(null);
            removeView.setOnLongClickListener(null);


            if (data.get(countItems-1).getVersion().equalsIgnoreCase("2")) {
                totalScore = totalScore + 1;
                score.setText(totalScore.toString());
                green2.setVisibility(View.VISIBLE);

                countItems--;
            }
            else {
                red2.setVisibility(View.VISIBLE);


                callRed(data.get(countItems-1).getVersion());
                countItems--;
            }
            if (parentLinearLayout.getChildCount() == 1) {
                showAlertDialog(R.layout.positive_dialoque);
            }
        }
        else if (v == item3)
        {
            nextQuestian = true;
            displayedItems = displayedItems + 1;

            item1.setOnClickListener(null);
            item2.setOnClickListener(null);
            item3.setOnClickListener(null);
            item4.setOnClickListener(null);
            removeView.setOnDragListener(null);
            removeView.setOnLongClickListener(null);


            if (data.get(countItems-1).getVersion().equalsIgnoreCase("3")) {
                totalScore = totalScore + 1;
                score.setText(totalScore.toString());
                green3.setVisibility(View.VISIBLE);
                countItems--;


            }
            else {
                red3.setVisibility(View.VISIBLE);

                callRed(data.get(countItems-1).getVersion());
                countItems--;
            }
            if (parentLinearLayout.getChildCount() == 1) {
                showAlertDialog(R.layout.positive_dialoque);
            }
        }
        else if (v == item4)
        {
            nextQuestian = true;
            displayedItems = displayedItems + 1;

            item1.setOnClickListener(null);
            item2.setOnClickListener(null);
            item3.setOnClickListener(null);
            item4.setOnClickListener(null);
            removeView.setOnDragListener(null);
            removeView.setOnLongClickListener(null);



            if (data.get(countItems-1).getVersion().equalsIgnoreCase("4")) {
                totalScore = totalScore + 1;

                score.setText(totalScore.toString());
                green4.setVisibility(View.VISIBLE);
                countItems--;

            }
            else {
                red4.setVisibility(View.VISIBLE);


                callRed(data.get(countItems-1).getVersion());
                countItems--;
            }

            if (parentLinearLayout.getChildCount() == 1) {
                showAlertDialog(R.layout.positive_dialoque);
            }
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

    private static class MyDragShadowBuilder extends View.DragShadowBuilder {

        // The drag shadow image, defined as a drawable thing
        private static Drawable shadow;

        // Defines the constructor for myDragShadowBuilder
        public MyDragShadowBuilder(View v) {

            // Stores the View parameter passed to myDragShadowBuilder.
            super(v);

            // Creates a draggable image that will fill the Canvas provided by the system.
            shadow = new ColorDrawable(Color.GRAY);
        }

        // Defines a callback that sends the drag shadow dimensions and touch point back to the
        // system.
        @Override
        public void onProvideShadowMetrics (Point size, Point touch) {
            // Defines local variables
            int width, height;


            // Sets the width of the shadow to half the width of the original View
            width = getView().getWidth() / 2;

            // Sets the height of the shadow to half the height of the original View
            height = getView().getHeight() / 2;

            // The drag shadow is a ColorDrawable. This sets its dimensions to be the same as the
            // Canvas that the system will provide. As a result, the drag shadow will fill the
            // Canvas.
            shadow.setBounds(0, 0, width, height);

            // Sets the size parameter's width and height values. These get back to the system
            // through the size parameter.
            size.set(width, height);

            // Sets the touch point's position to be in the middle of the drag shadow
            touch.set(width / 2, height / 2);
        }

        // Defines a callback that draws the drag shadow in a Canvas that the system constructs
        // from the dimensions passed in onProvideShadowMetrics().
        @Override
        public void onDrawShadow(Canvas canvas) {


            // Draws the ColorDrawable in the Canvas passed in from the system.
            shadow.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);

    }
}
