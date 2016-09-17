package com.beltonp.phil.budget.database.entities;

import com.beltonp.phil.budget.database.DatabaseHelper;
import com.beltonp.phil.budget.model.KeyFigure;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class EntityKeyFigure
{
	Dao<KeyFigure, Integer> keyFigureDao;

	public EntityKeyFigure(DatabaseHelper dbHelper)
	{
		try
		{
			keyFigureDao = dbHelper.getKeyFigureDao();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}

	public int create(KeyFigure keyFigure)
	{
		try
		{
			return keyFigureDao.create(keyFigure);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int update(KeyFigure keyFigure)
	{
		try
		{
			return keyFigureDao.update(keyFigure);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(KeyFigure keyFigure)
	{
		try
		{
			return keyFigureDao.delete(keyFigure);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public KeyFigure getById(int id)
	{
		try
		{
			QueryBuilder<KeyFigure, Integer> qb = keyFigureDao.queryBuilder();

			qb.where().eq("id", id);

			PreparedQuery<KeyFigure> pq = qb.prepare();
			return keyFigureDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public KeyFigure getByName(String name)
	{
		try
		{
			QueryBuilder<KeyFigure, Integer> qb = keyFigureDao.queryBuilder();

			qb.where().eq("name", name);

			PreparedQuery<KeyFigure> pq = qb.prepare();
			return keyFigureDao.queryForFirst(pq);
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<KeyFigure> getAll()
	{
		try
		{
			return keyFigureDao.queryForAll();
		}
		catch (SQLException e)
		{
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
}
