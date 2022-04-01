package com.example.testingapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLitePersonDao {

    static final String dbName = "person_db";
    static final String tbName = "person_tb";
    Context context;


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

        }finally {
            //db가 생성 되었다면 닫아줘야함
            if(db!=null) db.close();
        }
        return res;
    }

    //Update
    //TODO Update

    //DELETE
    //TODO DELETE


}
