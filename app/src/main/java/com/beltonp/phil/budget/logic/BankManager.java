package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.KeyFigure;

public class BankManager
{
	private static BankManager instance = null;

	private KeyFigure keyFigure;
	private DataModel model;

	private BankManager(KeyFigure keyFigure, DataModel model)
	{
		this.keyFigure = keyFigure;
		this.model = model;
	}

	public static BankManager getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new BankManager(model.keyFigures.getByName(BankManager.class.getName()), model);
		}
		return instance;
	}

	public float getBalance()
	{
		return keyFigure.getValue();
	}

	public String getBalanceString()
	{
		return keyFigure.getValueString();
	}

	public void setBalance(float balance)
	{
		keyFigure.setValue(balance);
	}

	public void save()
	{
		keyFigure.save(model);
	}
}
