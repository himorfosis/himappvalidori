package com.himorfosis.validori;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by him on 7/15/2018.
 */

public class Pengaturan extends Fragment {

    ArrayList<PengaturanClassData> dataList = new ArrayList<>();
    LinearLayout bagikan, saran, hubungi, tentang, validasi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.pengaturan, container, false);

    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        bagikan = view.findViewById(R.id.bagikan);
        saran = view.findViewById(R.id.saran);
        hubungi = view.findViewById(R.id.hubungi);
        tentang = view.findViewById(R.id.tentang);
        validasi = view.findViewById(R.id.validasi);


        bagikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Terima kasih sudah membagikan", Toast.LENGTH_SHORT).show();
            }
        });

        saran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Terima kasih sudah memberi saran", Toast.LENGTH_SHORT).show();
            }
        });

        hubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Terima kasih sudah menghubungi kami", Toast.LENGTH_SHORT).show();
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TentangKami.class);
                startActivity(intent);
            }
        });

        validasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ValidasiTest.class);
                startActivity(intent);
            }
        });

    }
}
