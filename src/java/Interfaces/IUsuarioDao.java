/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IUsuarioDao {
    
    public boolean save(Usuario usuario);
    public List<Usuario> listar();
    public Usuario list(int id);
    public boolean edit(Usuario usuario);
    public boolean delete(Usuario usuario);
    
}
