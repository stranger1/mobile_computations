package kpi.mobcomp.korean_grammar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kpi.mobcomp.korean_grammar.R;


public class Grammar extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
    }

    public void showEntry(View iView) {
        Intent intent = new Intent( Grammar.this, ShowEntry.class );

        int grammarTextId;

        switch (iView.getId()) {
            case R.id.grammar_symnida:
                grammarTextId = R.string.grammar_symnida_text;
                break;
            case R.id.grammar_symnika:
                grammarTextId = R.string.grammar_symnika_text;
                break;
            default:
                grammarTextId = R.string.button_error;
        }

        String grammarText = getResources().getString(grammarTextId);

        intent.putExtra("text", grammarText);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.grammar, menu);
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
