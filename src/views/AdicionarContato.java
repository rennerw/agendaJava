/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.ContatoDAO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaMarciana;

/**
 *
 * @author welli
 */
public class AdicionarContato extends javax.swing.JFrame {
    PessoaFisica pf = new PessoaFisica();
    PessoaJuridica pj = new PessoaJuridica();
    PessoaMarciana pm = new PessoaMarciana();
    /**
     * Creates new form AdicionarContato
     */
    public AdicionarContato() {
        initComponents();
        //this.setVisible(true);
        rdbPF.setSelected(true);
        txtNome.setText("");
        txtSobrenome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtEmail.setText("");
        txtReg1.setText("");
        txtReg2.setText("");
        
    }
    
    private void checaSelecionado(){
        if (rdbPF.isSelected()){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Sobrenome"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("CPF"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("RG"));
        }
        if (rdbPM.isSelected()){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Ki (xxx)"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("Numero de antenas"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("Registro Intergalatico"));
        } 
        if (rdbPJ.isSelected()){
            txtNome.setBorder(BorderFactory.createTitledBorder("Nome Fantasia"));
            txtSobrenome.setBorder(BorderFactory.createTitledBorder("Razão Social"));
            txtReg1.setBorder(BorderFactory.createTitledBorder("CNPJ"));
            txtReg2.setBorder(BorderFactory.createTitledBorder("Inscricao Estadual"));
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

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        rdbPF = new javax.swing.JRadioButton();
        rdbPJ = new javax.swing.JRadioButton();
        rdbPM = new javax.swing.JRadioButton();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtReg1 = new javax.swing.JTextField();
        txtReg2 = new javax.swing.JTextField();
        btnConf = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Tipo de contato: ");

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
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        txtSobrenome.setBorder(javax.swing.BorderFactory.createTitledBorder("Sobrenome"));
        txtSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSobrenomeKeyTyped(evt);
            }
        });

        txtEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));
        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyTyped(evt);
            }
        });

        txtTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone (xx-xxxx-xxxx)"));
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyTyped(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtReg1.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        txtReg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReg1KeyTyped(evt);
            }
        });

        txtReg2.setBorder(javax.swing.BorderFactory.createTitledBorder("RG"));
        txtReg2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReg2KeyTyped(evt);
            }
        });

        btnConf.setText("Confirma");
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void rdbPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPMActionPerformed

    }//GEN-LAST:event_rdbPMActionPerformed

    private void rdbPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPJActionPerformed

    }//GEN-LAST:event_rdbPJActionPerformed

    private void rdbPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPFActionPerformed

    }//GEN-LAST:event_rdbPFActionPerformed

    private void rdbPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPMMouseClicked
        rdbPM.setSelected(true);
        rdbPF.setSelected(false);
        rdbPJ.setSelected(false);
        this.checaSelecionado();
    }//GEN-LAST:event_rdbPMMouseClicked

    private void rdbPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPJMouseClicked
        rdbPJ.setSelected(true);
        rdbPF.setSelected(false);
        rdbPM.setSelected(false);
        this.checaSelecionado();
    }//GEN-LAST:event_rdbPJMouseClicked

    private void rdbPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPFMouseClicked
        rdbPF.setSelected(true);
        rdbPM.setSelected(false);
        rdbPJ.setSelected(false);
        this.checaSelecionado();
    }//GEN-LAST:event_rdbPFMouseClicked

    private void btnConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfActionPerformed
        
    }//GEN-LAST:event_btnConfActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void btnConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMouseClicked
        if(this.verifyData()){
        }
        else{
            this.getData();
            if (rdbPF.isSelected()){
                ContatoDAO.novoContato(pf);
            }
            else if (rdbPJ.isSelected()){
                ContatoDAO.novoContato(pj);
            }
            else if (rdbPM.isSelected()){
                ContatoDAO.novoContato(pm);
            }
        }
    }//GEN-LAST:event_btnConfMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtNome.setText("");
        txtSobrenome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtEmail.setText("");
        txtReg1.setText("");
        txtReg2.setText("");
    }//GEN-LAST:event_formWindowOpened

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        int maxLengt = 60;
        if (txtNome.getText().length() > maxLengt-1){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Nome muito grande. Apenas 60 caracteres");
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtSobrenomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSobrenomeKeyTyped
        int maxLengt = 60;
        if (rdbPM.isSelected() && txtSobrenome.getText().length() > 3){
            evt.consume();
        }
        else if (txtSobrenome.getText().length() == maxLengt){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Nome muito grande. Apenas 60 caracteres");
        }
    }//GEN-LAST:event_txtSobrenomeKeyTyped

    private void txtEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyTyped
        int maxLengt = 60;
        if (txtEndereco.getText().length() == maxLengt){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Nome muito grande. Apenas 60 caracteres");
        }
    }//GEN-LAST:event_txtEnderecoKeyTyped

    private void txtTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyTyped
        int maxLengt = 13;
        if (txtTelefone.getText().length() == maxLengt){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Nome muito grande. Apenas 60 caracteres");
        }
    }//GEN-LAST:event_txtTelefoneKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        int maxLengt = 60;
        if (txtEmail.getText().length() == maxLengt){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Nome muito grande. Apenas 60 caracteres");
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtReg1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReg1KeyTyped
        int maxLenght = 30;
        if (txtReg1.getText().length() > 0 && rdbPM.isSelected()){
            evt.consume();
        }
        else if (txtReg1.getText().length() == maxLenght){
            evt.consume();
        }
    }//GEN-LAST:event_txtReg1KeyTyped

    private void txtReg2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReg2KeyTyped
        int maxLenght = 30;

        if (txtReg2.getText().length() == maxLenght){
            evt.consume();
        }
    }//GEN-LAST:event_txtReg2KeyTyped
    
    private boolean verifyData(){
        if (txtNome.getText().length() < 3){ JOptionPane.showMessageDialog(null, "Nome muito curto"); return true;}
        else if (txtNome.getText().length() > 60) {JOptionPane.showMessageDialog(null, "Nome muito grande"); return true;}
        
        if (txtSobrenome.getText().length() > 4 && rdbPM.isSelected()){JOptionPane.showMessageDialog(null, "IMPOSSÍVEL HAVER UM SER TANTO KI NO UNIVERSO!"); return true;}
        else if (txtSobrenome.getText().length() < 3){ JOptionPane.showMessageDialog(null, "Sobrenome muito curto"); return true;}
        else if (txtSobrenome.getText().length() > 60) {JOptionPane.showMessageDialog(null, "Sobrenome muito grande"); return true;}
        
        if (txtTelefone.getText().length() < 8){ JOptionPane.showMessageDialog(null, "Telefone muito curto"); return true;}
        else if (txtSobrenome.getText().length() > 15) {JOptionPane.showMessageDialog(null, "Nome muito grande"); return true;}
        
        if (txtEmail.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Email muito curto"); return true;}
        else if (txtEmail.getText().length() > 60){JOptionPane.showMessageDialog(null, "Email muito grande"); return true;}
        
        if (txtEndereco.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Endereco muito curto"); return true;}
        else if (txtEndereco.getText().length() > 60){JOptionPane.showMessageDialog(null, "Endereço muito grande"); return true;}
        
        if (txtReg1.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Campo de documento muito curto"); return true;}
        else if (txtReg1.getText().length() > 1 && rdbPM.isSelected()) {JOptionPane.showMessageDialog(null, "Não há marcianos com tudo isso de antenas"); return true;}
        else if (txtReg1.getText().length() > 30) {JOptionPane.showMessageDialog(null, "Campo de documento muito curto"); return true;}
        
        if (txtReg2.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Campo de documento muito curto"); return true;}
        else if (txtReg2.getText().length() > 30) {JOptionPane.showMessageDialog(null, "Campo de documento muito curto"); return true;}
        
        return false;
    }
    
    private void getData(){
        if (rdbPF.isSelected()){
                pf.setNome(txtNome.getText());
                pf.setSobrenome(txtSobrenome.getText());
                pf.setEndereco(txtEndereco.getText());
                pf.setEmail(txtEmail.getText());
                pf.setCpf(txtReg1.getText());
                pf.setRg(txtReg2.getText());
                pf.setTelefone(txtTelefone.getText());
            }
            else if (rdbPJ.isSelected()){
                pj.setNome(txtNome.getText());
                pj.setRazaoSocial(txtSobrenome.getText());
                pj.setEndereco(txtEndereco.getText());
                pj.setEmail(txtEmail.getText());
                pj.setCnpj(txtReg1.getText());
                pj.setInsc(txtReg2.getText());
                pj.setTelefone(txtTelefone.getText());
            }
            else if (rdbPM.isSelected()){
                pm.setNome(txtNome.getText());
                pm.setKi(txtSobrenome.getText());
                pm.setEndereco(txtEndereco.getText());
                pm.setEmail(txtEmail.getText());
                pm.setNumeroAntenas(txtReg1.getText());
                pm.setInscricao(txtReg2.getText());
                pm.setTelefone(txtTelefone.getText());
            }
    }

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
            java.util.logging.Logger.getLogger(AdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarContato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConf;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
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
