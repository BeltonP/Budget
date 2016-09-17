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
import com.beltonp.phil.budget.model.Expense;
import com.beltonp.phil.budget.ui.adapters.ExpenseListAdapter;

import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity
{
	static final int ADD_NEW_EXPENSE = 1;
	ArrayList<Expense> expenses;
	private DataModel model;
	private ListView listView;
	private ExpenseListAdapter expenseListAdapter;

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
				Intent intent = new Intent(getApplicationContext(), ExpenseAddActivity.class);
				startActivityForResult(intent, ADD_NEW_EXPENSE);
			}
		});

		model = new DataModel(this);
		listView = (ListView)findViewById(R.id.list);
		listView.setEmptyView(findViewById(R.id.empty));
		expenses = new ArrayList<>(model.expenses.getAll());
		expenseListAdapter = new ExpenseListAdapter(this, R.layout.layout_list_item, expenses);

		listView.setAdapter(expenseListAdapter);
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
			case ADD_NEW_EXPENSE:
				if (resultCode == RESULT_OK)
				{
					expenses = new ArrayList<>(model.expenses.getAll());
					expenseListAdapter.clear();
					expenseListAdapter.addAll(expenses);
					expenseListAdapter.notifyDataSetChanged();
					Snackbar.make(findViewById(R.id.coordinatorLayout), "Expense added", Snackbar.LENGTH_LONG).show();
				}
				return;
			default:
				return;
		}
	}
}
