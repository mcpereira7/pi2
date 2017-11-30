/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controllers.ServicoCliente;
import Controllers.ServicoProduto;
import Controllers.ServicoVenda;
import Exceptions.DataSourceException;
import Exceptions.VendaException;
import Exceptions.productException;
import Model.Cliente;
import Model.DataHoje;
import Model.Produto;
import Model.Venda;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author Rerum
 */
public class Vendas extends javax.swing.JInternalFrame {

    //Criando objeto que retorna a data atual.
    DataHoje data = new DataHoje();
    //Consulta de cliente
    TesteDialog telaConsulta = null;
    //Cliente da venda
    Cliente clienteVenda = new Cliente();
    //Produto a ser add
    Produto produtoVenda = new Produto();
    //O objeto da Venda
    Venda carrinho = new Venda();
    int codigo = 0;

    //Lista de Produtos
    List<Produto> listaDosProduto = new ArrayList<>();

    //TOTAL
    double TOTAL = 0;

//Telas
    ConsultaProduto consultaProduto = null;
    ConsultaCliente consultaCliente = null;

    /**
     * Creates new form Vendas
     */
    public Vendas() {
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

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigoVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutosNaVenda = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabelTOTAL = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConsultaCliente = new javax.swing.JButton();
        jTextCodProduto = new javax.swing.JTextField();
        jButtonConsultaProduto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonAdicionarNaVenda = new javax.swing.JButton();
        jLabelData = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Venda");
        setMinimumSize(new java.awt.Dimension(540, 380));
        setPreferredSize(new java.awt.Dimension(540, 380));

        jLabel1.setText("Código");

        jTextFieldCodigoVenda.setEditable(false);

        jLabel2.setText("Data");

        jLabel4.setText("Cliente");

        jTextFieldNomeCliente.setToolTipText("Nome do cliente");

        jLabel5.setText("Produto");

        jTableProdutosNaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Produto", "Descrição", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(jTableProdutosNaVenda);

        jLabel6.setText("Total");

        jLabelTOTAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarVenda(evt);
            }
        });

        jButtonConsultaCliente.setText("Verificar Cliente");
        jButtonConsultaCliente.setToolTipText("Verifica o cadastro do cliente");
        jButtonConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaClienteActionPerformed(evt);
            }
        });

        jButtonConsultaProduto.setText("Verificar Produto");
        jButtonConsultaProduto.setToolTipText("Verifica o código do produto");
        jButtonConsultaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaProdutoActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantidade");

        jButtonAdicionarNaVenda.setText("Adicionar a venda");
        jButtonAdicionarNaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarNaVendaActionPerformed(evt);
            }
        });

        jLabelData.setText(data.getDataAtual());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelData))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextCodProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultaProduto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldNomeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultaCliente)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFinalizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar)
                            .addComponent(jLabelTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionarNaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelData))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultaCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultaProduto)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAdicionarNaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelTOTAL, jTextCodProduto, jTextFieldCodigoVenda, jTextFieldNomeCliente, jTextFieldQuantidade});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdicionarNaVenda, jButtonCancelar, jButtonConsultaCliente, jButtonConsultaProduto, jButtonFinalizar});

        jTextFieldCodigoVenda.setText(GerarCodigoVenda());
        jButtonConsultaProduto.getAccessibleContext().setAccessibleDescription("Consultar produtos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarVenda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarVenda
        try {
            // TODO add your handling code here:
            Object[] opcoes = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(rootPane,
                    "Você deseja cancelar a venda?",
                    "Cancelar", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes,
                    opcoes[0]) == 0) {
                setClosed(true);
            }

        } catch (PropertyVetoException ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelarVenda

    private void jButtonConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaClienteActionPerformed
        // TODO add your handling code here:
        try {
            if (!jTextFieldNomeCliente.getText().isEmpty()) {
                if (ServicoCliente.obterCliente(jTextFieldNomeCliente.getText()) != null) {
                    clienteVenda = ServicoCliente.obterClienteByNome(jTextFieldNomeCliente.getText());
                    JOptionPane.showMessageDialog(rootPane, "Cliente validado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Insira o nome do cliente.");
            }
        } catch (DataSourceException ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultaClienteActionPerformed

    private void jButtonConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaProdutoActionPerformed
        // TODO add your handling code here:
        try {
            if (produtoVenda != null) {
                ApagaProduto();
                if (!jTextCodProduto.getText().isEmpty() || !jTextFieldQuantidade.getText().isEmpty()) {
                    if (isParsable(jTextCodProduto.getText()) && isParsable(jTextFieldQuantidade.getText())) {
                        produtoVenda = ServicoProduto.getProdutoByCodProduto(jTextCodProduto.getText());
                        int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
                        produtoVenda.setQuantidadeVenda(quantidade);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Digite um código valido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Insira o código do produto.");
                }
            } else {
                if (!jTextCodProduto.getText().isEmpty() || !jTextFieldQuantidade.getText().isEmpty()) {
                    if (isParsable(jTextCodProduto.getText()) && isParsable(jTextFieldQuantidade.getText())) {
                        produtoVenda = ServicoProduto.getProdutoByCodProduto(jTextCodProduto.getText());
                        int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
                        produtoVenda.setQuantidadeVenda(quantidade);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Digite um código valido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Insira o código do produto.");
                }
            }
        } catch (productException | HeadlessException e) {
        }
    }//GEN-LAST:event_jButtonConsultaProdutoActionPerformed

    private void jButtonAdicionarNaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarNaVendaActionPerformed
        // TODO add your handling code here:
        try {
            if (!isProductValidated(produtoVenda)) {
                JOptionPane.showMessageDialog(rootPane, "Preencha as informações do produto.");
            } else {
                PopulaVenda(produtoVenda);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro", e.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarNaVendaActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        try {
            // TODO add your handling code here:
            Calendar dataCal = Calendar.getInstance();
            carrinho.setDataVenda(dataCal);
            carrinho.setCliente(clienteVenda);
            ServicoVenda.ConcluirVenda(carrinho);
            JOptionPane.showMessageDialog(rootPane, "Teste");
        } catch (VendaException ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

    public boolean isProductValidated(Produto naVenda) {
        if (naVenda.getQuantidadeVenda() == 0 || naVenda.getCodProduto() == 0
                || naVenda.getPreco() == 0) {
            return false;
        } else if (naVenda.getQuantidadeEstoque() < naVenda.getQuantidadeVenda()) {
            JOptionPane.showMessageDialog(rootPane, naVenda.getQuantidadeEstoque() + " " + naVenda.getNome() + " em estoque");
            return false;
        } else {
            return true;
        }
    }

    public String GerarCodigoVenda() {
        codigo = ServicoVenda.geraCodVenda();
        return Integer.toString(codigo);
    }
    
    public void ApagaProduto() {
        produtoVenda = null;
    }

    public void PopulaVenda(Produto novo) {
        //Adiciona produto a venda
        try {

            carrinho.setProdutoNaLista(novo);
            DefaultTableModel model = (DefaultTableModel) jTableProdutosNaVenda.getModel();
            Object[] row = new Object[5];
            row[0] = novo.getCodProduto();
            row[1] = novo.getDescricao();
            row[2] = novo.getQuantidadeVenda();
            row[3] = round(novo.getPreco(), 2);
            row[4] = novo.getQuantidadeVenda() * round(novo.getPreco(), 2);
            model.addRow(row);
            CalculaTotal(novo.getQuantidadeVenda() * round(novo.getPreco(), 2));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro", e.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CalculaTotal(double valor) {
        TOTAL += valor;
        String totalSTR = Double.toString(round(TOTAL, 2));
        jLabelTOTAL.setText(totalSTR);
    }

    public void showConsultaProduto() {
        if (consultaProduto == null || !consultaProduto.isVisible()) {
            try {
                consultaProduto = new ConsultaProduto();
                getParent().add(consultaProduto);
                consultaProduto.setVisible(true);
                String retornoProd = consultaProduto.RetornaCodProduto();
                produtoVenda = ServicoProduto.getProdutoByCodProduto(retornoProd);
            } catch (productException ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (consultaProduto.isVisible()) {
            try {
                consultaProduto.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            consultaProduto.getDesktopPane().getDesktopManager().deiconifyFrame(consultaProduto);
            consultaProduto.getDesktopPane().getDesktopManager().maximizeFrame(consultaProduto);
            consultaProduto.getDesktopPane().getDesktopManager().minimizeFrame(consultaProduto);
            consultaProduto.toFront();
        }
        jTextCodProduto.setText(produtoVenda.getNome());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarNaVenda;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultaCliente;
    private javax.swing.JButton jButtonConsultaProduto;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelTOTAL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutosNaVenda;
    private javax.swing.JTextField jTextCodProduto;
    private javax.swing.JTextField jTextFieldCodigoVenda;
    private static javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
