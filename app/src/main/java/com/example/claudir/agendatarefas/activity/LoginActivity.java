package com.example.claudir.agendatarefas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.claudir.agendatarefas.R;

public class LoginActivity extends AppCompatActivity {
    EditText usuario;
    EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.usuario);
    }

    public void login(View view) {
    }

    public void cadastrarUsuario(View view){
        Intent intecao = new Intent(this, CadastroUsarioActivity.class);
        startActivity(intecao);
    }
}
