package com.beltonp.phil.budget.model;

import com.beltonp.phil.budget.database.DataModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class KeyFigure extends Entity
{
	@DatabaseField(unique = true)
	private String name;
	@DatabaseField
	private float value;

	public KeyFigure()
	{
	}

	public KeyFigure(String name, float value)
	{
		this.setName(name);
		this.setValue(value);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getValue()
	{
		return value;
	}

	public String getValueString()
	{
		return "£" + String.format("%1$,.2f", value);
	}

	public void setValue(float value)
	{
		this.value = value;
	}

	public int save(DataModel model)
	{
		if (model.keyFigures.getById(this.id) == null)
		{
			return model.keyFigures.create(this);
		}
		else
		{
			return model.keyFigures.update(this);
		}
	}

	public int delete(DataModel model)
	{
		return model.keyFigures.delete(this);
	}

	@Override
	public String toString()
	{
		return name;
	}
}