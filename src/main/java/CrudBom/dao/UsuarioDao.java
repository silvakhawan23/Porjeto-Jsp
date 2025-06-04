package CrudBom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CrudBom.model.Municipio;
import CrudBom.model.Usuario;

public class UsuarioDao {
	public void Salvar(Usuario user) throws SQLException, ClassNotFoundException {
		
		
		  Class.forName("org.postgresql.Driver"); // PostgreSQL
	       Connection conn = DriverManager.getConnection(
	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
	           "postgres",                                // usu�rio do PostgreSQL
	           "Khawan23@"                                   // senha do PostgreSQL
	       );
	       String sql = "INSERT INTO usuario (nome,email,cpf,municipio_id) values (?,?,?,?) " ;
	       PreparedStatement stmt = conn.prepareStatement(sql);
	       stmt.setString(1, user.getNome());
	       stmt.setString(2, user.getEmail());
	       stmt.setString(3, user.getCpf());
	       stmt.setInt(4, user.getMunicipio().getId());
	       stmt.executeUpdate();
	       stmt.close();
	       conn.close();
       
	}
      
       
       public List<Usuario> ListaUser() throws Exception{
    		
 		  Class.forName("org.postgresql.Driver"); // PostgreSQL
 	       Connection conn = DriverManager.getConnection(
 	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
 	           "postgres",                                // usu�rio do PostgreSQL
 	           "Khawan23@"                                   // senha do PostgreSQL
 	       );
 	       
 	       String sql ="Select u.id, u.nome, u.email, u.cpf, u.municipio_id , m.nome as municipio_nome from usuario u inner join municipio m on m.id = u.municipio_id ORDER BY U.ID ";
 	       
 	       PreparedStatement stmt = conn.prepareStatement(sql);
 	      ResultSet rs = stmt.executeQuery();
 	      List<Usuario> lista = new ArrayList<>();
 	      while(rs.next()) {
 	    	  Usuario user = new Usuario();
 	    	  user.setId(rs.getInt("id"));
 	    	  user.setNome(rs.getString("nome"));
 	    	  user.setEmail(rs.getString("email"));
 	    	  user.setCpf(rs.getString("cpf"));
 	    	  Municipio mun =new Municipio();
 	    	  mun.setId(rs.getInt("municipio_id"));
 	    	  mun.setNome(rs.getString("municipio_nome"));
 	    	  user.setMunicipio(mun);
 	    	  lista.add(user);
 	      }
 	      stmt.close();
	       conn.close();
    	   return lista ;
    	   
       }
       public List<Usuario> BuscarUser(String nome) throws Exception{
   		
  		  Class.forName("org.postgresql.Driver"); // PostgreSQL
  	       Connection conn = DriverManager.getConnection(
  	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
  	           "postgres",                                // usu�rio do PostgreSQL
  	           "Khawan23@"                                   // senha do PostgreSQL
  	       );
  	       
  	       String sql ="Select u.id, u.nome, u.email, u.cpf, u.municipio_id , m.nome as municipio_nome from usuario u inner join municipio m on m.id = u.municipio_id"
  	       		+ "where u.nome = ?  ";
  	   
  	      PreparedStatement stmt = conn.prepareStatement(sql);
  	      stmt.setString(1, nome);
  	      ResultSet rs = stmt.executeQuery();
  	      List<Usuario> lista = new ArrayList<>();
  	      while(rs.next()) {
  	    	  Usuario user = new Usuario();
  	    	  user.setId(rs.getInt("id"));
  	    	  user.setNome(rs.getString("nome"));
  	    	  user.setEmail(rs.getString("email"));
  	    	  user.setCpf(rs.getString("cpf"));
  	    	  Municipio mun =new Municipio();
  	    	  mun.setId(rs.getInt("municipio_id"));
  	    	  mun.setNome(rs.getString("municipio_nome"));
  	    	  user.setMunicipio(mun);
  	    	  lista.add(user);
  	      }
  	      stmt.close();
 	       conn.close();
     	   return lista ;
     	   
        }
   	public void Editar(Usuario user) throws SQLException, ClassNotFoundException {
		
		
		  Class.forName("org.postgresql.Driver"); // PostgreSQL
	       Connection conn = DriverManager.getConnection(
	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
	           "postgres",                                // usu�rio do PostgreSQL
	           "Khawan23@"                                   // senha do PostgreSQL
	       );
	       String sql = "UPDATE usuario SET nome = ?, email = ?, cpf = ?, municipio_id = ? WHERE id = ?" ;
	       		
	       PreparedStatement stmt = conn.prepareStatement(sql);
	       stmt.setString(1, user.getNome());
	       stmt.setString(2, user.getEmail());
	       stmt.setString(3, user.getCpf());
	       stmt.setInt(4, user.getMunicipio().getId());
	       stmt.setInt(5, user.getId());
	       stmt.executeUpdate();
	       stmt.close();
	       conn.close();
     
	}
   	
   	
    public Usuario BuscarId(int id) throws Exception{
   		
		  Class.forName("org.postgresql.Driver"); // PostgreSQL
	       Connection conn = DriverManager.getConnection(
	           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
	           "postgres",                                // usu�rio do PostgreSQL
	           "Khawan23@"                                   // senha do PostgreSQL
	       );
	       
	       String sql ="SELECT u.id, u.nome, u.email, u.cpf, u.municipio_id, m.nome AS municipio_nome " +
	               "FROM usuario u INNER JOIN municipio m ON m.id = u.municipio_id " +
	               "WHERE u.id = ?";
	   
	      PreparedStatement stmt = conn.prepareStatement(sql);
	      stmt.setInt(1, id);
	      ResultSet rs = stmt.executeQuery();
	      
	      Usuario user = null;
	      if (rs.next()) {
	          user = new Usuario();
	          user.setId(rs.getInt("id"));
	          user.setNome(rs.getString("nome"));
	          user.setEmail(rs.getString("email"));
	          user.setCpf(rs.getString("cpf"));

	      
	          Municipio municipio = new Municipio();
	          municipio.setId(rs.getInt("municipio_id"));
	          municipio.setNome(rs.getString("municipio_nome"));

	          user.setMunicipio(municipio);
   	   
}
	      stmt.close();
	      conn.close();
		return user;
}
    
    
   public void Deletar(int id) throws SQLException, ClassNotFoundException {
	   Class.forName("org.postgresql.Driver"); // PostgreSQL
       Connection conn = DriverManager.getConnection(
           "jdbc:postgresql://localhost:5433/CrudJsp", // ajuste aqui o nome do banco
           "postgres",                                // usu�rio do PostgreSQL
           "Khawan23@"                                   // senha do PostgreSQL
       );
       
       String sql = "DELETE FROM Usuario where id = ?";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setInt(1, id);
       stmt.executeQuery();
       stmt.close();
       conn.close();
   }
   
    }
