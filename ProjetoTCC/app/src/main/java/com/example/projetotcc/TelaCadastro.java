package com.example.projetotcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetotcc.Class.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;


public class TelaCadastro extends AppCompatActivity {

    private TextView txtLog_In;
    private Button btnRegisterScreenRegister;
    private EditText edtNameScreenRegister, edtCpfScreenRegister,
            edtEmailScreenRegister, edtPasswordScreenRegister, edtPhoneScreenRegister;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        txtLog_In = findViewById(R.id.txtLog_In);

        SpannableString LI = new SpannableString("Já Possui uma Conta? Entrar");

        LI.setSpan(new CustomClick(), 21, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtLog_In.setText(LI);

        txtLog_In.setMovementMethod(LinkMovementMethod.getInstance());

        btnRegisterScreenRegister = findViewById(R.id.btnRegisterScreenRegister);

        edtNameScreenRegister = findViewById(R.id.edtNameScreenRegister);
        edtCpfScreenRegister = findViewById(R.id.edtCpfScreenRegister);
        edtEmailScreenRegister = findViewById(R.id.edtEmailScreenRegister);
        edtPasswordScreenRegister = findViewById(R.id.edtPasswordScreenRegister);
        edtPhoneScreenRegister = findViewById(R.id.edtPhoneScreenRegister);

        btnRegisterScreenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmailScreenRegister.getText().toString(),
                        password = edtPasswordScreenRegister.getText().toString(),

                        name = edtNameScreenRegister.getText().toString(),
                        cpf = edtCpfScreenRegister.getText().toString(),
                        phone = edtPhoneScreenRegister.getText().toString();

                Date lastLogin = new Date();

                //String confirmPassword = .getText().toString();

                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(password)) {
                    if (password.equals(password)) {
                        //progressBarCad.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Profile p = new Profile();
                                    p.setName(name);
                                    p.setCPF(cpf);
                                    p.setPhone(phone);
                                    p.seteMail(email);
                                    p.setPassword(password);
                                    p.setLastLogin(lastLogin);

                                    //p.registerProfile(p);

                                    System.out.println(p);

                                    //abrirMain();

                                } else {
                                    String erro = task.getException().getMessage();
                                    Toast.makeText(TelaCadastro.this, "Erro ao efetuar cadastro" + erro, Toast.LENGTH_SHORT).show();
                                }
                                //progressBarCad.setVisibility(View.VISIBLE);
                            }
                        });
                    } else {
                        //Toast.makeText(TelaCadastro.this, "Falha ao salvar!", Toast.LENGTH_SHORT);
                    }
                }

            }
        });
    }


    class CustomClick extends ClickableSpan {
        public void onClick(View view) {
            ShowLog_In(view);
        }

        @Override

        public void updateDrawState(TextPaint FG) {
            FG.setColor(Color.rgb(0, 100, 0));
            FG.setUnderlineText(true);
        }
    }

    private void ShowLog_In(View view) {
        Intent ShowLog_In = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(ShowLog_In);
    }
}