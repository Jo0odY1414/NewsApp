package com.example.android.newsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by a0 on 10‏/10‏/2017.
 */

public class SearchActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_WORD = "com.example.android.newsapp.KEY_WORD";

    public static String SECTION_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
    }

    public static class StoryPreferenceFragment extends PreferenceFragment
            implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.date_main);

            Preference searchFromDate = findPreference(getString(R.string.search_by_from_date_key));
            bindPreferenceSummaryToValue(searchFromDate);

            Preference searchToromDate = findPreference(getString(R.string.search_by_from_date_key));
            bindPreferenceSummaryToValue(searchFromDate);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        }

        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences =
                    PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = getIntent();
        SECTION_NAME = intent.getStringExtra(StoryActivity.EXTRA_KEY_WORD);
        intent = new Intent(getApplicationContext(), StoryActivity.class);
        intent.putExtra(EXTRA_KEY_WORD, SECTION_NAME);
        startActivity(intent);
    }
}