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
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    private Dialog RetrieveAccount;
    TextView txtForgotPassword, txtRegister, txtResend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        RetrieveAccount = new Dialog(this);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtRegister = findViewById(R.id.txtRegister);

        SpannableString FG = new SpannableString("Esqueceu Senha?");
        SpannableString RG = new SpannableString("Cadastrar");
        SpannableString RD = new SpannableString("Não recebeu o código?Reenviar Código");

        FG.setSpan(new CustomClickableSpan(),0, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        RG.setSpan(new CustomClickable(), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtForgotPassword.setText(FG);
        txtRegister.setText(RG);

        txtForgotPassword.setMovementMethod(LinkMovementMethod.getInstance());
        txtRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void ShowEmailPopup(View view){


        RetrieveAccount.setContentView(R.layout.popupesqueceusenha);
        RetrieveAccount.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RetrieveAccount.show();
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