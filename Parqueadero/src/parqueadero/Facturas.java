package parqueadero;

import java.time.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MARITZA ELIZABETH LOPEZ PEREZ
 Yamil Alejandro palacios Gonzalez, Ferney Henao, Maria Isabel Monsalve
 */
public class Facturas {

    private String Id, CedulaCliente, PlacaVehiculo;
    private double ValorTotal;
    private LocalDate fecha;

    //constructores
    public Facturas() {
    }

    public Facturas(String Id, LocalDate fecha, String CedulaCliente, String PlacaVehiculo, double ValorTotal) {
        this.Id = Id;
        this.CedulaCliente = CedulaCliente;
        this.PlacaVehiculo = PlacaVehiculo;
        this.ValorTotal = ValorTotal;
        this.fecha = fecha;
    }
    
    /* ---------------FALTA ESTE!!!----------------------------*/
 /*este metodo ingresa los datos de factura pero...
 se debe validar que el vehiculo exista,
 que el cliente exista, y el valor total se calcula...o sea 
 NO se piden estos datos sino que se reciben y calcula*/
    public Facturas IngresarDatos(String Id, String CdC, String plV) {
        JOptionPane.showMessageDialog(null, "Los Datos Ingresados Fueron Encontrados Correctamente En El Sistema\n Se PedirÃ¡n Detalles De La Factura", "GENERANDO FACTURA", 1);
        LocalDate fech;
        fech = Validaciones.LeerFecha("Ingrese Fecha: ");
        double valorT = 0;//= RETORNO DEL metodo acumular valores del detalle

        //objeto de retorno
        Facturas objf = new Facturas(Id, fech, CdC, plV, valorT);

        return objf;
    }

    @Override
    public String toString() {
        return "Id=" + Id + ", CedulaCliente=" + CedulaCliente + ", PlacaVehiculo=" + PlacaVehiculo + ", ValorTotal=" + ValorTotal + ", fecha=" + fecha;
    }

    public String EstructuraReg() {
        return Id + "," + CedulaCliente + "," + PlacaVehiculo + "," + ValorTotal + "," + fecha;
    }

    /* ---------------FALTA ESTE!!!----------------------------*/
 /*este metodo junta la factura con todos sus detalles para generar el 
 documento factura completo, retorna un string con toda la factura de 
 un cliente y sus detalles*/
    public String GenerarFactura(String id, Facturas objf, DetallesFactura objDe) {

        String texto = "";

        return texto;//parra error
    }

    /* ---------------FALTA ESTE!!!----------------------------
 OJO OJO Detalles de factura es un AGREGADO de Factura
 debe pedirse por cada factura los detalles y dar un total
 SE DEBE IMPLEMENTAR EL AGREGADO ENTRE ESTAS CLASES*/
    public Double CalcularFactura(Facturas objf, ListaSimple objDe){
        double valor=0;
        String id= objf.getId();
        
        return valor;
    }
     public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }
    public String getCedulaCliente() {
        return this.CedulaCliente;
    }

    public void setCedulaCliente(String CC) {
        this.CedulaCliente = CC;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setfecha(LocalDate f) {
        this.fecha = f;
    }

    public void setPlacaVehiculo(String v) {
        this.PlacaVehiculo = v;
    }

    public String getPlacaVehiculo() {
        return this.PlacaVehiculo;
    }

    public double getValorTotal() {
        return this.ValorTotal;
    }

    public void setValorTotal(double t) {
        this.ValorTotal = t;
    }

}//fin clase facturas

