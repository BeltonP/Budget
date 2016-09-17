package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.KeyFigure;

public class Bank
{
	private static Bank instance = null;

	private KeyFigure keyFigure;

	private Bank(KeyFigure keyFigure)
	{
		this.keyFigure = keyFigure;
	}

	public static Bank getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new Bank(model.keyFigures.getByName("Bank"));
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

	public void save(DataModel model)
	{
		keyFigure.save(model);
	}
}
