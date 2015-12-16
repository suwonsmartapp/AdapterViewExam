package com.example.massivcode.adapterviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 리스트 뷰의 어댑터에 담길 데이터 입니다.
    private List<Unit> mData;

    // 담길 데이터를 초기화하는 메소드 입니다.
    private void initData() {
        mData = new ArrayList<>();

        mData.add(new Unit("테란", "마린"));
        mData.add(new Unit("테란", "메딕"));
        mData.add(new Unit("테란", "마린"));
        mData.add(new Unit("테란", "메딕"));
        mData.add(new Unit("테란", "마린"));
        mData.add(new Unit("테란", "메딕"));
        mData.add(new Unit("프로토스", "질럿"));
        mData.add(new Unit("프로토스", "프로브"));
        mData.add(new Unit("프로토스", "질럿"));
        mData.add(new Unit("프로토스", "프로브"));
        mData.add(new Unit("프로토스", "질럿"));
        mData.add(new Unit("프로토스", "프로브"));
        mData.add(new Unit("저그", "라바"));
        mData.add(new Unit("저그", "저글링"));
        mData.add(new Unit("저그", "라바"));
        mData.add(new Unit("저그", "저글링"));
        mData.add(new Unit("저그", "라바"));
        mData.add(new Unit("저그", "저글링"));

    }

    private UnitAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mAdapter = new UnitAdapter(mData, getApplicationContext());
        mListView = (ListView)findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
    }
}
