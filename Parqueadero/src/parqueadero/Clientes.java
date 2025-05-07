
package parqueadero;

/**
 *
 * @author 
 * JUAN CAMILO MARTINEZ ZAPATA
MAR�A ISABEL MONSALVE GUERRA
DOMINIC ALONSO HIGUITA JARAMILLO

 */
public class Clientes extends Usuarios //Hereda de Usuarios
{

    //constructores
    public Clientes() {
    }

    public Clientes(String Identificacion, String Nombre, String Apellido, String Telefono, String Direccion) {
        super(Identificacion, Nombre, Apellido, Telefono, Direccion);
    }

       
    public Clientes IngresarDatos(String id){          
     EntrarDatos(id);//se llama el de la herencia
     Clientes objc=new Clientes(id, Nombre, Apellido,  Telefono, Direccion);
     return objc;
     }
    
    //para el archivo
    public String EstructuraReg()
    {
        return Identificacion + "," + Nombre + "," + Apellido + "," + Telefono + "," + Direccion;
    }

    @Override
    public String toString() {
        return super.toString();
    }//fin toString
    

}//fin clase clientes
