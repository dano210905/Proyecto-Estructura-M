
package parqueadero;

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
