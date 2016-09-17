package com.beltonp.phil.budget.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.helpers.StringHelper;
import com.beltonp.phil.budget.logic.BudgetManager;
import com.beltonp.phil.budget.model.KeyFigure;
import com.beltonp.phil.budget.ui.TileItem;
import com.beltonp.phil.budget.ui.adapters.TileAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity
{
	private DataModel model;
	private BudgetManager budgetManager;

	private GridView gridView;
	private TileAdapter gridAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		budgetManager = BudgetManager.getInstance(this);
		model = new DataModel(this);
		gridView = (GridView)findViewById(R.id.gridView);
		gridAdapter = new TileAdapter(this, R.layout.layout_tile, getData());
		gridView.setAdapter(gridAdapter);

		gridView.setOnItemClickListener(getOnGridViewItemClickListener());
	}

	@NonNull
	private AdapterView.OnItemClickListener getOnGridViewItemClickListener()
	{
		return new AdapterView.OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, final View view,
									int position, long id)
			{
				final TileItem item = (TileItem)parent.getItemAtPosition(position);
				Intent intent;
				switch (item.getTitle())
				{
					case "Expense":
						intent = new Intent(getApplicationContext(), ExpenseActivity.class);
						startActivity(intent);
						return;
					case "Income":
						intent = new Intent(getApplicationContext(), IncomeActivity.class);
						startActivity(intent);
						return;
					case "Purchase Plan":
						intent = new Intent(getApplicationContext(), PurchasePlanActivity.class);
						startActivity(intent);
						return;
					default:
						AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

						final EditText input = new EditText(HomeActivity.this);
						input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
						builder.setView(input);
						builder.setIcon(item.getImage());
						builder.setTitle(item.getTitle() + " " + item.getValueString());

						builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int which)
							{
								try
								{
									if (!Objects.equals(input.getText().toString(), ""))
									{
										float value = Float.parseFloat(input.getText().toString());
										item.setValue(value);
										KeyFigure figure = model.keyFigures.getByName(item.getTitle());
										if (figure == null)
										{
											figure = new KeyFigure(item.getTitle(), value);
										}
										figure.setValue(value);
										figure.save(model);
										gridAdapter.notifyDataSetChanged();
									}
								}
								catch (NumberFormatException e)
								{
									Snackbar.make(view, "Invalid input", Snackbar.LENGTH_LONG).show();
								}
							}
						});
						builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int which)
							{
								dialog.cancel();
							}
						});
						AlertDialog dialog = builder.create();
						dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
						dialog.show();
				}
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_menu, menu);
		return true;
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		View decorView = getWindow().getDecorView();

		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.action_settings:
				// Invoke the Settings activity here.
				Snackbar.make(findViewById(android.R.id.content), "You selected Settings", Snackbar.LENGTH_LONG).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private ArrayList<TileItem> getData()
	{
		final ArrayList<TileItem> tileItems = new ArrayList<>();
		LinkedHashMap<String, String> drawables = StringHelper.getMapFromStringArray(this, R.array.tiles);
		for (Map.Entry<String, String> entry : drawables.entrySet())
		{
			String title = entry.getKey();
			Drawable drawable = ResourcesCompat.getDrawable(getResources(), getResources().getIdentifier(entry.getValue(), "drawable", this.getPackageName()), null);
			KeyFigure figure = model.keyFigures.getByName(title);
			float value = figure == null ? 0f : figure.getValue();
			TileItem item = new TileItem(title, drawable, value);
			tileItems.add(item);
		}
		Drawable drawable = ResourcesCompat.getDrawable(getResources(), getResources().getIdentifier(drawables.get("Bank"), "drawable", this.getPackageName()), null);
		tileItems.add(new TileItem("Bank", drawable, budgetManager.bank.getBalance()));
		return tileItems;
	}
}