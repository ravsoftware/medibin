package com.example.medibin;
import android.os.Build;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

    private final String PREF_BLUE = "Username";
    private final String PREF_RED = "Useremailid";
    private final String PREF_YELLOW = "Userphone";
    private final String PREF_WHITE = "Password";
    private final String PREF_BLUEO = "UsernameO";
    private final String PREF_REDO = "UseremailidO";

    private final String PREF_BCOMPL = "UserProfileimages";
    private final String PREF_RCOMPL = "UserToken";
    private final String PREF_GCOMPL = "categies";
    private final String PREF_YCOMPL = "propertyids";
    private final String PREF_BCOMPLO = "UserProfileimagesO";
    private final String PREF_RCOMPLO = "UserTokenO";

    private final String PREF_USER_ID = "Userid";
    private final String PREF_PROPERTY_ID = "UserPropertyid";
    private final String PREF_TIMEZONE = "TimeZone";
    private final String PREF_LAT = "TimeLat";
    private final String PREF_START = "TimeLang";
    private final String PREF_END = "Login_Success";


    private static Preference sCommonPref;
    private SharedPreferences mPreference;
    private Context mContext;


    public static Preference getInstance(Context context) {
        if (sCommonPref == null) {
            sCommonPref = new Preference(context);
        }
        return sCommonPref;
    }

    private Preference(Context context) {
        mContext = context;
        mPreference = mContext.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
    }




    public void putBlue(String Categoryid) {
        mPreference.edit().putString(PREF_BLUE, Categoryid)
                .commit();
    }
    public String getBlue() {
        return mPreference.getString(PREF_BLUE, null);
    }



    public void putRed(String Categoryid) {
        mPreference.edit().putString(PREF_RED, Categoryid)
                .commit();
    }
    public String getRed() {
        return mPreference.getString(PREF_RED, null);
    }




    public void putBlueO(String Categoryid) {
        mPreference.edit().putString(PREF_BLUEO, Categoryid)
                .commit();
    }
    public String getBlueO() {
        return mPreference.getString(PREF_BLUEO, null);
    }



    public void putRedO(String Categoryid) {
        mPreference.edit().putString(PREF_REDO, Categoryid)
                .commit();
    }
    public String getRedO() {
        return mPreference.getString(PREF_REDO, null);
    }


    public void putYellow(String Categoryid) {
        mPreference.edit().putString(PREF_YELLOW, Categoryid)
                .commit();
    }
    public String getYellow() {
        return mPreference.getString(PREF_YELLOW, null);
    }



    public void putWhite(String BarberId) {
        mPreference.edit().putString(PREF_WHITE, BarberId)
                .commit();
    }
    public String getWhite() {
        return mPreference.getString(PREF_WHITE, null);
    }



    public void putBlueC(String Categoryid) {
        mPreference.edit().putString(PREF_BCOMPL, Categoryid)
                .commit();
    }
    public String getBlueC() {
        return mPreference.getString(PREF_BCOMPL, null);
    }



    public void putRedC(String Categoryid) {
        mPreference.edit().putString(PREF_RCOMPL, Categoryid)
                .commit();
    }
    public String getRedC() {
        return mPreference.getString(PREF_RCOMPL, null);
    }




    public void putBlueCO(String Categoryid) {
        mPreference.edit().putString(PREF_BCOMPLO, Categoryid)
                .commit();
    }
    public String getBlueCO() {
        return mPreference.getString(PREF_BCOMPLO, null);
    }



    public void putRedCO(String Categoryid) {
        mPreference.edit().putString(PREF_RCOMPLO, Categoryid)
                .commit();
    }
    public String getRedCO() {
        return mPreference.getString(PREF_RCOMPLO, null);
    }





    public void putYellowC(String Categoryid) {
        mPreference.edit().putString(PREF_YCOMPL, Categoryid)
                .commit();
    }
    public String getYellowC() {
        return mPreference.getString(PREF_YCOMPL, null);
    }



    public void putWhiteC(String BarberId) {
        mPreference.edit().putString(PREF_GCOMPL, BarberId)
                .commit();
    }
    public String getWhiteC() {
        return mPreference.getString(PREF_GCOMPL, null);
    }




    public void putUserId(String UserId) {
        mPreference.edit().putString(PREF_USER_ID, UserId)
                .commit();
    }

    public String getUserId() {
        return mPreference.getString(PREF_USER_ID, null);
    }

    public void putLat(String BarberId) {
        mPreference.edit().putString(PREF_LAT, BarberId)
                .commit();
    }
    public String getLat() {
        return mPreference.getString(PREF_LAT, null);
    }

    public void putStart(String BarberId) {
        mPreference.edit().putString(PREF_START, BarberId)
                .commit();
    }
    public String getStart() {
        return mPreference.getString(PREF_START, null);
    }


    public void putEnd(String LoginSuccess) {
        mPreference.edit().putString(PREF_END, LoginSuccess)
                .commit();
    }

    public String getEnd() {

        return mPreference.getString(PREF_END, null);
    }







    public void putUserName(String UserName) {
        mPreference.edit().putString(PREF_BLUE, UserName)
                .commit();
    }
    public String getUserName() {
        return mPreference.getString(PREF_BLUE, null);
    }


    public void putUserEmailid(String UserEmailid) {
        mPreference.edit().putString(PREF_RED, UserEmailid)
                .commit();
    }
    public String getUserEmailid() {
        return mPreference.getString(PREF_RED, null);
    }


    public void putUserPhone(String UserPhone) {
        mPreference.edit().putString(PREF_YELLOW, UserPhone)
                .commit();
    }
    public String getUserPhone() {
        return mPreference.getString(PREF_YELLOW, null);
    }




}
