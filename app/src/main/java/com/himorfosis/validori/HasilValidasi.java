package com.himorfosis.validori;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import me.grantland.widget.AutofitTextView;

public class HasilValidasi extends AppCompatActivity {

    TextView produkIsiDeskripsi, textValidasi;
    AutofitTextView produkNama;
    ImageView gambarProduk, gambarValidasi, gambarBrand;
    TextView kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran;
    LinearLayout bgGambar;

    // get data from validasi
    String getCode;

    // List isi detail
    int index = 0;
    ArrayList<String> isiDetailProduk = new ArrayList<>();
    DetailProdukListAdapter adapter;
    LayoutInflater inflater;
    LinearLayout listDetail;

    //toolbar
    TextView toolbarText;
    Button kembali;

    Database db;

    boolean validasi = false;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasilvalidasi);

        db = new Database(getApplicationContext());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        toolbarText = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbartext);
        toolbarText.setText("Hasil Validasi");

        kembali = (Button) getSupportActionBar().getCustomView().findViewById(R.id.kembali);
        kembali.setVisibility(View.VISIBLE);

//        produkIsiDeskripsi = (TextView) findViewById(R.id.produkIsiDeskripsi);
//        textValidasi = (TextView) findViewById(R.id.textValidasi);
//        gambarValidasi = (ImageView) findViewById(R.id.gambarValidasi);
//        listDetail = (LinearLayout) findViewById(R.id.listdetail);

        komposisi = (TextView) findViewById(R.id.komposisi);
        kadaluarsa = findViewById(R.id.kadaluarsa);
        beratbersih = findViewById(R.id.beratbersih);
        diproduksi = findViewById(R.id.diproduksi);
        sertifikasi = findViewById(R.id.sertifikasi);
        anjuran = findViewById(R.id.anjuran);

        gambarProduk = (ImageView) findViewById(R.id.gambarProduk);
        produkNama = (AutofitTextView) findViewById(R.id.produkNama);
        bgGambar = findViewById(R.id.bgGambar);
        gambarBrand = findViewById(R.id.brand);



        Intent intent = getIntent();

        getCode = intent.getStringExtra("code");

        String format = ", Format = QR_CODE";
        String content = "Contents = ";

        Log.e("isi code", "" + getCode);
        Log.e("isi code", "" + content + "nike1" + format);


        for (int x = 0; x < ValidasiGetData.validasiGetData().size(); x++) {

            ValidasiClassData data = ValidasiGetData.validasiGetData().get(x);

            if (getCode.equals(content + data.getId() + format)) {

                Log.e("validasi", "if");
                Log.e("id validasi", "" + content + data.getId() + format);

                validasi = true;
//                pos = x;

                produkNama.setText(data.getNama());
                produkIsiDeskripsi.setText(data.getDeskripsi());
                textValidasi.setText("Original");
                gambarProduk.setImageResource(data.getGambar());
                gambarValidasi.setImageResource(R.drawable.oricircle);

                // looping data detail

                for (int i = 0; i < data.getDetail().length; i++) {

                    inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View item = inflater.inflate(R.layout.rowisidetail, null);

                    TextView isiDetail = (TextView) item.findViewById(R.id.isideskripsi);

                    isiDetail.setText(data.getDetail()[i]);

                    listDetail.addView(item);

                }


            } else {

                Log.e("validasi", "else");

            }

        }

//        ValidasiClassData data = ValidasiGetData.validasiGetData().get(pos);

        if (validasi != true) {

            String deskrip = "Hati - hati barang palsu. Data produk ini tidak terdaftar kedalam sistem validori. " +
                    "Pelanggan berhak menolak untuk membeli produk ini " +
                    "mari lindungi konsumen dan produsen dari peredaran barang palsu\n\n" +
                    "Terima kasih";

            produkNama.setText("Palsu");
            produkIsiDeskripsi.setText(deskrip);
            gambarValidasi.setImageResource(R.drawable.kwcircle);
            gambarProduk.setImageResource(R.drawable.awas);
            textValidasi.setText("Barang Palsu");
//            textValidasi.setTextColor(Color.RED);

        }

//        if (validasi == true) {
//
//            //            gambarBrand.setImageResource();
//            produkNama.setText(data.getNama());
//            produkIsiDeskripsi.setText(data.getDeskripsi());
//            textValidasi.setText("Original");
//            gambarProduk.setImageResource(data.getGambar());
//            gambarValidasi.setImageResource(R.drawable.oricircle);
//
//            // looping data detail
//
//            for (int i = 0; i < data.getDetail().length; i++) {
//
//                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                final View item = inflater.inflate(R.layout.rowisidetail, null);
//
//                TextView isiDetail = (TextView) item.findViewById(R.id.isideskripsi);
//
//                isiDetail.setText(data.getDetail()[i]);
//
//                listDetail.addView(item);
//
//            }
//
//            simpanData();
//
//        } else {
//
//            String deskrip = "Hati - hati barang palsu. Data produk ini tidak terdaftar kedalam sistem validori. " +
//                    "Pelanggan berhak menolak untuk membeli produk ini " +
//                    "mari lindungi konsumen dan produsen dari peredaran barang palsu\n\n" +
//                    "Terima kasih";
//
//            produkNama.setText("Palsu");
//            produkIsiDeskripsi.setText(deskrip);
//            gambarValidasi.setImageResource(R.drawable.kwcircle);
//            gambarProduk.setImageResource(R.drawable.awas);
//            textValidasi.setText("Barang Palsu");
////            textValidasi.setTextColor(Color.RED);
//
//            simpanData();
//
//        }


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    private void simpanData() {

        Calendar c = Calendar.getInstance();

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate1 = df2.format(c.getTime());
        String[] daysArray = new String[]{"", "Minggu", "Senin", "Selasa", "Rabu", "Kamis ", "Jumat", "Sabtu"};
        String[] monthArray = new String[]{"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        String hari = formattedDate1.substring(formattedDate1.indexOf("-") + 1);
        String tanggalbulan = formattedDate1.substring(formattedDate1.indexOf("-") + 1);
        String tanggal = tanggalbulan.substring(tanggalbulan.lastIndexOf("-") + 1);
        String bulan = tanggalbulan.substring(0, tanggalbulan.indexOf("-"));
        String tahun = formattedDate1.substring(0, formattedDate1.indexOf("-"));

        int intbulan = Integer.parseInt(bulan);
        int date = c.get(Calendar.DAY_OF_WEEK);

        String dataTanggal = daysArray[date] + ", " + tanggal + " " + monthArray[intbulan - 1] + " " + tahun;

//        db.insertValidasi(new RiwayatClassData(null, getCode, produkNama.getText().toString(), dataTanggal, textValidasi.getText().toString()));

    }

}
