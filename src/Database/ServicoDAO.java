package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Servico;


public class ServicoDAO {
	
	private Connection connection;

    public ServicoDAO() {
        this.connection = new Coneccao().getConnection();
    }
    
    public void adiciona(Servico servico) {
        String sql = "insert into servico " +
                "(descricao,tempo,preco)" +
                " values (?,?,?)";

        try {
            // prepared statement para inser��o
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores

            stmt.setString(1,servico.getDescricao());
            stmt.setFloat(2, servico.getTempo());
            stmt.setFloat(3,servico.getPreco());
       
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Servico> getLista() throws SQLException{
    	PreparedStatement stmt = this.connection
                .prepareStatement("select * from servico");
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
    
    public Servico atualizar (){
        return null;
    }
    
    public void deletar(int id) throws SQLException{
       PreparedStatement stmt = this.connection
                .prepareStatement("delete from servico WHERE id= ?");
       
       stmt.setInt(1,id);
       stmt.execute();
       stmt.close();
       
    }


}
