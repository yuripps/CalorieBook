package com.example.yuripps.caloriebook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.yuripps.caloriebook.db.DatabaseHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_NAME;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_IMAGE;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_CALORIE;
import static com.example.yuripps.caloriebook.db.DatabaseHelper.COL_UNIT;


public class AddCalorieActivity extends AppCompatActivity {

    private static final String TAG = AddCalorieActivity.class.getName();
    static String table_name;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private String mLogoFilename = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calorie);


        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doInsertPhoneItem();
            }
        });

        ImageView logoImageView = findViewById(R.id.logo_image_view);
        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openChooserWithGallery(AddCalorieActivity.this, "เลือกรูปภาพ", 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagesPicked(@NonNull List<File> list, EasyImage.ImageSource imageSource, int i) {
                File logoFile = list.get(0);
                Log.i(TAG, logoFile.getAbsolutePath());
                Log.i(TAG, logoFile.getName());

                File privateDir = getFilesDir();
                File dstFile = new File(privateDir, logoFile.getName());
                try {
                    copy(logoFile, dstFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mLogoFilename = logoFile.getName();
                ImageView logoImageView = findViewById(R.id.logo_image_view);

                Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
                logoImageView.setImageBitmap(bitmap);
            }
        });
    }

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_food:
                if (checked)
                    table_name = "FOOD_TABLE";
                    break;
            case R.id.radio_fruit:
                if (checked)
                    table_name = "FRUIT_TABLE";
                    break;
            case R.id.radio_dessert:
                if (checked)
                    table_name = "DESSERTS_TABLE";
                break;
            case R.id.radio_drink:
                if (checked)
                    table_name = "DRINK_TABLE";
                break;
        }
    }

    private void doInsertPhoneItem() {
        EditText nameEditText = findViewById(R.id.name_edit_text);
        EditText calorieEditText = findViewById(R.id.calorie_edit_text);
        EditText unitEditText = findViewById(R.id.unit_edit_text);

        String name = nameEditText.getText().toString();
        String calorie = calorieEditText.getText().toString();
        String unit = unitEditText.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_CALORIE, calorie);
        cv.put(COL_IMAGE, mLogoFilename);
        cv.put(COL_UNIT,unit);
        mDb.insert(table_name, null, cv);

        finish();
    }

}
