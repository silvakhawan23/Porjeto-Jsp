package CrudBom.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBom.dao.MunicipioDAO;
import CrudBom.dao.UsuarioDao;
import CrudBom.model.Usuario;


public class IncluirUserServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Passou por aqui  ");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String cpf = req.getParameter("cpf");
		int municipio  = Integer.parseInt(req.getParameter("municipio_id"));
		MunicipioDAO municipiodao = new MunicipioDAO();
		try {
			Usuario user = new Usuario(0,nome,email,cpf,municipiodao.consultar(municipio));
			UsuarioDao userdao = new UsuarioDao();
			userdao.Salvar(user);
			req.getRequestDispatcher("index.jsp");
			
			System.out.println("Nome: " + nome);
			System.out.println("Email: " + email);
			System.out.println("CPF: " + cpf);
			System.out.println("Município: " + municipio);
			
			resp.sendRedirect("ListarUser");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
	

}
