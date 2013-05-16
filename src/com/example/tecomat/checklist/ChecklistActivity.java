package com.example.tecomat.checklist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChecklistActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_checklist, menu);
        return true;
    }
}
