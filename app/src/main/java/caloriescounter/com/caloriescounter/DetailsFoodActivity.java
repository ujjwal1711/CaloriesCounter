package caloriescounter.com.caloriescounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.CustomlistviewAdapter;
import data.DatabaseHandler;
import model.Food;
import util.Util;

public class DetailsFoodActivity extends AppCompatActivity {
    private DatabaseHandler dba;
    private ArrayList<Food> dbFoods = new ArrayList<>();
    private CustomlistviewAdapter foodAdapter;
    private ListView listView;

    private Food myFood;
    private TextView totalCals, totalFoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_food);
        listView = (ListView) findViewById(R.id.list);
        totalCals = (TextView) findViewById(R.id.totalamounttextview);
        totalFoods = (TextView) findViewById(R.id.totalitemtextview);

        refreshData();


    }

    private void refreshData() {
        dbFoods.clear();

        dba = new DatabaseHandler(getApplicationContext());

        ArrayList<Food> foodsFromDB = dba.getFoods();

        int calsValue = dba.totalCalories();
        int totalItems = dba.getTotalItems();
        String formattedValue = Util.formatNumber(calsValue);
        String formattedItems = Util.formatNumber(totalItems);

        totalCals.setText("Total Calories: " + formattedValue);
        totalFoods.setText("Total Foods: " + formattedItems);

        for (int i = 0; i < foodsFromDB.size(); i++) {

            String name = foodsFromDB.get(i).getFoodname();
            String dateText = foodsFromDB.get(i).getRecorddate();
            int cals = foodsFromDB.get(i).getCalories();
            int foodId = foodsFromDB.get(i).getFoodid();

            Log.v("FOOD IDS: ", String.valueOf(foodId));
            myFood = new Food();
            myFood.setFoodname(name);
            myFood.setRecorddate(dateText);
            myFood.setCalories(cals);
            myFood.setFoodid(foodId);

            dbFoods.add(myFood);



        }
        dba.close();

        foodAdapter = new CustomlistviewAdapter(DetailsFoodActivity.this, R.layout.list_row, dbFoods);
        listView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

    }
}