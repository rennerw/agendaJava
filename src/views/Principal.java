/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.ContatoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaMarciana;

/**
 *
 * @author welli
 */
public class Principal extends javax.swing.JFrame {

    AdicionarContato addContato = new AdicionarContato();
    //ArrayList<Pessoa> allContatos = new ArrayList();
    ArrayList<PessoaFisica> lstPF = new ArrayList();
    ArrayList<PessoaJuridica> lstPJ = new ArrayList();
    ArrayList<PessoaMarciana> lstPM = new ArrayList();
    ContatoDAO cdao = new ContatoDAO();
    
    public Principal() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaContatos.getModel();
        tabelaContatos.setRowSorter(new TableRowSorter(modelo));
        rdbAll.setSelected(true);
        txtaInstrucoes.setEditable(false);
        carregarLista();
    }
    
    /**
     * Metodo responsavel por atualizar a lista com os valores da tabela Contato
     */
    public void carregarLista(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaContatos.getModel();
        modelo.setNumRows(0);
        
        if (rdbPM.isSelected()){ 
            ContatoDAO.mostrarContatos("Marciana", lstPF, lstPJ, lstPM);
            for (int i = 0; i < lstPM.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPM.get(i).getId()),
                lstPM.get(i).getNome(),
                lstPM.get(i).getTelefone()
                });
            }
        }
        else if (rdbPF.isSelected()){ 
            ContatoDAO.mostrarContatos("Fisica", lstPF, lstPJ, lstPM);
            for (int i = 0; i < lstPF.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPF.get(i).getId()),
                lstPF.get(i).getNome(),
                lstPF.get(i).getTelefone()
                });
            }
        }
        else if (rdbPJ.isSelected()){ 
            ContatoDAO.mostrarContatos("Juridica", lstPF, lstPJ, lstPM);
            for (int i = 0; i < lstPJ.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPJ.get(i).getId()),
                lstPJ.get(i).getNome(),
                lstPJ.get(i).getTelefone()
                });
            }
        }
        else{
            ContatoDAO.mostrarContatos("all", lstPF, lstPJ, lstPM);
            for (int i = 0; i < lstPJ.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPJ.get(i).getId()),
                lstPJ.get(i).getNome(),
                lstPJ.get(i).getTelefone()
                });
            }
            for (int i = 0; i < lstPF.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPF.get(i).getId()),
                lstPF.get(i).getNome(),
                lstPF.get(i).getTelefone()
                });
            }
            for (int i = 0; i < lstPM.size(); i++){
                modelo.addRow(new Object[]{
                Integer.toString(lstPM.get(i).getId()),
                lstPM.get(i).getNome(),
                lstPM.get(i).getTelefone()
                });
            }
        }

        
    }
    
    /*
    *   Metodo responsavel por limpar a lista quando troca o radioButton
    */
    public void limparLista(){
        lstPF.clear();
        lstPJ.clear();
        lstPM.clear();
        DefaultTableModel modelo = (DefaultTableModel) tabelaContatos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        list1 = new java.awt.List();
        txtPequisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JToggleButton();
        rdbPF = new javax.swing.JRadioButton();
        rdbPJ = new javax.swing.JRadioButton();
        rdbPM = new javax.swing.JRadioButton();
        rdbAll = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaContatos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaInstrucoes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda LP3");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        txtPequisar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnPesquisar.setText("Pesq");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });

        rdbPF.setText("Pessoa Física");
        rdbPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPFMouseClicked(evt);
            }
        });

        rdbPJ.setText("Pessoa Jurídica");
        rdbPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPJMouseClicked(evt);
            }
        });

        rdbPM.setText("Pessoa Marciana");
        rdbPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPMMouseClicked(evt);
            }
        });
        rdbPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPMActionPerformed(evt);
            }
        });

        rdbAll.setText("Todos");
        rdbAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbAllMouseClicked(evt);
            }
        });

        jButton1.setText("Adicionar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Contato", "Nome", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatosMouseClicked(evt);
            }
        });
        tabelaContatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaContatosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaContatos);

        txtaInstrucoes.setColumns(20);
        txtaInstrucoes.setRows(5);
        txtaInstrucoes.setText("Instruções:\n1 - Dê duplo clique em um item da tabela para\neditar o contato referente ao item.\n2 - Pressiona delete no teclado para remover\num contato.\n3 - Depois de uma busca clique selecione a opção\nTodos para preencher a lista novamente.");
        jScrollPane1.setViewportView(txtaInstrucoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPequisar, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbAll)
                        .addGap(18, 18, 18)
                        .addComponent(rdbPF)
                        .addGap(18, 18, 18)
                        .addComponent(rdbPJ)
                        .addGap(18, 18, 18)
                        .addComponent(rdbPM)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPequisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPF)
                    .addComponent(rdbPJ)
                    .addComponent(rdbPM)
                    .addComponent(rdbAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPMActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addContato.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        addContato.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void rdbAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbAllMouseClicked
        rdbAll.setSelected(true);
        rdbPF.setSelected(false);
        rdbPM.setSelected(false);
        rdbPJ.setSelected(false);
        this.limparLista();
        this.carregarLista();
    }//GEN-LAST:event_rdbAllMouseClicked

    private void rdbPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPFMouseClicked
        rdbAll.setSelected(false);
        rdbPF.setSelected(true);
        rdbPM.setSelected(false);
        rdbPJ.setSelected(false);
        this.limparLista();
        this.carregarLista();
    }//GEN-LAST:event_rdbPFMouseClicked

    private void rdbPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPJMouseClicked
        rdbAll.setSelected(false);
        rdbPF.setSelected(false);
        rdbPM.setSelected(false);
        rdbPJ.setSelected(true);
        this.limparLista();
        this.carregarLista();
    }//GEN-LAST:event_rdbPJMouseClicked

    private void rdbPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPMMouseClicked
        rdbAll.setSelected(false);
        rdbPF.setSelected(false);
        rdbPM.setSelected(true);
        rdbPJ.setSelected(false);
        this.limparLista();
        this.carregarLista();
    }//GEN-LAST:event_rdbPMMouseClicked

    private void tabelaContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatosMouseClicked
        if (evt.getClickCount() == 2){
            JTable modelo = (JTable) tabelaContatos;
            int linha = modelo.getSelectedRow();
            int n;
            n = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
            EditarContato e = new EditarContato(n);
            //txtPequisar.setText(Integer.toString(n));
            e.setVisible(true);
        }
    }//GEN-LAST:event_tabelaContatosMouseClicked

    private void tabelaContatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaContatosKeyPressed
        if (evt.getKeyCode() == 127){
            //Object[] opc = { "Confirmar", "Cancelar" };
            int i =   JOptionPane.showConfirmDialog(this, "Apagar contato para sempre?", "ATENÇÃO!", YES_NO_OPTION, QUESTION_MESSAGE);
            
            if (JOptionPane.YES_OPTION == i){
                JTable modelo = (JTable) tabelaContatos;
                int linha = modelo.getSelectedRow();
                int n;
                n = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
                ContatoDAO.deletarContato(n);
                this.limparLista();
                this.carregarLista();
            }
            else{
                System.out.println("nada");
            }
            
        }
    }//GEN-LAST:event_tabelaContatosKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == 116){
            this.limparLista();
            this.carregarLista();
        }
    }//GEN-LAST:event_formKeyPressed

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) tabelaContatos.getModel();
        modelo.setNumRows(0);
        this.limparLista();
        if (txtPequisar.getText().isEmpty()){
            this.carregarLista();
        }
        else{
        limparLista();
        ContatoDAO.buscarNome(txtPequisar.getText(), lstPF, lstPJ, lstPM, "all");
        if (rdbAll.isSelected()){
            
            for (int i = 0; i < lstPJ.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPJ.get(i).getId()),
                    lstPJ.get(i).getNome(),
                    lstPJ.get(i).getTelefone()
                    });

                }
                for (int i = 0; i < lstPF.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPF.get(i).getId()),
                    lstPF.get(i).getNome(),
                    lstPF.get(i).getTelefone()
                    });
                }
                for (int i = 0; i < lstPM.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPM.get(i).getId()),
                    lstPM.get(i).getNome(),
                    lstPM.get(i).getTelefone()
                    });
                }
        }
        else if(rdbPF.isSelected()){
            limparLista();
            ContatoDAO.buscarNome(txtPequisar.getText(), lstPF, lstPJ, lstPM, "PF");
            modelo.setNumRows(0);
            for (int i = 0; i < lstPF.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPF.get(i).getId()),
                    lstPF.get(i).getNome(),
                    lstPF.get(i).getTelefone()
                    });
                }
        }
        else if(rdbPJ.isSelected()){
            limparLista();
            ContatoDAO.buscarNome(txtPequisar.getText(), lstPF, lstPJ, lstPM, "PJ");
            
            for (int i = 0; i < lstPJ.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPJ.get(i).getId()),
                    lstPJ.get(i).getNome(),
                    lstPJ.get(i).getTelefone()
                    });
                }
        }
        else if(rdbPM.isSelected()){
            limparLista();
            ContatoDAO.buscarNome(txtPequisar.getText(), lstPF, lstPJ, lstPM, "PM");
            
            for (int i = 0; i < lstPM.size(); i++){
                    modelo.addRow(new Object[]{
                    Integer.toString(lstPM.get(i).getId()),
                    lstPM.get(i).getNome(),
                    lstPM.get(i).getTelefone()
                    });
                }
        } 
        }
        
    }//GEN-LAST:event_btnPesquisarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.List list1;
    private javax.swing.JRadioButton rdbAll;
    private javax.swing.JRadioButton rdbPF;
    private javax.swing.JRadioButton rdbPJ;
    private javax.swing.JRadioButton rdbPM;
    private javax.swing.JTable tabelaContatos;
    private javax.swing.JTextField txtPequisar;
    private javax.swing.JTextArea txtaInstrucoes;
    // End of variables declaration//GEN-END:variables
}
