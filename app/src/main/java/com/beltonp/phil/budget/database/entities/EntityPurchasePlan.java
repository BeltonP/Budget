package com.beltonp.phil.budget.database.entities;

import com.beltonp.phil.budget.database.DatabaseHelper;
import com.beltonp.phil.budget.model.PurchasePlan;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class EntityPurchasePlan
{
	Dao<PurchasePlan, Integer> purchasePlanDao;

	public EntityPurchasePlan(DatabaseHelper dbHelper)
	{
		try
		{
			purchasePlanDao = dbHelper.getPurchasePlanDao();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}

	public int create(PurchasePlan purchasePlan)
	{
		try
		{
			return purchasePlanDao.create(purchasePlan);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int update(PurchasePlan purchasePlan)
	{
		try
		{
			return purchasePlanDao.update(purchasePlan);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(PurchasePlan purchasePlan)
	{
		try
		{
			return purchasePlanDao.delete(purchasePlan);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public PurchasePlan getById(int id)
	{
		try
		{
			QueryBuilder<PurchasePlan, Integer> qb = purchasePlanDao.queryBuilder();

			qb.where().eq("id", id);

			PreparedQuery<PurchasePlan> pq = qb.prepare();
			return purchasePlanDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<PurchasePlan> getByName(String name)
	{
		try
		{
			QueryBuilder<PurchasePlan, Integer> qb = purchasePlanDao.queryBuilder();

			qb.where().eq("name", name);

			PreparedQuery<PurchasePlan> pq = qb.prepare();
			return purchasePlanDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<PurchasePlan> getAllPaid()
	{
		try
		{
			QueryBuilder<PurchasePlan, Integer> qb = purchasePlanDao.queryBuilder();

			qb.where().eq("remainingCost", 0);

			PreparedQuery<PurchasePlan> pq = qb.prepare();
			return purchasePlanDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<PurchasePlan> getAllUnpaid()
	{
		try
		{
			QueryBuilder<PurchasePlan, Integer> qb = purchasePlanDao.queryBuilder();

			qb.where().gt("remainingCost", 0);

			PreparedQuery<PurchasePlan> pq = qb.prepare();
			return purchasePlanDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<PurchasePlan> getAll()
	{
		try
		{
			return purchasePlanDao.queryForAll();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
}
