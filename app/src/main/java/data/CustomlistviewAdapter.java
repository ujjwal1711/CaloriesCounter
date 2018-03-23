package data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


import caloriescounter.com.caloriescounter.Fooditemdetails;
import caloriescounter.com.caloriescounter.R;
import model.Food;

/**
 * Created by UjjwalNUtsav on 22-03-2018.
 */

public class CustomlistviewAdapter extends ArrayAdapter<Food>{
    private int layoutresource;
    private Activity activity;
    private ArrayList<Food> foodlist = new ArrayList<>();
    public CustomlistviewAdapter(Activity act, @LayoutRes int resource,ArrayList<Food> data) {
        super(act, resource, data);
        layoutresource = resource;
        activity=act;
        foodlist=data;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return foodlist.size();
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return foodlist.get(position);
    }

    @Override
    public int getPosition(@Nullable Food item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = null;

        if ( row == null || (row.getTag() == null)) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            row = inflater.inflate(layoutresource, null);

            holder = new ViewHolder();

            holder.foodname = (TextView) row.findViewById(R.id.name);
            holder.fooddate = (TextView) row.findViewById(R.id.dateText);
            holder.foodcalorie = (TextView) row.findViewById(R.id.calories);

            row.setTag(holder);

        }else {

            holder = (ViewHolder) row.getTag();
        }


        holder.food = getItem(position);

        holder.foodname.setText(holder.food.getFoodname());
        holder.fooddate.setText(holder.food.getRecorddate());
        holder.foodcalorie.setText(String.valueOf(holder.food.getCalories()));


        final ViewHolder finalHolder = holder;

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, Fooditemdetails.class);

                Bundle mBundle = new Bundle();
                mBundle.putSerializable("userObj", finalHolder.food);
                i.putExtras(mBundle);


                activity.startActivity(i);


            }
        });







        return row;

    }
    public  class ViewHolder{

        Food food;
        TextView foodname;
        TextView foodcalorie;
        TextView fooddate;
    }
}
