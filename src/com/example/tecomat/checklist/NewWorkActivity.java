package com.example.tecomat.checklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewWorkActivity extends Activity implements OnClickListener {

	protected EditText textNomeObra;
	protected EditText textQtdeBalanca;
	protected EditText textDataInicio;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_work);
        
        textNomeObra = (EditText) findViewById(R.id.etNovaObra);
        textQtdeBalanca = (EditText) findViewById(R.id.etQtdeBalanca);
        textDataInicio = (EditText) findViewById(R.id.etDataInicio);
        
        Button button = (Button) findViewById(R.id.btCriarObra);
        
        button.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
		/*String nObra = textNomeObra.getText().toString();
		int qtdeBalanca = Integer.parseInt(textQtdeBalanca.getText().toString());
		int dtInicio = Integer.parseInt(textDataInicio.getText().toString());*/
		
    	Intent backToInit = new Intent(this, InitialActivity.class);
    	
    	backToInit.putExtra("nomeObra", textNomeObra.getText().toString());
    	backToInit.putExtra("qtBalancas", Integer.parseInt(textQtdeBalanca.getText().toString()));
    	backToInit.putExtra("dtInicio", Integer.parseInt(textDataInicio.getText().toString()));
    	
		setResult(RESULT_OK, backToInit);
		
		finish();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_new_work, menu);
        return true;
    }
}
