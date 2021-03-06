package Telas;

import Controllers.ServicoProduto;
import Exceptions.DataSourceException;
import Exceptions.productException;
import Model.DataHoje;
import Model.Produto;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Rerum
 */
public class CadastroProduto extends javax.swing.JInternalFrame {

    //Criando objeto que retorna a data atual.
    DataHoje data = new DataHoje();

    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
        initComponents();
    }

    public CadastroProduto(Produto produto) {
        initComponents();

        // inicializando os campos com os dados do Produto
        
        cpId.setText(String.valueOf(produto.getId()));
        cpCodigo.setText(String.valueOf(produto.getCodProduto()));
        cpNome.setText(produto.getNome());
        cpFornecedor.setText(produto.getFornecedor());
        cpQtde.setText(String.valueOf(produto.getQuantidadeEstoque()));
        cpValor.setText(String.valueOf(produto.getPreco()));
        cbTipo.setSelectedItem(produto.getTipo());
        cbPlataforma.setSelectedItem(produto.getPlataforma());
        jTextArea1.setText(produto.getDescricao());
        
        cpCodigo.setEditable(false);
        

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbPlataforma = new javax.swing.JComboBox<>();
        jLabelCodigo = new javax.swing.JLabel();
        cpCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpFornecedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cpQtde = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cpValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        cpId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro Produto");

        jLabel6.setText("Tipo*");

        jLabel7.setText("Plataforma");

        cbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha", "Nintendo Switch", "PC", "Playstation 3", "Playstation 4", "Xbox 360", "Xbox One", "Wii", "Wii U" }));
        cbPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlataformaActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Código");

        cpCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpCodigoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data");

        jTextField3.setEditable(false);
        jTextField3.setText(data.getDataAtual());
        jTextField3.setCaretColor(new java.awt.Color(153, 153, 153));
        jTextField3.setEnabled(false);

        jLabel2.setText("Nome*");

        jLabel4.setText("Fornecedor*");

        jLabel5.setText("Descrição");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha", "Jogo", "Periférico", "Itens diversos" }));

        jLabel8.setText("Quantidade*");

        jLabel9.setText("Valor*");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel10.setText("Campos obrigatórios *");

        jButtonSave.setText(" Salvar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        cpId.setEditable(false);
        cpId.setAutoscrolls(false);
        cpId.setEnabled(false);
        cpId.setMaximumSize(new java.awt.Dimension(0, 0));
        cpId.setMinimumSize(new java.awt.Dimension(0, 0));
        cpId.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpNome, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(cpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cpFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpValor, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(cpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cpFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cpQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cpValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addGap(19, 19, 19)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPlataformaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboxPlataformaActionPerformed
    private void jbuttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbuttonCancelActionPerformed

    private void cpCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        //Novo objeto
        Produto p = new Produto();

        //dados do objeto
        try {
            p.setId(Integer.parseInt(cpId.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        try {
            p.setCodProduto(Integer.parseInt(cpCodigo.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        try {
            p.setNome(cpNome.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setFornecedor(cpFornecedor.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setPreco(Float.parseFloat(cpValor.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setDataCadastro(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setPlataforma((String) cbPlataforma.getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setDescricao(jTextArea1.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setTipo((String) cbTipo.getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        try {
            p.setQuantidadeEstoque(Integer.parseInt(cpQtde.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        //gravando o objeto na lista
        try {
            if(!cpId.getText().equals("") || !cpId.getText().isEmpty()){
                ServicoProduto.atualizaProduto(p);
                JOptionPane.showMessageDialog(rootPane, "Produto atualizado com sucesso!");
            }else{
            ServicoProduto.cadastroProduto(p);//chama serviço para adicionar produtos.
            JOptionPane.showMessageDialog(rootPane, "Produto cadastrado com sucesso!");
            }
        } catch (DataSourceException | productException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, e, "Erro, ", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //limpar a tela após gravar
        cbPlataforma.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
        cpCodigo.setText("");
        cpFornecedor.setText("");
        cpNome.setText("");
        cpQtde.setText("");
        cpValor.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        int n;
        if (!cpCodigo.equals("")) {
            n = JOptionPane.showConfirmDialog(rootPane, "Deseja sair sem salvar as informações?", "WARNING!", JOptionPane.YES_NO_OPTION);
            if (n != 0) {
                return;
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    public void setPosicao(){
    Dimension d = this.getDesktopPane().getSize();
    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPlataforma;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JTextField cpCodigo;
    private javax.swing.JTextField cpFornecedor;
    private javax.swing.JTextField cpId;
    private javax.swing.JTextField cpNome;
    private javax.swing.JTextField cpQtde;
    private javax.swing.JTextField cpValor;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
