package com.example.claudir.agendatarefas.modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Claudir on 26/05/2018.
 */
@Entity
public class Usuarios {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "usuario")
    private String usuario;

    @ColumnInfo(name = "senha")
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
