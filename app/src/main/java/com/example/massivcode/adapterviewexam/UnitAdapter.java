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

        // 이제부터 ViewHolder 패턴을 적용해보도록 하겠습니다.
        // ViewHolder 패턴은 findViewById() 메소드를 한번만 사용해서 아이템 뷰들을 갖고 있다가
        // 차후에 데이터를 세팅할 때 이용할 수 있도록 하는 역할을 합니다.

        ViewHolder viewHolder;

        // getView 가 최초로 실행될 때는 ListView 의 Child Item View 가 null 입니다.
        // 밑의 코드를 살펴보시면 convertview 가 null 일 때는 view 를 생성하고,
        // null 이 아닐때는 기존의 view 를 재사용 한다는 것을 알 수 있습니다.
        // 첫번째로 convertView 를 이용하여 자원을 절약하고,
        // 두번째로 viewHolder 패턴을 이용하여 불필요한 리소스의 낭비를 방지합니다.
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_layout, parent, false);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.item_title_tv);
            viewHolder.contentsTextView = (TextView) convertView.findViewById(R.id.item_contents_tv);
            // view 클래스에는 setTag(Object object) 라는 메소드가 있습니다.
            // 해당 객체에 특정한 객체를 보관하는 메소드 입니다.
            // 위에서 viewHolder 객체를 생성하고, findViewById() 를 한 다음에, 그 결과물을 보관합니다.
            convertView.setTag(viewHolder);
        } else {
            // convertView 가 존재할 때는 객체에 담긴 viewHolder 객체를 가져옵니다.
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 데이터 세팅
        Unit unit = (Unit) getItem(position);
        viewHolder.titleTextView.setText(unit.getRace());
        viewHolder.contentsTextView.setText(unit.getName());

        return convertView;
    }

    static class ViewHolder {
        TextView titleTextView;
        TextView contentsTextView;
    }
}
