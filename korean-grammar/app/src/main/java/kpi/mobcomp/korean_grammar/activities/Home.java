package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;


public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Button buttonNoun = (Button) findViewById( R.id.button_noun );
//        buttonNoun.setOnClickListener(  );
    }

    /** Called when the "Basic words (noun)" button is clicked */
    public void startNouns(View iView) {
        Intent intent = new Intent( this, nouns.class );

        startActivity(intent);
    }

    public void startVerbs(View iView) {
        Intent intent = new Intent( this, Verbs.class );

        startActivity(intent);
    }

    public void startGrammar(View iView) {
        Intent intent = new Intent( this, Grammar.class );

        startActivity(intent);
    }

    public void startNumbers(View iView) {
        Intent intent = new Intent( this, Numerals.class );

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
