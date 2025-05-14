
package parqueadero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class CRUDCeldas {
    /*Metodo que busca un vehiculo en el archivo plano y si lo encuentra
    retorna verdadero, sino lo encuentra retorna falso*/
    public boolean Buscar(Archivos objArch, String IdCel) {
        boolean sw = false;//retorno
        try {
            //locales auxiliares para extraer la informacion del archivo
            
            String Id,TiVe,Ubi,Disp;
            
                     
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            objArch.AbrirArchivoModoLectura("Celdas.txt");
            //se invoca al metodo de leer registro con 8 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(4);
            //mientras existan datos en el archivo
            while (Reg != null) //mientras not EOF()
            {
                /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Id = Reg[0];
                TiVe= Reg[1];
                Ubi = Reg[2];
                Disp = Reg[3];
                
                              
                //si el id que extraimos del archivo en Reg es igual al id de celda que se esta buscando
                if (Id.equalsIgnoreCase(IdCel)) 
                {
                    sw = true;
                }//fin si
                //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                Reg = objArch.LeerRegistro(4);
            }//fin mientras
            //cerramos el archivo plano de texto en modo lectura
            objArch.CerrarArchivoModoLectura();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return sw;

    }//fin de buscar

    //--------------------------------------------------------------    
    /*metodo que a partir del id lo busca en el archivo y si no lo encuentra
     lo graba fisicamente con sus otros datos en el archivo y si lo encuentra muestra un mensaje 
     y no graba de nuevo la celda porque estara repetido*/
    public void IngresarCelda(Archivos objArch, String IdCel) 
    {
        Celdas objCel = new Celdas();
        //se invoca el metodo buscar   
        if (Buscar(objArch, IdCel) == false) {
            //se llama el metodo de ingresar datos de Celda que recibe el id y retorna el objeto Celdas  
            objCel = objCel.IngresarDatos(IdCel);
            //se invoca el metodo que graba fisicamente en el archivo
            GrabarVehiculo(objArch, objCel);
        } else {
            JOptionPane.showMessageDialog(null, "*****vehiculo YA existe en el archivo*****");
        }//fin si
    }//fin de ingresar
    
/*metodo que graba fisicamente el registro en el archivo, recibe el objeto
  archivo para el manejo del archivo y el objeto celda que lo pasa a un
  String con la estructura de registro deseada para el .txt  */
    public void GrabarVehiculo(Archivos objArchivos, Celdas objCel) 
    {
        try {
            String cadena = "";//para pasar el objeto a cadena con estructura
            objArchivos.AbrirArchivoModoEscritura("Celdas.txt");
            /*con el objeto que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la cadena para grabarla en el archivo*/
            cadena = objCel.EstructuraReg();//se recibe el objeto pero en una cadena de atributos separados por comas
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO*****");
        }
    }//fin de grabar Celdas

    //metodo que retorna en una cadena todo el contenido del archivo para ser mostrado
    public String MostrarTodo(Archivos objArch) 
    {      
        String cadena = "";
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Id,TiVe, Ubi, Disp;
            
           
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Celdas.txt"));
            //se invoca al metodo de leer registro con 4 atributos para el vector de la linea o registro del archivo  
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(4);
            //mientras existan datos en el archivo
            while (Reg!=null) //mientras not EOF()
            {
               /*los datos del Reg que se obtiene del archivo IdCelano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Id = Reg[0];
                TiVe= Reg[1];
                Ubi = Reg[2];
                Disp = Reg[3];
                
                                
                Celdas objC=new Celdas(Id,TiVe,Ubi,Disp);
                cadena = cadena + objC.toString() + "\n";
                                
                Reg = objArch.LeerRegistro(4);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
     }//fin de mostrar todo el archivo

      
 public Celdas Consultar(Archivos objArch,String IdCel)   
 {
     Celdas objC, objCelC =null;//variable local para el retorno
     if(Buscar(objArch, IdCel)==true)//se encuentra el dato en el archivo
     {
         try {
            //locales auxiliares para extraer la informacion del archivo
            String Id,TiVe, Ubi, Disp;
            
            
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Celdas.txt"));
            //se invoca al metodo de leer registro con 4 atributos para el vector de la linea o registro del archivo  
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(4);
            //mientras existan datos en el archivo
            while (Reg!=null) //mientras not EOF()
            {
               /*los datos del Reg que se obtiene del archivo  de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Id = Reg[0];
                TiVe= Reg[1];
                Ubi = Reg[2];
                Disp = Reg[3];
                
                
                
                objC=new Celdas(Id,TiVe,Ubi,Disp);
                if(Id.equalsIgnoreCase(IdCel))
                     objCelC=objC;
                               
                Reg = objArch.LeerRegistro(4);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
     }else{//No se encuentra
         JOptionPane.showMessageDialog(null,"Dato a consultar en el archivo NO existe");
     }//fin si
  return objCelC ;//retorna en null o el objeto Celdas
 }//fin consultar
 
 
  public int ContarLineas(String arch)
    {
      int numLineas=0;//contador de lineas y es su retorno
      
      try
      {
       File archivo = new File(arch);
       if(archivo.isFile()== false)//si no hay archivo
       {
         return 0;  //retorna cero registros
       }
       else//si hay archivo
        {
       FileReader lectura = new FileReader(arch);
       BufferedReader Br = new BufferedReader(lectura);//objeto logico de archivo
       
        while (Br.readLine()!=null) //mientras se "lean" lineas y no llegue a null
          {
            numLineas++;//contador de lineas
          }
        Br.close();//se cierra el buffer o sea el almacenamiento
        return numLineas;//retorna el numero de lineas o registros que tiene
       }//fin si
      }
      catch (IOException e)
      {
         e.printStackTrace();/*printStackTrace( ) Se utiliza para imprimir 
                                el registro del stack donde se ha iniciado la excepción*/
      }
      return numLineas;
    }//fin de contar lineas

  
  
  
}//fin clase CRUD


