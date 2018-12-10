package Database;

import Banco.Coneccao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Cliente;
import Models.Servico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            // prepared statement para inser��o
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
    
    public List<Cliente> getLista() throws SQLException{
    	PreparedStatement stmt = this.connection
                .prepareStatement("select * from cliente");
        ResultSet rs = stmt.executeQuery();

        List<Cliente> clientes = new ArrayList<Cliente>();

        while (rs.next()) {

            // criando o objeto usuario
        	Cliente cliente = new Cliente();
        	cliente.setId(rs.getInt("id"));
        	cliente.setNome(rs.getString("nome"));
        	cliente.setContato(rs.getString("contato"));
                cliente.setCriadoEm(rs.getTimestamp("criado_em"));

            // adicionando o objeto � lista
            clientes.add(cliente);
        }

        rs.close();
        stmt.close();

        return clientes;
    }
    
    public void adicionaServico(Servico servico){
        
    }

}
