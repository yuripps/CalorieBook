package com.example.yuripps.caloriebook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yuripps.caloriebook.db.DatabaseHelper;

import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_ID;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_NAME;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_CALORIE;

public class EditCalorieItemActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mCalorieEditText;
    private Button mSaveButton;

    private long mId;

    public static String t_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_calorie_item);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String calorie = intent.getStringExtra("calorie");
        mId = intent.getLongExtra("id", 0);

        mNameEditText = findViewById(R.id.name_edit_text);
        mCalorieEditText = findViewById(R.id.calorie_edit_text);
        mSaveButton = findViewById(R.id.save_button);


        mNameEditText.setText(name);
        mCalorieEditText.setText(calorie);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: บันทึกข้อมูลใหม่ลง db
                DatabaseHelper helper = new DatabaseHelper(EditCalorieItemActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                String newName = mNameEditText.getText().toString().trim();
                String newCalorie = mCalorieEditText.getText().toString().trim();

                ContentValues cv = new ContentValues();
                cv.put(COL_NAME, newName);
                cv.put(COL_CALORIE, newCalorie);


                db.update(
                        t_name,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();
            }
        });
    }

    public static void Table_name(String tablename){
        t_name = tablename;
    }

}

