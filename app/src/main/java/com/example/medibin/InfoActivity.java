package com.example.medibin;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medibin.bindata.InfoData;

import static com.example.medibin.bindata.InfoData.nameArray;

public class InfoActivity extends AppCompatActivity {

    ImageView image,image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setting the title
        toolbar.setTitle("Find your bin");
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        image = (ImageView)findViewById(R.id.image);

        image1 = (ImageView)findViewById(R.id.image1);


        image.setVisibility(View.GONE);
        image1.setVisibility(View.GONE);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, nameArray);
            AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.ac_Country);
            actv.setThreshold(1);
            actv.setAdapter(adapter);
            actv.requestFocus();
            showKeyboard();
        actv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                System.out.println("    dddd    ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("    fff    ");
                if (s.toString().isEmpty())
                {
                    image.setVisibility(View.GONE);
                    image1.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("    hhh    ");
            }
        });

            actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    System.out.println(parent.getItemAtPosition(position));
                    System.out.println(parent.getSelectedView());
                    System.out.println(view.getAutofillValue());
                    System.out.println(position);
                    int req = 0;

                    closeKeyboard();
                    for (int i = 0; i<nameArray.length; i++)
                    {
                        if (parent.getItemAtPosition(position).toString().trim().equalsIgnoreCase(nameArray[i].toString().trim()))
                        {

                            System.out.println(nameArray[i]);
                            req = i;
                            break;
                        }
                    }

                    if (InfoData.versionArray[req].equalsIgnoreCase("1"))
                    {
                        image.setImageResource(R.drawable.blue_icon);
                        image1.setImageResource(InfoData.drawableArray[req]);
                        image.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.VISIBLE);
                    }
                    else if (InfoData.versionArray[req].equalsIgnoreCase("2"))
                    {
                        image.setImageResource(R.drawable.red_icon);
                        image1.setImageResource(InfoData.drawableArray[req]);
                        image.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.VISIBLE);
                    }
                    else if (InfoData.versionArray[req].equalsIgnoreCase("3"))
                    {
                        image.setImageResource(R.drawable.yellow_icon);
                        image1.setImageResource(InfoData.drawableArray[req]);
                        image.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.VISIBLE);
                    }
                    else if (InfoData.versionArray[req].equalsIgnoreCase("4"))
                    {
                        image.setImageResource(R.drawable.white_icon);
                        image1.setImageResource(InfoData.drawableArray[req]);
                        image.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.VISIBLE);
                    }


                }
            });

        }
    public void closeKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
    public void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
