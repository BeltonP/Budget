package com.beltonp.phil.budget.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.beltonp.phil.budget.R;
import com.beltonp.phil.budget.ui.TileItem;

import java.util.ArrayList;

public class TileAdapter extends ArrayAdapter
{
	private Context context;
	private int viewResourceId;
	private ArrayList data = new ArrayList();

	public TileAdapter(Context context, int viewResourceId, ArrayList data)
	{
		super(context, viewResourceId, data);
		this.viewResourceId = viewResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		ViewHolder holder = null;

		if (row == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(viewResourceId, parent, false);
			holder = new ViewHolder();
			holder.text = (TextView)row.findViewById(R.id.name);
			holder.image = (ImageView)row.findViewById(R.id.image);
			row.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)row.getTag();
		}

		TileItem item = (TileItem)data.get(position);
		holder.text.setText(item.getValueString());
		holder.image.setImageDrawable(item.getImage());
		return row;
	}

	static class ViewHolder
	{
		TextView text;
		ImageView image;
	}

}
