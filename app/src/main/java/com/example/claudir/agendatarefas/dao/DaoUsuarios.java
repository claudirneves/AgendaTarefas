package com.example.claudir.agendatarefas.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.claudir.agendatarefas.modelo.Usuarios;

import java.util.List;

/**
 * Created by Claudir on 26/05/2018.
 */
@Dao
public interface DaoUsuarios {
    @Insert
    void insertAll(Usuarios usuario);

    @Query("Select * from usuario")
    List<Usuarios> getAll();

   // @Query("Select * from usuario where usuario like :usuario and senha like :senha limit 1")

    @Delete
    void delete(Usuarios usuario);

}
