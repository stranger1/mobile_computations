package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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


public class ShowEntry extends Activity {

    /** SQL test method. Do not use */
    public void populate(DBhandler iDBhandler) {
        SQLiteDatabase db = iDBhandler.getWritableDatabase();

        db.execSQL( "insert into " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME + "("
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + ","
                + GrammarEntrySchema.GrammarEntryStructure.TITLE + ","
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD + ")"

                + " VALUES ("
                + R.id.grammar_symnida + ","
                + "'" + getString(R.string.grammar_symnida) + "'" + ","
                + "'" + getString(R.string.grammar_symnida_text) + "')");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_entry);

        TextView textView = (TextView) findViewById(R.id.show_entry_text);
        Bundle extras = getIntent().getExtras();
        textView.setText(extras.getString("text"));
        DBhandler database = new DBhandler(this.getBaseContext());
//        populate(database);
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
