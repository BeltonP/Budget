package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.KeyFigure;

public class CreditCard
{
	private static CreditCard instance = null;

	private KeyFigure keyFigure;

	private CreditCard(KeyFigure keyFigure)
	{
		this.keyFigure = keyFigure;
	}

	public static CreditCard getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new CreditCard(model.keyFigures.getByName("Credit Card"));
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
