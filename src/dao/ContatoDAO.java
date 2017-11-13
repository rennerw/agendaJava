/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaMarciana;
import views.Principal;

/**
 *
 * @author welli
 */
public class ContatoDAO {
    
    public static void novoContato(PessoaFisica pf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO pf (id, nome, sobrenome, endereco, telefone, email, doc1, doc2)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, 0);
            stmt.setString(2,pf.getNome());
            stmt.setString(3,pf.getSobrenome());
            stmt.setString(4,pf.getEndereco());
            stmt.setString(5,pf.getTelefone());
            stmt.setString(6,pf.getEmail());
            stmt.setString(7,pf.getCpf());
            stmt.setString(8,pf.getRg());
            stmt.executeUpdate();
            stmt = con.prepareCall("call mudarId_PF");
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void novoContato(PessoaJuridica pj){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO pj (id, nome, sobrenome, endereco, telefone, email, doc1, doc2)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, 0);
            stmt.setString(2,pj.getNome());
            stmt.setString(3,pj.getRazaoSocial());
            stmt.setString(4,pj.getEndereco());
            stmt.setString(5,pj.getTelefone());
            stmt.setString(6,pj.getEmail());
            stmt.setString(7,pj.getCnpj());
            stmt.setString(8,pj.getInsc());
            stmt.executeUpdate();
            stmt = con.prepareCall("call mudarId_PJ");
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void novoContato(PessoaMarciana pm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO pm (id,nome, sobrenome, endereco, telefone, email, doc1, doc2)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, 0);
            stmt.setString(2,pm.getNome());
            stmt.setString(3,pm.getKi());
            stmt.setString(4,pm.getEndereco());
            stmt.setString(5,pm.getTelefone());
            stmt.setString(6,pm.getEmail());
            stmt.setString(7,pm.getNumeroAntenas());
            stmt.setString(8,pm.getInscricao());
            stmt.executeUpdate();
            stmt = con.prepareCall("call mudarId_PM");
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }
        catch (SQLException ex) {
            if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
            else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void mostrarContatos(String s, ArrayList lstpf, ArrayList lstpj, ArrayList lstpm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (s.equals("all")){
            try {
                stmt = con.prepareStatement("SELECT * from verTodos order by id");
                rs = stmt.executeQuery();
                
                while (rs.next()){
                    if ("Fisica".equals(rs.getString("tipoContato"))){
                        PessoaFisica pf = new PessoaFisica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pf.setNome(rs.getString("nome"));
                        pf.setSobrenome(rs.getString("sobrenome"));
                        pf.setCpf(rs.getString("doc1"));
                        pf.setRg(rs.getString("doc2"));
                        lstpf.add(pf);
                    }
                    if ("Juridica".equals(rs.getString("tipoContato"))){
                        PessoaJuridica pj = new PessoaJuridica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pj.setNome(rs.getString("nome"));
                        pj.setRazaoSocial(rs.getString("sobrenome"));
                        pj.setCnpj(rs.getString("doc1"));
                        pj.setInsc(rs.getString("doc2"));
                        lstpj.add(pj);
                    }
                    if ("Marciana".equals(rs.getString("tipoContato"))){
                        PessoaMarciana pm = new PessoaMarciana(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pm.setNome(rs.getString("nome"));
                        pm.setKi(rs.getString("sobrenome"));
                        pm.setNumeroAntenas(rs.getString("doc1"));
                        pm.setInscricao(rs.getString("doc2"));
                        lstpm.add(pm);
                    }
                }
            } 
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
        if (s.equals("Fisica")){
            try {
                stmt = con.prepareStatement("SELECT * from pf");
                rs = stmt.executeQuery();
                
                while (rs.next()){
                        PessoaFisica pf = new PessoaFisica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pf.setNome(rs.getString("nome"));
                        pf.setSobrenome(rs.getString("sobrenome"));
                        pf.setCpf(rs.getString("doc1"));
                        pf.setRg(rs.getString("doc2"));
                        lstpf.add(pf);
                }
            }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
        if (s.equals("Juridica")){
            try {
                stmt = con.prepareStatement("SELECT * from pj");
                rs = stmt.executeQuery();
                
                while (rs.next()){
                        PessoaJuridica pj = new PessoaJuridica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pj.setNome(rs.getString("nome"));
                        pj.setRazaoSocial(rs.getString("sobrenome"));
                        pj.setCnpj(rs.getString("doc1"));
                        pj.setInsc(rs.getString("doc2"));
                        lstpj.add(pj);
                }
            }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        
        if (s.equals("Marciana")){
            try {
                stmt = con.prepareStatement("SELECT * from pm");
                rs = stmt.executeQuery();
                
                while (rs.next()){
                        PessoaMarciana pm = new PessoaMarciana(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pm.setNome(rs.getString("nome"));
                        pm.setKi(rs.getString("sobrenome"));
                        pm.setNumeroAntenas(rs.getString("doc1"));
                        pm.setInscricao(rs.getString("doc2"));
                        lstpm.add(pm);
                }
            }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
    }
    
    /*
        Mostra o contato escolhido na seleção
    */
    public static String mostrarContato(int num, ArrayList lstpf, ArrayList lstpj, ArrayList lstpm){
        Connection con = ConnectionFactory.getConnection();
        ArrayList listinha = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
                stmt = con.prepareStatement("SELECT distribuidorID.nada from distribuidorID where distribuidorID.id = ?");
                stmt.setInt(1,num);
                rs1 = stmt.executeQuery();
                while (rs1.next()){
                if (rs1.getString("distribuidorID.nada").equals("f")){
                    stmt = con.prepareStatement("SELECT * from pf where pf.id = ?");
                    stmt.setInt(1,num);
                    rs = stmt.executeQuery();
                    PessoaFisica pf = null;
                    while (rs.next()){
                    pf = new PessoaFisica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                    pf.setNome(rs.getString("nome"));
                    pf.setSobrenome(rs.getString("sobrenome"));
                    pf.setCpf(rs.getString("doc1"));
                    pf.setRg(rs.getString("doc2"));
                    }
                    lstpf.add(pf);
                    return "Fisica";
                }
                else if (rs1.getString("distribuidorID.nada").equals("j")){
                    stmt = con.prepareStatement("SELECT * from pj where pj.id = ?");
                    stmt.setInt(1,num);
                    rs = stmt.executeQuery();
                    PessoaJuridica pj = null;
                    while (rs.next()){
                    pj = new PessoaJuridica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                    pj.setNome(rs.getString("nome"));
                    pj.setRazaoSocial(rs.getString("sobrenome"));
                    pj.setCnpj(rs.getString("doc1"));
                    pj.setInsc(rs.getString("doc2")); 
                    }
                    lstpj.add(pj);
                    return "Juridica";
                }
                else if (rs1.getString("distribuidorID.nada").equals("m")){
                    stmt = con.prepareStatement("SELECT * from pm where pm.id = ?");
                    stmt.setInt(1,num);
                    rs = stmt.executeQuery();
                    PessoaMarciana pm = null;
                    while (rs.next()){
                    pm = new PessoaMarciana(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                    pm.setNome(rs.getString("nome"));
                    pm.setKi(rs.getString("sobrenome"));
                    pm.setNumeroAntenas(rs.getString("doc1"));
                    pm.setInscricao(rs.getString("doc2"));
                    
                    }
                    lstpm.add(pm);
                    return "Marciana";
                }
            }
        }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        return "";
    }
    
    public static void atualizarContato(int num, String n, String sn, String end, String tel, String email, String doc1, String doc2){
        Connection con = ConnectionFactory.getConnection();
        ArrayList listinha = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
                stmt = con.prepareStatement("SELECT distribuidorID.nada from distribuidorID where distribuidorID.id = ?");
                stmt.setInt(1,num);
                rs1 = stmt.executeQuery();
                while (rs1.next()){
                if (rs1.getString("distribuidorID.nada").equals("f")){
                    stmt = con.prepareStatement("UPDATE pf set nome = ?, sobrenome = ?, endereco = ?,telefone = ?, email = ?, doc1 = ?, doc2 = ? where id = ?");
                    stmt.setString(1,n);
                    stmt.setString(2,sn);
                    stmt.setString(3,end);
                    stmt.setString(4,tel);
                    stmt.setString(5,email);
                    stmt.setString(6,doc1);
                    stmt.setString(7,doc2);
                    stmt.setInt(8,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Universo agradece sua atualização\n");
                }
                else if (rs1.getString("distribuidorID.nada").equals("j")){
                    stmt = con.prepareStatement("UPDATE pj set nome = ?, sobrenome = ?, endereco = ?,telefone = ?, email = ?, doc1 = ?, doc2 = ? where id = ?");
                    stmt.setString(1,n);
                    stmt.setString(2,sn);
                    stmt.setString(3,end);
                    stmt.setString(4,tel);
                    stmt.setString(5,email);
                    stmt.setString(6,doc1);
                    stmt.setString(7,doc2);
                    stmt.setInt(8,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Universo agradece sua atualização\n");
                }
                else if (rs1.getString("distribuidorID.nada").equals("m")){
                    stmt = con.prepareStatement("UPDATE pm set nome = ?, sobrenome = ?, endereco = ?,telefone = ?, email = ?, doc1 = ?, doc2 = ? where id = ?");
                    stmt.setString(1,n);
                    stmt.setString(2,sn);
                    stmt.setString(3,end);
                    stmt.setString(4,tel);
                    stmt.setString(5,email);
                    stmt.setString(6,doc1);
                    stmt.setString(7,doc2);
                    stmt.setInt(8,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Universo agradece sua atualização\n");
                    }
                }
        }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!\n"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
    }
    
    public static void deletarContato(int num){
    Connection con = ConnectionFactory.getConnection();
        ArrayList listinha = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
                stmt = con.prepareStatement("SELECT distribuidorID.nada from distribuidorID where distribuidorID.id = ?");
                stmt.setInt(1,num);
                rs1 = stmt.executeQuery();
                while (rs1.next()){
                if (rs1.getString("distribuidorID.nada").equals("f")){
                    stmt = con.prepareStatement("DELETE from pf where id = ?");
                    stmt.setInt(1,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Contato removido!\n");
                }
                else if (rs1.getString("distribuidorID.nada").equals("j")){
                    stmt = con.prepareStatement("DELETE from pj where id = ?");
                    stmt.setInt(1,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Contato removido!\n");
                }
                else if (rs1.getString("distribuidorID.nada").equals("m")){
                    stmt = con.prepareStatement("DELETE from pm where id = ?");
                    stmt.setInt(1,num);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Contato removido!\n");
                }
                }
        }
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!\n"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
    }
    
    public static void buscarNome(String nome, ArrayList lstpf, ArrayList lstpj, ArrayList lstpm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
            try {
                String sql = "SELECT * FROM verTodos where nome like ?";
   		stmt = con.prepareStatement(sql);
   		stmt.setString(1, "%"+nome+"%");
                rs = stmt.executeQuery();
                
                while (rs.next()){
                    if (rs.getString("tipoContato").equals("Fisica")){
                        PessoaFisica pf = new PessoaFisica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pf.setNome(rs.getString("nome"));
                        pf.setSobrenome(rs.getString("sobrenome"));
                        pf.setCpf(rs.getString("doc1"));
                        pf.setRg(rs.getString("doc2"));
                        lstpf.add(pf);
                    }
                    if (rs.getString("tipoContato").equals("Juridica")){
                        PessoaJuridica pj = new PessoaJuridica(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pj.setNome(rs.getString("nome"));
                        pj.setRazaoSocial(rs.getString("sobrenome"));
                        pj.setCnpj(rs.getString("doc1"));
                        pj.setInsc(rs.getString("doc2"));
                        lstpj.add(pj);
                    }
                    if (rs.getString("tipoContato").equals("Marciana")){
                        PessoaMarciana pm = new PessoaMarciana(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"));
                        pm.setNome(rs.getString("nome"));
                        pm.setKi(rs.getString("sobrenome"));
                        pm.setNumeroAntenas(rs.getString("doc1"));
                        pm.setInscricao(rs.getString("doc2"));
                        lstpm.add(pm);
                    }
                }
            } 
            catch (SQLException ex) {
                if (ex.getErrorCode() == 1406) JOptionPane.showMessageDialog(null, "O campo é muito grande");
                else JOptionPane.showMessageDialog(null, "Marcianos farão o desenvolvedor pagar por esse erro!"+ex);
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
}
