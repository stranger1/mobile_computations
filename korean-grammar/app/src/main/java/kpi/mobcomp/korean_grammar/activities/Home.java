package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;
import kpi.mobcomp.korean_grammar.storage.DBhandler;


public class Home extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
/*
        DBhandler dBhandler = new DBhandler( this );
        resetDatabase( dBhandler.getWritableDatabase() );*/
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
}
