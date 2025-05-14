
package parqueadero;

import javax.swing.JOptionPane;


public class ManejoPila 
{
    /*este metodo ingresa los datos en la pila que le llegue 
    como parametro y como la cambia la retorna*/
    public Pila IngresarDatos(Pila p1)
    {
        Servicios objS;//porque la pila es de servicios
        int resp;//para el ingreso de los datos
        String ids;
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos?","Apilar",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION)//mientras usuario quiera
        {
            //para que sobreescriba
            objS=new Servicios();
            ids=Validaciones.LeerString("Ingrese id del servicio: ");
            objS=objS.IngresarDatos(ids);//se recibe el objeto servicio completo
            //se apila el servicio
            p1.Push(objS);
            resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos?","Apilar",JOptionPane.YES_NO_OPTION);
        }//fin mientras
        return p1;//pila con nuevos datos o igual
        
    }//fin ingresar datos
    
    /*metodo que recibe dos pilas y pasa la primera pila a la segunda pila*/
    public void Devolver(Pila p1, Pila p2)
    {
        while(p1.IsEmpty()==false)//mientras tenga datos
        {
            p2.Push(p1.Pop());//se desapila en p1 y se apila en p2
        }//fin mientras
    }//fin devolver
    
    
            
    /*metodo que retorna en una cadena el contenido de la pila sin perder los datos*/
    public String JuntarPila(Pila p1, Pila p2)
    {
        //variable de retorno
        String texto="";
        
        while(p1.IsEmpty()==false)//mientras tenga datos
        {
            texto=texto+p1.Peek().toString()+"\n";
            //se desapila para tener acceso a otro dato
            //y se guarda en la auxiliar para que no se pierdan los datos
            p2.Push(p1.Pop());
            
        }//fin mientras
        //todo como estaba, se invoca al metodo para devolver la pila a la original
        Devolver(p2,p1);
        return texto;
    }//fin juntar

    
public boolean Buscar(Pila p1, Pila p2, String idb)
{
boolean sw=false;
Object info;
while(p1.IsEmpty()==false)
{
info=p1.Pop();
if(((Servicios)info).getId().equalsIgnoreCase(idb))
	sw=true;
//fin si
p2.Push(info);//para no peder dato
}//fin mientras
Devolver(p2,p1);
return sw;
}//fin

public Pila EliminarDato(Pila p1, Pila p2, String ide)
{
Object info;
if(Buscar(p1,p2,ide)==false)
       JOptionPane.showMessageDialog(null,"Dato a eliminar no se encuentra en la pila");
else
{
while(p1.IsEmpty()==false)
{
    info=p1.Pop();
    if(!(((Servicios)info).getId().equalsIgnoreCase(ide)))
       p2.Push(info);
    //fin si
}//fin mientras
Devolver(p2,p1);
JOptionPane.showMessageDialog(null,"Dato se elimina de la pila "+ide);
}//Fin si
return p1;
}//Fin 


public Object ConsultarDato(Pila p1, Pila p2, String idc)
{
Object info,datoc=null;
if(Buscar(p1,p2,idc)==false)
       JOptionPane.showMessageDialog(null,"Dato a consultar no se encuentra en la pila");
else
{
while(p1.IsEmpty()==false)
{
    info=p1.Pop();
    if(((Servicios)info).getId().equalsIgnoreCase(idc))
      datoc=info;
    //fin si
    p2.Push(info);
}//fin mientras
Devolver(p2,p1);
}//Fin si
return datoc;
}//Fin 

public Pila ActualizarDatos(Pila p1, Pila p2, String idm)
{
Object  info;
String Tser;
double VlrSer;
int op,resp;
if(Buscar(p1,p2,idm)==false)
        JOptionPane.showMessageDialog(null,"Dato a modificar no se encuentra en la pila");
else
{
    while(p1.IsEmpty()==false)
    {
    info=p1.Pop();
    if(((Servicios)info).getId().equalsIgnoreCase(idm))
    {
       Tser=((Servicios)info).getTipoServicio();
       VlrSer=((Servicios)info).getValorServicio();	
	do{	      
	   op=Validaciones.LeerInt("menú actualización"+
				   "Id= "+ idm+"\n"+
                                   "1. Tipo Servicio= "+Tser+"\n"+
                                   "2. Valor servicio= "+VlrSer+"\n"+
                                   "3. Terminar la actualización");
           switch(op)// En caso(op)	
           {
	    case 1: Tser=Validaciones.LeerTipoServicios();
                    break; 
	    case 2: VlrSer=Validaciones.LeerDouble("valor servicio: ");
                    break;
           }//Fin caso
        }while(op<3);
        resp=JOptionPane.showConfirmDialog(null,"Grabar los cambios?","Actualiza",JOptionPane.YES_OPTION);
        if(resp==JOptionPane.YES_OPTION)
        {
            ((Servicios)info).setTipoServicio(Tser);
            ((Servicios)info).setValorServicio(VlrSer);
        }//Fin si
    }//finsi
    p2.Push(info);
    }//fin mientras
Devolver(p2,p1);
}//fin si 
return p1;
}//fin


    /*Metodo que desapila el ultimo dato ingresado*/
public Object Desapilar(Pila p1)
{
    return p1.Pop();
}
    /*Metodo que desapila el primer dato ingresado */
       
public Object DesapilarPrimero(Pila p1, Pila p2)
{
 Devolver(p1,p2);
 p2.Pop();
 Devolver(p2,p1);
 return p1;
}


public int ContarElementos (Pila p1, Pila p2)
{
    int cont = 0; //contador de retorno
    while (p1.IsEmpty()== false)
    {
        p2.Push(p1.Pop());
        cont++;
    }
   Devolver(p2, p1);
   return cont;
}
}//fin clase manejo pila

