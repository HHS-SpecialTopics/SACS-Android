package us.in.k12.sacs.sacsandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import com.onesignal.OneSignal;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String KEY_PREF_ALL_NOTIFICATIONS = "pref_key_all_notifications";
    public static final String KEY_PREF_STATUS_UPDATES = "pref_key_status_update_notifications";
    public static final String KEY_PREF_NEWS_UPDATES = "pref_key_new_article_notifications";

    // TODO Later
    public static final String OS_KEY_ALL = "all_notifications";
    public static final String OS_KEY_STATUS = "status_notifications";
    public static final String OS_KEY_NEWS = "news_notifications";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals(KEY_PREF_ALL_NOTIFICATIONS)) {

            boolean enabled = sharedPreferences.getBoolean(key, true);
            OneSignal.sendTag("Delays", Boolean.toString(enabled));
            OneSignal.sendTag("Cancellations", Boolean.toString(enabled));
            OneSignal.sendTag("News articles", Boolean.toString(enabled));
            OneSignal.sendTag("Other", Boolean.toString(enabled));

        } else if (key.equals(KEY_PREF_STATUS_UPDATES)) {

            boolean enabled = sharedPreferences.getBoolean(key, true);
            OneSignal.sendTag("Delays", Boolean.toString(enabled));
            OneSignal.sendTag("Cancellations", Boolean.toString(enabled));

        } else if (key.equals(KEY_PREF_NEWS_UPDATES)) {

            boolean enabled = sharedPreferences.getBoolean(key, true);
            OneSignal.sendTag("News articles", Boolean.toString(enabled));

        }
    }

    @Override
    public void onResume() {

        super.onResume();

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {

        super.onPause();

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
