package com.beltonp.phil.budget.logic;

import android.content.Context;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.database.entities.EntityExpense;

public class DataManager
{
	private static DataManager instance = null;

	private DataModel model;
	public BankManager bankManager;
	public WalletManager walletManager;
	public CreditCardManager creditCardManager;
	public EntityExpense expenses;

	private DataManager(Context context)
	{
		model = new DataModel(context);
		bankManager = BankManager.getInstance(model);
		walletManager = WalletManager.getInstance(model);
		creditCardManager = CreditCardManager.getInstance(model);
		expenses = model.expenses;
	}

	public static DataManager getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new DataManager(context);
		}
		return instance;
	}
}
