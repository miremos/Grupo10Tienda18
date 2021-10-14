package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.DetalleDTO;





public class DetalleDAO {
	PreparedStatement preparedStatement;

	
public ArrayList <DetalleDTO> listarDetalles(){
		
		ArrayList <DetalleDTO> miDaetalle = new ArrayList<DetalleDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM detalle_ventas");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				DetalleDTO detalle = new DetalleDTO();
				detalle.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
				detalle.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
				detalle.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				detalle.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				detalle.setValor_total(Double.parseDouble(res.getString("valor_total")));
				detalle.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
				detalle.setValor_iva(Double.parseDouble(res.getString("valor_iva")));
				miDaetalle.add(detalle);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miDaetalle;
	}


public void registrDetalle(DetalleDTO detalle) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO detalle_ventas VALUES ( '" + detalle.getCantidad_producto()+"', '"+ detalle.getCodigo_producto()+"','"+detalle.getCodigo_venta()+"','"+detalle.getValor_total()+"','"+detalle.getValor_venta()+"','"+detalle.getValor_iva()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente del detalle de vanta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar el detalle de venta");
		
	}
	
}


public ArrayList <DetalleDTO> consultarDetalle(int documento){
	ArrayList<DetalleDTO> miDatalle = new ArrayList <DetalleDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM usuarios WHERE codigo_detalle_venta = ?");
		consulta.setInt(1, documento);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			DetalleDTO detalle = new DetalleDTO();			
			detalle.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
			detalle.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
			detalle.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
			detalle.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			detalle.setValor_total(Double.parseDouble(res.getString("valor_total")));
			detalle.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
			detalle.setValor_iva(Double.parseDouble(res.getString("valor_iva")));
			miDatalle.add(detalle);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar al usuario" + e);
		
	}
	return miDatalle;
	
}


public void eliminarDetalle (int codigo) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM detalle_ventas WHERE codigo_detalle_venta =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, codigo);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar el detalle venta" + e);
		System.out.println(e.getMessage());
	}
	
}



public void editarDetalle (DetalleDTO usuario) {
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("UPDATE detalle_ventas SET cantidad_producto= '" +usuario.getCantidad_producto()+"', codigo_producto= '"+usuario.getCodigo_producto()+"', codigo_venta= '" +usuario.getCodigo_venta()+"', valor_total = '"+usuario.getValor_total()+"', valor_venta = '"+usuario.getValor_venta()+"', valor_iva = '"+usuario.getValor_iva()+"' WHERE codigo_detalle_venta= " + usuario.getCodigo_detalle_venta());
		JOptionPane.showMessageDialog(null, "se ha modificado el usuario");
		st.close();
		conex.desconectar();
		
		

	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se pudo modificar el detalle venta" + e);
	}
}

}
