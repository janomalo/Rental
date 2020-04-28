/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import ModeloDaoImpl.*;
import Modelo.*;

public class Login {
    
    
    private UsuarioDaoImpl dao;
	
	public Login() {
		dao=new UsuarioDaoImpl();
	}
	
	public Usuario validate(Usuario u) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dao.list(u.getId());
		//return null;
	}
    
}
