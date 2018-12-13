package Database;

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
        String sql = "insert into Cliente " +
                "(nome, contato)" +
                " values (?,?)";

        try {
            // prepared statement para inser��o
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores

            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getContato());

       
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Cliente> getLista() throws SQLException{
    	PreparedStatement stmt = this.connection
                .prepareStatement("select * from Cliente");
        ResultSet rs = stmt.executeQuery();

        List<Cliente> clientes = new ArrayList<Cliente>();

        while (rs.next()) {

            // criando o objeto usuario
        	Cliente cliente = new Cliente();
        	cliente.setId(rs.getInt("id"));
        	cliente.setNome(rs.getString("nome"));
        	cliente.setContato(rs.getString("contato"));
                cliente.setCriadoEm(rs.getTimestamp("criado_em"));
                cliente.setServicos();

            // adicionando o objeto � lista
            clientes.add(cliente);
        }

        rs.close();
        stmt.close();

        return clientes;
    }
    
    public List<Servico> getServicos(int idcliente) throws SQLException{
        PreparedStatement stmt = this.connection
                .prepareStatement("select * from servico a inner join servico_has_Cliente b on a.id = b.servico_id where b.Cliente_id = ?");
        stmt.setInt(1,idcliente);
        ResultSet rs = stmt.executeQuery();

        List<Servico> servicos = new ArrayList<Servico>();

        while (rs.next()) {

            // criando o objeto usuario
        	Servico servico = new Servico();
        	servico.setId(rs.getInt("id"));
        	servico.setDescricao(rs.getString("descricao"));
        	servico.setTempo(rs.getFloat("tempo"));
        	servico.setPreco(rs.getFloat("preco"));

            // adicionando o objeto � lista
            servicos.add(servico);
        }

        rs.close();
        stmt.close();

        return servicos;
        
    }
    
    public void cadastrarServico(int idcliente, int idservico){
        String sql = "insert into servico_has_Cliente " +
                "(servico_id, Cliente_id)" +
                " values (?, ?)";

        try {
            // prepared statement para inser��o
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores

            stmt.setInt(1,idservico);
            stmt.setInt(1,idcliente);
       
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cliente atualizar (){
        return null;
    }
    
   public void deletar(int id) throws SQLException{
       PreparedStatement stmt = this.connection
                .prepareStatement("delete from cliente WHERE id= ?");
       
       stmt.setInt(1,id);
       stmt.execute();
       stmt.close();
       
    }

}
