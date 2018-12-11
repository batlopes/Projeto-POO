/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import Database.ServicoDAO;
import Models.Servico;

/**
 *
 * @author 2017007379
 */
public class BarberApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servico servico = new Servico();
        servico.setDescricao("Corte sem tesoura");
        servico.setPreco(20.00f);
        servico.setTempo(0.5f);
        ServicoDAO dao = new ServicoDAO();
        dao.adiciona(servico);
    }
    
}
