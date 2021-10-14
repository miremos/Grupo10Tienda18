package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.ClienteDTO;




public class ClienteDAO {
	
	PreparedStatement preparedStatement;
	
public ArrayList <ClienteDTO> listarClientes(){
		
		ArrayList <ClienteDTO> miCliente = new ArrayList<ClienteDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM clientes");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				ClienteDTO cliente = new ClienteDTO();
				cliente.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
				cliente.setDireccionCliente(res.getString("direccion_cliente"));
				cliente.setEmailCliente(res.getString("email_cliente"));
				cliente.setNombreCliente(res.getString("nombre_cliente"));
				cliente.setTelefonoCliente(res.getString("telefono_cliente"));
				miCliente.add(cliente);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miCliente;
	}


public void registrarCliente(ClienteDTO cliente) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO clientes VALUES ( '" + cliente.getCedulaCliente()+"', '"+ cliente.getDireccionCliente()+"','"+cliente.getEmailCliente()+"','"+cliente.getNombreCliente()+"','"+cliente.getTelefonoCliente()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente el cliente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar el cliente");
		
	}
	
}

public ArrayList <ClienteDTO> consultarCliente(int documento){
	ArrayList<ClienteDTO> miCliente = new ArrayList <ClienteDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = ?");
		consulta.setInt(1, documento);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
			cliente.setDireccionCliente(res.getString("direccion_cliente"));
			cliente.setEmailCliente(res.getString("email_cliente"));
			cliente.setNombreCliente(res.getString("nombre_cliente"));
			cliente.setTelefonoCliente(res.getString("telefono_cliente"));
			miCliente.add(cliente);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar al cliente" + e);
		
	}
	return miCliente;
	
}

public void eliminarCliente (int cedula) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM clientes WHERE cedula_cliente =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, cedula);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente" + e);
		System.out.println(e.getMessage());
	}
	
}


public void editarCliente (ClienteDTO cliente) {
	Conexion conex = new Conexion();
	
	try {
		preparedStatement = conex.getConection().prepareStatement("UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? WHERE cedula_cliente =?");
		
		preparedStatement.setString(1, cliente.getDireccionCliente());
		preparedStatement.setString(2, cliente.getEmailCliente());
		preparedStatement.setString(3, cliente.getNombreCliente());
		preparedStatement.setString(4, cliente.getTelefonoCliente());
		preparedStatement.setInt(5, cliente.getCedulaCliente());
		preparedStatement.executeUpdate();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

}
