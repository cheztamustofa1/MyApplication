package com.example.myapplication.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.home.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Users;
import com.example.myapplication.registrasi.RegistrasiActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button buttonlogin;
    EditText edtEmail, edtPassword;
    Users mUsers;
    TextView create;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth =  FirebaseAuth.getInstance();

        buttonlogin=findViewById(R.id.buttonlogin);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        create=findViewById(R.id.create);
        mUsers=new Users();
        buttonlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrasiActivity.class));
                finish();
            }
        });

    }
    void validasi(){
        mUsers.email = edtEmail.getText().toString();
        mUsers.password = edtPassword.getText().toString();

        if (TextUtils.isEmpty(mUsers.email) && TextUtils.isEmpty(mUsers.password)){
            showToast("Harap Isi Email Dan Password");

        } else if (TextUtils.isEmpty(mUsers.email)){
            edtEmail.setError("Isi Email");

        } else if (TextUtils.isEmpty(mUsers.password)){
            edtPassword.setError("Password Salah");
        } else {
            login(mUsers.email , mUsers.password);
        }
    }

    void login(String email, String password ){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    showToast("Gagal Login FIREBASE");
                }
            }
        });
    }

    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    private void showtoast() {
    }

    public Button getButtonlogin() {
        return buttonlogin;
    }
}
