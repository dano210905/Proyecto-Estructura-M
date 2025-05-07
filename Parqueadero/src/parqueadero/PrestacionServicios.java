
package parqueadero;
import java.time.*;
/**
 *
 * @author Andrés Bedoya Cifuentes e Isabela Bohada Valencia
 */
public class PrestacionServicios 
{
        //Atributos propios y privados
    private String Id,PlacaVehiculo, IdCelda, TurnoServicio;
    private LocalDate FechaIngreso, FechaSalida;
    private String HoraIngreso, HoraSalida;

    public PrestacionServicios() {
    }

    public PrestacionServicios(String Id, String PlacaVehiculo, String IdCelda, String TurnoServicio, LocalDate FechaIngreso, LocalDate FechaSalida, String HoraIngreso, String HoraSalida) {
        this.Id = Id;
        this.PlacaVehiculo = PlacaVehiculo;
        this.IdCelda = IdCelda;
        this.TurnoServicio = TurnoServicio;
        this.FechaIngreso = FechaIngreso;
        this.FechaSalida = FechaSalida;
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
    }

       
    /* ---------------FALTA ESTE!!!----------------------------*/
 /*este metodo ingresa los datos de prestacion del servicio pero...
 se debe validar que el vehiculo exista, que la celda este disponible,
 que el turno exista...o sea 
 NO se piden estos datos sino que se reciben*/
    public PrestacionServicios IngresarDatos(String Id, String PlVehiculo, String IdCel, String TurnoServ)
    {
        //variables locales auxiliares
           
        LocalDate FechaIng, FechaSal;
        String HoraIng, HoraSal;
        
        FechaIng=Validaciones.LeerFecha("Ingrese Fecha de Ingreso:");
        FechaSal=Validaciones.LeerFecha("Ingrese Fecha de Salida:");
        HoraIng=Validaciones.LeerString("Ingrese Hora de Ingreso:");
        HoraSal=Validaciones.LeerString("Ingrese Hora de Salida:");
        
        PrestacionServicios objS=new PrestacionServicios(Id,PlVehiculo,IdCel,TurnoServ,FechaIng,FechaSal,HoraIng,HoraSal);
        return objS;
    }//fin ingresar

    @Override
    public String toString() {
        return "Id=" + Id + ", Placa del Vehiculo=" + PlacaVehiculo + ", Id Celda=" + IdCelda + ", Turno del Servicio=" + TurnoServicio + ", Fecha de Ingreso=" + FechaIngreso + ", Fecha de Salida=" + FechaSalida + ", Hora de Ingreso=" + HoraIngreso + ", Hora de Salida=" + HoraSalida;
        
    }
     public String EstructuraReg() {
        return Id + "," + PlacaVehiculo + "," + IdCelda + "," + TurnoServicio + "," + FechaIngreso + "," + FechaSalida + "," + HoraIngreso + "," + HoraSalida;
    
     }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }

    public void setPlacaVehiculo(String PlacaVehiculo) {
        this.PlacaVehiculo = PlacaVehiculo;
    }

    public String getIdCelda() {
        return IdCelda;
    }

    public void setIdCelda(String IdCelda) {
        this.IdCelda = IdCelda;
    }

    public String getTurnoServicio() {
        return TurnoServicio;
    }

    public void setTurnoServicio(String TurnoServicio) {
        this.TurnoServicio = TurnoServicio;
    }

    public LocalDate getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(LocalDate FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(LocalDate FechaSalida) {
        this.FechaSalida = FechaSalida;
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
    

}//fin clase de prestacion de servicios
