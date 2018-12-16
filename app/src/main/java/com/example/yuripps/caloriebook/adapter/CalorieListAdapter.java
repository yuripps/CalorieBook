package com.example.yuripps.caloriebook.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuripps.caloriebook.R;
import com.example.yuripps.caloriebook.model.CalorieItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CalorieListAdapter extends ArrayAdapter<CalorieItem> {
    private Context mContext;
    private int mResource;
    private List<CalorieItem> mCalorieList;

    public CalorieListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<CalorieItem> calorieItemList) {
        super(context, resource, calorieItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mCalorieList = calorieItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView nameTextView = view.findViewById(R.id.name_text_view);
        TextView calorieTextView = view.findViewById(R.id.calorie_text_view);
        TextView unitTextView = view.findViewById(R.id.unit_text_view);
        ImageView imageView = view.findViewById(R.id.image_view);


        CalorieItem calorieItem = mCalorieList.get(position);
        String name = calorieItem.name;
        String calorie = calorieItem.calorie;
        String filename = calorieItem.image;
        String unit = calorieItem.unit;

        nameTextView.setText(name);
        calorieTextView.setText(calorie+" กิโลแคลอรี่");
        unitTextView.setText("1 "+unit);

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(filename);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        return view;
    }
}


