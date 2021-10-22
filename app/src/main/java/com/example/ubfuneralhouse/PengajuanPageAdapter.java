package com.example.ubfuneralhouse;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PengajuanPageAdapter extends FragmentStatePagerAdapter {
    private int mNoOfTabs;


    public PengajuanPageAdapter(@NonNull FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                data_pengaju_fragment dataPengaju = new data_pengaju_fragment();
                return dataPengaju;
            case 1 :
                data_jenazah_fragment dataJenazah = new data_jenazah_fragment();
                return dataJenazah;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
