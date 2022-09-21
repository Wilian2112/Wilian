package com.example.projetotcc.Class;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.projetotcc.TelaCadastro;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class Profile {
    private String id;
    private Object photo;
    private String name;
    private String CPF;
    private String phone;
    private Date lastLogin;
    private String eMail;
    private String password;

    public Profile(){

    }
    public Profile(String id, Object photo, String name, String CPF, String phone, Date lastLogin, String eMail, String password) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.CPF = CPF;
        this.phone = phone;
        this.lastLogin = lastLogin;
        this.eMail = eMail;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void registerProfile(Profile p){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

//        Profile p = new Profile();
//
//        p.setId(idP);
//        p.setName(nameP);
//        p.setCPF(CpfP);
//        p.setPhone(phoneP);
//        p.setLastLogin(lastLoginP);
//        p.seteMail(eMailP);
//        p.setPassword(passwordP);

        db.collection("User").document().set(p) .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                //Toast.makeText("Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(TelaCadastro, "Falha ao cadastrar!", Toast.LENGTH_SHORT).show();
            }
        });;

    }
}
