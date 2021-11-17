package com.example.rquiz;

import android.os.Bundle;

import java.util.prefs.Preferences;

import androidx.preference.PreferenceFragmentCompat;

public class SettingFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String setting) {

        //set layout to settings fragment
        setPreferencesFromResource(R.xml.preferences, setting);

    }
}
