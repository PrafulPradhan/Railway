package com.example.railway

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBManager(context:Context):SQLiteOpenHelper(context,"Railway",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable="CREATE TABLE Student(first_name varchar(100),last_name varchar(100),division varchar(100),rollNo varchar(100),aadhar varchar(100));"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTable="DROP TABLE if exists Student"
        db?.execSQL(dropTable)
        onCreate(db)
    }
    fun insertData(student: Student):Boolean{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("first_name", student.firstName)
        cv.put("last_name", student.lastName)
        cv.put("division", student.division)
        cv.put("rollNo", student.rollNo)
        cv.put("aadhar", student.aadhar)
        val result=db.insert("Student", null, cv)
        return (Integer.parseInt("$result") != -1)
    }
}