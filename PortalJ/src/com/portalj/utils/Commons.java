package com.portalj.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Commons {
	
	
	public static DataSource getDs() throws NamingException {
		

		InitialContext cxt = new InitialContext();
	
		DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/bd_juegos" );

		
	return ds;
	

}

}
