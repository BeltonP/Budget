package com.beltonp.phil.budget.ui;

import android.graphics.drawable.Drawable;


public class TileItem
{
	private String title;
	private Drawable image;
	private Float value;

	public enum Titles
	{
		BANK,
		WALLET,
		CREDIT_CARD,
		PURCHASE_PLAN,
		INCOME,
		EXPENSE,
		PERSONAL_SPENDING
	}

	public TileItem(String title, Drawable image, float value)
	{
		super();
		this.setTitle(title);
		this.setImage(image);
		this.setValue(value);
	}

	public String getTitle()
	{
		return title;
	}

	private void setTitle(String title)
	{
		this.title = title;
	}

	public Drawable getImage()
	{
		return image;
	}

	public void setImage(Drawable image)
	{
		this.image = image;
	}

	public String getValueString()
	{
		return "£" + String.format("%1$,.2f", value);
	}

	public Float getValue()
	{
		return value;
	}

	public void setValue(Float value)
	{
		this.value = value;
	}
}
