package Conexion;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase ConexionBD
        ConexionBD conexion = new ConexionBD();
        
        // INSERTAR un nuevo cliente
        System.out.println("=== Insertar un nuevo cliente ===");
        conexion.insertarCliente(4, "Maria", "Lopez", "1988-10-15", "310123456", "Femenino");
        
        // CONSULTAR todos los clientes
        System.out.println("=== Consultar todos los clientes ===");
        conexion.consultar();
        
        // ACTUALIZAR un cliente existente
        System.out.println("=== Actualizar un cliente ===");
        conexion.actualizarCliente(4, "Danis", "Perez", "1991-03-30", "3043869443", "Masculino");
        
        // CONSULTAR después de actualizar
        System.out.println("=== Consultar después de actualizar ===");
        conexion.consultar();
        
        // ELIMINAR un cliente
        System.out.println("=== Eliminar un cliente ===");
        conexion.eliminarCliente(4);
        
        // CONSULTAR después de eliminar
        System.out.println("=== Consultar después de eliminar ===");
        conexion.consultar();
        
        // Cerrar la conexión
        conexion.cerrarConexion();
    }
}
