package kpi.mobcomp.korean_grammar;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class nouns extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouns);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


    }


    public void showEntry(View iView) {
        Intent intent = new Intent( nouns.this, ShowEntry.class );

        int grammarTextId;

        switch (iView.getId()) {
            case R.id.button_human:
                grammarTextId = R.string.word_human_text;
                break;
            case R.id.button_weather:
                grammarTextId = R.string.word_weather_text;
                break;
            default:
                grammarTextId = R.string.button_error;
        }

        String grammarText = getResources().getString(grammarTextId);

        intent.putExtra("text", grammarText);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nouns, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_nouns, container, false);
            LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_nouns, container, false);

            return rootView;
        }
    }
}
