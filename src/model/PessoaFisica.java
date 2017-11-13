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
public class PessoaFisica extends Pessoa{
    private String nome,sobrenome, cpf, rg;

    public PessoaFisica() {
    }
    
    public PessoaFisica(int id, String email, String tel, String end){
        super();
        super.setId(id);
        super.setEmail(email);
        super.setTelefone(tel);
        super.setEndereco(end);
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
}
