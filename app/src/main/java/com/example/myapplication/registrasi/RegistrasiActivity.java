package com.example.myapplication.registrasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.home.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Users;

public class RegistrasiActivity extends AppCompatActivity {

    //1. Bikin Variable
    private EditText edtEmail, edtPassword, edtRetype;
    private Button buttonlogin;
    Users mUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        // 2. Inisialisasi variable
        buttonlogin=findViewById(R.id.buttonlogin);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtRetype=findViewById(R.id.edtRetype);
        mUsers=new Users();



        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });


    }

    // 5. Bikin validasi editext
    void validasi(){
        mUsers.email = edtEmail.getText().toString();
        mUsers.password = edtPassword.getText().toString();
        mUsers.retype = edtRetype.getText().toString();

        if (TextUtils.isEmpty(mUsers.email) && TextUtils.isEmpty(mUsers.password)
            && TextUtils.isEmpty(mUsers.retype)){

            if (edtRetype.equals(mUsers.password)) {
                login();
            } else {
                edtRetype.setError("Password Tidak Sama");
            }

        } else if (TextUtils.isEmpty(mUsers.email)){
            showToast("ISI EMail");

        } else if (TextUtils.isEmpty(mUsers.password)){
            showToast("Password Salah");
        } else {
            login();
        }
    }

    // 4. Bikin Intent Untuk pindah Activity
    void login(){
        startActivity(new Intent(RegistrasiActivity.this, MainActivity.class));
        finish();
    }

    // 3. Bikin Toast Message
    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
