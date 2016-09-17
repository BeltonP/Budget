package com.beltonp.phil.budget.archive;

public class Currency
{
	private float value;

	public Currency(float value)
	{
		this.setValue(value);
	}

	@Override
	public String toString()
	{
		return "£" + String.format("%1$,.2f", value);
	}

	public float getValue()
	{
		return value;
	}

	public void setValue(float value)
	{
		this.value = value;
	}
}
