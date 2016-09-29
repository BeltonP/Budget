package com.beltonp.phil.budget.logic;

import com.beltonp.phil.budget.database.DataModel;
import com.beltonp.phil.budget.database.entities.EntityPurchasePlan;
import com.beltonp.phil.budget.model.PurchasePlan;

import java.util.List;

public class PurchasePlanManager
{
	private static PurchasePlanManager instance = null;

	private EntityPurchasePlan entityPurchasePlan;

	private PurchasePlanManager(EntityPurchasePlan entityPurchasePlan)
	{
		this.entityPurchasePlan = entityPurchasePlan;
	}

	public static PurchasePlanManager getInstance(DataModel model)
	{
		if (instance == null)
		{
			instance = new PurchasePlanManager(model.purchasePlans);
		}
		return instance;
	}

	public float getTotalAmountOutstanding()
	{
		List<PurchasePlan> outstandingPurchasePlans = entityPurchasePlan.getAllUnpaid();
		float sum = 0f;
		for (PurchasePlan purchasePlan : outstandingPurchasePlans)
		{
			sum += purchasePlan.getRemainingCost();
		}
		return sum;
	}
}
