package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;
import kpi.mobcomp.korean_grammar.storage.DBhandler;

import kpi.mobcomp.korean_grammar.R;
import kpi.mobcomp.korean_grammar.storage.GrammarEntrySchema;


public class ShowEntry extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_entry);

        TextView textView = (TextView) findViewById(R.id.show_entry_text);
        Bundle extras = getIntent().getExtras();
        String dataId = Integer.toString(extras.getInt("textId"));

        DBhandler dBhandler = new DBhandler(this);
        SQLiteDatabase db = dBhandler.getReadableDatabase();

        String selectQuery = "select " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD
                + " from " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME
                + " where "
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + "=" + dataId;

        Cursor resultSet = db.rawQuery(selectQuery, null);
        resultSet.moveToFirst();
        String grammarText = resultSet.getString(0);

        textView.setText( grammarText );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_entry, menu);
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
