package CrudBom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBom.dao.MunicipioDAO;
import CrudBom.model.Municipio;

public class ListarMunicipiosServlets extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MunicipioDAO municipioDao = new MunicipioDAO();
            List<Municipio> municipios = municipioDao.listar();
            
            req.setAttribute("municipios", municipios);
            req.getRequestDispatcher("IncluirUser.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
