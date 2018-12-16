package com.example.yuripps.caloriebook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "calorie.db";
    private static final int DATABASE_VERSION = 1;

    public static final String FOOD_TABLE = "food_table";
    public static final String FRUIT_TABLE = "fruit_table";
    public static final String DRINK_TABLE = "drink_table";
    public static final String DESSERTS_TABLE = "desserts_table";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_CALORIE = "calorie";
    public static final String COL_IMAGE = "image";
    public static final String COL_UNIT = "unit";

    private static final String SQL_CREATE_TABLE_FOOD
            = "CREATE TABLE " + FOOD_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_CALORIE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_UNIT + " TEXT"
            + ")";

    private static final String SQL_CREATE_TABLE_FRUIT
            = "CREATE TABLE " + FRUIT_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_CALORIE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_UNIT + " TEXT"
            + ")";

    private static final String SQL_CREATE_TABLE_DRINK
            = "CREATE TABLE " + DRINK_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_CALORIE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_UNIT + " TEXT"
            + ")";

    private static final String SQL_CREATE_TABLE_DESSERTS
            = "CREATE TABLE " + DESSERTS_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_CALORIE + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_UNIT + " TEXT"
            + ")";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //----------------------------- FOOD ---------------------------------
        db.execSQL(SQL_CREATE_TABLE_FOOD);
        ContentValues food = new ContentValues();
        food.put(COL_NAME, "กระเพาะปลา");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"150");
        food.put(COL_IMAGE, "fish.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ก๋วยเตี๋ยวคั่วไก่");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"435");
        food.put(COL_IMAGE, "kai.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ก๋วยเตี๋ยวเส้นเล็กต้มยำหมู");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"335");
        food.put(COL_IMAGE, "48358925.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "กุ้งแช่น้ำปลา");
        food.put(COL_UNIT, "ตัว");
        food.put(COL_CALORIE,"14");
        food.put(COL_IMAGE, "shrimp.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "เกาเหลาลูกชิ้นน้ำ");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"225");
        food.put(COL_IMAGE, "wswsw.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "แกงกะหรี่ไก่");
        food.put(COL_UNIT, "จาน");
        food.put(COL_CALORIE,"225");
        food.put(COL_IMAGE, "currychic.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ต้มจืดเลือดหมู");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"120");
        food.put(COL_IMAGE, "blood.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ไข่ตุ๋น");
        food.put(COL_UNIT, "ฟอง");
        food.put(COL_CALORIE,"159");
        food.put(COL_IMAGE, "egg.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ข้าวผัดกะเพราหมู");
        food.put(COL_UNIT, "จาน");
        food.put(COL_CALORIE,"580");
        food.put(COL_IMAGE, "kapao.jpg");
        db.insert(FOOD_TABLE, null, food);

        food = new ContentValues();
        food.put(COL_NAME, "ข้าวต้มปลา");
        food.put(COL_UNIT, "ชาม");
        food.put(COL_CALORIE,"325");
        food.put(COL_IMAGE, "khaotompla.jpg");
        db.insert(FOOD_TABLE, null, food);

        //------------------------------ FRUIT ------------------------------
        db.execSQL(SQL_CREATE_TABLE_FRUIT);
        ContentValues fruit = new ContentValues();
        fruit.put(COL_NAME, "ส้มเขียวหวาน");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"42");
        fruit.put(COL_IMAGE, "orange.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ลิ้นจี่");
        fruit.put(COL_UNIT, "เม็ด");
        fruit.put(COL_CALORIE,"57");
        fruit.put(COL_IMAGE, "lychee.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ชมพู่");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"16");
        fruit.put(COL_IMAGE, "chompoo.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "เชอรี่");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"15");
        fruit.put(COL_IMAGE, "cherry.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ทุเรียน");
        fruit.put(COL_UNIT, "เม็ด");
        fruit.put(COL_CALORIE,"59");
        fruit.put(COL_IMAGE, "chanee-durian.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "มะม่วงเขียวเสวย");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"120");
        fruit.put(COL_IMAGE, "mango.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "มะปราง");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"20");
        fruit.put(COL_IMAGE, "maprang.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ลำไย");
        fruit.put(COL_UNIT, "เม็ด");
        fruit.put(COL_CALORIE,"8");
        fruit.put(COL_IMAGE, "iStock-966482626.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ลูกพลับ");
        fruit.put(COL_UNIT, "ผล");
        fruit.put(COL_CALORIE,"120");
        fruit.put(COL_IMAGE, "lp.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "ส้มโอ");
        fruit.put(COL_UNIT, "กรีบ");
        fruit.put(COL_CALORIE,"60");
        fruit.put(COL_IMAGE, "pomelo.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "สับปะรด");
        fruit.put(COL_UNIT, "ชิ้นเล็ก");
        fruit.put(COL_CALORIE,"8");
        fruit.put(COL_IMAGE, "Pineapple.jpg");
        db.insert(FRUIT_TABLE, null, fruit);

        fruit = new ContentValues();
        fruit.put(COL_NAME, "องุ่น");
        fruit.put(COL_UNIT, "เม็ด");
        fruit.put(COL_CALORIE,"16");
        fruit.put(COL_IMAGE, "grape.jpg");
        db.insert(FRUIT_TABLE, null, fruit);





        //------------------------------ DRINK --------------------------------

        db.execSQL(SQL_CREATE_TABLE_DRINK);
        ContentValues drink = new ContentValues();
        drink.put(COL_NAME, "นมจืด");
        drink.put(COL_UNIT, "ขวดเล็ก");
        drink.put(COL_CALORIE,"160");
        drink.put(COL_IMAGE, "0002351_X2.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "นมจืดไขมัน 0%");
        drink.put(COL_UNIT, "ขวดเล็ก");
        drink.put(COL_CALORIE,"80");
        drink.put(COL_IMAGE, "7.png");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "นมเปรี้ยว UHT");
        drink.put(COL_UNIT, "กล่อง");
        drink.put(COL_CALORIE,"125");
        drink.put(COL_IMAGE, "xq.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "เบียร์");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"148");
        drink.put(COL_IMAGE, "48356235_730115517371253_390959018845143040_n.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "น้ำอัดลม");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"130");
        drink.put(COL_IMAGE, "can-of-coke.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "กาแฟร้อน");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"55");
        drink.put(COL_IMAGE, "Coffee_Cup.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "กาแฟเย็น");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"317");
        drink.put(COL_IMAGE, "48120784_530517227427462_7058350401002668032_n.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "ชาเขียวเย็น");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"319");
        drink.put(COL_IMAGE, "tea4.jpg");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "ชานมเย็น");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"319");
        drink.put(COL_IMAGE, "48237096_343800813117136_5435548324478320640_n.png");
        db.insert(DRINK_TABLE, null, drink);

        drink = new ContentValues();
        drink.put(COL_NAME, "น้ำผลไม้");
        drink.put(COL_UNIT, "แก้ว");
        drink.put(COL_CALORIE,"70");
        drink.put(COL_IMAGE, "df.jpg");
        db.insert(DRINK_TABLE, null, drink);

        //------------------------------ DESSERT ------------------------------
        db.execSQL(SQL_CREATE_TABLE_DESSERTS);

        ContentValues dessert = new ContentValues();
        dessert.put(COL_NAME, "ขนมชั้น");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"92");
        dessert.put(COL_IMAGE, "layer_sweet_cake.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "ขนมต้มขาว");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"41");
        dessert.put(COL_IMAGE, "maxresdefault.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "ขนมหม้อแกง");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"179");
        dessert.put(COL_IMAGE, "mokang.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "คุ้กกี้ช็อคโกแลตชิพ");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"215");
        dessert.put(COL_IMAGE, "ChocolateChipCookieDough.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "ทองหยิบ");
        dessert.put(COL_UNIT, "ดอก");
        dessert.put(COL_CALORIE,"105");
        dessert.put(COL_IMAGE, "yipgold.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "บราวนี่");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"340");
        dessert.put(COL_IMAGE, "brownies.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "พายชีสบูลเบอร์รี่");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"350");
        dessert.put(COL_IMAGE, "blueberrycheese.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "แยมโรล");
        dessert.put(COL_UNIT, "ชิ้น");
        dessert.put(COL_CALORIE,"310");
        dessert.put(COL_IMAGE, "yamrole.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);

        dessert = new ContentValues();
        dessert.put(COL_NAME, "ไอศกรีมวนิลลา");
        dessert.put(COL_UNIT, "ก้อน");
        dessert.put(COL_CALORIE,"140");
        dessert.put(COL_IMAGE, "1456322806.jpg");
        db.insert(DESSERTS_TABLE, null, dessert);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
