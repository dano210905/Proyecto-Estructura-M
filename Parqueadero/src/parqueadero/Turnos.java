
package parqueadero;
import java.time.LocalDate;

/**
 *
 * @author Aramid MauricioMonsalve

 */
public class Turnos 
{
    
    private String Id;
    private LocalDate FechaHoraIngreso, FechaHoraSalida;

    //constructores
    public Turnos() {
    }

    public Turnos(String Id, LocalDate FechaHoraIngreso, LocalDate FechaHoraSalida) {
        this.Id = Id;
        this.FechaHoraIngreso = FechaHoraIngreso;
        this.FechaHoraSalida = FechaHoraSalida;
    }

    public Turnos IngresarDatos(String id){
        
        LocalDate fHIng, fHSal;
        fHIng=Validaciones.LeerFecha("Ingrese la fecha de ingreso:");
        fHSal=Validaciones.LeerFecha("Ingrese la fecha de salida:");
        Turnos objT=new Turnos(id, fHIng, fHSal);
        return objT;
    }
    
    @Override
    public String toString() {
        return "Id= " + Id + ", FechaHoraIngreso= " + FechaHoraIngreso + ", FechaHoraSalida= " + FechaHoraSalida;
    }

    public String EstructuraReg() {
        return Id + "," + FechaHoraIngreso + "," + FechaHoraSalida;
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
     * @return the FechaHoraIngreso
     */
    public LocalDate getFechaHoraIngreso() {
        return FechaHoraIngreso;
    }

    /**
     * @param FechaHoraIngreso the FechaHoraIngreso to set
     */
    public void setFechaHoraIngreso(LocalDate FechaHoraIngreso) {
        this.FechaHoraIngreso = FechaHoraIngreso;
    }

    /**
     * @return the FechaHoraSalida
     */
    public LocalDate getFechaHoraSalida() {
        return FechaHoraSalida;
    }

    /**
     * @param FechaHoraSalida the FechaHoraSalida to set
     */
    public void setFechaHoraSalida(LocalDate FechaHoraSalida) {
        this.FechaHoraSalida = FechaHoraSalida;
    }
    
  
    
}//fin clase turnos
