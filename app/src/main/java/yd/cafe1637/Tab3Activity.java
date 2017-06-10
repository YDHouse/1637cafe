package yd.cafe1637;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

//QR 코드 관련
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class Tab3Activity extends AppCompatActivity implements View.OnClickListener {

    //버튼 관련
    private int buttonTAG;      //클릭된 버튼의 순서를 알기 위해 버튼의 숫자를 저장할 변수
    private int j = 11;         //버튼 생성 시 반복문의 초기 반복 횟수
    private int k = 0;          //버튼 생성 시 반복문의 초기 i의 값을 지정
    private LinearLayout linearLayout;  //동적으로 생성된 쿠폰 버튼들이 실제로 삽입 될 레이아웃 호출

    //DB 관련
    private ArrayList<C20_ItemsAll> resultDB = null;  //쿼리 결과가 저정될 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        //DB와 관련된 값을 구하기 위한 쿼리들을 실행한다.
        getDB();
    }



    //DB로 부터 필요한 값 가져오기
    public void getDB() {
        //쿼리를 실행해서 resultDB 에 couponId 별 flag 의 최신 상태를 저장한다.
        resultDB = D00_DBManager.dbManager.querySelect();

        //DB의 총 수를 구한다.
        int couponCount = D00_DBManager.dbManager.couponCount();

        //나누기 11을 하는 이유는 쿠폰 그룹에 생성되는 버튼의 수가 11개 이기때문이다.
        int loopCount = couponCount / 11;

        //loopCount 값을 기준으로 쿠폰 생성 메소드 실행
        for (int i = 0; i< loopCount; i++) {
            newCouponArea();
        }

        /*
         *** 새로운 쿠폰 생성을 위한 조건문 ***
         * 마지막 쿠폰에 도장이 찍히면 새로운 쿠폰 영역을 생성한다.
         * couponCount 값에 빼기 1을 하는 이유는 couponCount 값은 무료 쿠폰을 지정하고 있기 때문이다.
        */
        if (resultDB.get(couponCount-2).getFlag().equals("1")) {
            //DB에 새로운 값들을 insert 해야 한다.
            D00_DBManager.dbManager.couponInsert();

            //getDB() 메소드를 다시 실행해서 버튼을 생성한다.
            getDB();
        }
    }



    //쿠폰 생성 하기
    public void newCouponArea() {
        //다른 레이아웃에 있는 쿠폰 디자인을 호출하기 위해 inflater 사용
        LayoutInflater inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        //호출한 inflater 를 view 객체에 담는다.
        View view = inflater.inflate(R.layout.coupon_layout, null);

        //인플레이트 시키는 레이아웃(xml 파일)의 LinearLayout 을 호출한다.
        LinearLayout[] ll = new LinearLayout[11];
        ll[0] = (LinearLayout) view.findViewById(R.id.layout_coupon_01);    //1번 버튼이 들어갈 자리
        ll[1] = (LinearLayout) view.findViewById(R.id.layout_coupon_02);    //2번 버튼이 들어갈 자리
        ll[2] = (LinearLayout) view.findViewById(R.id.layout_coupon_03);    //3번 버튼이 들어갈 자리
        ll[3] = (LinearLayout) view.findViewById(R.id.layout_coupon_04);    //4번 버튼이 들어갈 자리
        ll[4] = (LinearLayout) view.findViewById(R.id.layout_coupon_05);    //5번 버튼이 들어갈 자리
        ll[5] = (LinearLayout) view.findViewById(R.id.layout_coupon_06);    //6번 버튼이 들어갈 자리
        ll[6] = (LinearLayout) view.findViewById(R.id.layout_coupon_07);    //7번 버튼이 들어갈 자리
        ll[7] = (LinearLayout) view.findViewById(R.id.layout_coupon_08);    //8번 버튼이 들어갈 자리
        ll[8] = (LinearLayout) view.findViewById(R.id.layout_coupon_09);    //9번 버튼이 들어갈 자리
        ll[9] = (LinearLayout) view.findViewById(R.id.layout_coupon_10);    //10번 버튼이 들어갈 자리
        ll[10] = (LinearLayout) view.findViewById(R.id.layout_used_coupon);    //무료 쿠폰 버튼이 들어갈 자리

        int llCount = 0;    //LinearLayout[] 배열의 방 번호
        int textNo = 1;     //쿠폰 버튼에 숫자 1~10을 기입하기 위한 넘버링
        for (int i=k; i <j; i++) {
            //버튼 생성
            Button btn = new Button(this);

            //생성한 버튼에 id 입력
            btn.setId(i);

            //생성한 버튼에 tag 입력
            btn.setTag(i);

            //생성한 버튼에 text 입력
            if (i == j - 1) {
                /* 예를 들어 초기 j 값이 11일 경우에 빼기 1을 하면 10이 되고,
                 * i의 값이 빼기 1한 j의 값과 동일해 지면,
                 * 마지막 버튼을 생성하는 것이 되므로,
                 * 마지막 버튼에는 무료 쿠폰이 기입되어야 하므로 setText 내용이 달라진다. */
                btn.setText("FREE\n\n아메리카노\n1잔");
                btn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);   //글자 크기는 12
            } else {
                btn.setText("" + textNo++);     //초기 textNo 1을 입력하고 ++ 시킨다.
                btn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);   //글자 크기는 10
            }

            /*
             * 오늘의 할 일 - 버튼의 활성 비활성 결정하기
             * 쿠폰을 순서대로 찍기 위한 방법이 무료 쿠폰이 사이에 껴있는 경우 먹힐지 않음
            if (k == 0) {
                btn.setEnabled(true);
            } else {
                btn.setEnabled(false);
            }
            */

            //LinearLayout 각 방에 생성한 버튼을 추가
            ll[llCount++].addView(btn);

            //버튼 클릭 리스너 등록
            btn.setOnClickListener(this);

            //쿠폰의 모양을 결정하기 위해서
            //FLAG 컬럼의 값이 0인 경우
            if (resultDB.get(i).getFlag().equals("0")) {
                //쿠폰 버튼의 모양을 도장 찍기 전의 모양으로 만들고
                btn.setBackground(ContextCompat.getDrawable(this, R.drawable.gray));
            }

            //FLAG 컬럼의 값이 1인 경우
            if (resultDB.get(i).getFlag().equals("1")) {
                //쿠폰 버튼의 모양을 도장 찍은 후의 모양으로 만든다.
                btn.setBackground(ContextCompat.getDrawable(this, R.drawable.red));
            }
        }

        //k 값에 j의 값을 대입시켜 다음 버튼 생성 시 j의 번호가 시작번호가 되게 만든다.
        //ex) j=11 , k=0 이면 k가 11이 되어서 다음 반복문은 11로 시작
        k = j;

        //j의 값에 11을 더해서
        // (11을 더하는 이유는 만들어 지는 버튼이 11개이기 때문)
        //다음 버튼 생성 시 11을 추가한 만큼의 수만큼 반복이 되게 한다.
        j = j + 11;

        //지금까지 만들어진 버튼이 실제로 삽입 될 레이아웃 호출
        linearLayout = (LinearLayout) findViewById(R.id.coupon_area);

        //호출한 레이아웃에 addView 한다.
        linearLayout.addView(view);
    }



    @Override
    public void onClick(View v) {
        //클릭된 버튼의 태그 담기
        buttonTAG = (Integer) v.getTag();
        Log.e("확인", "버튼 태그: " + buttonTAG);

        //buttonTAG 값이 0이고, flag 컬럼이 0이면 무조건 카메라 호출
        if (buttonTAG == 0) {
            if (resultDB.get(0).getFlag().equals("0")) {
                //QR 코드 읽는 카메라 호출
                new IntentIntegrator(this).initiateScan();
            } else {
                //flag 값이 1이면 이미 쿠폰을 찍었다는 의미이므로
                Toast.makeText(this, "이미 적립된 쿠폰입니다.", Toast.LENGTH_SHORT).show();
            }
        }


        /* ************************************
         *** 쿠폰을 순서대로 찍기 위한 방법 ***
         ************************************ */
        //buttonTAG 값이 0이 아니고
        if (buttonTAG != 0) {
            //앞 쿠폰 번호의 flag 번호가 1이고, 현재 번호의 flag 번호가 0인 경우에만 카메라 호출
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
    }



    //QR 코드 읽은 후의 이벤트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            //카메라로 제대로 된 QR 코드를 읽게 되면 QR 코드의 정보를 result 변수에 담는다.
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            //result 변수의 contents 안에 들어 있는 정보를 가져와서 check 변수에 담는다.
            String check = result.getContents();
            //Log.e("확인", "" + check);

            //체크 변수의 문자와 비교하기 위한 pw 변수
            // *** 후에 암호화 할 필요가 있음 ***
            String pw = "test1234567**";

            //QR 코드로 찍은 check 변수의 암호와 내가 지정한 pw 변수의 암호가 동일하다면
            if (check.equals(pw)){
                //buttonTAG 값을 기준으로 DB의 flag 컬럼을 1로 변경하는 쿼리를 실행한다.
                //참고로 buttonTAG 값은 0부터 시작하고, DB의 cId 컬럼 값은 1부터 시작하므로 buttonTAG+1을 해주어야 한다.
                D00_DBManager.dbManager.flagUpdate(buttonTAG+1);

                //쿠폰에 어떤 변화가 생기는 경우
                //DB로 부터 값을 가져와서 무조건 처음부터 다시 버튼을 생성해야 쿠폰 버튼의 최신 모양이 반영된다.
                //J와 K의 값을 초기 값으로 변경하면 버튼을 처음부터 생성한다.
                j = 11;
                k = 0;
                linearLayout.removeAllViews();
                getDB();
            } else {
                Toast.makeText(this, "잘못된 QR 코드입니다.", Toast.LENGTH_SHORT).show();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
