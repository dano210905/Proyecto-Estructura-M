
package parqueadero;

import javax.swing.JOptionPane;


public class ManejoListas 
{
    /*este metodo crea la lista de vehiculos por inicio o por final
    de acuerdo a la opcion del usuario, recuerden que 
    es excluyente*/
    public ListaSimple Crear(int op, ListaSimple LS)
    {
        String pl;//para la lectura del objeto
        int resp;//ingresar datos si o no
        Vehiculos objv;//puede ser object
        resp=JOptionPane.showConfirmDialog(null,
                "Ingresar vehículo en la lista?",
                "CREANDO LISTA",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_NO_OPTION)//mientras se quiera ingresar datos en la lista
        {
           objv=new Vehiculos();//para sobreescribir 
           pl=Validaciones.LeerString("Ingrese placa:");
           objv=objv.IngresarDatos(pl);//obtenemos el objeto vehiculo
           if(op==1)//por inicio
           {
               LS.CrearPorInicio(objv);//se crea el nodo en la lista y se copia el vehiculo
           }
           else//si es por final
           {
               LS.CrearPorFinal(objv);//se crea el nodo en la lista y se copia el vehiculo
           }//fin si
            resp=JOptionPane.showConfirmDialog(null,
                "Ingresar otro vehículo en la lista?",
                "CREANDO LISTA",JOptionPane.YES_NO_OPTION);
        }//fin mientras
        
        return LS;//variable de retorno
    }//fin de crear
    
    
    
    /*este metodo crea la lista doble de vehiculos por inicio o por final
    de acuerdo a la opcion del usuario, recuerden que 
    es excluyente*/
    public ListaDoble Crear(int op, ListaDoble LD)
    {
        String pl;//para la lectura del objeto
        int resp;//ingresar datos si o no
        Vehiculos objv;//puede ser object
        resp=JOptionPane.showConfirmDialog(null,
                "Ingresar vehículo en la lista?",
                "CREANDO LISTA",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_NO_OPTION)//mientras se quiera ingresar datos en la lista
        {
           objv=new Vehiculos();//para sobreescribir 
           pl=Validaciones.LeerString("Ingrese placa:");
           objv=objv.IngresarDatos(pl);//obtenemos el objeto vehiculo
           if(op==1)//por inicio
           {
               LD.CrearPorInicio(objv);//se crea el nodo en la lista y se copia el vehiculo
           }
           else//si es por final
           {
               LD.CrearPorFinal(objv);//se crea el nodo en la lista y se copia el vehiculo
           }//fin si
            resp=JOptionPane.showConfirmDialog(null,
                "Ingresar otro vehículo en la lista?",
                "CREANDO LISTA",JOptionPane.YES_NO_OPTION);
        }//fin mientras
        
        return LD;//variable de retorno
    }//fin de crear
    
    //metodo que copia el archivo a la lista doble, se admiten repeticiones en caso de tener datos la lista
    public ListaDoble CopiarArchivoLista(Archivos objArch, ListaDoble ld) 
    {      
        String cadena = "";
        try {
            //locales auxiliares para extraer la informacion del archivo
            String pl,TiVe, Mar, Co;
            int Mod;
            boolean Est;
           
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Vehiculos.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(6);
            //mientras existan datos en el archivo
            while (Reg!=null) //mientras not EOF()
            {
               /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                pl = Reg[0];
                TiVe= Reg[1];
                Mar = Reg[2];
                Co = Reg[3];
                Mod= Integer.parseInt(Reg[4]);
                Est = Boolean.parseBoolean(Reg[5]);
                                
                Vehiculos objv;
                objv=new Vehiculos(pl,TiVe,Mar,Co,Mod,Est);
                
                ld.CrearPorFinal(objv);//se copia el registro a la lista doble
                                
                Reg = objArch.LeerRegistro(6);//se lee otro registro para terminar y salir del ciclo
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return ld;//se cambia, se retorna
     }//fin de copiar archivo a lista
    
    /*este metodo recibe una fila valida y copia de la matriz a la 
    lista simple, si la lista simple no ha sido creada ..la crea, sino
    anexa los datos a la existente*/
    public ListaSimple CopiarFilaEspecificaToLS(Object mat[][], int maxc, ListaSimple objLS, int fila){
	for(int i = 0; i < maxc; i++){
	    objLS.CrearPorFinal(mat[fila][i]);  // Copiamos de la matriz, su primera fila a la lista ubicando este v. de 1ro
	    JOptionPane.showMessageDialog(null, "Vehiculos guardados exitosamente en la lista"); // Mostramos la accion efectuada
	}//fin para
    return objLS;
    }//fin de copiar 
 
//metodo que elimina los datos repetidos en lista simple con relacion a la lista doble    
//se eliminan de la simple quedan en la doble
public ListaSimple EliminarDatosRepetidos(ListaSimple ls, ListaDoble ld)
{
Nodo q;//variable local para el recorrido tambien puede usar con el objeto la q de la clase    
String placa;//variable local para buscar el dato de ls en ld
String texto="";//variable que ocncatena los vehiculos borrados en lista simple en caso de repetidos
Vehiculos objv;//para realizar la conversion de object a vehiculo
if(ls.IsEmpty()==false)//si hay datos en ls
{
  if(ld.IsEmpty()==false)//si hay datos en ld  
  {
   q = ls.getStart();//se inicia en start en ls
   while(q!=null)//mientras q señale a nodo
   {
       objv=new Vehiculos();//para que sobreescriba
       objv = (Vehiculos)q.getDato();//tomamos el vehiculo con la conversion de object
       placa = objv.getNroPlaca();//se toma la placa del nodo de ls para buscarla en la ld
       if(ld.Buscar(placa)==true){//si encuentra la placa en la lista doble
             texto=texto+objv.EstructuraReg()+"\n";//se concatena el que va ha ser borrado
             ls.LiberarDato(placa);//eliminamos el vehiculo de la lista simple por repetido
       }//fin si
       q=q.getSig();//adelantamos en lista simple
    }//fin mientras
    if(texto.equals(""))
         JOptionPane.showMessageDialog(null, "no habian Vehiculos repetidos");
    else
        JOptionPane.showMessageDialog(null, "Los Vehiculos repetidos y eliminado de la lista simple son: \n"+texto);
  }//fin si.. hay datos en ld
}//fin si... hay datos en ls
return ls;
}//fin eliminar repetidos en lista simple
    
    
public ListaDoble Invertir(ListaDoble ld)
{
Object aux;//para el intercambio de información
Nodo q,t;//para los ciclos
int NumeroElementos=ld.ContarNodos();//se cuentan los datos de la lista
int mitad=NumeroElementos/2;//Cuando divides dos enteros en Java, el resultado será un entero, y la parte decimal se descartará.
if(ld.IsEmpty()==false)//hay datos
{
         q=ld.getStart();//se ubica q adelante en Start
         t=ld.getEnd();//se ubica t atras en End
         for(int i=1;i<=mitad;i++)//hasta la mitad como efecto espejo
         {
            aux=t.getDato();//se guarda el dato señalado por t
            t.setDato(q.getDato());//se copia el dato señalado por q
            q.setDato(aux);//al dato señalado por q se cambia por aux que tiene el de t
            q=q.getSig();//se adelanta a q en la lista..va hasta la mitad
            t=t.getAnt();//se atraza a t por anterior
         }//fin para
}//fin si
return ld;//se cambia... se retorna
}//fin metodo
    

}//fin clase manejo de listas
