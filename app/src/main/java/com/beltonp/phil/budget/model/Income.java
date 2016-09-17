package com.beltonp.phil.budget.model;

import com.beltonp.phil.budget.database.DataModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Income extends Entity
{
	@DatabaseField
	private String name;
	@DatabaseField
	private float value;
	@DatabaseField
	private String payer;
	@DatabaseField
	private Date creationDate;
	@DatabaseField
	private Boolean paid;

	public Income()
	{
	}

	public Income(String name, float value, String payer, Date creationDate)
	{
		this.name = name;
		this.value = value;
		this.payer = payer;
		this.creationDate = creationDate;
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

	public String getPayer()
	{
		return payer;
	}

	public void setPayer(String payer)
	{
		this.payer = payer;
	}

	public Date getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
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
		if (model.incomes.getById(this.id) == null)
		{
			return model.incomes.create(this);
		}
		else
		{
			return model.incomes.update(this);
		}
	}

	@Override
	public int delete(DataModel model)
	{
		return model.incomes.delete(this);
	}

	@Override
	public String toString()
	{
		return name;
	}
}
