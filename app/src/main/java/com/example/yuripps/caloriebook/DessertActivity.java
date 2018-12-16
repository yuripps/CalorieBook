package com.example.yuripps.caloriebook;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.yuripps.caloriebook.AddCalorieActivity;
import com.example.yuripps.caloriebook.adapter.CalorieListAdapter;
import com.example.yuripps.caloriebook.db.DatabaseHelper;
import com.example.yuripps.caloriebook.model.CalorieItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_CALORIE;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_ID;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_IMAGE;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_NAME;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.DESSERTS_TABLE;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_UNIT;

import static com.example.yuripps.caloriebook.EditCalorieItemActivity.Table_name;

public class DessertActivity extends AppCompatActivity {


    private static final String TAG = com.example.yuripps.caloriebook.MainActivity.class.getName();

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<CalorieItem> mCalorieItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        mHelper = new DatabaseHelper(DessertActivity.this);
        mDb = mHelper.getWritableDatabase();

        ImageView addCalorie = findViewById(R.id.add_image);
        addCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DessertActivity.this,AddCalorieActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPhoneData();
        setupListView();
    }
    private void loadPhoneData() {

        Cursor c = mDb.query(DESSERTS_TABLE, null, null, null, null, null, null);
        mCalorieItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String name = c.getString(c.getColumnIndex(COL_NAME));;
            String calorie = c.getString(c.getColumnIndex(COL_CALORIE));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));
            String unit = c.getString(c.getColumnIndex(COL_UNIT));

            CalorieItem item = new CalorieItem(id, name, calorie, image, unit);
            mCalorieItemList.add(item);
        }
        c.close();
    }

    private void setupListView() {
        CalorieListAdapter adapter = new CalorieListAdapter(
                DessertActivity.this,
                R.layout.item_calorie,
                mCalorieItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                String[] items = new String[]{
                        "Edit",
                        "Delete"
                };

                new AlertDialog.Builder(DessertActivity.this)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final CalorieItem calorieItem = mCalorieItemList.get(position);

                                switch (i) {
                                    case 0: // Edit
                                        Intent intent = new Intent(DessertActivity.this, com.example.yuripps.caloriebook.EditCalorieItemActivity.class);
                                        intent.putExtra("name", calorieItem.name);
                                        //   intent.putExtra("type", calorieItem.type);
                                        intent.putExtra("calorie", calorieItem.calorie);
                                        intent.putExtra("id", calorieItem._id);
                                        startActivity(intent);

                                        Table_name("DESSERTS_TABLE");

                                        break;
                                    case 1: // Delete
                                        new AlertDialog.Builder(DessertActivity.this)
                                                .setMessage("ต้องการลบข้อมูลนี้ ใช่หรือไม่")
                                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        mDb.delete(
                                                                DESSERTS_TABLE,
                                                                COL_ID + " = ?",
                                                                new String[]{String.valueOf(calorieItem._id)}
                                                        );
                                                        loadPhoneData();
                                                        setupListView();
                                                    }
                                                })
                                                .setNegativeButton("No", null)
                                                .show();
                                        break;
                                }
                            }
                        })
                        .show();

                return true;
            }
        });
    }

}
