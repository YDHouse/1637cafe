package yd.cafe1637;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class D00_DBManager extends SQLiteOpenHelper{

    //다른 클래스에서 현 클래스를 호출할 수 있게 스태틱으로 선언
    static D00_DBManager dbManager;

    D00_DBManager(Context context) {
        super(context, "Cafe1637.db", null, 1);

        //onCreate() 메소드가 실행되면서 (혹은 생성자로 클래스를 호출할 때)
        //현 클래스가 스태틱으로 메모리에 등록된다.
        //이 구문이 빠지면 스태틱 선언을 해도 this 로 지정된 곳이 없기 때문에
        //nullPointerException 이 발생하므로 반드시 지정해 주어야 한다.
        dbManager = this;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `CAFE1637` ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `FLAG` INTEGER NOT NULL);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
        db.execSQL("INSERT INTO CAFE1637 VALUES (null, 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DELETE FROM CAFE1637");
    }

    int favoriteCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from CAFE1637 where FLAG = 1", null);
        int count = 0;
        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }
        return count;
    }
}
