package com.himorfosis.validori;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by him on 7/21/2018.
 */

public class DetailProdukListAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> list;

    public DetailProdukListAdapter(Context context, List<String> list) {

        super(context, R.layout.rowisidetail, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v = view;
        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.rowisidetail, null);

        }

        Log.e("posisi", "" +position);

        Integer pos = position +1;

        String strposisi = String.valueOf(pos);

        String data = list.get(position);

        if (data != null) {

            TextView penjelasan = (TextView) v.findViewById(R.id.isideskripsi);

            penjelasan.setText(data);

        }

        return v;

    }
}
