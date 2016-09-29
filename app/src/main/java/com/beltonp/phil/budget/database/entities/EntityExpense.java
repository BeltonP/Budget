package com.beltonp.phil.budget.database.entities;

import com.beltonp.phil.budget.database.DatabaseHelper;
import com.beltonp.phil.budget.model.Expense;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class EntityExpense
{
	Dao<Expense, Integer> expenseDao;

	public EntityExpense(DatabaseHelper dbHelper)
	{
		try
		{
			expenseDao = dbHelper.getExpenseDao();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}

	public int create(Expense expense)
	{
		try
		{
			return expenseDao.create(expense);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Expense expense)
	{
		try
		{
			return expenseDao.update(expense);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Expense expense)
	{
		try
		{
			return expenseDao.delete(expense);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public Expense getById(int id)
	{
		try
		{
			QueryBuilder<Expense, Integer> qb = expenseDao.queryBuilder();

			qb.where().eq("id", id);

			PreparedQuery<Expense> pq = qb.prepare();
			return expenseDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Expense> getByName(String name)
	{
		try
		{
			QueryBuilder<Expense, Integer> qb = expenseDao.queryBuilder();

			qb.where().eq("name", name);

			PreparedQuery<Expense> pq = qb.prepare();
			return expenseDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Expense> getByPaid(Boolean paid)
	{
		try
		{
			QueryBuilder<Expense, Integer> qb = expenseDao.queryBuilder();

			qb.where().eq("paid", paid);

			PreparedQuery<Expense> pq = qb.prepare();
			return expenseDao.query(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Expense> getAllPaid()
	{
		return getByPaid(true);
	}

	public List<Expense> getAllUnpaid()
	{
		return getByPaid(false);
	}

	public List<Expense> getAll()
	{
		try
		{
			return expenseDao.queryForAll();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
}
