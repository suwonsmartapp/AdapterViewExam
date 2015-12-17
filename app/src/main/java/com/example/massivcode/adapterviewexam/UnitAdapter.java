package com.example.massivcode.adapterviewexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by massivCode on 2015-12-16.
 */
public class UnitAdapter extends BaseAdapter {

    // ListView 에 표시할 데아터
    private List<Unit> mList;
    // ListView 의 item view 를 inflate 할 때 사용하는 객체
    private LayoutInflater mLayoutInflater;

    public UnitAdapter(List<Unit> mList, Context mContext) {
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 아래의 3개 메소드는 getView 내부에서 사용되는 메소드 입니다.
     * getCount() : 리스트의 개수를 리턴
     * getItem(int position) : 해당 position 의 item 을 리턴.
     * getItemId(int position) : 해당 position 의 id를 리턴. 주로 position 이 id가 됩니다.
     */

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_layout, parent, false);
        }

        Unit unit = (Unit) getItem(position);
        TextView title = (TextView) convertView.findViewById(R.id.item_title_tv);
        TextView contents = (TextView) convertView.findViewById(R.id.item_contents_tv);
        title.setText(unit.getRace());
        contents.setText(unit.getName());

        return convertView;
    }
}
