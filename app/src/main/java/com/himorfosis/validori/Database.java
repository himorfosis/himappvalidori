package com.himorfosis.validori;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by him on 7/10/2018.
 */

    public class Database extends SQLiteOpenHelper {

//        private static final String ID_PRODUK = "id_produk";
//        private static final String WAKTU = "waktu";
//        private static final String KODE = "kode";
//        private static final String VALIDASI = "validasi";
//        private static final String NAMA = "nama";

        private static final String BRAND = "brand";
        private static final String DETAIL = "detail";


        private static final String id = "id";
        private static final String namaproduk = "namaproduk";
        private static final String kadaluarsa = "kadaluarsa";
        private static final String beratbersih = "beratbersih";
        private static final String komposisi = "komposisi";
        private static final String diproduksi = "diproduksi";
        private static final String sertifikasi = "sertifikasi";
        private static final String anjuran = "anjuran";
        private static final String waktu = "waktu";
        private static final String validasi = "validasi";

        private static final String DatabaseName = "Validori";
        private static final int DatabaseVersion = 2;

        public Database(Context context) {
            super(context, DatabaseName, null, DatabaseVersion);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE tabelvalidasi ( id INTEGER PRIMARY KEY AUTOINCREMENT, namaproduk TEXT NOT NULL, kadaluarsa TEXT NOT NULL, beratbersih TEXT NOT NULL, komposisi TEXT NOT NULL, diproduksi TEXT NOT NULL, sertifikasi TEXT NOT NULL, anjuran TEXT NOT NULL, waktu TEXT NOT NULL, validasi TEXT NOT NULL ); ");

        }

        @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS tabelvalidasi");

            onCreate(db);
        }

        public void insertValidasi(RiwayatClassData classData) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(id, classData.getId());
            cv.put(namaproduk, classData.getNamaproduk());
            cv.put(kadaluarsa, classData.getKadaluarsa());
            cv.put(beratbersih, classData.getBeratbersih());
            cv.put(komposisi, classData.getKomposisi());
            cv.put(diproduksi, classData.getDiproduksi());
            cv.put(sertifikasi, classData.getSertifikasi());
            cv.put(anjuran, classData.getAnjuran());
            cv.put(waktu, classData.getWaktu());
            cv.put(validasi, classData.getValidasi());

            db.insert("tabelvalidasi", null, cv);
            db.close();

        }

//    public void insertValidasi(RiwayatClassData classData) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(ID_PRODUK, classData.getId_produk());
//        cv.put(KODE, classData.getKode());
//        cv.put(NAMA, classData.getNama());
//        cv.put(WAKTU, classData.getWaktu());
//        cv.put(VALIDASI, classData.getValidasi());
//
//        db.insert("tabelvalidasi", null, cv);
//        db.close();
//
//    }

        public void deleteValidasi(String id) {

            SQLiteDatabase db = this.getWritableDatabase();
            String[] args = {id};
            ContentValues cv = new ContentValues();

            db.delete("tabelvalidasi", "id=?", args);
            db.close();
        }

        public List<RiwayatClassData> getallValidasi() {
            List<RiwayatClassData> dataArray = new ArrayList<RiwayatClassData>();
            String query = "SELECT * FROM tabelvalidasi";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                do {

                    RiwayatClassData datalist = new RiwayatClassData(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
                    dataArray.add(datalist);

                } while (cursor.moveToNext());
            }
            return dataArray;
        }
}
