package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.database.entities.EntityExpense;
import com.beltonp.phil.budget.model.Expense;

import java.util.List;

public class ExpenseManager
{
	private static ExpenseManager instance = null;

	private EntityExpense entityExpense;

	private ExpenseManager(EntityExpense entityExpense)
	{
		this.entityExpense = entityExpense;
	}

	public static ExpenseManager getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new ExpenseManager(model.expenses);
		}
		return instance;
	}

	public float geTotalAmountOutstanding()
	{
		List<Expense> outstandingExpenses = entityExpense.getAllUnpaid();
		float sum = 0f;
		for(Expense expense: outstandingExpenses)
		{
			sum += expense.getValue();
		}
		return sum;
	}
}