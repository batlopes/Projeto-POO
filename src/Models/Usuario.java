package Models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import Banco.UsuarioDAO;

public class Usuario extends UsuarioDAO {
	
	private String nome;
	private String email;
	private String senha;
	private int id;
	private static int workload = 12;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static String hashPassword(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenha[] = algorithm.digest(senha.getBytes("UTF-8"));
          
        StringBuilder hexStringSenha = new StringBuilder();
        for (byte b : messageDigestSenha) {
                 hexStringSenha.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexStringSenha.toString();
        
        return senhahex;
	}
	
	public static boolean verifyPassword(String senha, String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenha[] = algorithm.digest(senha.getBytes("UTF-8"));
          
        StringBuilder hexStringSenha = new StringBuilder();
        for (byte b : messageDigestSenha) {
                 hexStringSenha.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexStringSenha.toString();
        
        System.out.println(hash);   
        return senhahex.equals(hash);
	}
	
	public static Usuario login(String email, String senha) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
		
		UsuarioDAO dao = new UsuarioDAO();
	    Usuario usuario = dao.getForEmail(email);
	    
	    if (usuario!=null){
	    	if (verifyPassword(senha, usuario.getSenha())){
	    		return usuario;
	    	}
	    	else {
	    		System.out.println("Senha incorreta");
	    	}
	    }
	    System.out.println("Usuario não existe");
		return null;
	}
	


}
