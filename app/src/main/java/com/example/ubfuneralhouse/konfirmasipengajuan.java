package com.example.ubfuneralhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class konfirmasipengajuan extends AppCompatActivity {
    private TextView tvNama_pengaju, tvStatus, tvPekerjaan, tvNomor_telepon, tvAlamat_pengaju,tvNama_jenazah
            ,tvJenis_kelamin, tvFakultas, tvTanggal_lahir, tvTanggal_kematian, tvTanggal_pemakaman, tvAlamat_jenazah;
    private String id_google;
    private Button btConfirm_pengajuan,btBatal_pengajuan;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmation_pengajuan);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu...");
        Intent intentKonfirmasi = getIntent();
        if(intentKonfirmasi.hasExtra("id_google")){
            id_google = intentKonfirmasi.getStringExtra("id_google");

        }
        tvTanggal_pemakaman = findViewById(R.id.knfTanggal_pemakaman);
        if(intentKonfirmasi.hasExtra("tanggal_pemakaman")){
            String tanggal_pemakaman = intentKonfirmasi.getStringExtra("tanggal_pemakaman");
            tvTanggal_pemakaman.setText(tanggal_pemakaman);
        }

        /*Ahli Waris*/
        tvNama_pengaju = findViewById(R.id.knfNama_pengaju);
        if(intentKonfirmasi.hasExtra("nama_pengaju")){
            String nama_pengaju = intentKonfirmasi.getStringExtra("nama_pengaju");
            tvNama_pengaju.setText(nama_pengaju);
        }

        tvStatus = findViewById(R.id.knfStatus);
        if(intentKonfirmasi.hasExtra("status")){
            String status = intentKonfirmasi.getStringExtra("status");
            tvStatus.setText(status);
        }

        tvPekerjaan = findViewById(R.id.knfPekerjaan);
        if(intentKonfirmasi.hasExtra("pekerjaan")){
            String pekerjaan = intentKonfirmasi.getStringExtra("pekerjaan");
            tvPekerjaan.setText(pekerjaan);
        }

        tvNomor_telepon = findViewById(R.id.knfNomor_telepon);
        if(intentKonfirmasi.hasExtra("nomor_telepon")){
            String nomor_telepon = intentKonfirmasi.getStringExtra("nomor_telepon");
            tvNomor_telepon.setText(nomor_telepon);
        }

        tvAlamat_pengaju = findViewById(R.id.knfAlamat_pengaju);
        if(intentKonfirmasi.hasExtra("alamat_pengaju")){
            String alamat_pengaju = intentKonfirmasi.getStringExtra("alamat_pengaju");
            tvAlamat_pengaju.setText(alamat_pengaju);
        }
        /*Jenazah*/
        tvNama_jenazah = findViewById(R.id.knfNama_jenazah);
        if(intentKonfirmasi.hasExtra("nama_jenazah")){
            String nama_jenazah = intentKonfirmasi.getStringExtra("nama_jenazah");
            tvNama_jenazah.setText(nama_jenazah);
        }

        tvJenis_kelamin = findViewById(R.id.knfJenis_kelamin);
        if(intentKonfirmasi.hasExtra("jenis_kelamin")){
            String jenis_kelamin = intentKonfirmasi.getStringExtra("jenis_kelamin");
            tvJenis_kelamin.setText(jenis_kelamin);
        }

        tvFakultas = findViewById(R.id.knfFakultas);
        if(intentKonfirmasi.hasExtra("fakultas")){
            String fakultas = intentKonfirmasi.getStringExtra("fakultas");
            tvFakultas.setText(fakultas);
        }

        tvTanggal_lahir = findViewById(R.id.knfTanggal_lahir);
        if(intentKonfirmasi.hasExtra("tanggal_lahir")){
            String tanggal_lahir = intentKonfirmasi.getStringExtra("tanggal_lahir");
            tvTanggal_lahir.setText(tanggal_lahir);
        }

        tvTanggal_kematian = findViewById(R.id.knfTanggal_kematian);
        if(intentKonfirmasi.hasExtra("tanggal_kematian")){
            String tanggal_kematian = intentKonfirmasi.getStringExtra("tanggal_kematian");
            tvTanggal_kematian.setText(tanggal_kematian);
        }
        tvTanggal_pemakaman = findViewById(R.id.knfTanggal_pemakaman);
        tvAlamat_jenazah = findViewById(R.id.knfAlamat_jenazah);
        if(intentKonfirmasi.hasExtra("alamat_jenazah")){
            String alamat_jenazah = intentKonfirmasi.getStringExtra("alamat_jenazah");
            tvAlamat_jenazah.setText(alamat_jenazah);
        }

        btConfirm_pengajuan = findViewById(R.id.confirm_pengajuan);
        btConfirm_pengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaPemohon = tvNama_pengaju.getText().toString();
                String status = tvStatus.getText().toString();
                String pekerjaan = tvPekerjaan.getText().toString();
                String nomor_telepon = tvNomor_telepon.getText().toString();
                String alamat_pemohon = tvAlamat_pengaju.getText().toString();
                String nama_jenazah = tvNama_jenazah.getText().toString();
                String fakultas = tvFakultas.getText().toString();
                String tanggal_lahir = tvTanggal_lahir.getText().toString();
                String tanggal_kematian = tvTanggal_kematian.getText().toString();
                String alamat_jenazah = tvAlamat_jenazah.getText().toString();
                String jenis_kelamin = tvJenis_kelamin.getText().toString();
                String tanggal_pemakaman = tvTanggal_pemakaman.getText().toString();
                String google_id = id_google;
                String status_pengajuan = "Menunggu konfirmasi";
                savePengajuan(google_id,status_pengajuan,namaPemohon,status,pekerjaan,nomor_telepon,alamat_pemohon,nama_jenazah,fakultas,
                        tanggal_lahir,tanggal_kematian,alamat_jenazah,jenis_kelamin,tanggal_pemakaman);
            }
        });

        btBatal_pengajuan = findViewById(R.id.batal_pengajuan);
        btBatal_pengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(konfirmasipengajuan.this)
                        .setTitle("Peringatan")
                        .setMessage("Apakah anda ingin membatalkan pengajuan?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intentBack = new Intent(konfirmasipengajuan.this, Home.class);
                                startActivity(intentBack);
                                finish();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

    }

    private void savePengajuan(final String id_google,final String status_pengajuan, final String namaPemohon, final String status,
                               final String pekerjaan, final String nomor_telepon, final String alamat_pemohon,
                               final String nama_jenazah, final String fakultas, final String tanggal_lahir,
                               final String tanggal_kematian, final String alamat_jenazah, final String jenis_kelamin,
                               final String tanggal_pemakaman){
        progressDialog.show();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<pengajuan> call = apiInterface.savePengajuan(id_google,status_pengajuan, namaPemohon,status,pekerjaan,nomor_telepon,alamat_pemohon,nama_jenazah,fakultas,tanggal_lahir,
                tanggal_kematian,alamat_jenazah,jenis_kelamin,tanggal_pemakaman);
        call.enqueue(new Callback<pengajuan>() {
            @Override
            public void onResponse(@NonNull Call<pengajuan> call, @NonNull Response<pengajuan> response) {
                progressDialog.dismiss();
                if(response.isSuccessful() && response.body() !=null){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        Toast.makeText(konfirmasipengajuan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(btConfirm_pengajuan.getContext(), Home.class);
                        startActivity(home);
                        finish();
                    }else{
                        Toast.makeText(konfirmasipengajuan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<pengajuan> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(konfirmasipengajuan.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}