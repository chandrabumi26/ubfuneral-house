package com.example.ubfuneralhouse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;


public class account_fragment extends Fragment {
    private TextView tvNamaUser, tvEmailUser;
    GoogleSignInClient mGoogleSignInClient;
    private ImageView ivProfile;
    public Button btLogOut;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_account,container,false);
        tvNamaUser = v.findViewById(R.id.namaUser);
        tvEmailUser = v.findViewById(R.id.emailUser);
        String bndl_nama = this.getArguments().getString("nama_google");
        tvNamaUser.setText(bndl_nama);
        String bndl_email = this.getArguments().getString("email_google");
        tvEmailUser.setText(bndl_email);
        Uri bndl_photo = this.getArguments().getParcelable("image");
        ivProfile = v.findViewById(R.id.imageProfile);
        Picasso.with(getActivity()).load(bndl_photo).into(ivProfile);
        btLogOut = v.findViewById(R.id.logOut);
        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Home)getActivity()).mGoogleSignInClient.signOut();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });

        return v;
    }

}