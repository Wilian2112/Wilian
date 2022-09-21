package com.example.projetotcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaLogin extends AppCompatActivity {

    private Dialog RetrieveAccount, ConfirmCode, RedefinePassword;
    private TextView txtForgotPassword, txtRegister, txtResend;
    private Button btnLogin;
    private EditText edtEmailLogin, edtPasswordLogin;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        RedefinePassword = new Dialog(this);
        ConfirmCode = new Dialog(this);
        RetrieveAccount = new Dialog(this);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtRegister = findViewById(R.id.txtRegister);

        btnLogin = findViewById(R.id.btnRegisterScreenRegister);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);

        SpannableString FG = new SpannableString("Esqueceu Senha?");
        SpannableString RG = new SpannableString("Cadastrar");
        SpannableString RD = new SpannableString("Não recebeu o código?Reenviar Código");

        FG.setSpan(new CustomClickableSpan(), 0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        RG.setSpan(new CustomClickable(), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtForgotPassword.setText(FG);
        txtRegister.setText(RG);

        txtForgotPassword.setMovementMethod(LinkMovementMethod.getInstance());
        txtRegister.setMovementMethod(LinkMovementMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = edtEmailLogin.getText().toString();
                String loginPassword = edtPasswordLogin.getText().toString();
                if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginPassword)) {
                    //progressBarLogin.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail, loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startHome();
                            }else{
                                String erro = task.getException().getMessage();
                                Toast.makeText(TelaLogin.this, "Erro ao efetuar login!" + erro, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });

    }

    private void ShowEmailPopup(View view) {
        RetrieveAccount.setContentView(R.layout.popupesqueceusenha);
        Button btnConfirmRetrieveAccount;
        btnConfirmRetrieveAccount = RetrieveAccount.findViewById(R.id.btnConfirmRetrieveAccount);
        RetrieveAccount.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RetrieveAccount.show();
        btnConfirmRetrieveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrieveAccount.dismiss();
                ShowConfirmCodePopup(view);
            }
        });
    }

    public void ShowConfirmCodePopup(View view) {
        ConfirmCode.setContentView(R.layout.popupcodigo);
        Button btnConfirmcode;
        btnConfirmcode = ConfirmCode.findViewById(R.id.btnConfirmcode);
        ConfirmCode.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ConfirmCode.show();
        btnConfirmcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmCode.dismiss();
                ShowRedefinePassword(view);
            }
        });
    }

    public void ShowRedefinePassword(View view) {
        RedefinePassword.setContentView(R.layout.popupredefinirsenha);
        RedefinePassword.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RedefinePassword.show();
    }

    class CustomClickableSpan extends ClickableSpan {
        public void onClick(View view) {
            ShowEmailPopup(view);
        }

        @Override
        public void updateDrawState(TextPaint FG) {
            FG.setColor(Color.BLACK);
            FG.setUnderlineText(true);
        }
    }

    private void ShowRegister(View view) {
        Intent ShowRegister = new Intent(TelaLogin.this, TelaCadastro.class);
        startActivity(ShowRegister);
    }

    class CustomClickable extends ClickableSpan {
        public void onClick(View view) {
            ShowRegister(view);
        }

        @Override
        public void updateDrawState(TextPaint RG) {
            RG.setColor(Color.rgb(0, 100, 0));
            RG.setUnderlineText(true);
        }
    }
    private void startHome() {
        startActivity(new Intent(TelaLogin.this, Home.class));
        finish();
    }


}