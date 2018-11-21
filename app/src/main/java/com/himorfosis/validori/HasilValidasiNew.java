package com.himorfosis.validori;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import me.grantland.widget.AutofitTextView;

public class HasilValidasiNew extends AppCompatActivity {

    AutofitTextView produkNama;
    ImageView gambarProduk, gambarValidasi, gambarBrand;
    TextView textValidasi, kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran, lihatsertifikat;
    TextView txtkadaluarsa, txtberatbersih, txtkomposisi, txtdiproduksi, txtsertifikasi, txtanjuran;
    LinearLayout bgGambar;
    Button laporkan;

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

    AlertDialog alertDialog;

    String getid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasilvalidasinew);

        db = new Database(getApplicationContext());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        toolbarText = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbartext);
        toolbarText.setText("Hasil Validasi");

        kembali = (Button) getSupportActionBar().getCustomView().findViewById(R.id.kembali);


        komposisi = (TextView) findViewById(R.id.komposisi);
        kadaluarsa = findViewById(R.id.kadaluarsa);
        beratbersih = findViewById(R.id.beratbersih);
        diproduksi = findViewById(R.id.diproduksi);
        sertifikasi = findViewById(R.id.sertifikasi);
        anjuran = findViewById(R.id.anjuran);
        textValidasi = (TextView) findViewById(R.id.textValidasi);
        laporkan = findViewById(R.id.laporkan);
        lihatsertifikat = findViewById(R.id.lihatsertifikat);

        // id visibletext
        txtkadaluarsa = findViewById(R.id.txtkadaluarsa);
        txtkomposisi = findViewById(R.id.txtkomposisi);
        txtberatbersih = findViewById(R.id.txtberatbersih);
        txtdiproduksi = findViewById(R.id.txtdiproduksi);
        txtsertifikasi = findViewById(R.id.txtsertifikasi);
        txtanjuran = findViewById(R.id.txtanjuran);

        gambarValidasi = (ImageView) findViewById(R.id.gambarValidasi);
        gambarProduk = (ImageView) findViewById(R.id.gambarProduk);
        produkNama = (AutofitTextView) findViewById(R.id.produkNama);
        bgGambar = findViewById(R.id.bgGambar);
        gambarBrand = findViewById(R.id.brand);



        Intent intent = getIntent();

        getCode = intent.getStringExtra("code");

//        String format = ", Format = QR_CODE";
//        String content = "Contents = ";

        Log.e("isi code", "" + getCode);
//        Log.e("isi code", "" + content + "nike1" + format);


        for (int x = 0; x < ValidasiGetData.produkClassData().size(); x++) {

            final ProdukClassData data = ValidasiGetData.produkClassData().get(x);

            if (getCode.equals(data.getId())) {

                Log.e("validasi", "if");
                Log.e("id validasi", "" + data.getId());

                getid = data.getId();

                validasi = true;

                produkNama.setText(data.getNamaproduk());
                kadaluarsa.setText(data.getKadaluarsa());
                beratbersih.setText(data.getBeratbersih());
                komposisi.setText(data.getKomposisi());
                diproduksi.setText(data.getDiproduksi());
                sertifikasi.setText(data.getSertifikasi());
                anjuran.setText(data.getAnjuran());
                textValidasi.setText("Original");
                gambarProduk.setImageResource(data.getGambar());

                gambarValidasi.setImageResource(R.drawable.oricircle);

                laporkan.setVisibility(View.INVISIBLE);

                Log.e("gambar", "" +data.getGambar());

                int gambar = data.getGambar();

                Log.e("gambar", "" +gambar);

                simpanData();


            }
        }

        lihatsertifikat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                        Intent in = new Intent(HasilValidasiNew.this, LihatSertifikat.class);
//                        in.putExtra("id", "4");
//                        startActivity(in);

                final AlertDialog.Builder builder = new AlertDialog.Builder((HasilValidasiNew.this));
                LayoutInflater inflater = LayoutInflater.from(HasilValidasiNew.this);
                final View dialogView = inflater.inflate(R.layout.lihat_sertifikat, null);
                final ImageView gambar = (ImageView) dialogView.findViewById(R.id.gambarsertifikat);

                Log.e("id", "" +getid);

                if (getid.equals("samyang")) {

                    gambar.setImageResource(R.drawable.halal_samyang);

                }

                builder.setTitle("Sertifikat\n");
                builder.setView(dialogView);


                alertDialog = builder.create();
                alertDialog.show();

            }
        });



//        ValidasiClassData data = ValidasiGetData.validasiGetData().get(pos);

        if (validasi != true) {

            String deskrip = "Hati - hati barang palsu. Data produk ini tidak terdaftar kedalam sistem validori. " +
                    "Pelanggan berhak menolak untuk membeli produk ini " +
                    "mari lindungi konsumen dan produsen dari peredaran barang palsu\n\n" +
                    "Terima kasih";

            produkNama.setVisibility(View.INVISIBLE);
            beratbersih.setVisibility(View.INVISIBLE);
            diproduksi.setVisibility(View.INVISIBLE);
            sertifikasi.setVisibility(View.INVISIBLE);
            anjuran.setVisibility(View.INVISIBLE);

            txtkadaluarsa.setVisibility(View.INVISIBLE);
            txtberatbersih.setVisibility(View.INVISIBLE);
            txtdiproduksi.setVisibility(View.INVISIBLE);
            txtsertifikasi.setVisibility(View.INVISIBLE);
            txtanjuran.setVisibility(View.INVISIBLE);
            lihatsertifikat.setVisibility(View.INVISIBLE);

            produkNama.setText("Palsu");
            kadaluarsa.setText("Barang yang anda validasi terindikasi produk palsu\n" +
                    "harap laporkan agar segera kami tindak lanjuti");

            txtkomposisi.setText("Terima kasih");

//            int gambar = R.drawable.oricircle;

            gambarValidasi.setImageResource(R.drawable.kwcircle);
            gambarProduk.setImageResource(R.drawable.awas);
            textValidasi.setText("Barang Palsu");

            laporkan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Laporan terkirim", Toast.LENGTH_LONG).show();

                }
            });

            simpanData();

        }




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
        db.insertValidasi(new RiwayatClassData(null, produkNama.getText().toString(), kadaluarsa.getText().toString(),
                beratbersih.getText().toString(), komposisi.getText().toString(), diproduksi.getText().toString(),
                sertifikasi.getText().toString(), anjuran.getText().toString(), dataTanggal, textValidasi.getText().toString()));

    }


}
