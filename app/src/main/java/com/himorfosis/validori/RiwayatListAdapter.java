package com.himorfosis.validori;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by him on 7/17/2018.
 */

public class RiwayatListAdapter extends ArrayAdapter<RiwayatClassData> {

    private Context context;
    private List<RiwayatClassData> list;
    Database db;


    public RiwayatListAdapter(Context context, List<RiwayatClassData> list) {

        super(context, R.layout.riwayatlihatdata, list);
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
            v = vi.inflate(R.layout.riwayatrowisi, null);
        }

        RiwayatClassData p = list.get(position);

        db = new Database(getContext());

        if (p != null) {

            TextView tanggal = v.findViewById(R.id.tanggal);
            TextView nama = v.findViewById(R.id.nama);
            ImageView validasi = v.findViewById(R.id.rowValidasi);

            tanggal.setText(p.getWaktu());
            nama.setText(p.getNamaproduk());

            Log.e("getData", "" + p.getValidasi());
            Log.e("getData", "" + p.getWaktu());

            if (p.getValidasi().equals("Original")) {

                validasi.setImageResource(R.drawable.oricircle);

            } else {

                validasi.setImageResource(R.drawable.kwcircle);

            }


        }

        return v;
    }

}
