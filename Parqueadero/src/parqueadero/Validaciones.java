
package parqueadero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;


public class Validaciones 
{
    /*este metodo retorna un entero mayor que cero con las
    validaciones respectivas*/
    public static int LeerInt(String mensaje)
    {
        
    int num=0;//variable de retorno
    do{//obliga al usuario a digitar lo que necesito
       try{//maneja las excepciones que se salen de las manos
           num=Integer.parseInt(JOptionPane.showInputDialog(mensaje));//se pide el entero a validar
           if(num<=0)//solo es para mostrar mensaje de error
             JOptionPane.showMessageDialog(null,"Debe digitar número mayor que cero");
          }catch(Exception err)
          {//no ingresa lo pedido
             JOptionPane.showMessageDialog(null,"Debe digitar NUMEROS ");
          }
         //se sale con el numero mayor que cero de lo contrario se queda    
        }while(num<=0); 
    return num;
    }//fin de leer enteros
    
    /*este metodo retorna un real mayor o igual a cero con las
    validaciones respectivas*/
    public static double LeerDouble(String mensaje)
    {
        
    double num=0;//variable de retorno
    do{//obliga al usuario a digitar lo que necesito
       try{//maneja las excepciones que se salen de las manos
           num=Double.parseDouble(JOptionPane.showInputDialog(mensaje));//se pide el entero a validar
           if(num<0)//solo es para mostrar mensaje de error
             JOptionPane.showMessageDialog(null,"Debe digitar número mayor o igual que cero");
          }catch(Exception err)
          {//no ingresa lo pedido
             JOptionPane.showMessageDialog(null,"Debe digitar NUMEROS ");
          }
         //se sale con el numero mayor o igual que cero de lo contrario se queda    
        }while(num<0); 
    return num;
    }//fin de leer reales
    
     /*este metodo retorna un string o cadena con las
    validaciones respectivas, no lo deja en blanco*/
    public static String LeerString(String mensaje)
    {
    String txt="";//variable de retorno
    do{//obliga al usuario a digitar lo que necesito
       try{//maneja las excepciones que se salen de las manos
           txt=JOptionPane.showInputDialog(mensaje);//se pide el string a validar
           if(txt.equals(""))//solo es para mostrar mensaje de error
             JOptionPane.showMessageDialog(null,"Debe digitar información");
          }catch(Exception err)
          {//no ingresa lo pedido
             JOptionPane.showMessageDialog(null,"Debe digitar información");
          }
         //se sale con algun tipo de entrada de lo contrario se queda    
        }while(txt.equals("")); 
    return txt;
    }//fin de leer cadena o texto
    
    
      //Método para validar una fecha escrita por el usuario )
    public static LocalDate LeerFecha(String mensaje) 
    {    
        LocalDate fecha = null;    
        DateTimeFormatter formatoFec = DateTimeFormatter.ofPattern("dd/MM/yyyy");    
        do {        
            try {            
            String input = JOptionPane.showInputDialog(mensaje);
            //Se convierte el string en Local Date            
            fecha = LocalDate.parse(input, formatoFec);        
            } 
            catch (DateTimeParseException e) 
            {            
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato dd-MM-yyyy");     
            }    
        } while (fecha == null);    
        return fecha;
    }//fin leer fecha

    
    
    /*este metodo permite el ingreso de una celda disponible o no
    seleccionando el que se desea*/
    public static String LeerDisponibilidad()
     {
        //lectura de estado de la celda, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé estado o disponibilidad con las opciones que necesito
        Object [] est ={"Disponible","No Disponible"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Seleccione Estado de la celda? ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,est, est[0]);
           //se pide la variable opciones para pasarlo a estado de la celda que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String Estado=opciones.toString();//pasamos la opcion tipo Object a string
        return Estado;
     }//fin de leer estado de la celda

     /*este metodo permite el ingreso de tipo de vehiculos que existen en Colombia
    seleccionando el que se desea*/
    public static String LeerTipoVehiculo()
     {
        //lectura de tipo de vehiculo, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé tipo de vehiculo con las opciones que necesito
        Object [] TipoVehi ={"Automóvil","Bus","Buseta","Camión","Camioneta","Campero","Microbus","Tractocamión","Motocicleta","Motocarro","Mototriciclo","Cuatrimoto","Volqueta"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Seleccione Tipo de Vehiculo? ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,TipoVehi, TipoVehi[0]);
           //se pide la variable opciones para pasarlo a tipo de vehiculo que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra como???!!!
        String TipoVe=opciones.toString();//pasamos la opcion tipo Object a string
        return TipoVe;
     }//fin de leer tipo vehiculo
    
     /*este metodo permite el ingreso de tipo de servicios que existen en el parqueadero
    seleccionando el que se desea*/
    public static String LeerTipoServicios()
     {
        //lectura de tipo de servicios, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé tipo de servicios con las opciones que necesito
        Object [] TipoSer={"Parqueo por horas o fracción","Parqueo por días","Mensualidades residentes","Parqueo para motos","Parqueo bicicletas","Parqueo carros",
            "Lavado de vehículos básico","Lavado de vehículos completo","Mantenimiento básico (nivel de aceite, presión de llantas)","otroa"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Seleccione Tipo de Servicio? ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,TipoSer, TipoSer[0]);
           //se pide la variable opciones para pasarlo a tipo de servicios que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra como???!!!
        String TipoVe=opciones.toString();//pasamos la opcion tipo Object a string
        return TipoVe;
     }//fin de leer servicios
    
   
    
}//fin clase validaciones
