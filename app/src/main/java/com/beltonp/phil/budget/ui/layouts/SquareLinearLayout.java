package com.beltonp.phil.budget.ui.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class SquareLinearLayout extends LinearLayout
{
	public SquareLinearLayout(Context context)
	{
		super(context);
	}

	public SquareLinearLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public SquareLinearLayout(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	public SquareLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, widthMeasureSpec*9/100);
	}
}
