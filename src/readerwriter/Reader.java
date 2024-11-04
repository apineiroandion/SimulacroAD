package readerwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {
    String ruta;
    FileReader fileReader;
    BufferedReader bufferedReader;

    public Reader(String ruta) {
        this.ruta = ruta;
        this.fileReader = getFileReader(ruta);
        this.bufferedReader = getBufferedReader(fileReader);
    }

    public FileReader getFileReader(String ruta) {
        try {
            return new FileReader(ruta);
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
            return null;
        }
    }

    public BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }

    public ArrayList<Integer>leerArchivo(){
        ArrayList<Integer> lista = new ArrayList<>();
        try {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                lista.add(Integer.parseInt(linea));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
