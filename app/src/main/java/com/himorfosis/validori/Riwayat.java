package com.himorfosis.validori;



import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

/**
 * Created by him on 7/15/2018.
 */

public class Riwayat extends Fragment {

    Database db;
    Fragment fragment;
    AlertDialog alertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.riwayat, container, false);

    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        ListView list = view.findViewById(R.id.list);

        String data[] = null;
        db = new Database(getActivity());

        final List<RiwayatClassData> dataList = db.getallValidasi();
        data = new String[dataList.size()];

        int i = 0;

        for (RiwayatClassData b : dataList) {

//                    id, namaproduk, kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran, waktu, validasi

            data[i] = b.getId() + b.getNamaproduk() + b.getKadaluarsa() + b.getBeratbersih() + b.getKomposisi() +
                    b.getDiproduksi() + b.getSertifikasi() + b.getAnjuran() + b.getWaktu() + b.getValidasi();

            i++;
        }

        final RiwayatListAdapter adapter = new RiwayatListAdapter(getActivity(), dataList);

        Collections.reverse(dataList);

        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                final RiwayatClassData p = dataList.get(i);

                builder.setTitle("Hapus data");
                builder.setMessage("Apakah anda akan menghapus?");
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        db.deleteValidasi(String.valueOf(p.getId()));

                        fragment = new Riwayat();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.commit();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                alertDialog = builder.create();
                alertDialog.show();
                return true;

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                RiwayatClassData data = dataList.get(position);

                Log.e("data", data.getNamaproduk());

                Intent lihat = new Intent(getActivity(), RiwayatLihatData.class);
                lihat.putExtra("namaproduk", " " + data.getNamaproduk());
                lihat.putExtra("kadaluarsa", " " + data.getKadaluarsa());
                lihat.putExtra("beratbersih", " " + data.getBeratbersih());
                lihat.putExtra("komposisi", " " + data.getKomposisi());
                lihat.putExtra("diproduksi", " " + data.getDiproduksi());
                lihat.putExtra("sertifikasi", " " + data.getSertifikasi());
                lihat.putExtra("anjuran", " " + data.getAnjuran());
                lihat.putExtra("waktu", " " + data.getWaktu());
                lihat.putExtra("validasi", " " + data.getValidasi());

                getActivity().startActivity(lihat);

//                Log.e("kode", " " + data.getKode());
//                Log.e("nama", " " + data.getNama());
//                Log.e("waktu", " " + data.getWaktu());

            }
        });


    }
}
