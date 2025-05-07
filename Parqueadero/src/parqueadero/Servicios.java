
package parqueadero;

/**
 *
 * Lincoln Andres Palacios
 */
public class Servicios 
{
    //atributos propios y privados
   private String Id,TipoServicio;
   private double ValorServicio;

   //constructores
    public Servicios(){}
 
    public Servicios(String Id, String TipoServicio, double ValorServicio) {
        this.Id = Id;
        this.TipoServicio = TipoServicio;
        this.ValorServicio = ValorServicio;
    }
       
    /*este metodo recibe el id del servicio y retorna un objeto 
    de la clase servicios*/
    public Servicios IngresarDatos(String Id)
    {
        //variables locales aucxiliares
        String  TipoSer;
        double valorSer;
        TipoSer=Validaciones.LeerTipoServicios();
        valorSer=Validaciones.LeerDouble("Ingrese el valor del servicio: ");
        Servicios objS =new Servicios(Id, TipoSer, valorSer);
      return objS;
    }//fin ingresar
 
    @Override
    public String toString() {
        return  "Id= " + Id + ", Tipo Servicio= " + TipoServicio + ", Valor Servicio= " + ValorServicio;
    }
 
    public String EstructuraReg() {
        return  Id + "," + TipoServicio + "," + ValorServicio;
    }
    
    public String getId() {
        return Id;
    }
 
    public void setId(String Id) {
        this.Id = Id;
    }
 
    public String getTipoServicio() {
        return TipoServicio;
    }
 
    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }
 
    public double getValorServicio() {
        return ValorServicio;
    }
 
    public void setValorServicio(double ValorServicio) {
        this.ValorServicio = ValorServicio;
    }
 
   
    
}//fin clase servicios
