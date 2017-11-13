/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author welli
 */
public class PessoaMarciana extends Pessoa {
    private String nome, inscricao, numeroAntenas, ki;

    public PessoaMarciana() {
    }
    
    public PessoaMarciana(int id, String email, String tel, String end){
        super();
        super.setId(id);
        super.setEmail(email);
        super.setEndereco(end);
        super.setTelefone(tel);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getNumeroAntenas() {
        return numeroAntenas;
    }

    public void setNumeroAntenas(String numeroAntenas) {
        this.numeroAntenas = numeroAntenas;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    
    
    
}
