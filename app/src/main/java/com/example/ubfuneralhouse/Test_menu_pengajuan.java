package com.example.ubfuneralhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Test_menu_pengajuan extends AppCompatActivity {
    public String id_google;
    ViewPager viewPager;
    private Button btBack_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_menu_pengajuan);
        Intent intentPengajuan = getIntent();
        if(intentPengajuan.hasExtra("id_google")){
            id_google = intentPengajuan.getStringExtra("id_google");
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutPengajuan);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        LinearLayout tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }


        viewPager = (ViewPager) findViewById(R.id.pager);
        final PengajuanPageAdapter adapter = new PengajuanPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        final View touchView = findViewById(R.id.pager);
//        touchView.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View v, MotionEvent event)
//            {
//                return true;
//            }
//        });

        btBack_button = findViewById(R.id.backButton);
        btBack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Test_menu_pengajuan.this)
                        .setTitle("Peringatan")
                        .setMessage("Apakah anda ingin membatalkan pengajuan?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intentBack = new Intent(Test_menu_pengajuan.this, Home.class);
                                startActivity(intentBack);
                                finish();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

    }

    public void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }


}