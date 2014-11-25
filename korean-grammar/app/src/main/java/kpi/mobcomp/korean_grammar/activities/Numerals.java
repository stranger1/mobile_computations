package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;


public class Numerals extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerals);
    }

    public void showEntry(View iView) {
        Intent intent = new Intent( Numerals.this, ShowEntry.class );

        intent.putExtra("textId", iView.getId());
        startActivity(intent);
    }
}
