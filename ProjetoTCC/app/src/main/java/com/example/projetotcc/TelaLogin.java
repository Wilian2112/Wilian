package com.example.projetotcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    private Dialog RetrieveAccount,ConfirmCode,RedefinePassword;
    TextView txtForgotPassword, txtRegister, txtResend;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        RedefinePassword = new Dialog(this);
        ConfirmCode = new Dialog(this);
        RetrieveAccount = new Dialog(this);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);

        SpannableString FG = new SpannableString("Esqueceu Senha?");
        SpannableString RG = new SpannableString("Cadastrar");
        SpannableString RD = new SpannableString("Não recebeu o código?Reenviar Código");

        FG.setSpan(new CustomClickableSpan(),0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        RG.setSpan(new CustomClickable(), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtForgotPassword.setText(FG);
        txtRegister.setText(RG);

        txtForgotPassword.setMovementMethod(LinkMovementMethod.getInstance());
        txtRegister.setMovementMethod(LinkMovementMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(TelaLogin.this,Home.class);
                startActivity(Login);
            }
        });

    }

    private void ShowEmailPopup(View view){
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

    public void ShowConfirmCodePopup(View view){
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

    public void ShowRedefinePassword(View view){
        RedefinePassword.setContentView(R.layout.popupredefinirsenha);
        RedefinePassword.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RedefinePassword.show();
    }

    class CustomClickableSpan extends ClickableSpan {
        public void onClick(View view){
            ShowEmailPopup(view);
        }
        @Override
        public void updateDrawState (TextPaint FG){
            FG.setColor(Color.BLACK);
            FG.setUnderlineText(true);
        }
    }

    private void ShowRegister(View view){
        Intent ShowRegister = new Intent(TelaLogin.this, TelaCadastro.class);
        startActivity(ShowRegister);
    }

    class CustomClickable extends ClickableSpan{
        public void onClick(View view){
            ShowRegister(view);
        }
        @Override
        public void updateDrawState(TextPaint RG){
            RG.setColor(Color.rgb(0,100,0));
            RG.setUnderlineText(true);
        }
    }


}