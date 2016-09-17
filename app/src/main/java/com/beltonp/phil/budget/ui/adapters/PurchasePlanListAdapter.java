package com.beltonp.phil.budget.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.model.PurchasePlan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PurchasePlanListAdapter extends ArrayAdapter
{
	private Context context;
	private int viewResourceId;
	private ArrayList<PurchasePlan> data = new ArrayList();

	public PurchasePlanListAdapter(Context context, int viewResourceId, ArrayList data)
	{
		super(context, viewResourceId, data);
		this.context = context;
		this.viewResourceId = viewResourceId;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		PurchasePlan purchasePlan = data.get(position);

		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		View row = inflater.inflate(viewResourceId, parent, false);

		SimpleDateFormat simpleDate = new SimpleDateFormat("d MMMM yyyy");
		String stringDate = simpleDate.format(purchasePlan.getPurchaseDate());

		TextView nameTextView = (TextView)row.findViewById(R.id.name);
		TextView dateTextView = (TextView)row.findViewById(R.id.date);
		TextView amountTextView = (TextView)row.findViewById(R.id.amount);

		nameTextView.setText(purchasePlan.getName());
		dateTextView.setText(stringDate);
		amountTextView.setText(purchasePlan.getTotalCostString());
		return row;
	}
}
