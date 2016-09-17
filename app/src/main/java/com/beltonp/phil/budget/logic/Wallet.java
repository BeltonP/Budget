package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.KeyFigure;

public class Wallet
{
	private static Wallet instance = null;

	private KeyFigure keyFigure;

	private Wallet(KeyFigure keyFigure)
	{
		this.keyFigure = keyFigure;
	}

	public static Wallet getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new Wallet(model.keyFigures.getByName("Wallet"));
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
