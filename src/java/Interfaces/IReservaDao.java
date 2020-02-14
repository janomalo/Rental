/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Reserva;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IReservaDao {
    
     public void save(Reserva reserva);
    public List<Reserva> listar();
    public Reserva list(int id);
    public boolean edit(Reserva reserva);
    public void delete(Reserva reserva);
 
    
}
