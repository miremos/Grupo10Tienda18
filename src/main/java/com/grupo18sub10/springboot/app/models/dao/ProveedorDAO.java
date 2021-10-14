package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.ProveedorDTO;



public class ProveedorDAO {
	
	PreparedStatement preparedStatement;
	
public ArrayList <ProveedorDTO> listarProveedores(){
		
		ArrayList <ProveedorDTO> miProveedor = new ArrayList<ProveedorDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				ProveedorDTO proveedor = new ProveedorDTO();
				
				proveedor.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
				proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
				proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
				proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
				proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
				miProveedor.add(proveedor);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miProveedor;
	}

public void registrarProveedor(ProveedorDTO proveedor) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO proveedores VALUES ( '" + proveedor.getNitProveedor()+"', '"+ proveedor.getCiudadProveedor()+"','"+proveedor.getDireccionProveedor()+"','"+proveedor.getNombreProveedor()+"','"+proveedor.getTelefonoProveedor()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente el proveedor", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar el proveedor");
		
	}
	
}


public ArrayList <ProveedorDTO> consultarProveedor(int documento){
	ArrayList<ProveedorDTO> miProveedor = new ArrayList <ProveedorDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor = ?");
		consulta.setInt(1, documento);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			ProveedorDTO proveedor = new ProveedorDTO();
			
			proveedor.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
			proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
			proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
			proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
			proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
			miProveedor.add(proveedor);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar al proveedor" + e);
		
	}
	return miProveedor;
	
}

public void eliminarProveedor (int documento) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM proveedores WHERE nit_proveedor =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, documento);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar el proveedor" + e);
		System.out.println(e.getMessage());
	}
	
}

public void editarProveedor (ProveedorDTO proveedor) {
	Conexion conex = new Conexion();
	
	try {
		preparedStatement = conex.getConection().prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nit_proveedor =?");
		
		preparedStatement.setString(1, proveedor.getCiudadProveedor());
		preparedStatement.setString(2, proveedor.getDireccionProveedor());
		preparedStatement.setString(3, proveedor.getNombreProveedor());
		preparedStatement.setString(4, proveedor.getTelefonoProveedor());
		preparedStatement.setInt(5, proveedor.getNitProveedor());
		preparedStatement.executeUpdate();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}



}
