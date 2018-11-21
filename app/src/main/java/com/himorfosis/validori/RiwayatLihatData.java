package com.himorfosis.validori;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.grantland.widget.AutofitTextView;

public class RiwayatLihatData extends AppCompatActivity {

    //action bar
    TextView toolbarText;
    Button kembali;

    String getNamaproduk, getKadaluarsa, getBeratbersih, getKomposisi, getDiproduksi, getSertifikasi, getAnjuran,  getWaktu, getValidasi ;
    TextView txtkadaluarsa, txtberatbersih, txtkomposisi, txtdiproduksi, txtsertifikasi, txtanjuran;
    TextView textValidasi, kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran, lihatsertifikat;
    Button laporkan;

    AutofitTextView produkNama;
    ImageView gambarProduk, gambarValidasi;
    LinearLayout bgGambar;

    int index = 0;
    ArrayList<String> isiDetailProduk = new ArrayList<>();
    DetailProdukListAdapter adapter;
    LayoutInflater inflater;
    LinearLayout listDetail;

    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riwayatlihatdatanew);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        produkNama = (AutofitTextView) findViewById(R.id.produkNama);
        komposisi = (TextView) findViewById(R.id.komposisi);
        kadaluarsa = findViewById(R.id.kadaluarsa);
        beratbersih = findViewById(R.id.beratbersih);
        diproduksi = findViewById(R.id.diproduksi);
        sertifikasi = findViewById(R.id.sertifikasi);
        anjuran = findViewById(R.id.anjuran);
        textValidasi = (TextView) findViewById(R.id.textValidasi);
        gambarValidasi = (ImageView) findViewById(R.id.gambarValidasi);
        laporkan = findViewById(R.id.laporkan);
        gambarProduk = (ImageView) findViewById(R.id.gambarProduk);
        lihatsertifikat = findViewById(R.id.lihatsertifikat);


        toolbarText = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbartext);
        toolbarText.setText("Riwayat");

        kembali = (Button) getSupportActionBar().getCustomView().findViewById(R.id.kembali);
        kembali.setVisibility(View.VISIBLE);

        // id visibletext
        txtkadaluarsa = findViewById(R.id.txtkadaluarsa);
        txtkomposisi = findViewById(R.id.txtkomposisi);
        txtberatbersih = findViewById(R.id.txtberatbersih);
        txtdiproduksi = findViewById(R.id.txtdiproduksi);
        txtsertifikasi = findViewById(R.id.txtsertifikasi);
        txtanjuran = findViewById(R.id.txtanjuran);

        Intent intent = getIntent();

        getNamaproduk = intent.getStringExtra("namaproduk");
        getKadaluarsa = intent.getStringExtra("kadaluarsa");
        getBeratbersih = intent.getStringExtra("beratbersih");
        getKomposisi = intent.getStringExtra("komposisi");
        getDiproduksi = intent.getStringExtra("diproduksi");
        getSertifikasi = intent.getStringExtra("sertifikasi");
        getAnjuran = intent.getStringExtra("anjuran");
        getWaktu = intent.getStringExtra("waktu");
        getValidasi = intent.getStringExtra("validasi");

        Log.e("getNamaProduk", "" +getNamaproduk);

        if (getNamaproduk.equals(" Palsu")) {

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

            produkNama.setText(getNamaproduk);
            kadaluarsa.setText(getKadaluarsa);

            textValidasi.setText(getValidasi);
            gambarValidasi.setImageResource(R.drawable.kwcircle);
            gambarProduk.setImageResource(R.drawable.awas);

            txtkomposisi.setText(getKomposisi);

            laporkan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Laporan terkirim", Toast.LENGTH_LONG).show();

                }
            });

        } else {

            produkNama.setText(getNamaproduk);
            kadaluarsa.setText(getKadaluarsa);
            beratbersih.setText(getBeratbersih);
            komposisi.setText(getKomposisi);
            diproduksi.setText(getDiproduksi);
            sertifikasi.setText(getSertifikasi);
            anjuran.setText(getAnjuran);
            textValidasi.setText(getValidasi);

//            int gambar = 2131165275;

            if (getNamaproduk.equals(" Samyang Hot Chicken Ramen")) {

                gambarProduk.setImageResource(R.drawable.samyang);
                lihatsertifikat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        Intent in = new Intent(HasilValidasiNew.this, LihatSertifikat.class);
//                        in.putExtra("id", "4");
//                        startActivity(in);

                        final AlertDialog.Builder builder = new AlertDialog.Builder((RiwayatLihatData.this));
                        LayoutInflater inflater = LayoutInflater.from(RiwayatLihatData.this);
                        final View dialogView = inflater.inflate(R.layout.lihat_sertifikat, null);
                        final ImageView gambar = (ImageView) dialogView.findViewById(R.id.gambarsertifikat);

                            gambar.setImageResource(R.drawable.halal_samyang);

                        builder.setTitle("Sertifikat\n");
                        builder.setView(dialogView);


                        alertDialog = builder.create();
                        alertDialog.show();

                    }
                });


            } else {

                gambarProduk.setImageResource(R.drawable.aqua);

            }

            gambarValidasi.setImageResource(R.drawable.oricircle);

//            laporkan.setVisibility(View.INVISIBLE);

        }


//        String format = ", Format = QR_CODE";
//        String content = " Contents = ";

//        Log.e("kode", "" + content + "adidas1" + format);
//        Log.e("kode", "" +getKode);

//        if (getKode.equals(content + "adidas1" + format)) {
//
//            String data = "The Prophere is a new running style that shows off an " +
//                    "aggressive and unapologetic design, reworking vintage elements " +
//                    "with exaggerated proportions. These flexible knit shoes ride on a " +
//                    "sculpted, wave-like midsole. A dramatic new silhouette A wavy sculpted " +
//                    "midsole is a defining feature of the Prophere design Oversize proportions " +
//                    "High sidewalls add streetwise swagger Tailored trim Embroidered toe " +
//                    "details add a bespoke touch\n" +
//                    "\n\n" +
//                    "A modern running style with a resilient midsole and high side walls.";
//
//            produkNama.setText("Prophere Shoes");
//            produkIsiDeskripsi.setText(data);
//            textValidasi.setText("Original");
//            gambarProduk.setImageResource(R.drawable.adidas1view1);
//            gambarValidasi.setImageResource(R.drawable.oricircle);
//
//
//            isiDetailProduk.add("Regular fit");
//            isiDetailProduk.add("Lace closure");
//            isiDetailProduk.add("Knit upper with embroidered toe and elastic collar");
//            isiDetailProduk.add("Textile lining; Rubber outsole");
//            isiDetailProduk.add("Polyurethane midsole with sculpted sidewall");
//            isiDetailProduk.add("Stretchy upper and bouncy cushioning");

//            loopDetailProduk();

//        } else if (getKode.equals(content + "nike1" +format)) {
//
//            String data = "The NikeLab Collection Men's Full-Zip Hoodie features a standard fit, " +
//                    "articulated sleeves and slight stretch to give you the right amount of room for maximum comfort and mobility.\n" +
//                    "\n" +
//                    "\n" +
//                    "PREMIUM FEEL\n" +
//                    "Stretch French terry fleece offers premium comfort and subtle stretch." +
//                    " A split-kangaroo pocket provides storage.\n" +
//                    "\n" +
//                    "\n" +
//                    "CLASSIC PROTECTION\n" +
//                    "\n" +
//                    "The three-piece hood sits flat on your head and helps protect you from the elements." +
//                    " A scuba-style neckline adds warmth and weather protection. A two-way riri zip offers customisable closure.";
//
//            produkNama.setText("Slight Strerch Full Comfort");
//            produkIsiDeskripsi.setText(data);
//            textValidasi.setText("Original");
//            gambarProduk.setImageResource(R.drawable.nike1view1);
//            gambarValidasi.setImageResource(R.drawable.oricircle);
//
//            isiDetailProduk.add("Fabric: 97% cotton/3% elastane");
//            isiDetailProduk.add("Machine wash");
//            isiDetailProduk.add("Imported");
//            isiDetailProduk.add("Colour Shown: Medium Olive/Black/Black");
//            isiDetailProduk.add("Style: 923791-222");
//            isiDetailProduk.add("Country/Region of Origin: Vietnam");
//
//            loopDetailProduk();
//
//        } else {
//
//            String data = "Hati - hati barang palsu. Data produk ini tidak terdaftar kedalam sistem validori. " +
//                    "Pelanggan berhak menolak untuk membeli produk ini " +
//                    "mari lindungi konsumen dan produsen dari peredaran barang palsu\n\n" +
//                    "Terima kasih";
//
//            produkNama.setText("Produk palsu");
//            produkIsiDeskripsi.setText(data);
//            gambarValidasi.setImageResource(R.drawable.kwcircle);
//            gambarProduk.setImageResource(R.drawable.awas);
//            textValidasi.setText("Barang Palsu");
//            textValidasi.setTextColor(Color.RED);
//
//
//        }

            kembali.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });

        }


//    private void loopDetailProduk() {
//
//
//        for(int i = 0; i < isiDetailProduk.size(); i++) {
//
//            index = i;
//            dynamiclist();
//
//        }
//    }

//    private void dynamiclist() {
//
//        Log.e("nilai index", "" + index);
//
//        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final View item = inflater.inflate(R.layout.rowisidetail, null);
//
//        TextView isiDetail = (TextView) item.findViewById(R.id.isideskripsi);
//
//        isiDetail.setText(isiDetailProduk.get(index));
//
//        listDetail.addView(item);
//
//    }

}
