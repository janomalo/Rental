/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Usuario;
import ModeloDaoImpl.UsuarioDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class UsuarioControler {
    
    UsuarioDaoImpl dao;

    public UsuarioControler() {
        
        dao=new UsuarioDaoImpl();
    }

    public ArrayList<Usuario> getAll() {
        return (ArrayList<Usuario>) dao.listar();
        
    }
    
    public void save(Usuario usu){
    
         dao.save(usu);
    
    }

    public void delete(Usuario usu) {
       dao.delete(usu);
    }

    public Boolean edit(Usuario usu) {
      return dao.edit(usu);
       
    }
    public Usuario list(int id){
    return dao.list(id);
    
    }

    public int getidbyDni(int dni) {
        return dao.getidbyDni(dni);
    }

    public int getRolbyId(int idusuario) {
       return dao.getRolbyId(idusuario);
    }
            












}