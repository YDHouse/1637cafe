package yd.cafe1637;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabHost.OnTabChangeListener {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메뉴 탭 호출
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();    //setup() 함수를 호출하지 않으면 TabWidget 이 정상적으로 표시되지 않는다.

        //탭 1번
        TabHost.TabSpec ts1 = tabHost.newTabSpec("About 1637");
        ts1.setContent(R.id.tab1);
        ts1.setIndicator("About 1637");
        tabHost.addTab(ts1);

        //탭 2번
        TabHost.TabSpec ts2 = tabHost.newTabSpec("MENU");
        ts2.setContent(R.id.tab2);
        ts2.setIndicator("MENU");
        tabHost.addTab(ts2);

        //탭 3번
        TabHost.TabSpec ts3 = tabHost.newTabSpec("COUPON");
        ts3.setContent(R.id.tab3);
        ts3.setIndicator("COUPON");
        tabHost.addTab(ts3);

        //탭 4번
        TabHost.TabSpec ts4 = tabHost.newTabSpec("MAP");
        ts4.setContent(R.id.tab4);
        ts4.setIndicator("MAP");
        tabHost.addTab(ts4);

        //탭 색깔 변경 (unSelected)
        for (int i=0; i<tabHost.getTabWidget().getChildCount(); i++) {
            //탭의 배경색 검정으로 변경
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#000000"));
            //탭의 글자색을 변경하기 위해 호출
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            //탭의 글자색 흰색으로 변경
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }
        //초기 선택된 탭의 색
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#2a2406"));

        //탭 선택 리스너
        tabHost.setOnTabChangedListener(this);

        //버튼 클릭 이벤트 - QR 코드 읽기
        Button btn_readQR = (Button) findViewById(R.id.button_readQR);
        btn_readQR.setOnClickListener(this);

        //버튼 클릭 이벤트 - QR 코드 생성
        Button btn_createQR = (Button) findViewById(R.id.button_createQR);
        btn_createQR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //QR 코드 읽기
        if(v.getId() == R.id.button_readQR) {
            //QR 코드 읽는 카메라 호출
            new IntentIntegrator(this).initiateScan();
        }

        //QR 코드 생성
        if(v.getId() == R.id.button_createQR) {
            MultiFormatWriter gen = new MultiFormatWriter();
            String data = "test1234567**";
            try {
                final int WIDTH = 320;
                final int HEIGHT = 320;
                BitMatrix bitMatrix = gen.encode(data, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
                Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
                for (int i = 0 ; i < WIDTH ; ++i)
                    for (int j = 0 ; j < HEIGHT ; ++j) {
                        bitmap.setPixel(i, j, bitMatrix.get(i,j) ? Color.BLACK : Color.WHITE);
                    }

                ImageView view = (ImageView) findViewById(R.id.imageView);
                view.setImageBitmap(bitmap);
                view.invalidate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //QR 코드 읽은 후의 이벤트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getContents()));
        //startActivity(intent);

        Log.v("확인", "" + result);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(result.getContents());
    }

    //선택된 탭의 이벤트 리스너
    @Override
    public void onTabChanged(String s) {
        for (int i=0; i<tabHost.getTabWidget().getChildCount(); i++) {
            //선택된 탭을 제외한 나머지 탭의 배경색은 다시 검정으로 변경
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#000000"));
        }
        //선택된 탭의 배경색 변경
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#2a2406"));
    }
}
