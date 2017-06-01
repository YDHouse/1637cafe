package yd.cafe1637;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Tab3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_coupon_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        //버튼 클릭 이벤트 - QR 코드 읽기
        Button btn_coupon_01 = (Button) findViewById(R.id.btn_coupon_01);
        btn_coupon_01.setOnClickListener(this);

        //버튼 클릭 이벤트 - QR 코드 생성
        btn_coupon_02 = (Button) findViewById(R.id.btn_coupon_02);
        btn_coupon_02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //QR 코드 읽기
        if(v.getId() == R.id.btn_coupon_01) {
            //QR 코드 읽는 카메라 호출
            new IntentIntegrator(this).initiateScan();
        }
/*
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
        */
    }

    //QR 코드 읽은 후의 이벤트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        Log.v("확인", "" + result.getContents());

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getContents()));
        //startActivity(intent);

        //TextView tv = (TextView) findViewById(R.id.textView);
        //tv.setText(result.getContents());

        String pw = "test1234567**";
        String check = result.getContents();

        if (check.equals(pw)) {
            btn_coupon_02.setEnabled(true);
        } else {
            Toast.makeText(this, "잘못된 QR 코드입니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
