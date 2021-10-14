package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.VentaDTO;






public class VentaDAO {
	PreparedStatement preparedStatement;

	
public ArrayList <VentaDTO> listarVentas(){
		
		ArrayList <VentaDTO> miVenta = new ArrayList<VentaDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM ventas");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				VentaDTO venta = new VentaDTO();				
				
				venta.setCodigoVenta(Integer.parseInt(res.getString("codigo_venta")));
				venta.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
				venta.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
				venta.setIvaVenta(Double.parseDouble(res.getString("iva_venta")));
				venta.setTotalVenta(Double.parseDouble(res.getString("total_venta")));
				venta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
				miVenta.add(venta);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miVenta;
	}


public void registrarVenta(VentaDTO venta) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO ventas VALUES ( '" + venta.getCodigoVenta()+"','" + venta.getCedulaCliente()+"', '"+ venta.getCedulaUsuario()+"','"+venta.getIvaVenta()+"','"+venta.getTotalVenta()+"','"+venta.getValorVenta()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente la venta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar la venta");
		
	}
	
}


public ArrayList <VentaDTO> consultarVenta(int documento){
	ArrayList<VentaDTO> miVenta = new ArrayList <VentaDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM ventas WHERE codigo_venta = ?");
		consulta.setInt(1, documento);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			VentaDTO venta = new VentaDTO();
						
			venta.setCodigoVenta(Integer.parseInt(res.getString("codigo_venta")));
			venta.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
			venta.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
			venta.setIvaVenta(Double.parseDouble(res.getString("iva_venta")));
			venta.setTotalVenta(Double.parseDouble(res.getString("total_venta")));
			venta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
			miVenta.add(venta);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar al usuario" + e);
		
	}
	return miVenta;
	
}


public void eliminarVenta (int codigo) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM ventas WHERE codigo_venta =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, codigo);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar la venta" + e);
		System.out.println(e.getMessage());
	}
	
}



public void editarVenta (VentaDTO venta) {
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("UPDATE ventas SET cedula_cliente= '" +venta.getCedulaCliente()+"', cedula_usuario= '"+venta.getCedulaUsuario()+"', iva_venta= '" +venta.getIvaVenta()+"', total_venta = '"+venta.getTotalVenta()+"', valor_venta = '"+venta.getValorVenta()+"' WHERE codigo_venta= " + venta.getCodigoVenta());
		JOptionPane.showMessageDialog(null, "se ha modificado la venta");
		st.close();
		conex.desconectar();
		
		

	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se pudo modificar la venta" + e);
	}
}

}
