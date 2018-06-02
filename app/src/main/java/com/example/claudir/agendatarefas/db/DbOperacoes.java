package com.example.claudir.agendatarefas.db;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.example.claudir.agendatarefas.dao.DaoUsuarios;
import com.example.claudir.agendatarefas.modelo.Usuarios;


/**
 * Created by Claudir on 26/05/2018.
 */

public class DbOperacoes {



    public interface DbOperacoesUsuarioCallBack{
        void salvarUsuario(Boolean sucesso);

      //  void buscaTodosUsuario(List<Usuarios> listaUsuarios);
    }

    private Context contexto;
    private DbOperacoesUsuarioCallBack callBackUsuario;

    public DbOperacoes (Context contexto){
        this.contexto = contexto;
    }

    public void salvarUsuario(Usuarios usuarios, DbOperacoesUsuarioCallBack callBackUsuario){
        this.callBackUsuario = callBackUsuario;
        new salvarUsuario().execute(usuarios);
    }

    private class salvarUsuario extends AsyncTask<Usuarios, Void, Void>{
        @Override
        protected Void doInBackground(Usuarios... usuarios){
            try {
                DaoUsuarios daoUsuarios = AppDataBase.getInstancia(contexto).usuarioDao();
                daoUsuarios.insereUsuarios(usuarios[0]);
                if(callBackUsuario != null){
                    callBackUsuario.salvarUsuario(true);
                }
            }catch (Exception e){
                Log.e("Usuário Salvo", e.getMessage());
                if(callBackUsuario != null){
                    callBackUsuario.salvarUsuario(false);
                }
            }
            return null;
        }
    }

  /*  private class buscaUsuario extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(String... parametros){
            try{
                DaoUsuarios daoUsuarios = AppDataBase.getInstancia(contexto).usuarioDao();
             //   Usuarios usuarios = daoUsuarios.getBuscaUsuario(parametros[0], parametros[1]);
                if (callBackUsuario != null){
                    callBackUsuario.usuarioExiste(usuarios != null);
                }
            }catch (Exception e){
                Log.e("Busca Usuário", e.getMessage());
                if (callBackUsuario != null){
                    callBackUsuario.usuarioExiste(false);
                }
            }
            return null;
        }
    }*/

}
