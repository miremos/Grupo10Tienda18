package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.UsuarioDTO;





public class UsuarioDAO {
	PreparedStatement preparedStatement;

	
public ArrayList <UsuarioDTO> listarUsuarios(){
		
		ArrayList <UsuarioDTO> miUsuario = new ArrayList<UsuarioDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM usuarios");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
				usuario.setEmailUsuario(res.getString("email_usuario"));
				usuario.setNombreUsuario(res.getString("nombre_usuario"));
				usuario.setPassword(res.getString("password"));
				usuario.setUsuario(res.getString("usuario"));
				miUsuario.add(usuario);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miUsuario;
	}


public void registrarUsuario(UsuarioDTO usuario) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO usuarios VALUES ( '" + usuario.getCedulaUsuario()+"', '"+ usuario.getEmailUsuario()+"','"+usuario.getNombreUsuario()+"','"+usuario.getPassword()+"','"+usuario.getUsuario()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente el usuario", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar el usuario");
		
	}
	
}


public ArrayList <UsuarioDTO> consultarUsuario(int documento){
	ArrayList<UsuarioDTO> miUsuario = new ArrayList <UsuarioDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = ?");
		consulta.setInt(1, documento);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
			usuario.setEmailUsuario(res.getString("email_usuario"));
			usuario.setNombreUsuario(res.getString("nombre_usuario"));
			usuario.setPassword(res.getString("password"));
			usuario.setUsuario(res.getString("usuario"));
			miUsuario.add(usuario);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar al usuario" + e);
		
	}
	return miUsuario;
	
}


public void eliminarUsuario (int cedula) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM usuarios WHERE cedula_usuario =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, cedula);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario" + e);
		System.out.println(e.getMessage());
	}
	
}



public void editarUsuario (UsuarioDTO usuario) {
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("UPDATE usuarios SET email_usuario= '" +usuario.getEmailUsuario()+"', nombre_usuario= '"+usuario.getNombreUsuario()+"', password= '" +usuario.getPassword()+"', usuario = '"+usuario.getUsuario()+"' WHERE cedula_usuario= " + usuario.getCedulaUsuario());
		JOptionPane.showMessageDialog(null, "se ha modificado el usuario");
		st.close();
		conex.desconectar();
		
		

	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario" + e);
	}
}

}
