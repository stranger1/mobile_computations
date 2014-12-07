package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kpi.mobcomp.korean_grammar.storage.DBhandler;

import kpi.mobcomp.korean_grammar.R;
import kpi.mobcomp.korean_grammar.storage.GrammarEntrySchema;


public class ShowEntry extends BaseActivity {

    public String dataId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_entry);

        TextView textView = (TextView) findViewById(R.id.show_entry_text);
        Bundle extras = getIntent().getExtras();
        dataId = Integer.toString(extras.getInt("textId"));

        selectQuery = "select " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD
                + " from " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME
                + " where "
                + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + "=" + dataId;
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBhandler dBhandler = new DBhandler(this);
        SQLiteDatabase db = dBhandler.getReadableDatabase();


        Cursor resultSet = db.rawQuery(selectQuery, null);
        resultSet.moveToFirst();
        String grammarText = resultSet.getString(0);

        TextView textView = (TextView) findViewById(R.id.show_entry_text);
        textView.setText( grammarText );
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onEdit(View iView) {
        TextView textView = (TextView) findViewById(R.id.show_entry_text);
        textView.setVisibility(View.INVISIBLE);

        editText = new EditText( getBaseContext() );
        editText.setLayoutParams( new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT));
        editText.setText( textView.getText() );
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.container);
        layout.addView( editText );

        Button saveButton = new Button(getBaseContext());
        saveButton.setText( "Save" );
        updateQuery = "update " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME
                + " set " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD
                    + "=\'" + editText.getText().toString() + "\'"
                + " where " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + "=" + dataId;
        saveButton.setOnClickListener( saveHandler );
        layout.addView( saveButton );
    }

    private View.OnClickListener saveHandler = new View.OnClickListener() {
        public void onClick( View iView ) {
            updateQuery = "update " + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME
                    + " set " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD
                    + "=\'" + editText.getText().toString() + "\'"
                    + " where " + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + "=" + dataId;

            DBhandler dBhandler = new DBhandler(getApplicationContext());
            SQLiteDatabase db = dBhandler.getWritableDatabase();
            db.execSQL( updateQuery );
        }
    };

    EditText editText;
    private String selectQuery;
    private String updateQuery;
}
