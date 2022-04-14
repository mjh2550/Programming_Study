package com.example.testingapp.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class} , version = 1) //데이터 모델 클래스 , 수정사항을 위한 DB 버전 관리
public abstract class UserDatabase extends RoomDatabase {
    //DAO 호출
    public abstract UserDao userDao();

}
