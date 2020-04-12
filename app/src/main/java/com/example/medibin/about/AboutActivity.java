package com.example.medibin.about;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.medibin.MainActivity;
import com.example.medibin.R;

import java.util.Calendar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/* DAY */ 0);
        Element adsElement = new Element();
       // adsElement.setTitle("Advertise with us");

        String dfdjk= "<p style=\"color:#00008b;\"><i>Bio-medical waste means any waste generated during diagnosis, treatment or immunization of human beings or animals or research activities pertaining thereto or in the production or testing of biological or in health camps (WHO defn)</i></b>.</p> <p>*    Bio-medical waste or health-care waste includes all the waste generated within health-care facilities, research centers and laboratories related to medical procedures. It includes sharp waste, infectious waste, radioactive waste, chemical waste and pharmaceutical waste.</p><p>*    Although the quantity of such waste is around 10% to 15% of total waste generated from the Health Care Facility, they are hazardous and if mixed with non-hazardous waste then the whole waste has to be treated as hazardous.</P><p>*    Improper disposal of these waste can adversely affect the human health and environment. Proper training to the healthcare workers and others involved in handling the biomedical waste is therefore essential for sound management of healthcare waste to ensure occupational safety.</P><p>*    Biomedical waste management is majority done if the waste is properly segregated at the point of generation itself. This biomedical waste segregation is the core concept of Medibin.</p><p>*    Medibin gives a novel, intuitive and goal-oriented approach to increase awareness and impart knowledge about biomedical waste segregation in healthcare workers, medical and paramedical students and also the waste handlers. This app helps you to learn, inquire and to evaluate yourself.<br></p>" +

                "<p><b>Dr.Aarthy Marimuthu(Founder Medibin)</b>" +
                "<br>Completed MBBS and pursuing M.D Community Medicine. <br>Worked under Tamil Nadu State government as Medical Officer in Primary Health Centre.<br> Interested in Public health administration and Research.</p>" +

                "<br><b>Ramkumaar Rethinam Asokan(Co Founder Medibin)</b>" +
                "<br>Completed B.Tech in Computer Science. With 11+ experience in Software development. <br>Director, RAV software solutions INC,Toronto, Canada." +
                "<br>Interested in developing innovative solutions." +

                "<p><h2>Developers</h2>" +
                "<b>Ganeshpandi Subbaiah</b>" +
                "<br>Completed B.E. in Electronics and Communication Engineering"+
                "<br>Working as Android application developer at Cybzero.com"+
                "<br>Interested in creating innovative Android application  ."+
                "<br><br><b>Aravind Dharmaraj</b>" +
                "<br>Completed B.Tech in Information Technology.<br> Working as Software team lead at Cybzero.com,  Weekend open source programmer. <br>Interested in helping entrepreneurs with tools and ideas to build and grow their companies." +
                "<br>Quality assurance and Analyst" +
                "<br><br><b>Ramnath Thirumalai Kalaichelvan</b>" +
                "<br>Completed B.Tech in Computer Science Engineering. " +
                "<br>Working as Senior Test Lead in a Global MNC IT company. " +
                "<br>Having 10 years of experience in Mobile Functional Testing.<br>Interested in playing QA role for mobile app solutions and thereby ensuring quality product deliveries.<p>";
        String next = "<font color='#860F0F'>SIGN IN</font>";
       // txt_signin.setText(Html.fromHtml("hdifuhdishif" + "  "+next));

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                //.setImage(R.drawable.about_icon)
               // .addItem(new Element().setTitle("Version 6.2"))
                .setDescription(Html.fromHtml(dfdjk))
                .addItem(adsElement)

               // .addGroup("Connect with us")
                .addEmail("medibinrav@gmail.com")
               // .addWebsite("http://medyo.github.io/")
                //.addFacebook("the.medy")
               // .addTwitter("medyo80")
               // .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
               // .addPlayStore("com.ideashower.readitlater.pro")
               // .addInstagram("medyo80")
               // .addGitHub("medyo")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setIconTint(R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER_VERTICAL);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}
