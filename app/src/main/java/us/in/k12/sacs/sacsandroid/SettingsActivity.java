package us.in.k12.sacs.sacsandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Christopher on 3/1/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
