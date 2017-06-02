package yd.cafe1637;

import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends ActivityGroup implements TabHost.OnTabChangeListener {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터베이스 삭제
        //getApplication().deleteDatabase("Cafe1637.db");

        //데이터베이스 생성
        //(메뉴 드로어에서 DB를 사용하기 때문에 A10에서 DB 생성을 해 주어야 한다.)
        new D00_DBManager(this);

        //메뉴 탭 호출
        tabHost = (TabHost) findViewById(R.id.tabHost);
        //setup() 함수를 호출하지 않으면 TabWidget 이 정상적으로 표시되지 않는다.
        tabHost.setup(getLocalActivityManager());

        //탭 1번 - 1637에 대해서
        TabHost.TabSpec ts1 = tabHost.newTabSpec("TAB1");
        ts1.setContent(new Intent(this, Tab1Activity.class));
        ts1.setIndicator("About 1637");
        tabHost.addTab(ts1);

        //탭 2번 - 메뉴
        TabHost.TabSpec ts2 = tabHost.newTabSpec("TAB2");
        ts2.setContent(new Intent(this, Tab2Activity.class));
        ts2.setIndicator("MENU");
        tabHost.addTab(ts2);

        //탭 3번 - 쿠폰
        TabHost.TabSpec ts3 = tabHost.newTabSpec("TAB3");
        ts3.setContent(new Intent(this, Tab3Activity.class));
        ts3.setIndicator("COUPON");
        tabHost.addTab(ts3);

        //탭 4번 - 오시는 길
        TabHost.TabSpec ts4 = tabHost.newTabSpec("TAB4");
        ts4.setContent(new Intent(this, Tab4Activity.class));
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
