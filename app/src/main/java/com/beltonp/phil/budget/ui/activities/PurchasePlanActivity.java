package com.beltonp.phil.budget.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.PurchasePlan;
import com.beltonp.phil.budget.ui.adapters.PurchasePlanListAdapter;

import java.util.ArrayList;

public class PurchasePlanActivity extends AppCompatActivity
{
	private DataModel model;

	private ListView listView;
	private PurchasePlanListAdapter purchasePlanListAdapter;

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
				Snackbar.make(view, "This will add a purchase plan", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		model = new DataModel(this);
		listView = (ListView)findViewById(R.id.list);
		listView.setEmptyView(findViewById(R.id.empty));
		ArrayList<PurchasePlan> purchasePlans = new ArrayList<>(model.purchasePlans.getAll());
		purchasePlanListAdapter = new PurchasePlanListAdapter(this, R.layout.layout_list_item, purchasePlans);

		listView.setAdapter(purchasePlanListAdapter);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		View decorView = getWindow().getDecorView();

		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}
}
