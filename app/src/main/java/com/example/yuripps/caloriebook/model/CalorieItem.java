package com.example.yuripps.caloriebook.model;

import java.util.Locale;

public class CalorieItem {
    public final long _id;
    public final String name;
    public final String calorie;
    public final String image;
    public final String unit;

    public CalorieItem(long _id, String name, String calorie,String image,String unit) {
        this._id = _id;
        this.name = name;
        this.calorie = calorie;
        this.image = image;
        this.unit = unit;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s) (%s)",
                this.name,
                this.calorie,
                this.unit
        );
        return msg;
    }
}
