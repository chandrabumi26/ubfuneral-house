package com.example.ubfuneralhouse;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class data_jenazah_fragment extends Fragment {
    private EditText etNamaJenazah,etAlamatJenazah;
    private Button btJnzh,btDateLahir,btDateKematian,btnSwipeBack,btDatePemakaman;
    private RadioGroup rgJenazah;
    private RadioButton rbJenazah;
    private String id_google;
    private DatePickerDialog.OnDateSetListener setListener1,setListener2,setListener3;
    private Spinner spnFakultas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.data_jenazah_fragment,container,false);
        id_google = ((Test_menu_pengajuan)getActivity()).id_google;
        etNamaJenazah = v.findViewById(R.id.nama_jenazah1);
        etAlamatJenazah = v.findViewById(R.id.alamat_jenazah);
        spnFakultas = v.findViewById(R.id.fakultas);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fakultas));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFakultas.setAdapter(myAdapter);
        rgJenazah = v.findViewById(R.id.radio_group_jenazah);
        int radioId = rgJenazah.getCheckedRadioButtonId();
        rbJenazah = v.findViewById(radioId);
        btDateLahir = v.findViewById(R.id.date_lahir);
        btDateKematian = v.findViewById(R.id.date_kematian);
        btDatePemakaman = v.findViewById(R.id.date_pemakaman);

        Calendar kalender = Calendar.getInstance();
        final int year = kalender.get(Calendar.YEAR);
        final int month = kalender.get(Calendar.MONTH);
        final int day = kalender.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        btDateKematian.setText(date);

        btDateLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener1,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = day +"/" +month+ "/"+year;
                btDateLahir.setText(date);
            }
        };

        btDateKematian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener2,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = day +"/" +month+ "/"+year;
                btDateKematian.setText(date);
            }
        };

        btDatePemakaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener3,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = day +"/" +month+ "/"+year;
                btDatePemakaman.setText(date);
            }
        };

        btJnzh = v.findViewById(R.id.confirm_jnzh);
        btJnzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Peringatan")
                        .setMessage("Data yang telah diisi merupakan data yang sebenar benarnya")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intentKonfirmasi = new Intent(getContext(), konfirmasipengajuan.class);
                                int rbPengaju = ((RadioGroup)getActivity().findViewById(R.id.radio_group_pengaju)).getCheckedRadioButtonId();
                                int rbJenazah = ((RadioGroup)getActivity().findViewById(R.id.radio_group_jenazah)).getCheckedRadioButtonId();
                                intentKonfirmasi.putExtra("id_google",id_google);
                                /*Pengaju*/
                                intentKonfirmasi.putExtra("nama_pengaju",((EditText)getActivity().findViewById(R.id.nama_pengaju)).getText().toString());
                                intentKonfirmasi.putExtra("pekerjaan",((EditText)getActivity().findViewById(R.id.pekerjaan)).getText().toString());
                                intentKonfirmasi.putExtra("nomor_telepon",((EditText)getActivity().findViewById(R.id.no_telp)).getText().toString());
                                intentKonfirmasi.putExtra("alamat_pengaju",((EditText)getActivity().findViewById(R.id.alamat_pengaju)).getText().toString());
                                intentKonfirmasi.putExtra("status",((RadioButton)getActivity().findViewById(rbPengaju)).getText().toString());
                                /*Jenazah*/
                                intentKonfirmasi.putExtra("nama_jenazah",((EditText)getActivity().findViewById(R.id.nama_jenazah1)).getText().toString());
                                intentKonfirmasi.putExtra("nama_jenazah",((EditText)getActivity().findViewById(R.id.nama_jenazah1)).getText().toString());
                                intentKonfirmasi.putExtra("alamat_jenazah",((EditText)getActivity().findViewById(R.id.alamat_jenazah)).getText().toString());
                                intentKonfirmasi.putExtra("tanggal_lahir",((Button)getActivity().findViewById(R.id.date_lahir)).getText().toString());
                                intentKonfirmasi.putExtra("tanggal_kematian",((Button)getActivity().findViewById(R.id.date_kematian)).getText().toString());
                                intentKonfirmasi.putExtra("tanggal_pemakaman",((Button)getActivity().findViewById(R.id.date_pemakaman)).getText().toString());
                                intentKonfirmasi.putExtra("jenis_kelamin",((RadioButton)getActivity().findViewById(rbJenazah)).getText().toString());
                                intentKonfirmasi.putExtra("fakultas",((Spinner)getActivity().findViewById(R.id.fakultas)).getSelectedItem().toString());
                                startActivity(intentKonfirmasi);
                                getActivity().finish();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });

        btnSwipeBack = v.findViewById(R.id.swipeBack);
        btnSwipeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Test_menu_pengajuan)getActivity()).setCurrentItem (0, true);
            }
        });

        return v;
    }

}