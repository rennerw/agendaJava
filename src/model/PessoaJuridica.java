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
public class PessoaJuridica extends Pessoa{
    private String nome, razaoSocial,cnpj,insc;

    public PessoaJuridica() {
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", insc=" + insc + '}';
    }
    
    public PessoaJuridica(int id, String email, String tel, String end){
        super();
        super.setId(id);
        super.setEmail(email);
        super.setEndereco(end);
        super.setTelefone(tel);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeFantasia) {
        this.nome = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
    }

    
    
    
}
