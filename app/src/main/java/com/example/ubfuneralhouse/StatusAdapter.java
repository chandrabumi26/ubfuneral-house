package com.example.ubfuneralhouse;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {
    private Context context;
    private List<pengajuan> pengajuanList;
    private String cobaId,blok,baris;
    private ApiInterface apiInterface;
    private List<letak> letaks = new ArrayList<>();

    public StatusAdapter(Context context, List<pengajuan> pengajuanList){
        this.context = context;
        this.pengajuanList = pengajuanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_item,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        pengajuan pengajuans = pengajuanList.get(position);
        holder.tvStNamaJenazah.setText(pengajuans.getNama_jenazah());
        holder.tvTglKematian.setText(pengajuans.getTanggal_kematian());
        holder.tvTglPemakaman.setText(pengajuans.getTanggal_pemakaman());
        holder.tvStatusPengajuan.setText(pengajuans.getStatus_pengajuan());
        cobaId = pengajuans.getLetak_id();
        /*Ga terlalu penting, cuma warna label status doang, bisa terakhir!!
        bisa pake http post kaya di medium.com, buat request baru postLetak(cobaId)
        coba letak pemakaman if(letaks.getId_letak().equals(cobaID))
        * blok = letaks.getBlok();
        * baris = letaks.baris
        *
        * !!problem apiInterface = null???????
        * ifnya (pengajuans.getStatus_pengajuan().equals("Letak Pemakaman telah dipilih ("+"blok"+" - "+"baris"+")"))
        * cape nulis if satu satu per blok ama baris dari DB
        * */
        if(pengajuans.getStatus_pengajuan().equals("Letak Pemakaman telah dipilih ("+"A"+" - "+"1.3"+")")){
            holder.vo.setBackgroundResource(R.drawable.status_blok);
        }

    }

    @Override
    public int getItemCount() {
        return pengajuanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvStNamaJenazah, tvTglKematian,tvTglPemakaman,tvStatusPengajuan;
        private LinearLayout vo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStNamaJenazah = itemView.findViewById(R.id.stNamaJenazah);
            tvTglKematian = itemView.findViewById(R.id.tglMeninggal);
            tvTglPemakaman = itemView.findViewById(R.id.tglPemakaman);
            tvStatusPengajuan = itemView.findViewById(R.id.stPengajuan);
            vo = itemView.findViewById(R.id.linearStatus);

        }
    }

}
