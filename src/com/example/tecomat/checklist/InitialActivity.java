package com.example.tecomat.checklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class InitialActivity extends Activity implements OnClickListener {

	private static final int CRIAR_OBRA = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        
        Button button = (Button) findViewById(R.id.btNovaObra);        
        button.setOnClickListener(this);
        
        final Intent verObraIntent = new Intent(this, SeeWorkActivity.class);
        
        Button sel_button = (Button) findViewById(R.id.btSelObra);
        sel_button.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				startActivity(verObraIntent);
			}
        	
        });
    }
    
    @Override
	public void onClick(View v) {
    	
    	final Intent novaObraIntent = new Intent(this, NewWorkActivity.class);
		startActivityForResult(novaObraIntent, CRIAR_OBRA);
		
	}
    
    @Override
    public void onActivityResult(int codigo, int resultado, Intent it) {
    	if (codigo == CRIAR_OBRA) {
    		if (it == null) {
				return;
			}
    		
    		if (resultado == RESULT_OK) {
    			
    			Bundle returns = it.getExtras();
        		
        		if (returns != null) {
    				String nomeObra = returns.getString("nomeObra");
    				int qtBalanca = returns.getInt("qtBalanca");
    				int dtInicio = returns.getInt("dtInicio");
    				String[] obras = new String[] {nomeObra};
    				Spinner select = (Spinner) findViewById(R.id.slObras);
    				ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obras);
    				select.setAdapter(adapter);
    			}
			}
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_initial, menu);
        return true;
    }

    
}
