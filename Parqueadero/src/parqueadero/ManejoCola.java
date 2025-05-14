
package parqueadero;

import javax.swing.JOptionPane;


public class ManejoCola 
{
    /*este metodo ingresa los datos en la cola que le llegue 
    como parametro y como la cambia la retorna*/
    public Cola IngresarDatos(Cola c1)
    {
        Celdas objC;//porque la cola es de celdas
        int resp;//para el ingreso de los datos
        String idc;
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos?","Encolar",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION)//mientras usuario quiera
        {
            //para que sobreescriba
            objC=new Celdas();
            idc=Validaciones.LeerString("Ingrese id de la celda de parqueo: ");
            objC=objC.IngresarDatos(idc);//se recibe el objeto celda completo
            //se encola la celda
            c1.Push(objC);
            resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos?","Encolar",JOptionPane.YES_NO_OPTION);
        }//fin mientras
        return c1;//cola con nuevos datos o igual
        
    }//fin ingresar datos
    
    /*metodo que recibe dos colas y pasa la primera cola a la segunda cola*/
    public void Devolver(Cola c1, Cola c2)
    {
        while(c1.IsEmpty()==false)//mientras tenga datos
        {
            c2.Push(c1.Pop());//se desencola en c1 y se encola en c2
        }//fin mientras
    }//fin devolver
    
            
    /*metodo que retorna en una cadena el contenido de la cola sin perder los datos*/
    public String JuntarCola(Cola c1, Cola c2)
    {
        //variable de retorno
        String texto="";
        
        while(c1.IsEmpty()==false)//mientras tenga datos
        {
            texto=texto+c1.Peek().toString()+"\n";
            //se desencola para tener acceso a otro dato
            //y se guarda en la auxiliar para que no se pierdan los datos
            c2.Push(c1.Pop());
            
        }//fin mientras
        //todo como estaba, se invoca al metodo para devolver la cola a la original
        Devolver(c2,c1);
        return texto;
    }//fin juntar
    
    public boolean Buscar(Cola c1, Cola c2, String idb)
{
boolean sw=false;
Object info;
while(c1.IsEmpty()==false)
{
info=c1.Pop();
if(((Celdas)info).getId().equalsIgnoreCase(idb))
	sw=true;
//fin si
c2.Push(info);//para no peder dato
}//fin mientras
Devolver(c2,c1);
return sw;
}//fin

public Cola EliminarDato(Cola c1, Cola c2, String ide)
{
Object info;
if(Buscar(c1,c2,ide)==false)
       JOptionPane.showMessageDialog(null,"Dato a eliminar no se encuentra en la cola");
else
{
while(c1.IsEmpty()==false)
{
    info=c1.Pop();
    if(!(((Celdas)info).getId().equalsIgnoreCase(ide)))
       c2.Push(info);
    //fin si
}//fin mientras
Devolver(c2,c1);
JOptionPane.showMessageDialog(null,"Dato se elimina de la cola "+ide);
}//Fin si
return c1;
}//Fin 


public Object ConsultarDato(Cola c1, Cola c2, String idc)
{
Object info,datoc=null;
if(Buscar(c1,c2,idc)==false)
       JOptionPane.showMessageDialog(null,"Dato a consultar no se encuentra en la cola");
else
{
while(c1.IsEmpty()==false)
{
    info=c1.Pop();
    if(((Celdas)info).getId().equalsIgnoreCase(idc))
      datoc=info;
    //fin si
    c2.Push(info);
}//fin mientras
Devolver(c2,c1);
}//Fin si
return datoc;
}//Fin 

public Cola ActualizarDatos(Cola c1, Cola c2, String idm)
{
Object  info;
int op,resp;
String Ubi,TiVe;
String Est;
if(Buscar(c1,c2,idm)==false)
        JOptionPane.showMessageDialog(null,"Dato a modificar no se encuentra en la cola");
else
{
    while(c1.IsEmpty()==false)
    {
    info=c1.Pop();
    if(((Celdas)info).getId().equalsIgnoreCase(idm))
    {
        Ubi=((Celdas)info).getUbicacion();
        TiVe=((Celdas)info).getTipoVehiculo();
   
       Est=((Celdas)info).getEstado();	
	do{	      
	   op=Validaciones.LeerInt("menú actualización"+
				   "Id= "+ idm+"\n"+
                                   "1. Ubicacion de la celda= "+Ubi+"\n"+
                                   "2. Tipo de vehiculo= "+TiVe+"\n"+
                                   "3. Disponibilidad (Estado)= "+ Est+"\n"+        
                                   "4. Terminar la actualización");
           switch(op)// En caso(op)	
           {
	    case 1: Ubi=Validaciones.LeerString("ubicacion de la celda");
                    break; 
	    case 2: TiVe=Validaciones.LeerTipoVehiculo();
                    break;
            case 3: Est=Validaciones.LeerDisponibilidad();
                    break;
           }//Fin caso
        }while(op<4);
        resp=JOptionPane.showConfirmDialog(null,"Grabar los cambios?","Actualiza",JOptionPane.YES_OPTION);
        if(resp==JOptionPane.YES_OPTION)
        {
            ((Celdas)info).setUbicacion(Ubi);
            ((Celdas)info).setTipoVehiculo(TiVe);
            ((Celdas)info).setEstado(Est);
        }//Fin si
    }//finsi
    c2.Push(info);
    }//fin mientras
Devolver(c2,c1);
}//fin si 
return c1;
}//fin
    /*Metodo que desencola el primer dato ingresado*/
public Object Desencolar(Cola c1)
{
    return c1.Pop();
}
/*Metodo que desencola el ultimo dato ingresado*/

public Object DesencolarUltimo (Cola c1, Cola c2)
{
    Object info = null;
    int cont=ContarElementos(c1, c2);
     while (c1.IsEmpty()== false)
    {
        
    if(cont==1)//si llegamos al ultimo dato
    
        info=c1.Pop();
    else{
        c2.Push(c1.Pop());
        cont--; //para decrementar y llegar al ultimo de cola
    }//fin si
    }//fin mientras
     return info;
}

public int ContarElementos (Cola c1, Cola c2)
{
    int cont = 0; //contador de retorno
    while (c1.IsEmpty()== false)
    {
        c2.Push(c1.Pop());
        cont++;
    }
   Devolver(c2, c1);
   return cont;
}
}//fin clase manejo de cola
