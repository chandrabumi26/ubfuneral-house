package com.example.ubfuneralhouse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("save.php")
    Call<pengajuan> savePengajuan(@Field("id_google") String id_google,
                                  @Field("status_pengajuan") String status_pengajuan,
                                  @Field("namaPemohon") String namaPemohon,
                                  @Field("status") String status,
                                  @Field("pekerjaan") String pekerjaan,
                                  @Field("nomor_telepon") String nomor_telepon,
                                  @Field("alamat_pemohon") String alamat_pemohon,
                                  @Field("nama_jenazah") String nama_jenazah,
                                  @Field("fakultas") String fakultas,
                                  @Field("tanggal_lahir") String tanggal_lahir,
                                  @Field("tanggal_kematian") String tanggal_kematian,
                                  @Field("alamat_jenazah") String alamat_jenazah,
                                  @Field("jenis_kelamin") String jenis_kelamin,
                                  @Field("tanggal_pemakaman") String tanggal_pemakaman);

    @FormUrlEncoded
    @POST("loginUser.php")
    Call<user_google> checkUserGoogle(@Field("id_user_google") String id_user_google,
                                      @Field("nama_user_google") String nama_user_google,
                                      @Field("email_user_google") String email_user_google);

    @GET("getStatus.php")
    Call<Value> view();

    @GET("getLetak.php")
    Call<Value> viewLetak();

}
