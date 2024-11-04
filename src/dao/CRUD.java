package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUD {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public CRUD(String query) throws SQLException {
        connection = Connexion.getConnection();
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );
        resultSet = statement.executeQuery(query);
    }

    public ArrayList<String> listarUnidades(ArrayList<Integer> ids){
        ArrayList<String> unidades = new ArrayList<>();
        try {
            resultSet.beforeFirst();
            while (resultSet.next()) {
                for (int i = 0; i < ids.size(); i++) {
                    if (resultSet.getInt("cod") == ids.get(i)) {
                        String nome = resultSet.getString("nome");
                        Integer puntos = resultSet.getInt("puntos");
                        unidades.add(nome + " -  " + puntos);
                    }
                }
            }
        }catch (SQLException e){
            System.out.println("No se han encontrado resultados" + e.getMessage());
        }
        return unidades;
    }
}
