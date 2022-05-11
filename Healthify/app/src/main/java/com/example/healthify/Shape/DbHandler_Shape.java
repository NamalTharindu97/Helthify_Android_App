package com.example.healthify.Shape;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.healthify.BMI.BMIModel;
import com.example.healthify.BodyFat.FatModel;

import java.util.ArrayList;
import java.util.List;


public class DbHandler_Shape extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DB_NAME = "BodyShapeCalculator";
    public static final String TABLE_NAME = "Shape_Val";

    public static final String ID = "id";
    public static final String RESULT = "result";
    public static final String BUST = "bust";
    public static final String WAIST = "waist";
    public static final String HIGH_HIP = "high_hip";
    public static final String HIP = "hip";
    public static final String DATE = "date";

    public DbHandler_Shape(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " +TABLE_NAME+" " +
                " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RESULT + " TEXT, "
                + BUST + " INTEGER, "
                + WAIST + " INTEGER, "
                + HIGH_HIP + " INTEGER, "
                + HIP + " INTEGER, "
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

    public void AddBodyShape(ShapeModel shapeModel){
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, shapeModel.getResult());
        contentValues.put(BUST, shapeModel.getBust());
        contentValues.put(WAIST, shapeModel.getWaist());
        contentValues.put(HIGH_HIP, shapeModel.getHigh_hip());
        contentValues.put(HIP, shapeModel.getHip());
        contentValues.put(DATE, shapeModel.getDate());

        sql.insert(TABLE_NAME,null,contentValues);
        sql.close();

    }

   public List<ShapeModel> getAllBodyShape(){

       List<ShapeModel> ShapeModels = new ArrayList();
       SQLiteDatabase db = getReadableDatabase();
       String query = "SELECT * FROM " + TABLE_NAME;

       Cursor cursor = db.rawQuery(query,null);

       if (cursor.moveToFirst()){
           do {
               ShapeModel shapeModel = new ShapeModel();

               shapeModel.setId(cursor.getInt(0));
               shapeModel.setResult(cursor.getString(1));
               shapeModel.setBust(cursor.getInt(2));
               shapeModel.setWaist(cursor.getInt(3));
               shapeModel.setHigh_hip(cursor.getInt(4));
               shapeModel.setHip(cursor.getInt(5));
               shapeModel.setDate(cursor.getString(6));

               ShapeModels.add(shapeModel);
           }while (cursor.moveToNext());
       }
       return ShapeModels;
   }

    public void deleteShapeRecords(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?", new String[]{String.valueOf(id)});
        db.close();
    }
    public int updateSingleShape(ShapeModel shapeModel){

        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RESULT, shapeModel.getResult());
        contentValues.put(BUST, shapeModel.getBust());
        contentValues.put(WAIST, shapeModel.getWaist());
        contentValues.put(HIGH_HIP, shapeModel.getHigh_hip());
        contentValues.put(HIP, shapeModel.getHip());
        contentValues.put(DATE, shapeModel.getDate());

        int status = sql.update(TABLE_NAME,contentValues,ID + " =?" ,
                new String[]{String.valueOf(shapeModel.getId())});

        sql.close();
        return status;

    }

    public ShapeModel getSingleShape(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,RESULT,BUST,WAIST,HIGH_HIP,HIP,DATE},ID + "= ?",
                new String[]{String.valueOf(id)},null,null,null);

        ShapeModel shapeModel;
        if(cursor != null){
            cursor.moveToFirst();
            shapeModel = new ShapeModel(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getString(6)

            );
            return shapeModel;
        }
        return null;
    }
}
