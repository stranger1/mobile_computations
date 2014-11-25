package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;
import kpi.mobcomp.korean_grammar.storage.DBhandler;
import kpi.mobcomp.korean_grammar.storage.GrammarEntrySchema;


public class Grammar extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
    }

    public void showEntry(View iView) {
        Intent intent = new Intent( Grammar.this, ShowEntry.class );

        intent.putExtra("textId", iView.getId());
        startActivity(intent);
    }

}
