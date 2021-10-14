package com.grupo18sub10.springboot.app.models.dao;

import java.sql.*;



public class Conexion {
	
	
	//static String bd = "db_springboot";
		static String bd = "grupo18_equipo10";
		//static String bd = "tiendagrupo18";
		//static String login = "root";
		//static String password = "admin";
		static String login = "admin";
		static String password = "Admin123$";
		//static String url = "jdbc:mysql://localhost/" + bd;
		//static String url = "jdbc:mysql://localhost:3306/tiendagrupo18?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
		static String url = "jdbc:mariadb://camiloc2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/grupo18_equipo10";
		
		Connection connection = null;
		
		public Conexion() {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				//Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, login, password);
				
				if(connection != null) {
					System.out.println("Conexion a la base de datos " + bd + "Exitoso");
				}
				
			} catch (SQLException e) {
				System.out.println(e);
			}catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		
		public Connection getConection() {
			return connection;
		}
		
		public void desconectar() {
			connection = null;
		}

}
