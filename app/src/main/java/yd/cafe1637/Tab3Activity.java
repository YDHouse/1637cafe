package yd.cafe1637;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class Tab3Activity extends AppCompatActivity implements View.OnClickListener {

    //클릭된 버튼의 순서를 알기 위해 버튼의 숫자를 저장할 변수
    private int buttonTAG;

    //버튼을 배열로 생성
    private Button[] buttonArray = new Button[11];

    //DB 관련
    private ArrayList<C20_ItemsAll> resultDB = null;  //쿼리 결과가 저정될 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        //적립 쿠폰 버튼 클릭
        buttonArray[0] = (Button) findViewById(R.id.btn_coupon_01);
        buttonArray[1] = (Button) findViewById(R.id.btn_coupon_02);
        buttonArray[2] = (Button) findViewById(R.id.btn_coupon_03);
        buttonArray[3] = (Button) findViewById(R.id.btn_coupon_04);
        buttonArray[4] = (Button) findViewById(R.id.btn_coupon_05);
        buttonArray[5] = (Button) findViewById(R.id.btn_coupon_06);
        buttonArray[6] = (Button) findViewById(R.id.btn_coupon_07);
        buttonArray[7] = (Button) findViewById(R.id.btn_coupon_08);
        buttonArray[8] = (Button) findViewById(R.id.btn_coupon_09);
        buttonArray[9] = (Button) findViewById(R.id.btn_coupon_10);
        /*
        buttonArray[10] = (Button) findViewById(R.id.btn_coupon_11);
        buttonArray[11] = (Button) findViewById(R.id.btn_coupon_12);
        buttonArray[12] = (Button) findViewById(R.id.btn_coupon_14);
        buttonArray[13] = (Button) findViewById(R.id.btn_coupon_14);
        buttonArray[14] = (Button) findViewById(R.id.btn_coupon_15);
        buttonArray[15] = (Button) findViewById(R.id.btn_coupon_16);
        buttonArray[16] = (Button) findViewById(R.id.btn_coupon_17);
        buttonArray[17] = (Button) findViewById(R.id.btn_coupon_18);
        buttonArray[18] = (Button) findViewById(R.id.btn_coupon_19);
        buttonArray[19] = (Button) findViewById(R.id.btn_coupon_20);

        buttonArray[20] = (Button) findViewById(R.id.btn_coupon_21);
        buttonArray[21] = (Button) findViewById(R.id.btn_coupon_22);
        buttonArray[22] = (Button) findViewById(R.id.btn_coupon_23);
        buttonArray[23] = (Button) findViewById(R.id.btn_coupon_24);
        buttonArray[24] = (Button) findViewById(R.id.btn_coupon_25);
        buttonArray[25] = (Button) findViewById(R.id.btn_coupon_26);
        buttonArray[26] = (Button) findViewById(R.id.btn_coupon_27);
        buttonArray[27] = (Button) findViewById(R.id.btn_coupon_28);
        buttonArray[28] = (Button) findViewById(R.id.btn_coupon_29);
        buttonArray[29] = (Button) findViewById(R.id.btn_coupon_30);

        buttonArray[30] = (Button) findViewById(R.id.btn_coupon_31);
        buttonArray[31] = (Button) findViewById(R.id.btn_coupon_32);
        buttonArray[32] = (Button) findViewById(R.id.btn_coupon_33);
        buttonArray[33] = (Button) findViewById(R.id.btn_coupon_34);
        buttonArray[34] = (Button) findViewById(R.id.btn_coupon_35);
        buttonArray[35] = (Button) findViewById(R.id.btn_coupon_36);
        buttonArray[36] = (Button) findViewById(R.id.btn_coupon_37);
        buttonArray[37] = (Button) findViewById(R.id.btn_coupon_38);
        buttonArray[38] = (Button) findViewById(R.id.btn_coupon_39);
        buttonArray[39] = (Button) findViewById(R.id.btn_coupon_40);
        */

        /*
        //무료 쿠폰 버튼 클릭
        buttonArray[40] = (Button) findViewById(R.id.btn_coupon_used_01);
        buttonArray[41] = (Button) findViewById(R.id.btn_coupon_used_02);
        buttonArray[42] = (Button) findViewById(R.id.btn_coupon_used_03);
        buttonArray[43] = (Button) findViewById(R.id.btn_coupon_used_04);
        */

        for (int i=0; i<10; i++) {
            //각 버튼에 태그 지정
            buttonArray[i].setTag(i);

            //버튼 클릭 이벤트 - 리스너
            buttonArray[i].setOnClickListener(this);
        }

        //쿠폰의 모양을 결정하는 메소드 실행
        reLoad();
    }

    //쿠폰 모양 결정
    public void reLoad() {
        // *** DB 총 수 확인 ***
        //int count = D00_DBManager.dbManager.idCount();
        //Log.e("확인", "FLAG 수는: " + count);

        //쿼리를 실행해서 어레이리스트 resultDB 에 저장한다.
        resultDB = D00_DBManager.dbManager.querySelect();
        //Log.e("확인", "db: " + resultDB.get(0).getFlag());

        //쿠폰 적립
        for (int i=0; i<10; i++) {
            //FLAG 컬럼의 값이 0인 경우에는
            if (resultDB.get(i).getFlag().equals("0")) {
                //쿠폰 버튼의 모양을 도장 찍기 전의 모양으로 만들고
                buttonArray[i].setBackground(ContextCompat.getDrawable(this, R.drawable.gray));
            }

            //FLAG 컬럼의 값이 1인 경우에는
            if (resultDB.get(i).getFlag().equals("1")) {
                //쿠폰 버튼의 모양을 도장 찍은 후의 모양으로 만든다.
                buttonArray[i].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
            }
        }

        //1~10번 쿠폰을 전부 찍으면 첫번째 무료 쿠폰을 활성화 시킨다.
        if(resultDB.get(9).getFlag().equals("1")) {
            //40번 버튼 활성화
            //buttonArray[40].setEnabled(true);
        }

        //11~20번 쿠폰을 전부 찍으면 두번째 무료 쿠폰을 활성화 시킨다.
        if(resultDB.get(19).getFlag().equals("1")) {
            //41번 버튼 활성화
            //buttonArray[41].setEnabled(true);
        }

        //21~30번 쿠폰을 전부 찍으면 세번째 무료 쿠폰을 활성화 시킨다.
        if(resultDB.get(29).getFlag().equals("1")) {
            //42번 버튼 활성화
            //buttonArray[42].setEnabled(true);
        }

        //31~40번 쿠폰을 전부 찍으면 네번째 무료 쿠폰을 활성화 시킨다.
        if(resultDB.get(39).getFlag().equals("1")) {
            //43번 버튼 활성화
            //buttonArray[43].setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        //클릭된 뷰를 버튼으로 받기
        Button clickedButton = (Button) v;

        //buttonArray 갯수 만큼 반복
        for (Button tempButton : buttonArray) {
            //클릭된 버튼을 찾으면
            if (tempButton == clickedButton) {
                //클릭된 버튼의 태그 담기
                buttonTAG = (Integer) v.getTag();
            }
        }

        //buttonTAG 값이 0이고, flag 컬럼이 0이면 무조건 카메라 호출
        if (buttonTAG ==0) {
            if (resultDB.get(0).getFlag().equals("0")) {
                //QR 코드 읽는 카메라 호출
                new IntentIntegrator(this).initiateScan();
            } else {
                //flag 값이 1이면 이미 쿠폰을 찍었다는 의미이므로
                Toast.makeText(this, "이미 적립된 쿠폰입니다.", Toast.LENGTH_SHORT).show();
            }
        }

        //buttonTAG 값이 0이 아닌 경우에는
        //(쿠폰을 순서대로 찍기 위해서)
        //앞 쿠폰 번호의 flag 번호가 1이고, 현재 번호의 flag 번호가 0인 경우에만 카메라 호출
        if (buttonTAG != 0 && buttonTAG <= 40) {
            if (resultDB.get(buttonTAG-1).getFlag().equals("1") && resultDB.get(buttonTAG).getFlag().equals("0")) {
                //QR 코드 읽는 카메라 호출
                new IntentIntegrator(this).initiateScan();
            }
            //앞 쿠폰 번호의 flag 번호가 1이고, 현재 번호의 flag 번호가 1인 경우에는 이미 적립된 쿠폰이므로 토스트를 호출
            else if (resultDB.get(buttonTAG-1).getFlag().equals("1") && resultDB.get(buttonTAG).getFlag().equals("1")) {
                Toast.makeText(this, "이미 적립된 쿠폰입니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "쿠폰은 순서대로 찍어주세요.", Toast.LENGTH_SHORT).show();
            }
        }

        if (buttonTAG > 40) {
            //무료 쿠폰 사용 이벤트 적용
        }

    }

    //QR 코드 읽은 후의 이벤트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            //카메라로 제대로 된 QR 코드를 읽게 되면 QR 코드의 정보를 result 변수에 담는다.
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            //result 변수의 contents 안에 들어 있는 정보를 가져와서 check 변수에 담는다.
            String check = result.getContents();

            //체크 변수의 문자와 비교하기 위한 pw 변수
            // *** 후에 암호화 할 필요가 있음 ***
            String pw = "test1234567**";

            //Log.v("확인", "" + result.getContents());

            //QR 코드로 찍은 check 변수의 암호와 내가 지정한 pw 변수의 암호가 동일하다면
            if (check.equals(pw)){
                //buttonTAG 값을 기준으로 DB의 flag 컬럼을 1로 변경하는 쿼리를 실행한다.
                //참고로 buttonTAG 값은 0부터 시작하고, DB의 cId 컬럼 값은 1부터 시작하므로 buttonTAG+1을 해주어야 한다.
                D00_DBManager.dbManager.flagUpdate(buttonTAG+1);
            } else {
                Toast.makeText(this, "잘못된 QR 코드입니다.", Toast.LENGTH_SHORT).show();
            }

            //쿠폰 버튼의 모양을 변경하기 위해 reLoad() 함수 실행
            reLoad();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
