
package parqueadero;

import javax.swing.JOptionPane;

/**
 *
 * @author Ferney Esteban Henao Palacios
 Yamil Alejandro Palacios Gonzalez
  
 */
public class Celdas 
{
    private String Id;
    private String Estado;
    private String Ubicacion;
    private String TipoVehiculo;

    public Celdas() 
    { }

    public Celdas(String Id, String Estado, String Ubicacion, String TipoVehiculo) {
        this.Id = Id;
        this.Estado = Estado;
        this.Ubicacion = Ubicacion;
        this.TipoVehiculo = TipoVehiculo;
    }
    
    public Celdas IngresarDatos(String Id)
    {
        String Ubi,TiVe;
        String Est;
        Ubi=Validaciones.LeerString("Ingrese Ubicacion del vehiculo: ");
        TiVe=Validaciones.LeerTipoVehiculo();
        Est =  Validaciones.LeerDisponibilidad();
        Celdas objc = new Celdas (Id,Est,Ubi,TiVe);
        return objc;
    }

    /* ---------------FALTA ESTE!!!----------------------------*/
    /*metodo que verifica si la celda esta disponible o no*/
    public boolean VerificarDisponibilidad (ManejoCola objC, Cola c1, Cola c2)
    {
        
        String celb = Validaciones.LeerString("Ingrese el numero de la celda que desea ver la disponibilidad");
        if (objC.BuscarDis(c1, c2, celb) == true)
        {
            JOptionPane.showMessageDialog(null, "Celda diponible");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Celda no diponible");
            return false;
        }
         //Para que no muestre error
    }
    
    /* ---------------FALTA ESTE!!!----------------------------*/
    /*metodo que nos arroja un listado de las celdas disponibles y 
    el tipo de vehiculo que se puede ingresar en ella*/
   public String MostrarDisponiblesParaTipoVehi(String tipoVehiculo, Cola c1, Cola c2) {
    String disponibles = ""; // Acumulador de resultados
    Object info;
    ManejoCola co = new ManejoCola();
    while (!c1.IsEmpty()) {
        info = c1.Pop();
        

        if (((Celdas) info).getEstado().equalsIgnoreCase("Disponible") &&
            ((Celdas) info).getTipoVehiculo().equalsIgnoreCase(tipoVehiculo)) //Condicional para verificar que este disponible la celda del tipo de vehiculo
        {
            disponibles += "ID: " + ((Celdas) info).getId() + " - Tipo Vehículo: " + ((Celdas) info).getTipoVehiculo() + "\n"; //acumulador de la lista que se muestra
        }

        c2.Push(info); // Mantener datos en c2 temporalmente
    }

        co.Devolver(c2, c1); // Restaurar la cola original
    return disponibles.isEmpty() ? "No hay celdas disponibles." : disponibles;
}
            
    
    @Override
    public String toString() {
        return  "Id= " + Id + ", Estado= " + Estado + ", Ubicacion= " + Ubicacion + ", TipoVehiculo= " + TipoVehiculo ;
    }

    public String EstructuraReg() {
        return Id + "," + Estado + "," + Ubicacion + "," + TipoVehiculo;
    }
    
    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Ubicacion
     */
    public String getUbicacion() {
        return Ubicacion;
    }

    /**
     * @param Ubicacion the Ubicacion to set
     */
    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    /**
     * @return the TipoVehiculo
     */
    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    /**
     * @param TipoVehiculo the TipoVehiculo to set
     */
    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    
    
}//fin clase de celdas

    
    public Celdas IngresarDatos(String Id)
    {
        String Ubi,TiVe;
        String Est;
        Ubi=Validaciones.LeerString("Ingrese Ubicacion del vehiculo: ");
        TiVe=Validaciones.LeerTipoVehiculo();
        Est = Validaciones.LeerDisponibilidad();
        Celdas objc = new Celdas (Id,Est,Ubi,TiVe);
        return objc;
    }

    /* ---------------FALTA ESTE!!!----------------------------*/
    /*metodo que verifica si la celda esta disponible o no*/
    public boolean VerificarDisponibilidad ()
    {
        return true; //Para que no muestre error
    }
    
    /* ---------------FALTA ESTE!!!----------------------------*/
    /*metodo que nos arroja un listado de las celdas disponibles y 
    el tipo de vehiculo que se puede ingresar en ella*/
    public String MostrarDisponiblesParaTipoVehi (String Id)
    {
        return ""; //Para que no muestre error
    }
            
    
    @Override
    public String toString() {
        return  "Id= " + Id + ", Estado= " + Estado + ", Ubicacion= " + Ubicacion + ", TipoVehiculo= " + TipoVehiculo ;
    }

    public String EstructuraReg() {
        return Id + "," + Estado + "," + Ubicacion + "," + TipoVehiculo;
    }
    
    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Ubicacion
     */
    public String getUbicacion() {
        return Ubicacion;
    }

    /**
     * @param Ubicacion the Ubicacion to set
     */
    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    /**
     * @return the TipoVehiculo
     */
    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    /**
     * @param TipoVehiculo the TipoVehiculo to set
     */
    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    
    
}//fin clase de celdas
