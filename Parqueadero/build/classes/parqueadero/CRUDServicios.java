
// Lincoln Andres Palacios Hinestroza

package parqueadero;

import java.io.*;
import javax.swing.JOptionPane;


public class CRUDServicios {

    public boolean Buscar(Archivos objArch, String cod) {
        boolean sw = false;
        try {
            String codigo, descripcion;
            double precio;
            boolean estado;

            String Reg[];
            objArch.AbrirArchivoModoLectura("Servicios.txt");
            Reg = objArch.LeerRegistro(4);
            while (Reg != null) {
                codigo = Reg[0];
                descripcion = Reg[1];
                precio = Double.parseDouble(Reg[2]);
                estado = Boolean.parseBoolean(Reg[3]);

                if (codigo.equalsIgnoreCase(cod)) {
                    sw = true;
                }
                Reg = objArch.LeerRegistro(4);
            }
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return sw;
    }

    public void IngresarServicio(Archivos objArch, String cod) {
        Servicios objS = new Servicios();
        if (Buscar(objArch, cod) == false) {
            objS = objS.IngresarDatos(cod);
            GrabarServicio(objArch, objS);
        } else {
            JOptionPane.showMessageDialog(null, "*****Servicio YA existe en el archivo*****");
        }
    }

    public void GrabarServicio(Archivos objArchivos, Servicios objS) {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Servicios.txt");
            cadena = objS.EstructuraReg();
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO*****");
        }
    }

    public String MostrarTodo(Archivos objArch) {
        String cadena = "";
        try {
            String codigo, descripcion;
            double precio;
            boolean estado;

            String Reg[];
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Servicios.txt"));
            Reg = objArch.LeerRegistro(4);
            while (Reg != null) {
                codigo = Reg[0];
                descripcion = Reg[1];
                precio = Double.parseDouble(Reg[2]);
                estado = Boolean.parseBoolean(Reg[3]);

                Servicios objS = new Servicios(codigo, descripcion, precio, estado);
                cadena += objS.EstructuraReg() + "\n";

                Reg = objArch.LeerRegistro(4);
            }
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }

    public Servicios Consultar(Archivos objArch, String cod) {
        Servicios objS, objSC = null;
        if (Buscar(objArch, cod) == true) {
            try {
                String codigo, descripcion;
                double precio;
                boolean estado;

                String Reg[];
                JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Servicios.txt"));
                Reg = objArch.LeerRegistro(4);
                while (Reg != null) {
                    codigo = Reg[0];
                    descripcion = Reg[1];
                    precio = Double.parseDouble(Reg[2]);
                    estado = Boolean.parseBoolean(Reg[3]);

                    objS = new Servicios(codigo, descripcion, precio, estado);
                    if (codigo.equalsIgnoreCase(cod))
                        objSC = objS;

                    Reg = objArch.LeerRegistro(4);
                }
                objArch.CerrarArchivoModoLectura();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dato a consultar en el archivo NO existe");
        }
        return objSC;
    }

    public int ContarLineas(String arch) {
        int numLineas = 0;
        try {
            File archivo = new File(arch);
            if (archivo.isFile() == false) {
                return 0;
            } else {
                FileReader lectura = new FileReader(arch);
                BufferedReader Br = new BufferedReader(lectura);
                while (Br.readLine() != null) {
                    numLineas++;
                }
                Br.close();
                return numLineas;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numLineas;
    }

    public Object RetornarUltimo(Archivos objArch) {
        Servicios ultimoServ = null, objS;
        int con = ContarLineas("Servicios.txt");
        if (con > 0) {
            try {
                String codigo, descripcion;
                double precio;
                boolean estado;

                String Reg[];
                JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Servicios.txt"));
                Reg = objArch.LeerRegistro(4);
                int conAux = 0;
                while (Reg != null) {
                    codigo = Reg[0];
                    descripcion = Reg[1];
                    precio = Double.parseDouble(Reg[2]);
                    estado = Boolean.parseBoolean(Reg[3]);

                    objS = new Servicios(codigo, descripcion, precio, estado);
                    conAux++;
                    if (conAux == con)
                        ultimoServ = objS;

                    Reg = objArch.LeerRegistro(4);
                }
                objArch.CerrarArchivoModoLectura();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
            }
        } else {
            JOptionPane.showMessageDialog(null, "***Archivo con problemas o vacío");
        }
        return ultimoServ;
    }

    public Object RetornarPrimero(Archivos objArch) {
        Servicios objS = null;
        int con = ContarLineas("Servicios.txt");
        if (con > 0) {
            try {
                String codigo, descripcion;
                double precio;
                boolean estado;

                String Reg[];
                JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Servicios.txt"));
                Reg = objArch.LeerRegistro(4);
                codigo = Reg[0];    
                descripcion = Reg[1];
                precio = Double.parseDouble(Reg[2]);
                estado = Boolean.parseBoolean(Reg[3]);

                objS = new Servicios(codigo, descripcion, precio, estado);
                objArch.CerrarArchivoModoLectura();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
            }
        } else {
            JOptionPane.showMessageDialog(null, "***Archivo con problemas o vacío");
        }
        return objS;
    }
}
