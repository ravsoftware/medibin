package com.example.medibin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medibin.about.AboutActivity;
import com.example.medibin.bindata.BlueDustBinNew;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView about;

   // TextView out, in, operation, injection, labour, blood;
   // TextView out1, in1, operation1, injection1, labour1, blood1;

    Button quiz,learn,search;
    Preference socitreepreference;

    TextView contentText;

    private static final int TIME_DELAY=2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socitreepreference = Preference.getInstance(this);



        quiz = (Button) findViewById(R.id.button2);
        learn = (Button) findViewById(R.id.button3);
        search = (Button) findViewById(R.id.button1);


        contentText= (TextView)findViewById(R.id.contenttext);
        about = (ImageView)findViewById(R.id.about);

        String text ="<p><br>Medibin aids capacity building in medical profesionals, paramedics, Medical &amp; Paramedical students and also the waste handlers on Biomedical waste segregation.</p>";


        contentText.setText(Html.fromHtml(text));

    /*   // in = (TextView)findViewById(R.id.in);
        operation = (TextView)findViewById(R.id.operation);
        injection = (TextView)findViewById(R.id.injection);
        labour = (TextView)findViewById(R.id.labour);
        blood = (TextView)findViewById(R.id.blood);

        out1 = (TextView)findViewById(R.id.out1);
        in1 = (TextView)findViewById(R.id.in1);
        operation1 = (TextView)findViewById(R.id.operation1);
        injection1 = (TextView)findViewById(R.id.injection1);
        labour1 = (TextView)findViewById(R.id.labour1);
        blood1 = (TextView)findViewById(R.id.blood1);
*/

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                intent.putExtra("title","LABOUR WARD");
                intent.putExtra("key","labour");
                startActivityForResult(intent,112);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BlueDustBin.class);
                intent.putExtra("title","LABOUR WARD");
                intent.putExtra("key","labour");
                startActivityForResult(intent,112);
            }
        });
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BlueDustBinNew.class);
                intent.putExtra("title","LEARN");
                intent.putExtra("key","labour");
                startActivityForResult(intent,112);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                startActivityForResult(intent,112);
            }
        });


       /* if (socitreepreference.getBlue()!= null)
        {
            if (socitreepreference.getBlueC().equalsIgnoreCase("complete")) {
                out.setTextColor(Color.parseColor("#08AF03"));
                out1.setText(socitreepreference.getBlue());
                out1.setVisibility(View.VISIBLE);
            }
        }
        if (socitreepreference.getRed()!= null)
        {
            if (socitreepreference.getRedC().equalsIgnoreCase("complete")) {

                in.setTextColor(Color.parseColor("#08AF03"));
                in1.setText(socitreepreference.getRed());
                in1.setVisibility(View.VISIBLE);
            }
        }
        if (socitreepreference.getYellow()!= null)
        {
            if (socitreepreference.getYellowC().equalsIgnoreCase("complete")) {

                operation.setTextColor(Color.parseColor("#08AF03"));
                operation1.setText(socitreepreference.getYellow());
                operation1.setVisibility(View.VISIBLE);
            }
        }
        if (socitreepreference.getWhite()!= null)
        {
            if (socitreepreference.getWhiteC().equalsIgnoreCase("complete")) {

                injection.setTextColor(Color.parseColor("#08AF03"));
                injection1.setText(socitreepreference.getWhite());
                injection1.setVisibility(View.VISIBLE);
            }
        }
        if (socitreepreference.getBlueO()!= null)
        {
            if (socitreepreference.getBlueCO().equalsIgnoreCase("complete")) {

                labour.setTextColor(Color.parseColor("#08AF03"));
                labour1.setText(socitreepreference.getBlueO());
                labour1.setVisibility(View.VISIBLE);
            }
        }
        if (socitreepreference.getRedO()!= null)
        {
            if (socitreepreference.getRedCO().equalsIgnoreCase("complete")) {

                blood.setTextColor(Color.parseColor("#08AF03"));
                blood1.setText(socitreepreference.getRedO());
                blood1.setVisibility(View.VISIBLE);
            }
        }


        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","OUT PATIENT WARD");
                intent.putExtra("key","out");
                startActivityForResult(intent,112);
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","IN PATIENT WARD");
                intent.putExtra("key","in");
                startActivityForResult(intent,112);
            }
        });
        operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","OPERATION THEATRE");
                intent.putExtra("key","operation");
                startActivityForResult(intent,112);
            }
        });
        injection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","INJECTION/DRESSING ROOM");
                intent.putExtra("key","injection");
                startActivityForResult(intent,112);
            }
        });
        labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","LABOUR WARD");
                intent.putExtra("key","labour");
                startActivityForResult(intent,112);
            }
        });
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),BlueDustBin.class);
                intent.putExtra("title","BLOOD/LABORATORY BANK");
                intent.putExtra("key","blood");
                startActivityForResult(intent,112);
            }
        });
*/





    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {

        if (back_pressed+TIME_DELAY>System.currentTimeMillis()) {


            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }else {

            /* this.doubleBackToExitPressedOnce = true;*/
            Toast.makeText(MainActivity.this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
           // displayToast();
        }
        back_pressed=System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {

    }
    public void displayToast() {


        Toast toast = Toast.makeText(getApplicationContext(),
                "Please click BACK again to exit",
                Toast.LENGTH_SHORT);

        View toastView = toast.getView();
        toastView.setBackgroundColor(Color.BLACK);
        TextView text = (TextView) toastView.findViewById(android.R.id.message);
        text.setTextColor(Color.WHITE);

        toast.show();



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 112)
        {

        }
    }
    public void closeKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
