package net.kvedalen.sandbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by trim on 08.04.2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> mDataList;
    private static LayoutInflater inflator = null;


    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> datalist){
        mContext = context;
        mDataList = datalist;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (convertView == null){
            view = inflator.inflate(R.layout.listrow_main, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView desc  = (TextView) view.findViewById(R.id.desc);

            HashMap<String, String> mData = new HashMap<>();
            mData = mDataList.get(position);

            title.setText(mData.get("title"));
            desc.setText(mData.get("desc"));
        }
        return view;
    }
}
