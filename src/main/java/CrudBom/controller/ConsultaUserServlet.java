package CrudBom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBom.dao.MunicipioDAO;
import CrudBom.dao.UsuarioDao;
import CrudBom.model.Usuario;

public class ConsultaUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("passou por aqui ");
		UsuarioDao userdao = new UsuarioDao();
		try {
			List<Usuario> lista = userdao.ListaUser();
			req.setAttribute("Usuario", lista);
			System.out.println("passou por aqui ");
			req.getRequestDispatcher("listarUser.jsp").forward(req, resp) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}
	
	
	

}
