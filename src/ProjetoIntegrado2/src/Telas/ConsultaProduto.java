/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controllers.ServicoProduto;
import DAO.ProdutoDAO;
import Model.Produto;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Rerum
 */
public class ConsultaProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaProduto
     */
    // Variáveis globais usadas na consulta Produto
    Integer codigo;
    String nome, tipo, fornecedor;

    // Variavel para alteração do produto selecionado
    // abre a tela de Cadastro
    CadastroProduto alteraProduto = null;

    //Selecionado
    String codDoProdutoSelecionado = null;

    public ConsultaProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipoDoProduto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTabelaDeProdutos = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Produto"));

        jLabel1.setText("Nome");

        jLabel2.setText("Cod.");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        jComboBoxTipoDoProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha", "Jogo", "Periférico", "Itens diversos" }));

        jLabel4.setText("Fornecedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodProduto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jTextFieldFornecedor))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTipoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTableTabelaDeProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Fornecedor", "Data Entrada", "Estoque"
            }
        ));
        jScrollPane2.setViewportView(jTableTabelaDeProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        boolean resultSearch = false;
//Verifica os campos da pesquisa e atribui seus valores as variaveis
        if (!jTextFieldCodProduto.getText().isEmpty()) {
            codigo = Integer.parseInt(jTextFieldCodProduto.getText().trim());
        }
        if (!jTextFieldNomeProduto.getText().isEmpty()) {
            nome = jTextFieldNomeProduto.getText().trim();
        } else {
            nome = "";
        }
        if (jComboBoxTipoDoProduto.getSelectedIndex() != 0) {
            tipo = (String) jComboBoxTipoDoProduto.getSelectedItem();
        } else {
            tipo = "";
        }
        if (!jTextFieldFornecedor.getText().isEmpty()) {
            fornecedor = jTextFieldFornecedor.getText().trim();
        } else {
            fornecedor = "";
        }

        try {
            resultSearch = refreshList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
        }
        
        // limpado dados do filtro após pesquisa
        jTextFieldCodProduto.setText(null);
        jTextFieldNomeProduto.setText(null);
        jComboBoxTipoDoProduto.setSelectedIndex(0);
        jTextFieldFornecedor.setText(null);
        codigo=null;
        nome=null;
        tipo=null;
        fornecedor=null;
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableTabelaDeProdutos.getModel();
        jTableTabelaDeProdutos.setModel(model);
        int coluna = 0;
        int linha = jTableTabelaDeProdutos.getSelectedRow();
        int codProduto = Integer.parseInt(jTableTabelaDeProdutos.getValueAt(linha, coluna).toString());
        
        Produto p = ProdutoDAO.selecionaProduto(codProduto);
        
        
        
        try {
             int n, i;
        if (p.getCodProduto()>0l) {
            n = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o produto selecionado?", "WARNING!", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                ServicoProduto.excluirProduto(p);
                
                i= jTableTabelaDeProdutos.getSelectedRow();
               model.removeRow(i);
                return;
            }
        }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Falha ao excluir Produto", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        TableModel model = (AbstractTableModel) jTableTabelaDeProdutos.getModel();
        jTableTabelaDeProdutos.setModel(model);
        int coluna = 0;
        int linha = jTableTabelaDeProdutos.getSelectedRow();
        int codProduto = Integer.parseInt(jTableTabelaDeProdutos.getValueAt(linha, coluna).toString());
        
        Produto p = ProdutoDAO.selecionaProduto(codProduto);
        
        // Chama tela altera produto
        if (alteraProduto == null || !alteraProduto.isVisible()) {
            alteraProduto = new CadastroProduto(p);
            this.getParent().add(alteraProduto);
            alteraProduto.setVisible(true);
        } else if (alteraProduto.isVisible()) {
            try {
                alteraProduto.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            alteraProduto.getDesktopPane().getDesktopManager().deiconifyFrame(alteraProduto);
            alteraProduto.getDesktopPane().getDesktopManager().maximizeFrame(alteraProduto);
            alteraProduto.getDesktopPane().getDesktopManager().minimizeFrame(alteraProduto);
            alteraProduto.toFront();
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    public String RetornaCodProduto() {
        return codDoProdutoSelecionado;
    }

    public boolean refreshList() throws Exception {

//        List<Produto> resultado = MockListaDeProduto.procurar(codigo, nome, tipo, fornecedor);
//    List<Produto> resultado = ServicoProduto.consultaProduto(codigo, nome, tipo, fornecedor); 
        List<Produto> resultado = ProdutoDAO.procurarProduto(codigo, nome, fornecedor, tipo);
        DefaultTableModel model = (DefaultTableModel) jTableTabelaDeProdutos.getModel();
        model.setRowCount(0);

        //        Formatar a saida da data para o padrão dd/MM/yyyy
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        for (int i = 0; i < resultado.size(); i++) {
            Produto p = resultado.get(i);
            if (p != null) {
                Object[] row = new Object[5];
                row[0] = p.getCodProduto();
                row[1] = p.getNome();
                row[2] = p.getFornecedor();
                row[3] = p.getDataCadastro();
                row[4] = p.getQuantidadeEstoque();
                model.addRow(row);
                // teste

                System.out.println("Codigo: " + p.getCodProduto() + "| Nome: " + p.getNome() + " | Fornecedor: " + p.getFornecedor()
                        + " | Tipo: " + p.getTipo() + " | Qtd: " + p.getQuantidadeEstoque() + " | Valor: " + p.getPreco());

                // teste
            }
        }

        return true;
    }
public void setPosicao(){
    Dimension d = this.getDesktopPane().getSize();
    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JComboBox<String> jComboBoxTipoDoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTabelaDeProdutos;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNomeProduto;
    // End of variables declaration//GEN-END:variables
}
