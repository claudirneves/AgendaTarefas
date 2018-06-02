package com.example.claudir.agendatarefas.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.claudir.agendatarefas.dao.DaoUsuarios;
import com.example.claudir.agendatarefas.modelo.Usuarios;

/**
 * Created by Claudir on 26/05/2018.
 */
@Database(entities = {Usuarios.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static final String nomeBanco = "agenda_tarefas";

    private static AppDataBase instancia;
    public abstract DaoUsuarios usuarioDao();

    public static AppDataBase getInstancia(Context contexto){
        if(instancia == null || !instancia.isOpen()){
            instancia = Room.databaseBuilder(contexto, AppDataBase.class, nomeBanco).build();
        }
        return instancia;
    }
}
