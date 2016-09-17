package com.beltonp.phil.budget.database.entities;

import com.beltonp.phil.budget.database.DatabaseHelper;
import com.beltonp.phil.budget.model.Income;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class EntityIncome
{
	Dao<Income, Integer> incomeDao;

	public EntityIncome(DatabaseHelper dbHelper)
	{
		try
		{
			incomeDao = dbHelper.getIncomeDao();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}

	public int create(Income income)
	{
		try
		{
			return incomeDao.create(income);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Income income)
	{
		try
		{
			return incomeDao.update(income);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Income income)
	{
		try
		{
			return incomeDao.delete(income);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public Income getById(int id)
	{
		try
		{
			QueryBuilder<Income, Integer> qb = incomeDao.queryBuilder();

			qb.where().eq("id", id);

			PreparedQuery<Income> pq = qb.prepare();
			return incomeDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public Income getByName(String name)
	{
		try
		{
			QueryBuilder<Income, Integer> qb = incomeDao.queryBuilder();

			qb.where().eq("name", name);

			PreparedQuery<Income> pq = qb.prepare();
			return incomeDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Income> getByPaid(Boolean paid)
	{
		try
		{
			QueryBuilder<Income, Integer> qb = incomeDao.queryBuilder();

			qb.where().eq("paid", paid);

			PreparedQuery<Income> pq = qb.prepare();
			return incomeDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Income> getByPayer(String payer)
	{
		try
		{
			QueryBuilder<Income, Integer> qb = incomeDao.queryBuilder();

			qb.where().eq("payer", payer);

			PreparedQuery<Income> pq = qb.prepare();
			return incomeDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Income> getAll()
	{
		try
		{
			return incomeDao.queryForAll();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
}
