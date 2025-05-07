
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
    
}//fin clase manejo pila
