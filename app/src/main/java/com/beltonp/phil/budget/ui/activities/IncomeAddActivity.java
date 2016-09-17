package com.beltonp.phil.budget.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.Income;

import java.util.Date;

public class IncomeAddActivity extends AppCompatActivity
{
	private DataModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income_add);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		model = new DataModel(this);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		View decorView = getWindow().getDecorView();

		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}

	protected void onSave(View view)
	{
		try
		{
			String name = ((EditText)findViewById(R.id.editTextName)).getText().toString();
			float value = Float.parseFloat(((EditText)findViewById(R.id.editTextValue)).getText().toString());
			String payer = ((EditText)findViewById(R.id.editTextPayer)).getText().toString();
			CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);

			Income newIncome = new Income(name, value, payer, new Date(calendarView.getDate()));
			newIncome.save(model);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		setResult(RESULT_OK);
		finish();
	}
}
