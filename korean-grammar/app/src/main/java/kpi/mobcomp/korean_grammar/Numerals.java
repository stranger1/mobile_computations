package kpi.mobcomp.korean_grammar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Numerals extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerals);
    }

    public void showEntry(View iView) {
        Intent intent = new Intent( Numerals.this, ShowEntry.class );

        int grammarTextId;

        switch (iView.getId()) {
            //TODO
            default:
                grammarTextId = R.string.button_error;
        }

        String grammarText = "Under construction.";//getResources().getString(grammarTextId);

        intent.putExtra("text", grammarText);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.numerals, menu);
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