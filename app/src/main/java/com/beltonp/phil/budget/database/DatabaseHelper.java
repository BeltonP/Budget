package com.beltonp.phil.budget.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.beltonp.phil.budget.model.Expense;
import com.beltonp.phil.budget.model.Income;
import com.beltonp.phil.budget.model.KeyFigure;
import com.beltonp.phil.budget.model.PurchasePlan;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
	private static final String DATABASE_NAME = "budget.db";
	private static final int DATABASE_VERSION = 3;

	private Dao<KeyFigure, Integer> keyFigureDao = null;
	private Dao<Expense, Integer> expenseDao = null;
	private Dao<Income, Integer> incomeDao = null;
	private Dao<PurchasePlan,Integer> purchasePlanDao = null;
	
	public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource)
	{
		try
		{
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, KeyFigure.class);
			TableUtils.createTable(connectionSource, Expense.class);
			TableUtils.createTable(connectionSource, Income.class);
			TableUtils.createTable(connectionSource, PurchasePlan.class);
		}
		catch (SQLException e)
		{
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion)
	{
		try
		{
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, KeyFigure.class, true);
			TableUtils.dropTable(connectionSource, Expense.class, true);
			TableUtils.dropTable(connectionSource, Income.class, true);
			TableUtils.dropTable(connectionSource, PurchasePlan.class, true);
			onCreate(db, connectionSource);
		}
		catch (SQLException e)
		{
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	public Dao<KeyFigure, Integer> getKeyFigureDao() throws SQLException
	{
		if (keyFigureDao == null)
		{
			keyFigureDao = getDao(KeyFigure.class);
		}
		return keyFigureDao;
	}

	public Dao<Expense, Integer> getExpenseDao() throws SQLException
	{
		if (expenseDao == null)
		{
			expenseDao = getDao(Expense.class);
		}
		return expenseDao;
	}

	public Dao<Income, Integer> getIncomeDao() throws SQLException
	{
		if (incomeDao == null)
		{
			incomeDao = getDao(Income.class);
		}
		return incomeDao;
	}

	public Dao<PurchasePlan, Integer> getPurchasePlanDao() throws SQLException
	{
		if (purchasePlanDao == null)
		{
			purchasePlanDao = getDao(PurchasePlan.class);
		}
		return purchasePlanDao;
	}
	@Override
	public void close()
	{
		super.close();
		keyFigureDao = null;
		expenseDao = null;
		incomeDao = null;
		purchasePlanDao = null;
	}
}
