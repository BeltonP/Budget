package com.beltonp.phil.budget.model;

import com.beltonp.phil.budget.database.DataModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Expense extends Entity
{
	@DatabaseField
	private String name;
	@DatabaseField
	private float value;
	@DatabaseField
	private Date dueDate;
	@DatabaseField
	private Boolean paid;

	public Expense()
	{
	}

	public Expense(String name, Float value, Date dueDate)
	{
		this.name = name;
		this.value = value;
		this.dueDate = dueDate;
		this.paid = false;
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

	public Date getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	public Boolean getPaid()
	{
		return paid;
	}

	public void setPaid(Boolean paid)
	{
		this.paid = paid;
	}

	@Override
	public int save(DataModel model)
	{
		if (model.expenses.getById(this.id) == null)
		{
			return model.expenses.create(this);
		}
		else
		{
			return model.expenses.update(this);
		}
	}

	@Override
	public int delete(DataModel model)
	{
		return model.expenses.delete(this);
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
