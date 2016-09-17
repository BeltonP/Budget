package com.beltonp.phil.budget.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.model.Expense;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExpenseListAdapter extends ArrayAdapter
{
	private Context context;
	private int viewResourceId;
	private ArrayList<Expense> data = new ArrayList();

	public ExpenseListAdapter(Context context, int viewResourceId, ArrayList data)
	{
		super(context, viewResourceId, data);
		this.context = context;
		this.viewResourceId = viewResourceId;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Expense expense = data.get(position);

		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		View row = inflater.inflate(viewResourceId, parent, false);

		SimpleDateFormat simpleDate = new SimpleDateFormat("d MMMM yyyy");
		String stringDate = simpleDate.format(expense.getDueDate());

		TextView nameTextView = (TextView)row.findViewById(R.id.name);
		TextView dateTextView = (TextView)row.findViewById(R.id.date);
		TextView amountTextView = (TextView)row.findViewById(R.id.amount);

		nameTextView.setText(expense.getName());
		dateTextView.setText(stringDate);
		amountTextView.setText(expense.getValueString());
		return row;
	}
}
