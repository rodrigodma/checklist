package com.example.tecomat.checklist;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

public class SeeWorkActivity extends ExpandableListActivity {
	
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		// this is not really  necessary as ExpandableListActivity contains an ExpandableList
		//setContentView(R.layout.main);
		
		
		ExpandableListView expandableList = getExpandableListView(); // you can use (ExpandableListView) findViewById(R.id.list)
		
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();

		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
	}

	public void setGroupParents() {
		parentItems.add("Limpeza da Base");
		parentItems.add("Chapisco");
		parentItems.add("Emboço");
		parentItems.add("Cerâmica");
		parentItems.add("Rejunte");
		parentItems.add("Selante");
	}

	public void setChildData() {
		
		// Limpeza
		ArrayList<String> child = new ArrayList<String>();
		child.add("Limpeza com passagem de escova de aço");
		childItems.add(child);
				
		// Chapisco
		child = new ArrayList<String>();
		child.add("Execução de molhagem antes do chapisco");
		child.add("Proporção dos materiais em quantidades conhecidas e controladas");
		childItems.add(child);
		
		// Emboço
		child = new ArrayList<String>();
		child.add("Espera mínima de 48 horas após a execução do chapisco");
		child.add("Utilização de tela metálica para espessuras > 40mm");
		child.add("Emprego das telas metálicas definidas no projeto");
		child.add("Proporção dos materiais utilizados para a mistura");
		child.add("Dimensões dos cortes das juntas (12mm x 30mm)");
		child.add("Execução de cura úmida");
		childItems.add(child);
		
		// Assentamento
		child = new ArrayList<String>();
		child.add("Molhagem do emboço antes da aplicação da cerâmica");
		child.add("Prazo mínimo de 14 após a execução do emboço");
		child.add("Rastreamento dos lotes dos materiais (cerâmica/AC)");
		child.add("Quantidade de água colocada na mistura");
		child.add("Mistura da argamassa colante com equipamento mecânico");
		child.add("Dimensões mínimas de (6x6x6)mm das desempenadeiras");
		child.add("Preenchimento total do tardoz da cerâmica com AC");
		child.add("Espessura de 6mm no encontro com o contra marco");
		childItems.add(child);
		
		// Rejunte
		child = new ArrayList<String>();
		child.add("Prazo mínimo de 72 horas após a aplicação da cerâmica");
		child.add("Rastreamento dos lotes de rejunte");
		child.add("Quantidade de água colocada na mistura");
		childItems.add(child);
		
		// Selante
		child = new ArrayList<String>();
		child.add("Realização de treinamento dado pelo fornecedor");
		child.add("Limpeza da borda da cerâmica com pano com álcool");
		child.add("Colocação de fita crepe nas bordas da cerâmica");
		child.add("Acabamento superficial arredondado");
		child.add("Execução de acabamento nos encontros com rejunte");
		childItems.add(child);
	}
}
