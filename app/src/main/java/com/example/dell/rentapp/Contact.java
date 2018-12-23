package com.example.dell.rentapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import javax.mail.Authenticator;
import javax.mail.Session;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

public class Contact extends AppCompatActivity implements View.OnClickListener {

    EditText edtTo, edtSubject, edtMess;
    Button guimail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        edtTo = (EditText)findViewById(R.id.editTo);
        edtMess = (EditText)findViewById(R.id.editMessage);
        edtSubject = (EditText)findViewById(R.id.editSubject);
        guimail = (Button)findViewById(R.id.btnSend);

        setSupportActionBar(toolbar);
        guimail.setOnClickListener(Contact.this);

    }
    private void sendEmail() {
        //Getting content for email
        String email = edtTo.getText().toString().trim();
        String subject = edtSubject.getText().toString().trim();
        String message = edtMess.getText().toString().trim();

//        SendMail sm = new SendMail(Contact.this, email, subject, message);
//
//        sm.execute();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , message);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contact.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}