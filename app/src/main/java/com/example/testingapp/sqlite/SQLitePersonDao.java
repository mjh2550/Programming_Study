package com.example.testingapp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SQLitePersonDao {

    static final String dbName = "person_db";
    static final String tbName = "person_tb";
    Context context;

    /**
     * %d 정수
     * %f 실수
     * %c 문자
     * %s 문자열
     */


    public SQLitePersonDao(Context context){
        this.context = context;
    }


    //DB 호출 함수
    private SQLiteDatabase getDatabase(){
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);

        //테이블 존재하지 않으면 생성하는 쿼리 문
        db.execSQL("CREATE TABLE IF NOT EXISTS "+tbName
                + "(idx Integer primary key autoincrement"
                + ",name text"
                + ", tel text)");

        return db;
    }

    public ArrayList<PersonVo> selectList(){
        ArrayList<PersonVo> selectList = new ArrayList<PersonVo>();

        //Cursor
        Cursor cursor = null;
        SQLiteDatabase db = null;


        String [] col_names = {"idx","name","tel"};
        try {
            db = getDatabase();
            cursor = db.query(tbName,col_names,null,null,null,null,null);

            if(cursor!=null){
                if(cursor.moveToFirst()){//첫번째 레코드
                    //다음 레코드없을 때 까지 while문 돌림

                    do {
                        int idx = cursor.getInt(0);
                        String name = cursor.getString(0);
                        String tel = cursor.getString(0);

                        //vo포장 후 ArrayList넣기
                        selectList.add(new PersonVo(idx,name,tel));
                    }while (cursor.moveToNext());

                }
            }
        }catch (Exception e){
            Log.d("Error",e.getMessage());
        }finally {
            db.close();
        }
        return selectList;
    }


    //Insert
    public int insert(PersonVo vo){
        int res = 0;
        SQLiteDatabase db = null;
        try {
            //db생성(싱글톤, 없으면 생성 있으면 그대로 리턴)
            db = getDatabase();
            String sql = String.format("insert into %s(name,tel) values('%s','%s')",tbName,vo.getName(),vo.getTel());
            //TODO %s가 어떻게 들어가는지 알아보자
            db.execSQL(sql);
            res = 1;

        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }finally {
            //db가 생성 되었다면 닫아줘야함
            if(db!=null) db.close();
        }
        return res;
    }

    //Update
    public int Update(PersonVo vo){
        int res = 0;
        SQLiteDatabase db = null;
        try {
            db = getDatabase();
            String sql = String.format("update %s set name = '%s' , tel = '%s' " +
                                        "where idx = '%s' "
                                        ,tbName,vo.getName(),vo.getTel(),vo.getIdx());

            db.execSQL(sql);
            res=1;
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }finally {
            db.close();
        }
        return res;
    }


    //DELETE
    public int Delete(PersonVo vo){
        int res = 0;
        SQLiteDatabase db = null;
        try {
            db = getDatabase();
            String sql = String.format("Delete from %s " +
                                        "where idx = '%s'"
                                        ,tbName,vo.getIdx());

            db.execSQL(sql);
            res=1;
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }finally {
            db.close();
        }
        return res;
    }


}
