package com.example.sharedpreferenceseventbookingyou;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public static void writeIntToPreference(Context context, String key, Long value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringFromPreference(Context context, String key) {
        return getSharedPreference(context).getString(key, null);
    }

    public static long getIntFromPreference(Context context, String key) {
        return getSharedPreference(context).getLong(key, 0);
    }
}