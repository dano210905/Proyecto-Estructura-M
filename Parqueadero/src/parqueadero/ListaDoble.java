
package parqueadero;

import javax.swing.JOptionPane;


public class ListaDoble 
{
    //atributos propios y privados
    private Nodo Start, End;

    //constructor vacio
    public ListaDoble() 
    {
        Start=End=null;//condiciones iniciales de lista vacia
    }

     /*auxiliares, la q se va a usar para recorridos y la 
    p SOLO PARA EL METODO BUSCAR*/
    Nodo q,p;
    
    /*metodo que retorna verdadero si la lista esta vacia o 
    falso en caso contrario*/
    public boolean IsEmpty()
    {
        if(Start==null)
            return true;
        else
            return false;
        //fin si
    }//fin is empty
    
public void CrearPorFinal(Object info)
{
if (IsEmpty()==false)
{
   getEnd().setSig(new Nodo(End,info, null));  
   setEnd(getEnd().getSig()); 
}else
{
   Start = End = new Nodo(null,info, null); 
}//Fin si
}//fin de insertar nodo por final

    
public void CrearPorInicio(Object info)
{
if (IsEmpty()==false)
{
    setStart(new Nodo(null,info,getStart())); 
    getStart().getSig().setAnt(getStart()); 
}else
{
      Start = End = new Nodo(null,info, null); 
}//Fin si
    
}//fin de insertar nodo por inicio
   
/*

*/
public String JuntarDesdeStart()
{
String texto="";//variable del retorno
if(IsEmpty()==false)
{
q=getStart();
while(q!=null)
{
	texto=texto+q.getDato()+"\n";
     	q=q.getSig();//adelantar en la lista
}//fin mientras
}//fin si
return texto;
}//fin juntar desde inicio
  
    
public String JuntarDesdeEnd()
{
String texto="";//variable del retorno
if(IsEmpty()==false)
{
q=getEnd();
while(q!=null)
{
	texto=texto+q.getDato()+"\n";
     	q=q.getAnt();//al anterior en la lista
}//fin mientras
}//fin si
return texto;
}//fin juntar desde final

/*metodo que busca por la placa en la lista,
 retorna verdadero si lo encuentra y ademas deja el apuntador
 p en el dato y retorna falso en  caso de no encontrarlo*/
    public boolean Buscar(String pl)
    {
       if(IsEmpty()==false)//si hay datos
       {
         String pla;//variable que debemos usar para capturar la placa 
         p=getStart();//colocamos el apuntador al inicio
         pla=((Vehiculos)p.getDato()).getNroPlaca();/*tomamos la placa del vehiculo
         que esta en el nodo para que no haga la pregunta con p en null!! esto
         NO es necesario en el algoritmo porque es un problema de programacion 
         de java no del analisis*/
         while(p!=null&&!(pla.equalsIgnoreCase(pl)))
         {
             p=p.getSig();//p adelanta en la lista
             if(p!=null)/*si hay aun datos para tomar otro id, esto 
                 no lo tenemos que hacer en el algoritmo*/
                 pla=((Vehiculos)p.getDato()).getNroPlaca();
         }//fin mientras
       }
       if(p==null)//recorrio toda la lista y no lo encuentra
           return false;
       else//p quedo ubicada en la lista en el dato buscado
           return true;
    }//fin buscar

    //metodo que recibe un objeto y lo inserta un nodo de primero
public void InsertarStart(Object d)
{
if(IsEmpty()==false)//si hay datos
{
    setStart(new Nodo(null,d,getStart()));//se crea el nuevo nodo y se le asigna a start
    getStart().getSig().setAnt(getStart());
}//fin si
}//fin insertar start

//metodo que recibe un objeto y lo inserta al final
public void InsertarEnd(Object d)
{
if (IsEmpty()==false)
{
	setEnd(new Nodo(getEnd(),d,null));
        getEnd().getAnt().setSig(getEnd());
}//fin si
}//fin insertar end

//metodo que retorna y elimina el primer dato
public Object LiberarStart()
{
Object d=null;//variable local de retorno
if (IsEmpty()==false)//hay datos
{
  d=getStart().getDato();//se toma el dato del primer nodo para retornarlo y eliminarlo
  if(getStart().getSig()==null) //si es lista de un solo nodo 
  {//la lista quedara vacia
    getStart().finalize();//llamada al metodo destructor
    Start=End=null;//condiciones iniciales de lista vacia
  }
  else//la lista tiene varios nodos
  {    
    setStart(getStart().getSig());//se cambia a Start para el sig
    getStart().getAnt().finalize();//llamada al destructor
    getStart().setAnt(null);//el primer nodo siempre tiene en el ant null
  }//fin si
}//fin si
return d;//dato eliminado
}//fin liberar start

//metodo que retorna y elimina el ultimo dato
public Object LiberarEnd()
{
Object d=null;
if (IsEmpty()==false)
{
  d=getEnd().getDato();
  if(getStart().getSig()==null)
  {
    getStart().finalize();
    Start=End=null;
  }
  else
  {
    setEnd(getEnd().getAnt());//pasamos el end al penultimo
    getEnd().getSig().finalize();//liberamos el ultimo
    getEnd().setSig(null);
  }//fin si
}//fin si
return d;
}//fin liberar end

public void InsertarAntes(String plnueva, String plrefer)
{
if(IsEmpty()==false)
{
Vehiculos d=new Vehiculos();
if(Buscar(plrefer)==true)//dato encontrado
{
   d=d.IngresarDatos(plnueva);
   if(p==getStart())//lo encontro de primero
	InsertarStart(d);//se llama al metodo insertar de primero
   else 
   {
     p.setAnt(new Nodo(p.getAnt(),d,p));
     p.getAnt().getAnt().setSig(p.getAnt());
   }//fin si
}else
     JOptionPane.showMessageDialog(null,"placa referencia no se encuentra, no se inserta el dato");
//fin si
}//fin si
}//fin insertar antes

public boolean LiberarDato(String plElim)
{
boolean sw=false;//significa que no se eliminó el dato
if(IsEmpty()==false)
{
if(Buscar(plElim)==true)
{
 sw=true;//lo encontró ...se va a eliminar   
 if (p==getStart())//si el dato esta de primero
      LiberarStart();
 else{
     if(p==getEnd())//si el dato esta de ultimo
		LiberarEnd();
     else{//esta en medio de dos nodos
	p.getAnt().setSig(p.getSig());
	p.getSig().setAnt(p.getAnt());
	p.finalize();
     }//fin si
 }//fin si
}//Fin si
}//fin si
return sw;
}//Fin liberar	

public void InsertarDespues(String plnueva, String plrefer)
{
if(IsEmpty()==false)
{    
Vehiculos d=new Vehiculos();
if(Buscar(plrefer)==true)
{
  d=d.IngresarDatos(plnueva);
  if(p==getEnd())
	InsertarEnd(d);
  else
  {  p.setSig(new Nodo(p, d,p.getSig()));
     p.getSig().getSig().setAnt(p.getSig());
  }//fin si
}else
    JOptionPane.showMessageDialog(null,"placa referencia no se encuentra, no se inserta el dato");
//fin si
}//fin si
}//fin insertar despues

/*este método retorna el numero de elementos de la lista*/
public int ContarNodos()
{
int con=0;//variable del retorno
if(IsEmpty()==false)
{
q=getStart();
while(q!=null)
{
	con++;//se cuenta el dato
     	q=q.getSig();//adelantar en la lista
}//fin mientras
}//fin si
return con;
}//fin contar nodos


    public Nodo getStart() {
        return Start;
    }
    

    public void setStart(Nodo Start) {
        this.Start = Start;
    }

    public Nodo getEnd() {
        return End;
    }

    public void setEnd(Nodo End) {
        this.End = End;
    }
    
    
    
    
    
    
    
}
