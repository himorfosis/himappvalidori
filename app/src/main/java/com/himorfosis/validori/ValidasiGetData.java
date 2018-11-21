package com.himorfosis.validori;

import java.util.ArrayList;

/**
 * Created by him on 7/27/2018.
 */

public class ValidasiGetData {

    public static ArrayList<ValidasiClassData> validasiGetData() {

        ArrayList<ValidasiClassData> validasiGetData = new ArrayList<>();

        validasiGetData.add(new ValidasiClassData(IsiData.idAdi1, IsiData.adiNama1, IsiData.adidas, IsiData.adiGambar1, IsiData.adiDesk1, IsiData.adiDet1));
        validasiGetData.add(new ValidasiClassData(IsiData.idNike1, IsiData.nikeNama1, IsiData.nike, IsiData.nikeGambar1, IsiData.nikeDesk1, IsiData.nikeDet1));
//        validasiGetData.add(new ValidasiClassData(IsiData.id3, IsiData.nama3, IsiData.produk3, IsiData.gambar3, IsiData.desk3, IsiData.detail3));



        return validasiGetData;
    }

    //  namaproduk, kadaluarsa, beratbersih, komposisi, diproduksi, sertifikasi, anjuran;


    public static ArrayList<ProdukClassData> produkClassData() {

        ArrayList<ProdukClassData> produkClassData = new ArrayList<>();

        produkClassData.add(new ProdukClassData(IsiData.id3, IsiData.namaproduk3, IsiData.kadaluarsa3, IsiData.gambar3, IsiData.beratbersih3, IsiData.komposisi3, IsiData.diproduksi3, IsiData.sertifikasi3, IsiData.anjuran3));
        produkClassData.add(new ProdukClassData(IsiData.id4, IsiData.namaproduk4, IsiData.kadaluarsa4, IsiData.gambar4, IsiData.beratbersih4, IsiData.komposisi4, IsiData.diproduksi4, IsiData.sertifikasi4, IsiData.anjuran4));

        return produkClassData;
    }

}
