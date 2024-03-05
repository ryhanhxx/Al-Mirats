package com.ch.al_mirats.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocaleHelper {

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static Context setLocale(Context context, String language){
        persist(context, language);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return updateResource(context, language);
        }

        return updateResource(context, language);
    }

    private static Context updateResource(Context context, String language) {
        Locale locale = new Locale(language);
                Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static void persist(Context context, String language){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    private static Context updateResourcesLegacy(Context context, String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
