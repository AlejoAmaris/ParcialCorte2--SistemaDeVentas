package Controlador;

import Modelo.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.EmpleadoDAO;

public class Validar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadoDAO eDAO = new EmpleadoDAO();
        Empleado e = new Empleado();
        String accion = request.getParameter("accion");

        if (accion.equals("Ingresar")) {
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");

            e = eDAO.validar(usuario, clave);

            if (e.getUsuario() != null) {
                request.setAttribute("user", e);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } 
            else
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        } 
        else 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
