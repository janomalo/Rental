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


}