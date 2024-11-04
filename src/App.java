import dao.CRUD;
import readerwriter.Reader;
import readerwriter.Writer;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    static String query = "SELECT * FROM adeptasororitas order by puntos desc";
    static  ArrayList<Integer> ids = new ArrayList<>();
    static String rutaLectura = "/home/accesodatos/Escritorio/SimulacroExamen/codigosUnidades.txt";
    static String rutaEscritura = "/home/accesodatos/Escritorio/SimulacroExamen/resultado.txt";
    public static void main(String[] args) throws SQLException {
        CRUD crud = new CRUD(query);
        Reader reader = new Reader(rutaLectura);
        ids = reader.leerArchivo();
        ArrayList<String> unidades = crud.listarUnidades(ids);
        imprimirUnidades(unidades);
        Writer writer = new Writer(rutaEscritura);
        writer.escribirArchivo(unidades);
    }

    public static void imprimirUnidades(ArrayList<String> unidades){
        for (String unidade : unidades) {
            System.out.println(unidade);
        }
    }
}
