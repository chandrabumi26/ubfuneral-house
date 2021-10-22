package com.example.ubfuneralhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity{
    private CardView cvAjukan,cvPengajuanSaya,cvAccountInfo;
    GoogleSignInClient mGoogleSignInClient;
    private String email_user_google, nama_user_google,id_user_google;
    private TextView tvAccName;
    private Button btSignOut;
    private ProgressDialog progressDialog;
    private ApiInterface apiInterface;
    private Uri photo;
    private List<pengajuan> pengajuans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
        tvAccName = findViewById(R.id.accName);
//        btSignOut = findViewById(R.id.googleSignOut);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu...");
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        cvAjukan = findViewById(R.id.ajukanSkrg);
        cvPengajuanSaya = findViewById(R.id.pengajuan_saya);
        cvAccountInfo = findViewById(R.id.accountInfo);
//        btSignOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    // ...
//                    case R.id.googleSignOut:
//                        signOut();
//                        break;
//                    // ...
//                }
//            }
//        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            tvAccName.setText(personName);
            email_user_google = personEmail;
            nama_user_google = personName;
            id_user_google = personId;
            photo = personPhoto;
        }
        checkUserGoogle(id_user_google,nama_user_google,email_user_google);
//        loadData();
        cvAjukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Objbook = new Intent(cvAjukan.getContext(), Test_menu_pengajuan.class);
                Objbook.putExtra("id_google",id_user_google);
                startActivity(Objbook);
            }
        });

        cvPengajuanSaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bndl = new Bundle();
                bndl.putString("id",id_user_google);
                FragmentManager fm = getSupportFragmentManager();
                StatusFragment statusFragment = new StatusFragment();
                statusFragment.setArguments(bndl);
                fm.beginTransaction().replace(R.id.layout_home,statusFragment).addToBackStack( "tag" ).commit();
            }
        });

        cvAccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bndl = new Bundle();
                bndl.putString("nama_google",nama_user_google);
                bndl.putString("email_google",email_user_google);
                bndl.putParcelable("image",photo);
                FragmentManager fm = getSupportFragmentManager();
                account_fragment accountFragment = new account_fragment();
                accountFragment.setArguments(bndl);
                fm.beginTransaction().replace(R.id.layout_home,accountFragment).addToBackStack( "tag" ).commit();
            }
        });

    }

    public void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Home.this, "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                        Intent objSignOut = new Intent(Home.this,Login.class);
                        startActivity(objSignOut);
                        finish();
                    }
                });
    }

    private void checkUserGoogle(final String id_user_google, final String nama_user_google,
                                 final String email_user_google){
        progressDialog.show();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<user_google> call = apiInterface.checkUserGoogle(id_user_google,nama_user_google,email_user_google);
        call.enqueue(new Callback<user_google>() {
            @Override
            public void onResponse(Call<user_google> call, Response<user_google> response) {
                progressDialog.dismiss();
                if(response.isSuccessful() && response.body() !=null){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        /*test message message=sabi(new) message=oi(already)*/
//                        Toast.makeText(Home.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Home.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<user_google> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Home.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()){
//                case R.id.pengajuansaya:
//                    selectedFragment = new StatusFragment();
//                    break;
//                case R.id.akun :
//                    selectedFragment = new account_fragment();
//                    break;
//            }
//            Bundle bndl = new Bundle();
//            bndl.putString("id",id_user_google);
//            bndl.putString("nama_google",nama_user_google);
//            bndl.putString("email_google",email_user_google);
//            bndl.putParcelable("image",photo);
//            selectedFragment.setArguments(bndl);
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
//            return true;
//        }
//    };

    /*ini ngetes ngambil select nama jenazah from pengajuan where id_google = id_user_google*/
//    private void loadData(){
//        progressDialog.show();
//        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//        Call<Value> call = apiInterface.view();
//        call.enqueue(new Callback<Value>() {
//            @Override
//            public void onResponse(Call<Value> call, Response<Value> response) {
//                progressDialog.dismiss();
//                String value = response.body().getValue();
//                if(value.equals("1")){
//                    pengajuans = response.body().getPengajuan();
//                    for(pengajuan u:pengajuans ){
//                        Log.d("namaPemohon", u.getNamaPemohon());
//                        Log.d("id_google", u.getId_google());
//                    }
//                    String [] id = new String[pengajuans.size()];
//                    String [] nama = new String[pengajuans.size()];
//
//                        /*SAMPE SINI HARI INI*/
//                    for(int i = 0; i<pengajuans.size(); i++){
//
//                        id[i] = pengajuans.get(i).getId_google();
//                        nama[i] = pengajuans.get(i).getNamaPemohon();
//                        if(id[i].equals(id_user_google)){
//                            tvDicoba.setText(nama[i]);
//                            coba = nama[i];
//                            coba2 = id[i];
//                        }
//
//                    }
////                        nama[1] = pengajuans.get(1).getNamaPemohon();
////                        tvDicoba.setText(usernames[1]);
//
//
//                }else{
//                    Toast.makeText(Home.this, "Anda belum melakukan pengajuan", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Value> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}