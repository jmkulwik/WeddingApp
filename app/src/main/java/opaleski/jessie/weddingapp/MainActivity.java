package opaleski.jessie.weddingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.Parse;

public class MainActivity extends Activity {

    SharedPreferences preferences;
    final String welcomeScreenShownPref = "welcomeScreenShown";

    private void displayScreen() {
        TextView txt = (TextView) findViewById(R.id.heading);
        Typeface font = Typeface.createFromAsset(getAssets(), "RegencyScriptFLF.ttf");
        txt.setTypeface(font);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "M9DxWvjXvPe60Bd1Zm5YAs91FxEaCsA1FGurQjBF", "GfgARGavTQCdMp3ZGYw45ysjSViBqMJqMOxwdYNB");

        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown = preferences.getBoolean(welcomeScreenShownPref, false);

       // if (!welcomeScreenShown) { TODO: here
            displayScreen();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(welcomeScreenShownPref, true);
            editor.apply(); // Very important to save the preference
       /* } else {
            Intent menuIntent = new Intent(this, MenuActivity.class);
            startActivity(menuIntent);
            finish();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openMenu(View view) {
        Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
        finish();
    }

}
