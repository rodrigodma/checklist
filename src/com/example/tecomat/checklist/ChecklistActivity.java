package com.example.tecomat.checklist;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ChecklistActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        
        final EditText textNomeObra = (EditText) findViewById(R.id.etNovaObra);
        final EditText textQtdeBalanca = (EditText) findViewById(R.id.etQtdeBalanca);
        final EditText textDataInicio = (EditText) findViewById(R.id.etDataInicio);
        
        Button button = (Button) findViewById(R.id.btCriarObra);
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String nObra = textNomeObra.getText().toString();
				int qtdeBalanca = Integer.parseInt(textQtdeBalanca.getText().toString());
				int dtInicio = Integer.parseInt(textDataInicio.getText().toString());
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_checklist, menu);
        return true;
    }
}
