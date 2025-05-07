
package parqueadero;

import javax.swing.JOptionPane;


public class Parqueadero 
{

   
    public static void main(String[] args) 
    {
       //INSTANCIAR LAS CLASES
       //clase de archicos
       Archivos objarc=new Archivos();
       //clase de crud de vehiculos
       CRUDVehiculo objcrudv=new CRUDVehiculo();
       //clase matriz
       Matriz objMa=new Matriz();
       Object mat[][]=null;//para recibir la matriz creada
       //clase manejo de matriz
       ManejoMatriz objManMat=new ManejoMatriz();
       //lista simple de vehiculos
       ListaSimple objLS=new ListaSimple();//condiciones iniciales
       //lista doble de vehiculos
       ListaDoble objLD=new ListaDoble();//condiciones iniciales
       //clase Manejo de listas
       ManejoListas objML=new ManejoListas();
       //clase de menus
       Menus objm=new Menus();
       //crear las pilas
       Pila objp=new Pila(100000);//crear pila original
       Pila objpa=new Pila(100000);//crear pila auxiliar
       //crear las colas
       Cola objc=new Cola(100000);//crear cola original
       Cola objca=new Cola(100000);//crear cola auxiliar
       //clase manejo pila
       ManejoPila objMP=new ManejoPila();
       //clase manejo cola
       ManejoCola objMC=new ManejoCola();
       
       //objeto vehiculo para recibir retornos
       Vehiculos objV=new Vehiculos();
       Object objaux;
       //opciones para los menu
       int resp,f=-1,c=-1,opMPpal,opInfBase,opManArc,opManEst,opCRUDCel,opCRUDCli;
       int opCRUDFac,opCRUDDetFac, opCRUDEmp, opCRUDPreSer, opCRUDSer, opCRUDVeh, opManPi, opManco, opLDVeh;
       String pl,texto;
   
       do{//mientras del menu principal
           opMPpal=Validaciones.LeerInt(objm.MenuPrincipal());
           switch(opMPpal)
           {
               case 1://informacion base
                      do{//mientras del menu de informacion base   
                          opInfBase=Validaciones.LeerInt(objm.MenuInformacionBase());
                          switch(opInfBase)
                          {
                              case 1://manejo de archivos
                                     do{//mientras del menu de manejo de archivos
                                        opManArc=Validaciones.LeerInt(objm.MenuManejoArchivos());
                                        switch(opManArc)
                                        {
                                            case 1://CRUD de celdas
                                                   do{//mientras del menu de crud de celdas
                                                      opCRUDCel=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDCel)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDCel
                                                                                                           
                                                   }while(opCRUDCel<4);
                                                   break;
                                            case 2://CRUD de clientes
                                                   do{//mientras del menu de crud de clientes
                                                      opCRUDCli=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDCli)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDCli
                                                                                                           
                                                   }while(opCRUDCli<4);
                                                   break;  
                                            case 3://CRUD de Facturas
                                                   do{//mientras del menu de crud de facturas
                                                      opCRUDFac=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDFac)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDFac
                                                                                                           
                                                   }while(opCRUDFac<4);
                                                   break;
                                            case 4://CRUD de detalles de Facturas
                                                   do{//mientras del menu de crud de detalles de facturas
                                                      opCRUDDetFac=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDDetFac)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDFac
                                                                                                           
                                                   }while(opCRUDDetFac<4);
                                                   break; 
                                            case 5://CRUD de Empleados
                                                   do{//mientras del menu de crud de empleados
                                                      opCRUDEmp=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDEmp)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDEmp
                                                                                                           
                                                   }while(opCRUDEmp<4);
                                                   break;  
                                            case 6://CRUD de Prestacion de servicios
                                                   do{//mientras del menu de crud de Prestacion de servicios
                                                      opCRUDPreSer=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDPreSer)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDPreSer
                                                                                                           
                                                   }while(opCRUDPreSer<4);
                                                   break; 
                                            case 7://CRUD de  servicios
                                                   do{//mientras del menu de crud de servicios
                                                      opCRUDSer=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                      switch(opCRUDSer)
                                                      {
                                                          case 1:
                                                                 break;
                                                      }//fin caso de opCRUDSer
                                                                                                           
                                                   }while(opCRUDSer<4);
                                                   break; 
                                            case 8://CRUD vehiculos       
                                                   do{//ciclo mientras del menu de archivos de vehiculos
                                                    opCRUDVeh=Validaciones.LeerInt(objm.MenuCRUDARchivos());
                                                    switch(opCRUDVeh)
                                                      {
                                                          case 1://ingresar datos en el archivo de vehiculos
                                                                  pl=Validaciones.LeerString("ingrese placa a grabar: ");
                                                                  objcrudv.IngresarVehiculo(objarc, pl);
                                                                break;
                                                          case 2://se llama al metodo mostrar todo el archivo
                                                                 JOptionPane.showMessageDialog(null,"El archivo es:\n"+objcrudv.MostrarTodo(objarc));
                                                                 break;
                                                          case 3:/*se lee la placa para buscar en el archivo y se llama al metodo consultar 
                                                                 para mostrar la informacion grabada*/
                                                                 pl=Validaciones.LeerString("ingrese placa a consultar: ");
                                                                 objV=objcrudv.Consultar(objarc, pl);
                                                                 if(objV!=null)
                                                                     JOptionPane.showMessageDialog(null,"El vehiculo es:\n "+objV.EstructuraReg());
                                                                 break;
                                                      }//fin caso de opCRUDVeh
                                                                                                           
                                                   }while(opCRUDVeh<4);
                                                   break;
                                        }//fin caso de opManArc
                                         
                                     }while(opManArc<9);//fin mientras de opManArc
                                     break; 
                              case 2://manejo de estructuras
                                     do{//mientras del menu de manejo de estructuras
                                        opManEst=Validaciones.LeerInt(objm.MenuManejoEstructuras());
                                        switch(opManEst)
                                        {
                                            case 1://cola de celdas
                                                   do{
                                                       opManco=Validaciones.LeerInt(objm.MenuColaCeldas());
                                                       switch(opManco)
                                                       {
                                                           case 1:objc=objMC.IngresarDatos(objc);
                                                                  break;
                                                           case 2:if(objc.IsEmpty()==true)//si no hay datos??
                                                                     JOptionPane.showMessageDialog(null,"Cola de celdas vacia");
                                                                  else
                                                                      JOptionPane.showMessageDialog(null,"la cola de celdas es:\n"+objMC.JuntarCola(objc, objca));
                                                                  break;
                                                       }//fin caso opManco
                                                   }while(opManco<6);
                                                   break;
                                            case 7://pila de servicios
                                                   do{
                                                       opManPi=Validaciones.LeerInt(objm.MenuPilaServicios());
                                                       switch(opManPi)
                                                       {
                                                           case 1:objp=objMP.IngresarDatos(objp);
                                                                  break;
                                                           case 2:if(objp.IsEmpty()==true)//si no hay datos??
                                                                     JOptionPane.showMessageDialog(null,"Pila de servicios vacia");
                                                                  else
                                                                      JOptionPane.showMessageDialog(null,"la pila de servicios es:\n"+objMP.JuntarPila(objp, objpa));
                                                                  break;
                                                       }//fin caso opManpi
                                                   }while(opManPi<6);
                                                   break; 
                                            case 9: do{//ciclo mientras del menu de listas doble de vehiculos 
                                                        opLDVeh=Validaciones.LeerInt(objm.MenuLDVehiculos());
                                                    switch(opLDVeh)
                                                    {
                                                    case 1://crear la lista por inicio o final
                                                           objLD=new ListaDoble();//porque es crear condiciones iniciales
                                                           resp=0;
                                                           do{//obliga al usuario a digitar lo que necesito
                                                               try{//maneja las excepciones que se salen de las manos
                                                           resp=Integer.parseInt(JOptionPane.showInputDialog("CREAR LISTA\n"
                                                                   + "1. Por inicio\n"
                                                                   + "2. Por final\n"));//se pide la opcion de crear
                                                           if(resp<1 || resp>2)//solo es para mostrar mensaje de error
                                                               JOptionPane.showMessageDialog(null,"Debe digitar SOLO 1 o 2");

                                                               }catch(Exception err)
                                                               {//no ingresa lo pedido
                                                                   JOptionPane.showMessageDialog(null,"Debe digitar NUMEROS ");
                                                               }
                                                           //se sale con la respouesta que QUIERO de lo contrario se queda    
                                                           }while(resp<1 || resp>2); //while(resp!=1 || resp!=2);

                                                           objLD=objML.Crear(resp, objLD);
                                                           break;
                                                    case 2://metodos de juntar la lista
                                                           if(objLD.IsEmpty()==false)//si hay datos
                                                           {
                                                           resp=0;
                                                           do{//obliga al usuario a digitar lo que necesito
                                                               try{//maneja las excepciones que se salen de las manos
                                                           resp=Integer.parseInt(JOptionPane.showInputDialog("MOSTRAR LA LISTA\n"
                                                                   + "1. Desde el inicio\n"
                                                                   + "2. Desde el final\n"));//se pide la opcion 
                                                           if(resp<1 || resp>2)//solo es para mostrar mensaje de error
                                                               JOptionPane.showMessageDialog(null,"Debe digitar SOLO 1 o 2");

                                                               }catch(Exception err)
                                                               {//no ingresa lo pedido
                                                                   JOptionPane.showMessageDialog(null,"Debe digitar NUMEROS ");
                                                               }
                                                           //se sale con la respouesta que QUIERO de lo contrario se queda    
                                                           }while(resp<1 || resp>2); //while(resp!=1 || resp!=2);   
                                                           if (resp==1)                           
                                                               JOptionPane.showMessageDialog(null,"La lista doble es:\n"+objLD.JuntarDesdeStart());
                                                           else
                                                               JOptionPane.showMessageDialog(null,"La lista doble es:\n"+objLD.JuntarDesdeEnd());
                                                            }
                                                            else
                                                                JOptionPane.showMessageDialog(null,"Lista vacia");
                                                           break;
                                                    case 4:if(objLD.IsEmpty()==false)//si hay datos
                                                           {
                                                           pl=Validaciones.LeerString("Ingrese número de placa a eliminar: ");
                                                           if(objLD.LiberarDato(pl)==true)//si lo encontró lo borró
                                                               JOptionPane.showMessageDialog(null,"se elimininó el vehiculo con placa "+pl); 
                                                           else
                                                               JOptionPane.showMessageDialog(null,"placa a eliminar NO se encuentra en la lista");
                                                               //Fin si
                                                           }
                                                            else
                                                                JOptionPane.showMessageDialog(null,"Lista vacia");
                                                           break;    
                                                    case 5://actualizar o modificar
                                                           break;
                                                    case 6://listar por tipo de vehiculo
                                                           break;
                                                    case 7://listar por estado       
                                                           break;
                                                           
                                                       }//fin caso opLDVeh
                                                    }while(opLDVeh<8);      
                             
                                                   break;
                                                   
                                        }//fin caso de opManEst
                                         
                                     }while(opManEst<10);
                                     break;
                          }//fin caso de opInfBase
                          
                      }while(opInfBase<4);//fin mientras de opInfBase
                      break;
               
           }//fin caso de opMPpal        
                   
       }while(opMPpal<5);
       
       
       
       
       
       
//       do{//mientras del menu principal op1
//           op1=Validaciones.LeerInt("MENU PRINCIPAL\n"
//                   + "1. Archivo Vehiculos\n"
//                   + "2. Matriz Vehiculos\n"
//                   + "3. Lista Simple Vehiculos\n"
//                   + "4. Lista Doble Vehiculos\n"
//                   + "5. Puntos del taller para estudiar Y EVENTO DEL 23 DE ABRIL\n"
//                   + "6. Salir\n");
//           //en caso de op1 del menu principal
//           switch(op1)
//           {
//               case 1: 
//               case 2: 
//                       do{//ciclo mientras del menu de matriz de vehiculos op3
//                            
//                            op3=Validaciones.LeerInt("MENU MATRIZ VEHICULOS\n"
//                                                    + "1. Ingresar datos en la matriz de Vehículos\n"
//                                                    + "2. Mostrar la matriz por filas de Vehículos\n"
//                                                    + "3. Mostrar la matriz por columnas de Vehículos\n"
//                                                    + "4. Mostrar un vehículo específico\n"
//                                                    + "5. Promedio de modelos por todos los vehículos\n"
//                                                    + "6. Diagonal Principal\n"
//                                                    + "7. Diagonal Secundaria\n"
//                                                    + "8. Vehículo mas antiguo\n"
//                                                    + "9. Vehículo mas nuevo\n"
//                                                    + "10. Copiar matriz al archivo de Vehículos SIN REPETICIONES\n"
//                                                    + "15. Volver al menu principal\n");
//                             //en caso de op3 del menu de matrices de vehiculo
//                             switch(op3)
//                             {
//                                 case 1://ingresar todo lo de la matriz
//                                        resp=JOptionPane.showConfirmDialog(null,"Desea usar la prueba de escritorio: ","INGRESAR DATOS",JOptionPane.YES_NO_OPTION);
//                                        //respuesta del usuario para usar la asignación interna
//                                        if(resp==JOptionPane.YES_OPTION)
//                                        {
//                                            f=c=3;//porque es orden de 3*3 segun los datos
//                                            objMa=new Matriz(f,c);
//                                            mat=objManMat.PruebaEscritorio(objMa.Mat);
//                                        }else{//usar asignacion externa
//                                        f=Validaciones.LeerInt("Ingrese el número de filas: ");
//                                        c=Validaciones.LeerInt("Ingrese el número de columnas: ");
//                                        objMa=new Matriz(f,c);//se crea la matriz con el tamaño leido
//                                        //ingresar datos en la matriz de vehiculos para entrar al menu de manejo
//                                        mat=objManMat.LlenarMatriz(objMa.Mat,f,c);
//                                        }
//                                        break;
//                                 case 2:if(mat!=null)//hay datos//se llama al metodo por filas
//                                             JOptionPane.showMessageDialog(null,"la matriz por filas es:\n"+objMa.JuntarMatrizFilas(mat));
//                                        else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                                 case 3:if(mat!=null)//se llama al metodo por columnas
//                                            JOptionPane.showMessageDialog(null,"la matriz por columnas es:\n"+objMa.JuntarMatrizColumnas(mat));
//                                        else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                                 case 4: if(mat!=null)
//                                         {
//                                         pl=Validaciones.LeerString("Ingrese placa del vehículo a buscar: ");
//                                         objaux=objManMat.BuscarVehiculoEspecifico(mat, f, c, pl);
//                                         if(objaux!=null)
//                                             JOptionPane.showMessageDialog(null,"El vehiculo es: \n"+objaux.toString());
//                                         }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                                 case 5:if(mat!=null)
//                                        {
//                                        JOptionPane.showMessageDialog(null,"El promedio de Modelos por todos los vehiculos de la matriz es: \n"+objManMat.PromediarModelo(mat, f, c));
//                                        
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;       
//                                 case 6:if(mat!=null)
//                                        {
//                                        texto=objManMat.JuntarDiagonalPpal(mat, f, c);//recibimos el texto
//                                        if(!texto.equals(""))//si texto NO esta vacio
//                                        {
//                                            JOptionPane.showMessageDialog(null,"la diagonal principal es:\n"+texto);
//                                        }//fin si
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                                 case 7:if(mat!=null)
//                                        {
//                                        texto=objManMat.JuntarDiagonalSec(mat, f, c);//recibimos el texto
//                                        if(!texto.equals(""))//si texto NO esta vacio
//                                        {
//                                            JOptionPane.showMessageDialog(null,"la diagonal secundaria es:\n"+texto);
//                                        }//fin si
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;  
//                                 case 8:if(mat!=null)
//                                        {
//                                        objV=(Vehiculos)objManMat.BuscarMasAntiguo(mat, f, c);
//                                        JOptionPane.showMessageDialog(null,"el vehiculo mas antiguo es: "+objV.EstructuraReg());
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                                 case 9:if(mat!=null)
//                                        {
//                                        objV=(Vehiculos)objManMat.BuscarMasNuevo(mat, f, c);
//                                        JOptionPane.showMessageDialog(null,"el vehiculo mas nuevo es: "+objV.EstructuraReg());
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;  
//                                 case 10:if(mat!=null){//hay datos
//                                            if(objManMat.GrabarMatriz(mat, f, c, objarc, objcrudv)==true)
//                                                JOptionPane.showMessageDialog(null,"se grabaron vehiculos de la matriz al archivo");
//                                            else
//                                                JOptionPane.showMessageDialog(null,"NO se grabaron vehiculos de la matriz al archivo");
//                                            //fin si
//                                        }else
//                                            JOptionPane.showMessageDialog(null,"la matriz tiene problemas o no tiene datos");
//                                        break;
//                             }//fin caso del menu de matriz vehiculo
//                         }while(op3<15);
//                         break;//caso 1 para el menu de matriz vehiculos del menu principal
//           case 3: do{//ciclo mientras del menu de listas simples de vehiculos op4
//                            op4=Validaciones.LeerInt("MENU LISTA SIMPLE VEHICULOS\n"
//                                                    + "1. Crear lista simple de vehículos\n"
//                                                    + "2. Mostrar lista simple de  Vehículos desde inicio\n"
//                                                    + "3. Consultar un vehículo específico\n"
//                                                    + "4. Insertar al inicio\n"
//                                                    + "5. Insertar al final\n"
//                                                    + "6. Insertar antes de un dato existente\n"
//                                                    + "7. Insertar despues de un dato existente\n"
//                                                    + "8. Liberar inicio\n"//borrar primero
//                                                    + "9. Liberar final\n"//borrar ultimo
//                                                    + "10. Liberar dato especifico\n"
//                                                    + "15. Volver al menu principal\n");
//                             //en caso de op4 del menu de lista simple de vehiculos
//                             switch(op4)
//                             {
//                                 case 1://crear la lista por inicio o final
//                                        objLS=new ListaSimple();//porque es crear condiciones iniciales
//                                        resp=0;
//                                        do{//obliga al usuario a digitar lo que necesito
//                                            try{//maneja las excepciones que se salen de las manos
//                                        resp=Integer.parseInt(JOptionPane.showInputDialog("CREAR LISTA\n"
//                                                + "1. Por inicio\n"
//                                                + "2. Por final\n"));//se pide la opcion de crear
//                                        if(resp<1 || resp>2)//solo es para mostrar mensaje de error
//                                            JOptionPane.showMessageDialog(null,"Debe digitar SOLO 1 o 2");
//                                        
//                                            }catch(Exception err)
//                                            {//no ingresa lo pedido
//                                                JOptionPane.showMessageDialog(null,"Debe digitar NUMEROS ");
//                                            }
//                                        //se sale con la respouesta que QUIERO de lo contrario se queda    
//                                        }while(resp<1 || resp>2); //while(resp!=1 || resp!=2);
//                                        
//                                        objLS=objML.Crear(resp, objLS);
//                                        break;
//                                 case 2://se llama al metodo juntar la lista
//                                        if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        JOptionPane.showMessageDialog(null,"La lista simple es:\n"+objLS.JuntarDesdeInicio());
//                                         }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;
//                                 case 3:/*se lee la placa para buscar en el archivo y se llama al metodo consultar 
//                                        para mostrar la informacion grabada*/
//                                        break;
//                                 case 4:if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        pl=Validaciones.LeerString("Ingrese número de placa a insertar de primero: ");
//                                        objV=objV.IngresarDatos(pl);
//                                        objLS.InsertarStart(objV);
//                                        JOptionPane.showMessageDialog(null,"Se insertó de primero en la lista a "+pl);
//                                        }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                       break;
//                                 case 5:if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        pl=Validaciones.LeerString("Ingrese número de placa a insertar de último: ");
//                                        objV=objV.IngresarDatos(pl);
//                                        objLS.InsertarEnd(objV);
//                                        JOptionPane.showMessageDialog(null,"Se insertó de último en la lista a "+pl);
//                                        }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                       break;    
//                                 case 6:if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        pl=Validaciones.LeerString("Ingrese número de placa a insertar: ");
//                                        texto=Validaciones.LeerString("Ingrese número de placa referencia para insertar antes: ");
//                                        objLS.InsertarAntes(pl, texto);
//                                        }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;
//                                 case 7:if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        pl=Validaciones.LeerString("Ingrese número de placa a insertar: ");
//                                        texto=Validaciones.LeerString("Ingrese número de placa referencia para insertar despues: ");
//                                        objLS.InsertarDespues(pl, texto);
//                                        }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;    
//                                 case 8:  if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        JOptionPane.showMessageDialog(null,"El dato eliminado de primero es:\n "+objLS.LiberarStart());
//                                        }   
//                                          else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;
//                                 case 9:  if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        JOptionPane.showMessageDialog(null,"El dato eliminado de último es:\n "+objLS.LiberarEnd());
//                                        }   
//                                          else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;
//                                 case 10:if(objLS.IsEmpty()==false)//si hay datos
//                                        {
//                                        pl=Validaciones.LeerString("Ingrese número de placa a eliminar: ");
//                                        if(objLS.LiberarDato(pl)==true)//si lo encontró lo borró
//                                            JOptionPane.showMessageDialog(null,"se elimininó el vehiculo con placa "+pl); 
//                                        else
//                                            JOptionPane.showMessageDialog(null,"placa a eliminar NO se encuentra en la lista");
//                                            //Fin si
//                                        }
//                                         else
//                                             JOptionPane.showMessageDialog(null,"Lista vacia");
//                                        break;      
//                             }//fin caso del menu de lista simple vehiculo
//                         }while(op4<15);
//                         break;//caso 4 para el menu de lista simple de vehiculos del menu principal
//          
//  
//                          
//               break;          
//           }//fin caso de op1 menu principal
//       }while(op1<6);//fin del mientras del menu principal
   
    }//fin main
    
    
}//fin clase parqueadero
