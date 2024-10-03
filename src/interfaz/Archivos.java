
package interfaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos  {
    private String nombre;
    private File archivo;

    public Archivos(String nombre)  {
        this.nombre=nombre;      
    }
    
    public void  create( String ruta) throws IOException  {
        this.archivo = new File(ruta);
        this.archivo.createNewFile();        
    }
 
    public String getNombre(){
    return this.nombre;
    }
    
    // Registra una línea en el archivo
    public  boolean registrar(String linea){
        try {
            if(archivo.exists()){
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return  true;
            }
        } catch (IOException ex) {
            System.out.println("error de archivo: "+ex);
               
        }
        return false;
    }
    
    // Limpia el archivo 
    public boolean limpiarArchivo(){
        try {
            String directorio = archivo.getParent();
            archivo.delete();
            new FileWriter(directorio+"/datos.txt",true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
}
