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
        super(context, "Cafe1637.db", null, 5);

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("update CAFE1637 set flag = 1 where id = 1;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 2;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 3;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 4;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 5;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 6;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 7;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 8;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 9;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 10;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 11;");

        db.execSQL("update CAFE1637 set flag = 1 where id = 12;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 13;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 14;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 15;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 16;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 17;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 18;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 19;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 20;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 21;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 22;");

        db.execSQL("update CAFE1637 set flag = 1 where id = 23;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 24;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 25;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 26;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 27;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 28;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 29;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 30;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 31;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 32;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 33;");

        db.execSQL("update CAFE1637 set flag = 1 where id = 34;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 35;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 36;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 37;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 38;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 39;");
        db.execSQL("update CAFE1637 set flag = 1 where id = 40;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 41;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 42;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 43;");
        db.execSQL("update CAFE1637 set flag = 0 where id = 44;");
    }

    //DB 전체 select 쿼리 실행
    ArrayList<C20_ItemsAll> querySelect() {
        //쿼리 실행 후 쿼리 값을 각 각의 컬럼 별로 나누기 위해 변수 선언
        String cId = "";     //ID
        String flag = "";       //글의 내용

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;

        //쿼리 실행문
        cursor = db.rawQuery("select ID, FLAG from CAFE1637", null);

        //DB 값들이 최종적으로 저장될 리스트
        ArrayList<C20_ItemsAll> resultDB = new ArrayList<>();

        //나중에 데이터를 나누기 위해 기호(/)를 추가해서 각 변수에 담는다.
        while (cursor.moveToNext()) {
            cId += cursor.getString(0) + "/";
            flag += cursor.getString(1) + "/";
        }

        cursor.close();

        //하나의 변수에 DB의 값이 전부 들어가 있기 때문에 기호 '/' 를 기준으로 나누어 준다.
        String[] cIdSplit = cId.split("/");
        String[] flagSplit = flag.split("/");

        //배열의 크기만큼 반복을 돌리기 위해 글의 내용을 나눈 cIdSplit 길이의 값을 변수 k에 저장
        int k = cIdSplit.length;
        for (int i=0; i<k; i++){
            //cId, flag 컬럼 값을 C20_ItemsAll 에 저장한다.
            C20_ItemsAll item = new C20_ItemsAll(cIdSplit[i], flagSplit[i]);

            //C20_ItemsAll 값을 최종적으로 리스트(resultDB)에 담는다.
            resultDB.add(item);
        }
        return resultDB;
    }

    //총 수 구하기
    int couponCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from CAFE1637", null);

        int count = 0;
        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }

        cursor.close();

        return count;
    }

    //flag 컬럼 값 없데이트
    void flagUpdate(int cId) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("update CAFE1637 set flag = " + 1 + " where ID = " + cId + ";");

        //DB 닫기 (꼭 닫아 줘야 함)
        db.close();
    }

    //flag 컬럼 값 없데이트
    void couponInsert() {
        SQLiteDatabase db = getWritableDatabase();

        //신규 쿠폰 버튼을 생성하기 위해 insert 실행을 11번 한다.
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

        //DB 닫기 (꼭 닫아 줘야 함)
        db.close();
    }


}
