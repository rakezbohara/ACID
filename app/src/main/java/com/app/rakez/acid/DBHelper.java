package com.app.rakez.acid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by RAKEZ on 11/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static String DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/databases/";
    public static final String DB_NAME = "students.db";
    public static final String TABLE_NAME = "info";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "GRADE";


    public DBHelper(Context context) {
        super(context,DB_PATH+DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "CREATE TABLE "+TABLE_NAME+" ("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT NOT NULL, "+COL_3+" TEXT );";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(sqLiteDatabase);

    }

    public Boolean insertData(String name, String grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,name);
        cv.put(COL_3,grade);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return result;
    }

    public void updateData(String name,String grade,String id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,id);
        cv.put(COL_2,name);
        cv.put(COL_3,grade);
        db.update(TABLE_NAME,cv,"ID=?",new String[]{id});



    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer result = db.delete(TABLE_NAME,"ID=?",new String[]{id});
        return result;
    }

}
