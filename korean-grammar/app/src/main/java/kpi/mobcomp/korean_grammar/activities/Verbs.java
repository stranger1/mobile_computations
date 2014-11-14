package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;


public class Verbs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbs);
    }

    public  void showEntry(View iView) {
        Intent intent = new Intent( Verbs.this, ShowEntry.class );

        int grammarTextId;

        switch (iView.getId()) {
            case R.id.button_to_like:
                grammarTextId = R.string.word_to_like_text;
                break;
            case R.id.button_to_love:
                grammarTextId = R.string.word_to_love_text;
                break;
            case R.id.button_to_travel:
                grammarTextId = R.string.word_to_travel_text;
                break;
            case R.id.button_to_wait:
                grammarTextId = R.string.word_to_wait_text;
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
        getMenuInflater().inflate(R.menu.verbs, menu);
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
}
