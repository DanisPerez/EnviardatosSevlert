package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que recoge la información del formulario y la muestra
 */
@WebServlet(name = "MostrarDatos", urlPatterns = {"/MostrarDatos"})
public class MostrarDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recoger los datos del formulario
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String pais = request.getParameter("pais");
        
        String profesion = request.getParameter("profesion");
        String experiencia = request.getParameter("experiencia");
        String nivelEducativo = request.getParameter("nivelEducativo");
        
        String biografia = request.getParameter("biografia");
        String[] hobbies = request.getParameterValues("hobbies");

        // Generar la respuesta HTML
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos del Usuario</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }");
            out.println(".container { max-width: 800px; margin: 0 auto; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h2 { text-align: center; color: #007bff; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }");
            out.println("th { background-color: #007bff; color: white; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Datos del Usuario</h2>");
            out.println("<table>");
            
            // Información personal
            out.println("<tr><th colspan='2'>Información Personal</th></tr>");
            out.println("<tr><td><strong>Nombre Completo:</strong></td><td>" + nombre + "</td></tr>");
            out.println("<tr><td><strong>Correo Electrónico:</strong></td><td>" + email + "</td></tr>");
            out.println("<tr><td><strong>Número de Teléfono:</strong></td><td>" + telefono + "</td></tr>");
            out.println("<tr><td><strong>Fecha de Nacimiento:</strong></td><td>" + fechaNacimiento + "</td></tr>");
            out.println("<tr><td><strong>Género:</strong></td><td>" + genero + "</td></tr>");
            
            // Información de dirección
            out.println("<tr><th colspan='2'>Información de Dirección</th></tr>");
            out.println("<tr><td><strong>Dirección:</strong></td><td>" + direccion + "</td></tr>");
            out.println("<tr><td><strong>Ciudad:</strong></td><td>" + ciudad + "</td></tr>");
            out.println("<tr><td><strong>País:</strong></td><td>" + pais + "</td></tr>");
            
            // Información profesional
            out.println("<tr><th colspan='2'>Información Profesional</th></tr>");
            out.println("<tr><td><strong>Profesión:</strong></td><td>" + profesion + "</td></tr>");
            out.println("<tr><td><strong>Años de Experiencia:</strong></td><td>" + experiencia + "</td></tr>");
            out.println("<tr><td><strong>Nivel Educativo:</strong></td><td>" + nivelEducativo + "</td></tr>");
            
            // Información adicional
            out.println("<tr><th colspan='2'>Información Adicional</th></tr>");
            out.println("<tr><td><strong>Breve Biografía:</strong></td><td>" + biografia + "</td></tr>");
            
            // Hobbies e intereses
            out.println("<tr><td><strong>Hobbies e Intereses:</strong></td><td>");
            if (hobbies != null) {
                for (String hobby : hobbies) {
                    out.println(hobby + "<br>");
                }
            } else {
                out.println("No seleccionó ningún hobby.");
            }
            out.println("</td></tr>");
            
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet que muestra los datos ingresados por el usuario";
    }
}

