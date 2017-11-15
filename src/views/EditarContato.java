/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.ContatoDAO;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaMarciana;

/**
 *
 * @author welli
 */
public class EditarContato extends javax.swing.JFrame {

    /**
     * Creates new form EditarContato
     */
    private static int idContato;
    //PessoaFisica pf;
    //PessoaJuridica pj;
    //PessoaMarciana pm;
    /*
    *   Objetos de ArrayList que pegam dados das classes PessoaFisica, PessoaJuridica, PessoaMarciana
    *   esses dados são carregados apartir do metodo carregaDados()
    */
    ArrayList<PessoaFisica> lstPF = new ArrayList();
    ArrayList<PessoaJuridica> lstPJ = new ArrayList();
    ArrayList<PessoaMarciana> lstPM = new ArrayList();
    
    private static String tipoContato;
    public EditarContato(int i) {
        initComponents();
        idContato = i;
        rdbPM.setEnabled(false);
        rdbPJ.setEnabled(false);
        rdbPF.setEnabled(false);
    }

    private EditarContato() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*
    *   Metodo responsável por preencher as caixas de texto e alterar as labels
    *   ele é chamado assim que a janela é aberta
    */
    private void carregaDados(){
        ArrayList listinha = new ArrayList();
        tipoContato = ContatoDAO.mostrarContato(idContato, lstPF, lstPJ, lstPM); 
        
        if (tipoContato.equals("Fisica")){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Sobrenome"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("CPF"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("RG"));
            txtNome.setText(lstPF.get(0).getNome());
            txtSobrenome.setText(lstPF.get(0).getSobrenome());
            txtReg1.setText(lstPF.get(0).getCpf());
            txtReg2.setText(lstPF.get(0).getRg());
            txtEmail.setText(lstPF.get(0).getEmail());
            txtTelefone.setText(lstPF.get(0).getTelefone());
            txtEndereco.setText(lstPF.get(0).getEndereco());
        }
        else if (tipoContato.equals("Juridica")){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome Fantasia"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Razão Social"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("CNPJ"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("Razao Social"));
            txtNome.setText(lstPJ.get(0).getNome());
            txtSobrenome.setText(lstPJ.get(0).getRazaoSocial());
            txtReg1.setText(lstPJ.get(0).getCnpj());
            txtReg2.setText(lstPJ.get(0).getInsc());
            txtEmail.setText(lstPJ.get(0).getEmail());
            txtTelefone.setText(lstPJ.get(0).getTelefone());
            txtEndereco.setText(lstPJ.get(0).getEndereco());
        }
        else if (tipoContato.equals("Marciana")){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Ki (xxx)"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("Numero de antenas"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("Registro Intergalatico"));
            txtNome.setText(lstPM.get(0).getNome());
            txtSobrenome.setText(lstPM.get(0).getKi());
            txtReg1.setText(lstPM.get(0).getNumeroAntenas());
            txtReg2.setText(lstPM.get(0).getInscricao());
            txtEmail.setText(lstPM.get(0).getEmail());
            txtTelefone.setText(lstPM.get(0).getTelefone());
            txtEndereco.setText(lstPM.get(0).getEndereco());
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

        txtReg1 = new javax.swing.JTextField();
        txtReg2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnConf = new javax.swing.JButton();
        rdbPF = new javax.swing.JRadioButton();
        rdbPJ = new javax.swing.JRadioButton();
        rdbPM = new javax.swing.JRadioButton();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtReg1.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));

        txtReg2.setBorder(javax.swing.BorderFactory.createTitledBorder("RG"));

        jLabel1.setText("Tipo de contato: ");

        btnConf.setText("Atualizar");
        btnConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfMouseClicked(evt);
            }
        });
        btnConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfActionPerformed(evt);
            }
        });

        rdbPF.setText("Pessoa Fisica");
        rdbPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPFMouseClicked(evt);
            }
        });
        rdbPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPFActionPerformed(evt);
            }
        });

        rdbPJ.setText("Pessoa Juridica");
        rdbPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPJMouseClicked(evt);
            }
        });
        rdbPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPJActionPerformed(evt);
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

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtSobrenome.setBorder(javax.swing.BorderFactory.createTitledBorder("Sobrenome"));

        txtEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));

        txtTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone (xxxx-xxxx)"));

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbPF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(rdbPJ))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(rdbPM))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtReg1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtReg2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnConf)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdbPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbPJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbPM)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMouseClicked
        
        ContatoDAO.atualizarContato(idContato, txtNome.getText(), txtSobrenome.getText(), txtEndereco.getText(),
                txtTelefone.getText(), txtEmail.getText(), txtReg1.getText(), txtReg2.getText());
        
        
    }//GEN-LAST:event_btnConfMouseClicked

    private void btnConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfActionPerformed

    }//GEN-LAST:event_btnConfActionPerformed

    private void rdbPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPFMouseClicked

    }//GEN-LAST:event_rdbPFMouseClicked

    private void rdbPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPFActionPerformed

    }//GEN-LAST:event_rdbPFActionPerformed

    private void rdbPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPJMouseClicked

    }//GEN-LAST:event_rdbPJMouseClicked

    private void rdbPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPJActionPerformed

    }//GEN-LAST:event_rdbPJActionPerformed

    private void rdbPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPMMouseClicked

    }//GEN-LAST:event_rdbPMMouseClicked

    private void rdbPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPMActionPerformed

    }//GEN-LAST:event_rdbPMActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed
    
    /*
    * carrega os dados do metodo @link carregaDados();
    */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregaDados();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(EditarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarContato().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdbPF;
    private javax.swing.JRadioButton rdbPJ;
    private javax.swing.JRadioButton rdbPM;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtReg1;
    private javax.swing.JTextField txtReg2;
    private javax.swing.JTextField txtSobrenome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
