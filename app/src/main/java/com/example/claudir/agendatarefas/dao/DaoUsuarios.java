package com.example.claudir.agendatarefas.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.claudir.agendatarefas.modelo.Usuarios;



/**
 * Created by Claudir on 26/05/2018.
 */
@Dao
public interface DaoUsuarios {


    @Query("SELECT  * FROM usuarios WHERE usuario LIKE :usuario AND senha LIKE :senha Limit 1")
    Usuarios getBuscaUsuario(String usuario, String senha);

    @Insert
    void insereUsuarios(Usuarios... usuario);

    @Update
    void atualizaUsuario(Usuarios... usuario);

}
