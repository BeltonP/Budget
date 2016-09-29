package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.database.entities.EntityIncome;
import com.beltonp.phil.budget.model.Income;

import java.util.List;

public class IncomeManager
{
	private static IncomeManager instance = null;

	private EntityIncome entityIncome;

	private IncomeManager(EntityIncome entityIncome)
	{
		this.entityIncome = entityIncome;
	}

	public static IncomeManager getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new IncomeManager(model.incomes);
		}
		return instance;
	}

	public float getTotalAmountOutstanding()
	{
		List<Income> outstandingIncomes = entityIncome.getAllUnpaid();
		float sum = 0f;
		for (Income income : outstandingIncomes)
		{
			sum += income.getValue();
		}
		return sum;
	}
}