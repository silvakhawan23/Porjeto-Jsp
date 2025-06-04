package CrudBom.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBom.dao.UsuarioDao;

public class ExcluirUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
	int id= Integer.parseInt(req.getParameter("id"));
	
	UsuarioDao dao = new UsuarioDao() ;
	
	
		try {
			dao.Deletar(id);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		resp.sendRedirect("ListarUser");
	
	}
	

}
