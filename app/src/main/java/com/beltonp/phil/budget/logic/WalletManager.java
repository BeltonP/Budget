package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.model.KeyFigure;

public class WalletManager
{
	private static WalletManager instance = null;

	private KeyFigure keyFigure;
	private DataModel model;

	private WalletManager(KeyFigure keyFigure, DataModel model)
	{
		this.keyFigure = keyFigure;
		this.model = model;
	}

	public static WalletManager getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new WalletManager(model.keyFigures.getByName(WalletManager.class.getName()), model);
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
