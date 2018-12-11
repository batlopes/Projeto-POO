package Models;

import java.sql.Timestamp;

import Database.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class Cliente{
	
	private String nome;
	private Timestamp  criadoEm;
	private int id;
	private String contato;
        private List<Servico> servico;
	
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
        
        public List<Servico> getServicos() {
		return servico;
	}
        
        public void setServicos() throws SQLException {
                ClienteDAO dao = new ClienteDAO();
		this.servico = dao.getServicos(this.id);
	}
        
        public void cadastrarServico(int idservico){
            ClienteDAO dao = new ClienteDAO();
            dao.cadastrarServico(this.id, idservico);
        }


}
