package com.himorfosis.validori;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by him on 7/17/2018.
 */

public class PengaturanListAdapter extends ArrayAdapter<PengaturanClassData> {

    Context context;
    List<PengaturanClassData> list;


    public PengaturanListAdapter(Context context, List<PengaturanClassData> object){
        super(context, R.layout.rowisipengaturan, object);
        this.context = context;
        this.list = object;


    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;

            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.rowisipengaturan, null);

        }

        PengaturanClassData data = (PengaturanClassData) getItem(position);

        if (data != null) {

            ImageView gambar = (ImageView) v.findViewById(R.id.gambar);
            TextView text = (TextView) v.findViewById(R.id.isitext) ;

            gambar.setImageResource(list.get(position).getGambar());
            text.setText(list.get(position).getNama());

        }

        return v;

    }

}
