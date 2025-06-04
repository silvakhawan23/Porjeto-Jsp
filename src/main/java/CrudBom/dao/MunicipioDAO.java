package CrudBom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CrudBom.model.Municipio;

public class MunicipioDAO {
	
	public Municipio consultar(int id) throws ClassNotFoundException, SQLException {
		   Class.forName("org.postgresql.Driver"); // PostgreSQL
	       Connection conn = DriverManager.getConnection(
	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
	           "postgres",                                // usu�rio do PostgreSQL
	           "Khawan23@"                                   // senha do PostgreSQL
	       );
	       String sql = "select * from municipio where id = ? " ;
	       PreparedStatement stmt = conn.prepareStatement(sql);
	       stmt.setInt(1, id);
	       
	       ResultSet rs = stmt.executeQuery();
	       Municipio municipio = null ;
	       if( rs.next()) {
	    	    municipio = new Municipio();
	    	   
	    	   municipio.setId(rs.getInt("id"));
	    	   municipio.setNome(rs.getString("nome"));
	    	 }
	       
	       stmt.close();
	       conn.close();
		return municipio ;
}
	 public List<Municipio> listar() throws Exception {
	        List<Municipio> lista = new ArrayList<>();

	        Class.forName("org.postgresql.Driver"); // PostgreSQL

	        Connection conn = DriverManager.getConnection(
	            "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
	            "postgres",                                // usu�rio do PostgreSQL
	            "Khawan23@"                                   // senha do PostgreSQL
	        );

	        String sql = "SELECT * FROM municipio";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	          Municipio  m = new Municipio();
	            m.setId(rs.getInt("id"));
	            m.setNome(rs.getString("nome"));
	           
	            lista.add(m);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	        return lista;
	    }
}
