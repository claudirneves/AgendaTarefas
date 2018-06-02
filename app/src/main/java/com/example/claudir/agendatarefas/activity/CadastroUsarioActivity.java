package com.example.claudir.agendatarefas.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.claudir.agendatarefas.R;
import com.example.claudir.agendatarefas.db.DbOperacoes;
import com.example.claudir.agendatarefas.modelo.Usuarios;

public class CadastroUsarioActivity extends AppCompatActivity {

    EditText usuarioEdit;
    EditText senhaEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usario);
        usuarioEdit = (EditText) findViewById(R.id.novoUsuario);
        senhaEdit = (EditText) findViewById(R.id.novaSenha);

    }

    public void cadastrarUsuario(View view){
        //getSupportActionBar().setTitle("Cadastro");

        String usuario = usuarioEdit.getText().toString();
        String senha = senhaEdit.getText().toString();

        DbOperacoes opUsuario = new DbOperacoes(this.getApplicationContext());
        opUsuario.salvarUsuario(new Usuarios(usuario, senha), new DbOperacoes.DbOperacoesUsuarioCallBack() {
            @Override
            public void salvarUsuario(Boolean sucesso) {
                CadastroUsarioActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CadastroUsarioActivity.this, "Usuario Salvo!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        usuarioEdit.setText("");
        senhaEdit.setText("");

        Intent intencao = new Intent(CadastroUsarioActivity.this,LoginActivity.class);
        startActivity(intencao);
    }
}
