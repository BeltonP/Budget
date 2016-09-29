package com.beltonp.phil.budget.logic;

import android.content.Context;

import com.beltonp.phil.budget.database.DataModel;

public class DataManager
{
	private static DataManager instance = null;

	private DataModel model;
	public BankManager bankManager;
	public WalletManager walletManager;
	public CreditCardManager creditCardManager;
	public ExpenseManager expenseManager;
	public IncomeManager incomeManager;
	public PurchasePlanManager purchasePlanManager;

	private DataManager(Context context)
	{
		model = new DataModel(context);
		bankManager = BankManager.getInstance(model);
		walletManager = WalletManager.getInstance(model);
		creditCardManager = CreditCardManager.getInstance(model);
		expenseManager = ExpenseManager.getInstance(model);
		incomeManager = IncomeManager.getInstance(model);
		purchasePlanManager = PurchasePlanManager.getInstance(model);
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
