package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    private String url = "jdbc:mysql://localhost:3306/"; // URL de conexión a MySQL
    private String bd = "protect";                       // Nombre de la base de datos actualizada
    private String user = "root";                        // Usuario de la base de datos (actualiza aquí si usas otro)
    private String password = "";                        // Contraseña de la base de datos (deja "" si no hay)
    private String driver = "com.mysql.cj.jdbc.Driver";  // Driver JDBC de MySQL
    private Connection con;                              // Objeto Connection para la conexión
    private Statement st;                                // Objeto Statement para ejecutar consultas
    private ResultSet rs;                                // Objeto ResultSet para almacenar resultados
            
    public ConexionBD() {
        try {
            // Cargar el driver de MySQL
            Class.forName(driver);

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(url + bd, user, password);
            st = con.createStatement();
            System.out.println("Conexión exitosa a la base de datos.");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontró el driver de MySQL.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
   
    // Método para ejecutar la consulta y mostrar los resultados
    public void consultar() {
        try {
            String query = "SELECT ID_Cliente, Nombre, Apellido, Fecha_Nacimiento, Num_Contacto, Genero FROM cliente";
            rs = st.executeQuery(query);

            while (rs.next()) {   
                int id_cliente = rs.getInt("ID_Cliente");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String fechaNacimiento = rs.getString("Fecha_Nacimiento");
                String numContacto = rs.getString("Num_Contacto");
                String genero = rs.getString("Genero");
                
                System.out.println("ID Cliente: " + id_cliente +
                                   "\nNombre: " + nombre +
                                   "\nApellido: " + apellido +
                                   "\nFecha de Nacimiento: " + fechaNacimiento +
                                   "\nNúmero de Contacto: " + numContacto +
                                   "\nGénero: " + genero + "\n");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta.");
            ex.printStackTrace();
        } 
    }

    // Método para insertar un nuevo cliente en la base de datos
    public void insertarCliente(int id_cliente, String nombre, String apellido, String fechaNacimiento, String numContacto, String genero) {
        try {
            String insertQuery = "INSERT INTO cliente (ID_Cliente, Nombre, Apellido, Fecha_Nacimiento, Num_Contacto, Genero) " +
                                 "VALUES (" + id_cliente + ", '" + nombre + "', '" + apellido + "', '" + fechaNacimiento + "', '" + numContacto + "', '" + genero + "')";

            int rowsInserted = st.executeUpdate(insertQuery);
            
            if (rowsInserted > 0) {
                System.out.println("Nuevo cliente insertado correctamente.");
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar el cliente.");
            ex.printStackTrace();
        } 
    }

    // Método para actualizar un cliente existente en la base de datos
    public void actualizarCliente(int id_cliente, String nombre, String apellido, String fechaNacimiento, String numContacto, String genero) {
        try {
            String updateQuery = "UPDATE cliente SET Nombre = '" + nombre + "', Apellido = '" + apellido + "', " +
                                 "Fecha_Nacimiento = '" + fechaNacimiento + "', Num_Contacto = '" + numContacto + "', " +
                                 "Genero = '" + genero + "' WHERE ID_Cliente = " + id_cliente;

            int rowsUpdated = st.executeUpdate(updateQuery);
            
            if (rowsUpdated > 0) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado.");
            }

        } catch (SQLException ex) {
            System.out.println("Error al actualizar el cliente.");
            ex.printStackTrace();
        }
    }

    // Método para eliminar un cliente existente de la base de datos
    public void eliminarCliente(int id_cliente) {
        try {
            String deleteQuery = "DELETE FROM cliente WHERE ID_Cliente = " + id_cliente;

            int rowsDeleted = st.executeUpdate(deleteQuery);
            
            if (rowsDeleted > 0) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado.");
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente.");
            ex.printStackTrace();
        }
    }
    
    // Método para cerrar la conexión de manera segura después de que termines todas las operaciones
    public void cerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión.");
            ex.printStackTrace();
        }
    }
}

