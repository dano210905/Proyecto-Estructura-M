
package parqueadero;


public class Menus 
{
    public String MenuPrincipal()
    {
        return "MENU PRINCIPAL\n"
                + "1. Información Base\n"
                + "2. Registrar o cancelar reserva\n"
                + "3. Registrar Alquiler-Contrato\n"
                + "4. Generar Pago\n"
                + "5. Terminar\n";
    }
    
    public String MenuInformacionBase()
    {
        return "MENU INFORMACIÓN BASE\n"
                + "1. Manejo Archivos\n"
                + "2. Manejo Estructuras\n"
                + "3. Combinar información\n"
                + "4. Volver a menu principal\n";
    }
    
    public String MenuManejoArchivos()
    {
        return "MENU ARCHIVOS\n"
                + "1. CRUD Celdas\n"
                + "2. CRUD Clientes\n"
                + "3. CRUD Factura\n"
                + "4. CRUD Detalles Factura\n"
                + "5. CRUD Empleados\n"
                + "6. CRUD Prestación de Servicios\n"
                + "7. CRUD de Servicios\n"
                + "8. CRUD Vehiculos\n"
                + "9. Volver a menu informacion base\n";
    }
    
    public String MenuManejoEstructuras()
    {
        return "MENU MANEJO ESTRUCTURAS\n"
                + "1. Cola de Celdas\n"
                + "2. Lista Doble de Clientes\n"
                + "3. Lista simple Factura\n"
                + "4. Lista simple de Detalles Factura\n"
                + "5. Lista Doble de Empleados\n"
                + "6. Lista Doble de Prestación de Servicios\n"
                + "7. Pila de Servicios\n"
                + "8. Matriz de Turnos\n"
                + "9. Lista Doble de Vehiculos\n"
                + "10. Volver a menu informacion base\n";
    }
    
    public String MenuCombinar()
    {
        return "MENU INFORMACION COMBINADA\n"
                + "1. Grabar las estructuras en los archivos .txt\n"
                + "2. Copiar los archivos en las estructuras\n"
                + "3. Volver a menu informacion base\n";
    }
    
    public String MenuCRUDARchivos()
    {
         return "MENU CRUD\n"
                + "1. Ingresar Datos en el archivo\n"
                + "2. Mostrar todo el contenido del archivo\n"
                + "3. Consultar un registro especifico\n" 
                + "4. Volver a menu de archivos\n";
    }
    
    public String MenuColaCeldas()
    {
         return "MENU MANEJO COLA CELDAS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar todo el contenido de cola\n"
                + "3. Consultar una celda especifica\n" 
                + "4. Eliminar una celda especifica\n" 
                + "5. Actualizar una celda especifica\n" 
                + "6. Volver a menu de Manejo de estructuras\n";
    }
    public String MenuLDClientes()
    {
         return "MENU MANEJO LISTA DOBLE CLIENTES\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar listado de clientes\n"
                + "3. Consultar un cliente especifico\n" 
                + "4. Eliminar un cliente especifico\n" 
                + "5. Actualizar un cliente especifico\n" 
                + "6. Volver a menu de Manejo de estructuras\n";
    }
   
    public String MenuLSFactura()
    {
         return "Menu LISTA SIMPLE FACTURA\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar listado de facturas\n"
                + "3. Consultar una factura específica\n" 
                + "4. Eliminar una factura\n" 
                + "5. Actualizar una factura especifica\n"
                + "6. Ingresar detalles de factura\n" 
                + "7. Eliminar detalles a la factura\n"  
                + "8. Totalizar valor a pagar en la factura\n" 
                + "9. Volver a menu de Manejo de estructuras\n";
    }
     public String MenuLSDetalleFactura()
    {
         return "Menu LISTA SIMPLE DETALLE DE FACTURA\n"
                + "1. Actualizar en una factura especifica sus detalles\n"
                + "2. Consultar en una factura especifica sus detalles\n" 
                + "3. Volver a menu de Manejo de estructuras\n";
    }
     public String MenuLDEmpleados()
    {
         return "MENU MANEJO LISTA DOBLE EMPLEADOS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar listado de Empleados\n"
                + "3. Consultar un empleado especifico\n" 
                + "4. Eliminar un empleado especifico\n" 
                + "5. Actualizar un empleado especifico\n"
                + "6. Registrar ingreso del empleado\n"
                + "7. Asignar turnos a los empleados\n" 
                + "8. Volver a menu de Manejo de estructuras\n";
    } 
    public String MenuLDPrestacionServicios()
    {
         return "MENU MANEJO LISTA DOBLE PRESTACIÓN DE SERVICIOS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar listado de servicios prestados\n"
                + "3. Consultar un servicio prestado especifico\n" 
                + "4. Eliminar un servicio prestado especifico\n" 
                + "5. Actualizar un servicio prestado especifico\n" 
                + "6. Listado de los servicios prestados a un vehiculo especifico\n" 
                + "7. Volver a menu de Manejo de estructuras\n";
    } 
     public String MenuPilaServicios()
    {
         return "MENU MANEJO PILA DE SERVICIOS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar todo el contenido de pila\n"
                + "3. Consultar un servicio especifico\n" 
                + "4. Eliminar un servicio especifico\n" 
                + "5. Actualizar un servicio especifico\n" 
                + "6. Volver a menu de Manejo de estructuras\n";
    }
     
    public String MenuMatrizTurnos()
    {
         return "MENU MANEJO MATRIZ TURNOS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar turnos existentes\n"
                + "3. Consultar un turno especifico\n" 
                + "4. Eliminar un turno especifico\n" 
                + "5. Actualizar un turno especifico\n" 
                + "6. Volver a menu de Manejo de estructuras\n";
    } 
    public String MenuLDVehiculos()
    {
         return "MENU MANEJO LISTA DOBLE VEHICULOS\n"
                + "1. Ingresar Datos\n"
                + "2. Mostrar listado de vehículos\n"
                + "3. Consultar un vehículo especifico\n" 
                + "4. Eliminar un vehículos especifico\n" 
                + "5. Actualizar un vehículos especifico\n"
                + "6. Listar vehículos por Tipo de Vehiculo\n"
                + "7. Listar vehículos por estado\n" 
                + "8. Volver a menu de Manejo de estructuras\n";
    }
}
