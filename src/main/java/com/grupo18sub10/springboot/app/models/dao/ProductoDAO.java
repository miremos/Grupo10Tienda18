package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.grupo18sub10.springboot.app.models.entity.ProductoDTO;




public class ProductoDAO {
	
	PreparedStatement preparedStatement;
	
public ArrayList <ProductoDTO> listarProductos(){
		
		ArrayList <ProductoDTO> miProducto = new ArrayList<ProductoDTO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM productos");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				
				ProductoDTO producto = new ProductoDTO();
				
				producto.setCodigoProducto(Integer.parseInt(res.getString("codigo_producto")));
				producto.setIvaCompra(Double.parseDouble(res.getString("iva_compra")));
				producto.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
				producto.setNombreProducto(res.getString("nombre_producto"));
				producto.setPrecioCompra(Double.parseDouble(res.getString("precio_compra")));
				producto.setPrecioVenta(Double.parseDouble(res.getString("precio_venta")));
				miProducto.add(producto);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo consultar" + e);
		}
		
		return miProducto;
	}
	

public void registrarProducto(ProductoDTO producto) {
	
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("INSERT INTO productos VALUES ( '" + producto.getCodigoProducto()+"', '"+ producto.getIvaCompra()+"','"+producto.getNitProveedor()+"','"+producto.getNombreProducto()+"','"+producto.getPrecioCompra()+"','"+producto.getPrecioVenta()+"')");
		JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente el producto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conex.desconectar();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se pudo registrar el producto");
		
	}
	
}


public ArrayList <ProductoDTO> consultarProducto(int codigo){
	ArrayList<ProductoDTO> miProducto = new ArrayList <ProductoDTO>();
	Conexion conex = new Conexion();
	
	try {
		PreparedStatement consulta = conex.getConection().prepareStatement("SELECT * FROM productos WHERE codigo_producto = ?");
		consulta.setInt(1, codigo);
		ResultSet res = consulta.executeQuery();
		
		if(res.next()) {
			ProductoDTO producto = new ProductoDTO();
			producto.setCodigoProducto(Integer.parseInt(res.getString("codigo_producto")));
			producto.setIvaCompra(Double.parseDouble(res.getString("iva_compra")));
			producto.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
			producto.setNombreProducto(res.getString("nombre_producto"));
			producto.setPrecioCompra(Double.parseDouble(res.getString("precio_compra")));
			producto.setPrecioVenta(Double.parseDouble(res.getString("precio_venta")));
			miProducto.add(producto);
			
		}
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo consultar el producto" + e);
		
	}
	return miProducto;
	
}


public void eliminarProducto (int codigo) {
	Conexion conex = new Conexion();
	
	try {
		String query = "DELETE FROM productos WHERE codigo_producto =?";
		preparedStatement = conex.getConection().prepareStatement(query);
		preparedStatement.setInt(1, codigo);
		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto" + e);
		System.out.println(e.getMessage());
	}
	
}




public void editarProducto (ProductoDTO producto) {
	Conexion conex = new Conexion();
	
	try {
		Statement st = conex.getConection().createStatement();
		st.executeUpdate("UPDATE productos SET iva_compra= '" +producto.getIvaCompra()+"', nit_proveedor= '"+producto.getNitProveedor()+"', nombre_producto= '" +producto.getNombreProducto()+"', precio_compra = '"+producto.getPrecioCompra()+"',precio_venta= '"+producto.getPrecioVenta()+"' WHERE codigo_producto= " + producto.getCodigoProducto());
		JOptionPane.showMessageDialog(null, "se ha modificado el producto");
		st.close();
		conex.desconectar();
		
		

	} catch (Exception e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se pudo modificar el producto" + e);
	}
}




	

}
