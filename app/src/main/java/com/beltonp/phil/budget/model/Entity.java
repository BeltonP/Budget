package com.beltonp.phil.budget.model;

import com.beltonp.phil.budget.database.DataModel;
import com.j256.ormlite.field.DatabaseField;

public abstract class Entity
{
	@DatabaseField(generatedId = true)
	protected int id;

	int save(DataModel model)
	{
		return 1;
	}

	int delete(DataModel model)
	{
		return 1;
	}
}
