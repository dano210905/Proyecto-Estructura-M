
package parqueadero;

/**
 *
 * @author Tomas Vargas y Juan pablo Acevedo 
 */
public class DetallesFactura 
{
    private String Id;
    private String IdFactura;
    private String IdServicio;

    
    //constructor vacio
    public DetallesFactura() {
    }

    
    //constructor con parametros
    public DetallesFactura(String Id, String IdFactura, String IdServicio) {
        this.Id = Id;
        this.IdFactura = IdFactura;
        this.IdServicio = IdServicio;
    }
    
    
    /* ---------------FALTA ESTE!!!----------------------------*/
    /*ingresar datos recibe el id del detalle
    recibe el Id de factura que exista!
    y el Id de servicio que exista*/
    public DetallesFactura IngresarDatos(String Id, String IdFactura, String IdServicio){
        
        this.Id= Id;
        return this ;//para no error
    }

//Metodo ToString
    
    @Override
    public String toString() {
        return "DetalleFactura{" + "Id=" + Id + ", IdFactura=" + IdFactura + ", IdServicio=" + IdServicio + '}';
    }

     public String EstructuraReg() {
        return  Id + "," + IdFactura + "," + IdServicio;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(String IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(String IdServicio) {
        this.IdServicio = IdServicio;
    }
    
}//fin clase detalles de factura
