
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.Rol;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RolDaoImpl {
    
    public ArrayList<Rol> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Rol> roles= new ArrayList<>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from roles");
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					r.setId(rs.getInt("id"));
					r.setNombre(rs.getString("nombre"));
					roles.add(r);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return roles;
	}
	
	public Rol getById(Rol rolToSearch) {
		Rol r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from roles where id=?"
					);
			stmt.setInt(1, rolToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				r=new Rol();
				r.setId(rs.getInt("id"));
				r.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	public Rol getByDesc(Rol rolToSearch) {
		Rol r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from rol where nombre=?"
					);
			stmt.setString(1, rolToSearch.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				r=new Rol();
				r.setId(rs.getInt("id"));
				r.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	public void setRoles(Usuario usu) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					  "select rol.* "
					+ "from rol "
					+ "inner join rol_persona "
					+ "on rol.id=rol_persona.id_rol "
					+ "where id_persona=?"
					);
			stmt.setInt(1, usu.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					r.setId(rs.getInt("id"));
					r.setNombre(rs.getString("nombre"));
					usu.addRol(r);;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void add(Rol rol) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into roles(nombre) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, rol.getNombre());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                rol.setId(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}

	}
	
	public void update(Rol rol) {
		PreparedStatement stmt= null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"update roles set nombre=? where id=?");
			stmt.setString(1, rol.getNombre());
			stmt.setInt(2, rol.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public void remove(Rol rol) {
		PreparedStatement stmt= null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"delete from roles where id=?");
			stmt.setInt(1, rol.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
    
    
    
    
    
    
}
