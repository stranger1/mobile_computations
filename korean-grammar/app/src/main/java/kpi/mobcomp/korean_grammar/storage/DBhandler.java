package kpi.mobcomp.korean_grammar.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kpi.mobcomp.korean_grammar.storage.GrammarEntrySchema;


/**
 * Created by stranger on 14.11.2014.
 */
public class DBhandler extends SQLiteOpenHelper {
    public DBhandler(Context context) {
        super(context, GrammarEntrySchema.GrammarEntryStructure.DATABASE_NAME, null, 1);
    }

    public static final String SQL_TABLE_CREATE = "create table "
            + GrammarEntrySchema.GrammarEntryStructure.TABLE_NAME + " ("
            + GrammarEntrySchema.GrammarEntryStructure.ENTRY_ID + " integer primary key, "
            + GrammarEntrySchema.GrammarEntryStructure.TITLE + " text, "
            + GrammarEntrySchema.GrammarEntryStructure.ENTRY_PAYLOAD + "text)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( SQL_TABLE_CREATE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
