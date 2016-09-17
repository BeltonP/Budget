package com.beltonp.phil.budget.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.Income;
import com.beltonp.phil.budget.ui.adapters.IncomeListAdapter;

import java.util.ArrayList;

public class IncomeActivity extends AppCompatActivity
{
	static final int ADD_NEW_INCOME = 1;
	private DataModel model;

	private ListView listView;
	private IncomeListAdapter incomeListAdapter;
	ArrayList<Income> incomes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(getApplicationContext(), IncomeAddActivity.class);
				startActivityForResult(intent, ADD_NEW_INCOME);
			}
		});

		model = new DataModel(this);
		listView = (ListView)findViewById(R.id.list);
		listView.setEmptyView(findViewById(R.id.empty));
		incomes = new ArrayList<>(model.incomes.getAll());
		incomeListAdapter = new IncomeListAdapter(this, R.layout.layout_list_item, incomes);

		listView.setAdapter(incomeListAdapter);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		View decorView = getWindow().getDecorView();

		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (requestCode)
		{
			case ADD_NEW_INCOME:
				if (resultCode == RESULT_OK)
				{
					incomes = new ArrayList<>(model.incomes.getAll());
					incomeListAdapter.clear();
					incomeListAdapter.addAll(incomes);
					incomeListAdapter.notifyDataSetChanged();
					Snackbar.make(findViewById(R.id.coordinatorLayout), "Income added", Snackbar.LENGTH_LONG).show();
				}
				return;
			default:
				return;
		}
	}
}
