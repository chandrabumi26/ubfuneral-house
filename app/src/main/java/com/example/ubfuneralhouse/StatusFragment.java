package com.example.ubfuneralhouse;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusFragment extends Fragment {
//    private TextView tvBuatNama, tvBuatId;
    private String cobaNama,cobaId;
    private List<pengajuan> pengajuans = new ArrayList<>();
    private StatusAdapter statusAdapter;
    private RecyclerView StatusRv;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_status,container,false);
//        tvBuatNama = v.findViewById(R.id.buatNama);
//        String bndl_nama = this.getArguments().getString("nama");
//        tvBuatNama.setText(bndl_nama);
//        tvBuatId = v.findViewById(R.id.buatId);
//        String bndl_id = this.getArguments().getString("id");
//        tvBuatId.setText(bndl_id);
        String bndl_nama = this.getArguments().getString("nama");
        cobaNama = bndl_nama;
        String bndl_id = this.getArguments().getString("id");
        cobaId = bndl_id;
        progressDialog = new ProgressDialog(this.getContext());
        progressDialog.setMessage("Tunggu...");

        StatusRv = v.findViewById(R.id.rvStatus);
        statusAdapter = new StatusAdapter(this.getContext(),pengajuans);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        StatusRv.setLayoutManager(mLayoutManager);
        StatusRv.setAdapter(statusAdapter);

        loadData();

        return v;
    }

    private void loadData(){
        progressDialog.show();
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Value> call = apiInterface.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progressDialog.dismiss();
                String value = response.body().getValue();
                if(value.equals("1")){
                    pengajuans = response.body().getPengajuan();
                    for(pengajuan u:pengajuans ){
                        Log.d("id_google", u.getId_google());
                        Log.d("nama_jenazah", u.getNama_jenazah());
                    }
                    String [] id = new String[pengajuans.size()];
                    List<pengajuan> p = new ArrayList<>();
                    /*SAMPE SINI HARI INI*/
                    for(int i = 0; i<pengajuans.size(); i++){

                        id[i] = pengajuans.get(i).getId_google();

                        if(id[i].equals(cobaId)){
                            p.add(pengajuans.get(i));
                            statusAdapter = new StatusAdapter(StatusFragment.this.getContext(),p);
                            StatusRv.setAdapter(statusAdapter);
                        }

                    }
//                        nama[1] = pengajuans.get(1).getNamaPemohon();
//                        tvDicoba.setText(usernames[1]);


                }else{

                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }

}