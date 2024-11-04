package readerwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Writer {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    String ruta;

    public Writer(String ruta) {
        this.ruta = ruta;
        this.fileWriter = getFileWriter(ruta);
        this.bufferedWriter = getBufferedWriter(fileWriter);
    }

    public FileWriter getFileWriter(String ruta) {
        try {
            return new FileWriter(ruta);
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
            return null;
        }
    }

    public BufferedWriter getBufferedWriter(FileWriter fileWriter) {
        return new BufferedWriter(fileWriter);
    }

    public void escribirArchivo(ArrayList<String> texto) {
        try {
            for (String linea : texto) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
