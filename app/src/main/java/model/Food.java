package model;

import java.io.Serializable;



public class Food implements Serializable{
    private static  final long serialversionuid=10L;
    private String foodname;
    private int calories;
    private int foodid;
    private String recorddate;

    public Food(String foodname, int calories, int foodid, String recorddate) {
        this.foodname = foodname;
        this.calories = calories;
        this.foodid = foodid;
        this.recorddate = recorddate;
    }
     public Food()
     {

     }
    public static long getSerialversionuid() {
        return serialversionuid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(String recorddate) {
        this.recorddate = recorddate;
    }
}
