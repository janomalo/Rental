/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Reserva;
import ModeloDaoImpl.ReservaDaoImpl;

/**
 *
 * @author Alejandro
 */
public class ReservaControler {

    ReservaDaoImpl dao;

    public ReservaControler() {
        this.dao = new ReservaDaoImpl();
    }

    public int add(Reserva r) {
        return dao.add(r);
    }

}
