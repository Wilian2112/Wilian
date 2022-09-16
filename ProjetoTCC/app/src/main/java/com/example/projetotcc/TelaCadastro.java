package com.example.projetotcc;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;

public class TelaCadastro extends AppCompatActivity {

=======
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class TelaCadastro extends AppCompatActivity {

    TextView txtLog_In;

>>>>>>> e55bd9fccd09c3e0b0a55455aeccbf8044769e18
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
<<<<<<< HEAD
=======

        txtLog_In = findViewById(R.id.txtLog_In);

        SpannableString LI = new SpannableString("Já Possui uma Conta? Entrar");

        LI.setSpan(new CustomClick(),21,27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtLog_In.setText(LI);

        txtLog_In.setMovementMethod(LinkMovementMethod.getInstance());



    }

    class CustomClick extends ClickableSpan {
        public void onClick(View view){
            ShowLog_In(view);
        }

        @Override

        public void updateDrawState (TextPaint FG){
            FG.setColor(Color.rgb(0,100,0));
            FG.setUnderlineText(true);
        }
    }

    private void ShowLog_In(View view){
        Intent ShowLog_In = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(ShowLog_In);
>>>>>>> e55bd9fccd09c3e0b0a55455aeccbf8044769e18
    }
}