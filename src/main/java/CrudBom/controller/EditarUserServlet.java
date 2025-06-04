package CrudBom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBom.dao.MunicipioDAO;
import CrudBom.dao.UsuarioDao;
import CrudBom.model.Municipio;
import CrudBom.model.Usuario;

public class EditarUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int id = Integer.parseInt(req.getParameter("id"));

	    UsuarioDao usuarioDao = new UsuarioDao();
	    Usuario usuario = null;
		try {
			usuario = usuarioDao.BuscarId(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	    MunicipioDAO municipioDao = new MunicipioDAO(); 
	    List<Municipio> municipios = null;
		try {
			municipios = municipioDao.listar();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	    req.setAttribute("usuario", usuario);
	    req.setAttribute("municipios", municipios);
	    
	    req.getRequestDispatcher("editarUser.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int id = Integer.parseInt(req.getParameter("id"));
	    String nome = req.getParameter("nome");
	    String cpf = req.getParameter("cpf") ;
	    String email = req.getParameter("email");
	    
	    int municipio_id =Integer.parseInt(req.getParameter("municipio_id"));
	    
	    

	    Usuario usuario = new Usuario();
	    usuario.setId(id);
	    usuario.setNome(nome);
	    usuario.setEmail(email);
	    usuario.setCpf(cpf);
        Municipio municipio = new Municipio();
        municipio.setId(municipio_id);
        usuario.setMunicipio(municipio);

	    UsuarioDao dao = new UsuarioDao();
	    try {
			dao.Editar(usuario);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	    resp.sendRedirect("index.jsp");

	
}
}
