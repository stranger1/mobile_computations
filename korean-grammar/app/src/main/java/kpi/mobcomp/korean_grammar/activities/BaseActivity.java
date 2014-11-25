package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import kpi.mobcomp.korean_grammar.R;
import kpi.mobcomp.korean_grammar.storage.DBhandler;
import kpi.mobcomp.korean_grammar.storage.GrammarEntrySchema;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.reset_database) {
            DBhandler dbhandler = new DBhandler(this.getBaseContext());
            resetDatabase(dbhandler.getWritableDatabase());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void resetDatabase(SQLiteDatabase db) {
        db.execSQL( "delete from " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME );

        db.execSQL( "insert into " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME + "("
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + ","
                + GrammarEntrySchema.GrammarEntryStructure.TITLE + ","
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD + ")"

                + " VALUES "

                + "(" + R.id.grammar_symnida + ","
                + "'" + getString(R.string.grammar_symnida) + "'" + ","
                + "'" + getString(R.string.grammar_symnida_text) + "'), "

                + "(" + R.id.grammar_symnika + ","
                + "'" + getString(R.string.grammar_symnika) + "'" + ","
                + "'" + getString(R.string.grammar_symnika_text) + "'), "

                + "(" + R.id.button_human + ","
                + "'" + getString(R.string.word_human) + "'" + ","
                + "'" + getString(R.string.word_human_text) + "'), "

                + "(" + R.id.button_tree + ","
                + "'" + getString(R.string.word_tree) + "'" + ","
                + "'" + getString(R.string.word_tree_text) + "'), "

                + "(" + R.id.button_market + ","
                + "'" + getString(R.string.word_market) + "'" + ","
                + "'" + getString(R.string.word_market_text) + "'), "

                + "(" + R.id.button_weather + ","
                + "'" + getString(R.string.word_weather) + "'" + ","
                + "'" + getString(R.string.word_weather_text) + "'), "

                + "(" + R.id.button_to_wait + ","
                + "'" + getString(R.string.word_to_wait) + "'" + ","
                + "'" + getString(R.string.word_to_wait_text) + "'), "

                + "(" + R.id.button_to_like + ","
                + "'" + getString(R.string.word_to_like) + "'" + ","
                + "'" + getString(R.string.word_to_like_text) + "'), "

                + "(" + R.id.button_to_love + ","
                + "'" + getString(R.string.word_to_love) + "'" + ","
                + "'" + getString(R.string.word_to_love_text) + "'), "

                + "(" + R.id.button_to_travel + ","
                + "'" + getString(R.string.word_to_travel) + "'" + ","
                + "'" + getString(R.string.word_to_travel_text) + "'), "

                + "(" + R.id.numerals_korean + ","
                + "'" + getString(R.string.numerals_korean) + "'" + ","
                + "'" + getString(R.string.numerals_korean_text) + "'), "

                + "(" + R.id.numerals_sinokorean + ","
                + "'" + getString(R.string.numerals_sinokorean) + "'" + ","
                + "'" + getString(R.string.numerals_sinokorean_text) + "'), "
        );
        /** populating */
    }
}
