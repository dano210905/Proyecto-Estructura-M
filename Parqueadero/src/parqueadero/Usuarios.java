
package parqueadero;


/**
 *
 * @author 
JUAN CAMILO MARTINEZ ZAPATA
MAR�A ISABEL MONSALVE GUERRA
DOMINIC ALONSO HIGUITA JARAMILLO
 */
public class Usuarios 
{
    
   protected String Identificacion;
   protected String Nombre,Apellido,Telefono,Direccion;

   //constructores
        public Usuarios() {//constructor vacio
        }

        public Usuarios(String Identificacion, String Nombre, String Apellido, String Telefono, String Direccion) { //Constructor lleno
            this.Identificacion = Identificacion;
            this.Nombre = Nombre;
            this.Apellido = Apellido;
            this.Telefono = Telefono;
            this.Direccion = Direccion;
        }

    public void  EntrarDatos(String id)
    {
       //se leen directamente del atributo protegido para que las clases derivadas las tomen       
       Nombre=Validaciones.LeerString("Ingrese su nombre ");
       Apellido=Validaciones.LeerString("Ingrese su Apellido ");
       Telefono=Validaciones.LeerString("Ingrese su telefono ");
       Direccion=Validaciones.LeerString("Ingrese su direccion ");
      
    }//fin ingresar

    @Override
    public String toString() {
        return "Su Identificacion= " + Identificacion + ",Su Nombre= " + Nombre + ",Su Apellidos= " + Apellido + ", Su Telefono= " + Telefono + ", Su Direccion= " + Direccion;
    }
    
   

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellidos(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    

    
}//fin clase usuarios
