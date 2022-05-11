package com.example.healthify.BMI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.healthify.BodyFat.FatModel;

import java.util.ArrayList;
import java.util.List;

public class DbHandler_BMI extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DB_NAME = "BMIFatCalculator";
    public static final String TABLE_NAME = "BMI_Val";

    public static final String ID = "id";
    public static final String RESULT = "result";
    public static final String FEET = "feet";
    public static final String INCHES = "inches";
    public static final String WEIGHT = "weight";
    public static final String DATE = "date";

    public DbHandler_BMI(@Nullable Context context) {
        super(context, DB_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE_QUERY = "CREATE TABLE " +TABLE_NAME+" " +
                " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RESULT + " TEXT, "
                + FEET + " INTEGER, "
                + INCHES + " INTEGER, "
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

    public void AddBMI(BMIModel bmiModel){
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, bmiModel.getResult());
        contentValues.put(FEET, bmiModel.getFeet());
        contentValues.put(INCHES, bmiModel.getInches());
        contentValues.put(WEIGHT, bmiModel.getWeight());
        contentValues.put(DATE, bmiModel.getDate());

        sql.insert(TABLE_NAME,null,contentValues);
        sql.close();

    }


    public List<BMIModel> getAllBMI(){

        List<BMIModel> BMIModels = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                BMIModel BmiModel = new BMIModel();

                BmiModel.setId(cursor.getInt(0));
                BmiModel.setResult(cursor.getString(1));
                BmiModel.setFeet(cursor.getInt(2));
                BmiModel.setInches(cursor.getInt(3));
                BmiModel.setWeight(cursor.getInt(4));
                BmiModel.setDate(cursor.getString(5));


                BMIModels.add(BmiModel);
            }while (cursor.moveToNext());
        }
        return BMIModels;
    }
    public void deleteBmiRecords(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?", new String[]{String.valueOf(id)});
        db.close();
    }
    public int updateSingleBMI(BMIModel bmiModel){

        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, bmiModel.getResult());
        contentValues.put(FEET, bmiModel.getFeet());
        contentValues.put(INCHES, bmiModel.getInches());
        contentValues.put(WEIGHT, bmiModel.getWeight());
        contentValues.put(DATE, bmiModel.getDate());

        int status = sql.update(TABLE_NAME,contentValues,ID + " =?" ,
                new String[]{String.valueOf(bmiModel.getId())});

        sql.close();
        return status;

    }

    public BMIModel getSingleBMI(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,RESULT,FEET,INCHES,WEIGHT,DATE},ID + "= ?",
                new String[]{String.valueOf(id)},null,null,null);

        BMIModel bm;
        if(cursor != null){
            cursor.moveToFirst();
            bm = new BMIModel(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getString(5)

            );
            return bm;
        }
        return null;
    }
}
