package Models;

import java.sql.Timestamp;

import Database.ClienteDAO;

public class Cliente extends ClienteDAO{
	
	private String nome;
	private Timestamp  criadoEm;
	private int id;
	private String contato;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Timestamp getCriadoEm() {
		return criadoEm;
	}


	public void setCriadoEm(Timestamp criadoEm) {
		this.criadoEm = criadoEm;
	}


}
