package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Usuario;

public class UsuarioDAO {
	
	private Connection connection;

    public UsuarioDAO() {
        this.connection = new Coneccao().getConnection();
    }
    
    public void adiciona(Usuario usuario) {
        String sql = "insert into usuario " +
                "(nome,email,senha)" +
                " values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores

            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getEmail());
            stmt.setString(3,usuario.getSenha());
       
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> getLista() throws SQLException{
    	PreparedStatement stmt = this.connection
                .prepareStatement("select * from usuario");
        ResultSet rs = stmt.executeQuery();

        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (rs.next()) {

            // criando o objeto usuario
        	Usuario usuario = new Usuario();
        	usuario.setId(rs.getInt("id"));
        	usuario.setNome(rs.getString("nome"));
        	usuario.setEmail(rs.getString("email"));
        	usuario.setSenha(rs.getString("senha"));

            // adicionando o objeto à lista
            usuarios.add(usuario);
        }

        rs.close();
        stmt.close();

        return usuarios;
    }
    
    public Usuario getForEmail(String email) throws SQLException{
    	PreparedStatement stmt = this.connection
                .prepareStatement("select * from usuario where email = ?");
    	stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        
        Usuario usuario = new Usuario();
        
        while (rs.first()) {

         
        	usuario.setNome(rs.getString("nome"));
        	usuario.setEmail(rs.getString("email"));
        	usuario.setSenha(rs.getString("senha"));
        }

        rs.close();
        stmt.close();
        
        return usuario;	
    }
}
