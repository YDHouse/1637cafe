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

    //클릭된 버튼의 순서를 알기 위해 버튼의 숫자를 저장할 변수
    private int buttonTAG;

    //LinearLayout 배열로 생성
    //private LinearLayout[] ll = new LinearLayout[11];
    private Button[] buttonArray = new Button[11];

    private LinearLayout[] ll = new LinearLayout[11];
    private View view;
    private LinearLayout linearLayout;
    private LayoutInflater inflater;
    private int j = 11;
    private int k = 0;

    //DB 관련
    private ArrayList<C20_ItemsAll> resultDB = null;  //쿼리 결과가 저정될 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        linearLayout = (LinearLayout) findViewById(R.id.coupon_area);
        inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        view = inflater.inflate(R.layout.coupon_layout, linearLayout);

        //인플레이트 시키는 레이아웃(xml 파일)의 LinearLayout 을 호출한다.
        ll[0] = (LinearLayout) view.findViewById(R.id.layout_coupon_01);
        ll[1] = (LinearLayout) view.findViewById(R.id.layout_coupon_02);
        ll[2] = (LinearLayout) view.findViewById(R.id.layout_coupon_03);
        ll[3] = (LinearLayout) view.findViewById(R.id.layout_coupon_04);
        ll[4] = (LinearLayout) view.findViewById(R.id.layout_coupon_05);
        ll[5] = (LinearLayout) view.findViewById(R.id.layout_coupon_06);
        ll[6] = (LinearLayout) view.findViewById(R.id.layout_coupon_07);
        ll[7] = (LinearLayout) view.findViewById(R.id.layout_coupon_08);
        ll[8] = (LinearLayout) view.findViewById(R.id.layout_coupon_09);
        ll[9] = (LinearLayout) view.findViewById(R.id.layout_coupon_10);
        ll[10] = (LinearLayout) view.findViewById(R.id.layout_used_coupon);

        newCouponArea();

        Button add_coupon = (Button) findViewById(R.id.btn_add_coupon);
        add_coupon.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                newCouponArea();
                inflater.inflate(R.layout.coupon_layout, linearLayout);
            }
        });
    }

    public void newCouponArea() {
        int llCount = 0;
        for (int i=k; i <j; i++) {
            Button btn = new Button(this);
            btn.setId(i);
            if (i == j - 1) {
                btn.setText("FREE\n\n아메리카노 1잔");
                btn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            } else {
                int result = i + 1;
                btn.setText("" + result);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
            }
            btn.setTag(i);
            ll[llCount].addView(btn);
            llCount++;
            btn.setOnClickListener(this);

            Log.e("확인", "버튼 ID 는 = " + btn.getId());
        }
        k = j;
        j = j + 11;
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
