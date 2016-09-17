package com.beltonp.phil.budget.database;

import android.content.Context;

import com.beltonp.phil.budget.database.entities.EntityExpense;
import com.beltonp.phil.budget.database.entities.EntityIncome;
import com.beltonp.phil.budget.database.entities.EntityKeyFigure;
import com.beltonp.phil.budget.database.entities.EntityPurchasePlan;

public class DataModel
{
	private DatabaseHelper dbHelper;

	public EntityKeyFigure keyFigures;
	public EntityExpense expenses;
	public EntityIncome incomes;
	public EntityPurchasePlan purchasePlans;

	public DataModel(Context context)
	{
		DatabaseManager<DatabaseHelper> dbManager = new DatabaseManager<DatabaseHelper>();
		dbHelper = dbManager.getHelper(context);

		keyFigures = new EntityKeyFigure(dbHelper);
		expenses = new EntityExpense(dbHelper);
		incomes = new EntityIncome(dbHelper);
		purchasePlans = new EntityPurchasePlan(dbHelper);
	}
}
