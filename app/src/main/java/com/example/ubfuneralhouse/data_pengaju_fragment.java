package com.example.ubfuneralhouse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//import com.basgeekball.awesomevalidation.AwesomeValidation;
//import com.basgeekball.awesomevalidation.ValidationStyle;
//import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class data_pengaju_fragment extends Fragment {
    private Fragment defaultFrag = null;
    private RadioGroup rgRadioGroup;
    public RadioButton rbRadioButton;
    private EditText etNama_pengaju,etPekerjaan,etNomor_telepon,etAlamat_pengaju;
    private Button btConfirm;
    private String id_google;
//    private AwesomeValidation awesomeValidation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.data_pengaju_fragment,container,false);
        id_google = ((Test_menu_pengajuan)getActivity()).id_google;
        etNama_pengaju = v.findViewById(R.id.nama_pengaju);
        etPekerjaan = v.findViewById(R.id.pekerjaan);
        etNomor_telepon = v.findViewById(R.id.no_telp);
        etAlamat_pengaju = v.findViewById(R.id.alamat_pengaju);
        btConfirm = v.findViewById(R.id.confirm);

        rgRadioGroup = v.findViewById(R.id.radio_group_pengaju);
        int radioId = rgRadioGroup.getCheckedRadioButtonId();
        rbRadioButton = v.findViewById(radioId);
        /*Validation*/
//        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
//        awesomeValidation.addValidation(getActivity(),R.id.nama_pengaju, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.invalid_name);

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(awesomeValidation.validate()){
//
//                }else{
//                    Toast.makeText(getContext(), "Gagal", Toast.LENGTH_SHORT).show();
//                }
                ((Test_menu_pengajuan)getActivity()).setCurrentItem (1, true);
            }
        });

        return v;

    }

}