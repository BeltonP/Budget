package com.beltonp.phil.budget.logic;

import android.content.Context;

import com.beltonp.phil.budget.database.DataModel;

public class BudgetManager
{
	private static BudgetManager instance = null;

	private DataModel model;
	public Bank bank;
	public Wallet wallet;
	public CreditCard creditCard;

	private BudgetManager(Context context)
	{
		model = new DataModel(context);
		bank = Bank.getInstance(model);
		wallet = Wallet.getInstance(model);
		creditCard = CreditCard.getInstance(model);
	}

	public static BudgetManager getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new BudgetManager(context);
		}
		return instance;
	}
}
