package com.example.ubfuneralhouse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pengajuan {

    @Expose
    @SerializedName("id_pengajuan") private int id;
    @Expose
    @SerializedName("letak_id") private String letak_id;
    @Expose
    @SerializedName("id_google") private String id_google;
    @Expose
    @SerializedName("status_pengajuan") private String status_pengajuan;
    @Expose
    @SerializedName("namaPemohon") private String namaPemohon;
    @Expose
    @SerializedName("status") private String status;
    @Expose
    @SerializedName("pekerjaan") private  String pekerjaan;
    @Expose
    @SerializedName("nomor_telepon") private String nomor_telepon;
    @Expose
    @SerializedName("alamat_pemohon") private String alamat_pemohon;
    @Expose
    @SerializedName("nama_jenazah") private String nama_jenazah;
    @Expose
    @SerializedName("fakultas") private String fakultas;
    @Expose
    @SerializedName("tanggal_lahir") private String tanggal_lahir;
    @Expose
    @SerializedName("tanggal_kematian") private String tanggal_kematian;
    @Expose
    @SerializedName("alamat_jenazah") private String alamat_jenazah;
    @Expose
    @SerializedName("jenis_kelamin") private String jenis_kelamin;
    @Expose
    @SerializedName("tanggal_pemakaman") private String tanggal_pemakaman;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetak_id() {
        return letak_id;
    }

    public String getNamaPemohon() {
        return namaPemohon;
    }

    public String getId_google() {
        return id_google;
    }

    public String getStatus_pengajuan() {
        return status_pengajuan;
    }

    public void setStatus_pengajuan(String status_pengajuan) {
        this.status_pengajuan = status_pengajuan;
    }

    public void setId_google(String id_google) {
        this.id_google = id_google;
    }

    public void setNamaPemohon(String namaPemohon) {
        this.namaPemohon = namaPemohon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public String getAlamat_pemohon() {
        return alamat_pemohon;
    }

    public void setAlamat_pemohon(String alamat_pemohon) {
        this.alamat_pemohon = alamat_pemohon;
    }

    public String getNama_jenazah() {
        return nama_jenazah;
    }

    public void setNama_jenazah(String nama_jenazah) {
        this.nama_jenazah = nama_jenazah;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTanggal_kematian() {
        return tanggal_kematian;
    }

    public void setTanggal_kematian(String tanggal_kematian) {
        this.tanggal_kematian = tanggal_kematian;
    }

    public String getAlamat_jenazah() {
        return alamat_jenazah;
    }

    public void setAlamat_jenazah(String alamat_jenazah) {
        this.alamat_jenazah = alamat_jenazah;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTanggal_pemakaman() {
        return tanggal_pemakaman;
    }

    public void setTanggal_pemakaman(String tanggal_pemakaman) {
        this.tanggal_pemakaman = tanggal_pemakaman;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
