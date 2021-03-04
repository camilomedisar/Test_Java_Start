package com.portalj.dao;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.portalj.model.CatProducto;
import com.portalj.utils.Commons;

public class CatProductoDao {

	
	private DataSource ds;
	 private QueryRunner qr;
	 private static CatProductoDao dao;
	 
	 private final String SQL_INSERT = "INSERT INTO public.cat_producto\n" +
			 						"id,nombre, descripcio, precio" +
			 						"VALUES(?, ?, ?, ?);\n";
	 
	 public CatProductoDao() throws NamingException {
		 
		 this.ds = Commons.getDs();
		 this.qr = new QueryRunner(ds);
	 }
	 
	 public static CatProductoDao getInstance() throws NamingException {
		 
		 if (dao == null) {
			 
			 dao = new CatProductoDao();
			 
		 }
		 
		 return dao;
		 	 
		 
	 }
	 
	 public int inser(CatProducto producto) throws SQLException {
		 
		 int result =0; 
		 
		 Object[] params = {producto.getPlayer1(),producto.getNumJueg()};
		 
		 result = qr.update(SQL_INSERT, params);
		 
		
			 
			 return result;
		 
	 }
	
}
