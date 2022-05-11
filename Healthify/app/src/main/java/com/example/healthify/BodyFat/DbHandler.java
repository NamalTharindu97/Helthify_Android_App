package com.example.healthify.BodyFat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DB_NAME = "BodyFatCalculator";
    public static final String TABLE_NAME = "BodyFat";


    public static final String ID = "id";
    public static final String RESULT = "result";
    public static final String AGE = "age";
    public static final String HEIGHT = "height";
    public static final String WEIST = "weist";
    public static final String HIP = "hip";
    public static final String NECK = "neck";
    public static final String WEIGHT = "weight";
    public static final String DATE = "date";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " +TABLE_NAME+" " +
                " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RESULT + " TEXT, "
                + AGE + " INTEGER, "
                + HEIGHT + " INTEGER, "
                + WEIST + " INTEGER, "
                + HIP + " INTEGER, "
                + NECK + " INTEGER, "
                + WEIGHT + " INTEGER, "
                + DATE + " TEXT" +
                ");";


        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_CREATE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_CREATE_QUERY);
        onCreate(sqLiteDatabase);
    }

    public void AddBodyFat(FatModel fatModel){
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, fatModel.getResult());
        contentValues.put(AGE, fatModel.getAge());
        contentValues.put(HEIGHT, fatModel.getHeight());
        contentValues.put(WEIST, fatModel.getWeist());
        contentValues.put(HIP, fatModel.getHip());
        contentValues.put(NECK, fatModel.getNeck());
        contentValues.put(WEIGHT, fatModel.getWeight());
        contentValues.put(DATE, fatModel.getDate());

        sql.insert(TABLE_NAME,null,contentValues);
        sql.close();

    }

    public List<FatModel> getAllBodyFats(){

        List<FatModel> fatModels = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                FatModel fatModel = new FatModel();

                fatModel.setId(cursor.getInt(0));
                fatModel.setResult(cursor.getString(1));
                fatModel.setAge(cursor.getInt(2));
                fatModel.setHeight(cursor.getInt(3));
                fatModel.setWeist(cursor.getInt(4));
                fatModel.setHip(cursor.getInt(5));
                fatModel.setNeck(cursor.getInt(6));
                fatModel.setWeight(cursor.getInt(7));
                fatModel.setDate(cursor.getString(8));

                fatModels.add(fatModel);
            }while (cursor.moveToNext());
        }
        return fatModels;
    }
    
    public void deleteFatModels(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?", new String[]{String.valueOf(id)});
        db.close();
    }
    public FatModel getSingleFatModel(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,RESULT,AGE,HEIGHT,WEIST,HIP,NECK,WEIGHT,DATE},ID + "= ?",
                new String[]{String.valueOf(id)},null,null,null);

        FatModel ft;
        if(cursor != null){
                cursor.moveToFirst();
            ft = new FatModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getString(8)

            );
            return ft;
        }
        return null;
    }

    public int updateSingleBodyFat(FatModel fatModel){

        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, fatModel.getResult());
        contentValues.put(AGE, fatModel.getAge());
        contentValues.put(HEIGHT, fatModel.getHeight());
        contentValues.put(WEIST, fatModel.getWeist());
        contentValues.put(HIP, fatModel.getHip());
        contentValues.put(NECK, fatModel.getNeck());
        contentValues.put(WEIGHT, fatModel.getWeight());
        contentValues.put(DATE, fatModel.getDate());

        int status = sql.update(TABLE_NAME,contentValues,ID + " =?" ,
                new String[]{String.valueOf(fatModel.getId())});

        sql.close();
        return status;

    }

}


















