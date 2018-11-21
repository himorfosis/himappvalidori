package com.himorfosis.validori;

/**
 * Created by him on 7/21/2018.
 */

public class CodeClassData {

    private String id;
    private String nama;
    private String deskripsi;

//    private String nilaikoh;


    public CodeClassData(String id, String nama, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
//        this.nilaikoh = nilaikoh;

    }

    public String getId() {
        return id;

    }

    public String getNama() {
        return nama;

    }

    public String getDeskripsi() {
        return deskripsi;

    }
}
