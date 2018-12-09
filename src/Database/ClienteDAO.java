package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Cliente;
import Models.Servico;

public class ClienteDAO {
	
	private Connection connection;

    public ClienteDAO() {
        this.connection = new Coneccao().getConnection();
    }
    
    public void adiciona(Cliente cliente) {
        String sql = "insert into cliente " +
                "(nome)" +
                " values (?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores

            stmt.setString(1,cliente.getNome());
       
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
