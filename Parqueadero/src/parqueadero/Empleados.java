
package parqueadero;

/**
 *
 * @author 
JUAN CAMILO MARTINEZ ZAPATA
MAR�A ISABEL MONSALVE GUERRA
DOMINIC ALONSO HIGUITA JARAMILLO
 */
public class Empleados extends Usuarios 
{
    
       //atributos propios y privados
    private String cargo;
    private String HoraIngreso,HoraSalida;

    //constructores
    public Empleados() {
    }

    public Empleados(String Identificacion, String Nombre, String Apellido, String Telefono, String Direccion,String cargo, String HoraIngreso, String HoraSalida) {
        super(Identificacion, Nombre, Apellido, Telefono, Direccion);
        this.cargo = cargo;
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
    }

    
    public Empleados IngresarDatos(String id){
         //variables aux
         String carg;
         String HoraI,HoraS;
         
         EntrarDatos(id);//se ingresan los datos de la herencia
         carg=Validaciones.LeerString("Ingrese su cargo ");
         HoraI=Validaciones.LeerString("Ingrese su Hora de ingreso");
         HoraS=Validaciones.LeerString("Ingrese su Hora de Salida ");
        
        Empleados objEm=new Empleados(id, Nombre, Apellido,  Telefono, Direccion,cargo,HoraI,HoraS);
     return objEm;
     
     }//fin ingresar datos

    @Override
    public String toString() {
        return super.toString()+"cargo= " + cargo + ", HoraIngreso= " + HoraIngreso + ", HoraSalida= " + HoraSalida;
    }

     //para el archivo
    public String EstructuraReg()
    {
        return Identificacion + "," + Nombre + "," + Apellido + "," + Telefono + "," + Direccion+"," + cargo + "," + HoraIngreso + "," + HoraSalida;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHoraIngreso() {
        return HoraIngreso;
    }

    public void setHoraIngreso(String HoraIngreso) {
        this.HoraIngreso = HoraIngreso;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }
     
   
}//fin clase
