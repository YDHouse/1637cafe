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

public class Tab3Activity extends AppCompatActivity implements View.OnClickListener {

    private int buttonTAG;

    private Button[] buttonArray = new Button[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        //버튼 클릭 이벤트 - 버튼 호출
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
        buttonArray[40] = (Button) findViewById(R.id.btn_coupon_41);
        buttonArray[41] = (Button) findViewById(R.id.btn_coupon_42);
        buttonArray[42] = (Button) findViewById(R.id.btn_coupon_43);
        buttonArray[43] = (Button) findViewById(R.id.btn_coupon_44);
        buttonArray[44] = (Button) findViewById(R.id.btn_coupon_45);
        */

        for (int i=0; i<10; i++) {
            //각 버튼에 태그 지정
            buttonArray[i].setTag(i);

            //버튼 클릭 이벤트 - 리스너
            buttonArray[i].setOnClickListener(this);

            //쿠폰 모양 결정
            /*
            if (couponNo == i && flag == 0) {
                buttonArray[i].setBackground(ContextCompat.getDrawable(this, R.drawable.gray));
            }

            if (couponNo == i && flag == 1) {
                buttonArray[i].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
            }
            */
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

        //앞 번호의 flag 번호가 1인 경우에만 카메라 호출
        /*
        if (resultDB.get(position).getFlag() == 1) {
            new IntentIntegrator(this).initiateScan();
        } else {
            Toast "순서대로 사용해주세요";
        }
        */

        //QR 코드 읽는 카메라 호출
        new IntentIntegrator(this).initiateScan();

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

            Log.v("확인", "" + result.getContents());

            if (check.equals(pw) && buttonTAG == 0) {
                buttonArray[0].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[0].setEnabled(false);
                buttonArray[1].setEnabled(true);
                // *** DB의 flag 번호를 변경해 주는 명령이 필요 ***
                int aaa = D00_DBManager.dbManager.favoriteCount();
                Log.e("확인", "FLAG 수는: " + aaa);
            } else if (check.equals(pw) && buttonTAG == 1) {
                buttonArray[1].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[1].setEnabled(false);
                buttonArray[2].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 2) {
                buttonArray[2].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[2].setEnabled(false);
                buttonArray[3].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 3) {
                buttonArray[3].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[3].setEnabled(false);
                buttonArray[4].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 4) {
                buttonArray[4].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[4].setEnabled(false);
                buttonArray[5].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 5) {
                buttonArray[5].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[5].setEnabled(false);
                buttonArray[6].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 6) {
                buttonArray[6].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[6].setEnabled(false);
                buttonArray[7].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 7) {
                buttonArray[7].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[7].setEnabled(false);
                buttonArray[8].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 8) {
                buttonArray[8].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[8].setEnabled(false);
                buttonArray[9].setEnabled(true);
            } else if (check.equals(pw) && buttonTAG == 9) {
                buttonArray[9].setBackground(ContextCompat.getDrawable(this, R.drawable.red));
                buttonArray[9].setEnabled(false);
                //buttonArray[10].setEnabled(true);
            } else {
                Toast.makeText(this, "잘못된 QR 코드입니다.", Toast.LENGTH_SHORT).show();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
