package kpi.mobcomp.korean_grammar.storage;

import android.provider.BaseColumns;

/**
 * Created by stranger on 14.11.2014.
 */
public final class GrammarEntrySchema {
    public GrammarEntrySchema(){}

    public static abstract class GrammarEntryStructure implements BaseColumns {
        public static final String DATABASE_NAME = "grammar.storage";

        public static final String TABLE_NAME = "grammarEntry";
        public static final String ENTRY_ID = "id";
        public static final String TITLE = "title";
        public static final String ENTRY_PAYLOAD = "entryPayload";

    }
}
