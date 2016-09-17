package com.beltonp.phil.budget.model;

import com.beltonp.phil.budget.database.DataModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class PurchasePlan extends Entity
{
	@DatabaseField
	private String name;
	@DatabaseField
	private float totalCost;
	@DatabaseField
	private float remainingCost;
	@DatabaseField
	private float repaymentAmount;
	@DatabaseField
	private Date purchaseDate;

	public PurchasePlan()
	{
	}

	public PurchasePlan(String name, float totalCost, Date purchaseDate)
	{
		this.name = name;
		this.totalCost = totalCost;
		this.remainingCost = totalCost;
		this.repaymentAmount = 0f;
		this.purchaseDate = purchaseDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getTotalCost()
	{
		return totalCost;
	}

	public String getTotalCostString()
	{
		return "£" + String.format("%1$,.2f", totalCost);
	}

	public void setTotalCost(float totalCost)
	{
		this.totalCost = totalCost;
	}

	public float getRemainingCost()
	{
		return remainingCost;
	}

	public String getRemainingCostString()
	{
		return "£" + String.format("%1$,.2f", remainingCost);
	}

	public void setRemainingCost(float remainingCost)
	{
		this.remainingCost = remainingCost;
	}

	public float getRepaymentAmount()
	{
		return repaymentAmount;
	}

	public String getRepaymentAmountString()
	{
		return "£" + String.format("%1$,.2f", repaymentAmount);
	}

	public void setRepaymentAmount(float repaymentAmount)
	{
		this.repaymentAmount = repaymentAmount;
	}

	public Date getPurchaseDate()
	{
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int save(DataModel model)
	{
		if (model.purchasePlans.getById(this.id) == null)
		{
			return model.purchasePlans.create(this);
		}
		else
		{
			return model.purchasePlans.update(this);
		}
	}

	@Override
	public int delete(DataModel model)
	{
		return model.purchasePlans.delete(this);
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
