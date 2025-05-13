
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

    public boolean Buscar(Cola c1, Cola c2, String idb) {
        boolean sw = false;
        Object info;
        while (c1.IsEmpty() == false) {
            info = c1.Pop();
            if (((Servicios) info).getId().equalsIgnoreCase(idb)) {
                sw = true;
            }
            //Fin si
            c2.Push(info);
        }//Fin Mientras
        Devolver(c2, c1);
        return sw;
    } //Fin Buscar
    
    public boolean BuscarDis(Cola c1, Cola c2, String idb) {
        boolean sw = false;
        Object info;
        while (c1.IsEmpty() == false) {
            info = c1.Pop();
            if (((Celdas) info).getId().equalsIgnoreCase(idb)) {
                if(((Celdas) info).getEstado().equalsIgnoreCase("Disponible"))
                sw = true;
            }
            //Fin si
            c2.Push(info);
        }//Fin Mientras
        Devolver(c2,c1);
        return sw;
    } //Fin BuscarDis
    
}//fin clase manejo de cola
