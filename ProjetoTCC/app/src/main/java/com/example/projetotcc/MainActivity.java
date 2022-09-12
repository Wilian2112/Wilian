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

public class MainActivity extends AppCompatActivity {

    private Dialog RecuperarConta, Cadastrar;
    TextView txtEsqueceuSenha, txtCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecuperarConta = new Dialog(this);
        txtEsqueceuSenha = findViewById(R.id.txtEsqueceuSenha);
        txtCadastrar = findViewById(R.id.txtCadastrar);

        SpannableString ES = new SpannableString("Esqueceu Senha?");
        SpannableString CT = new SpannableString("Cadastrar");

        ES.setSpan(new CustomClickableSpan(),0, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        CT.setSpan(new CustomClickable(), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtEsqueceuSenha.setText(ES);
        txtCadastrar.setText(CT);

        txtEsqueceuSenha.setMovementMethod(LinkMovementMethod.getInstance());
        txtCadastrar.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void ShowEmailPopup(View view){


        RecuperarConta.setContentView(R.layout.popupesqueceusenha);

        RecuperarConta.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RecuperarConta.show();
    }

    class CustomClickableSpan extends ClickableSpan {

        public void onClick(View view){
            ShowEmailPopup(view);
        }

        @Override

        public void updateDrawState (TextPaint ES){
            ES.setColor(Color.BLACK);
            ES.setUnderlineText(true);
        }

    }

    private void ShowCadastrar(View view){
        Intent Cadastrar = new Intent(MainActivity.this, TelaCadastro.class);
        startActivity(Cadastrar);
    }

    class CustomClickable extends ClickableSpan{
        public void onClick(View view){
            ShowCadastrar(view);
        }

        @Override

        public void updateDrawState(TextPaint CT){
            CT.setColor(Color.GREEN);
            CT.setUnderlineText(true);
        }

    }

}