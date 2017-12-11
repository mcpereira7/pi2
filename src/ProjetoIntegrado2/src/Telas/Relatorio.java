/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Model.Venda;
import Model.Cliente;
import Controllers.ServicoVenda;
import Model.ItensVenda;
import Model.Produto;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ultrabook HP
 */
public class Relatorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form Relatorio
     */
    public Relatorio() {
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        OrderButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FieldDataInicial = new javax.swing.JFormattedTextField();
        FieldDataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        OrderComboBox = new javax.swing.JComboBox<>();
        AscRadioButton = new javax.swing.JRadioButton();
        DescRadioButton = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReport = new javax.swing.JTable();

        jFormattedTextField1.setText("jFormattedTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Relatório");

        jLabel1.setText("Data de");

        jLabel2.setText("Até");

        jLabel3.setText("* range máximo de 30 dias");

        FieldDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        FieldDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel4.setText("Gerar Relatório de Vendas:");

        jButtonGerarRelatorio.setText("Gerar Relatório");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por"));

        OrderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data", "Cliente", "Produto", "Preço", "Quantidade", "Total" }));

        OrderButtonGroup.add(AscRadioButton);
        AscRadioButton.setText("Asc.");

        OrderButtonGroup.add(DescRadioButton);
        DescRadioButton.setText("Desc.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(OrderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AscRadioButton)
                .addGap(18, 18, 18)
                .addComponent(DescRadioButton)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(OrderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AscRadioButton)
                    .addComponent(DescRadioButton)))
        );

        tableReport.setAutoCreateRowSorter(true);
        tableReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Cliente", "Produto", "Preço", "Quantidade", "Total"
            }
        ));
        jScrollPane2.setViewportView(tableReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(FieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))))
                                .addGap(17, 17, 17)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonGerarRelatorio)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        //Obtém as datas configuradas no relatório

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dataIni = (Date) FieldDataInicial.getValue();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(dataIni.getTime());
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        dataIni = calendar1.getTime();

        Date dataFim = (Date) FieldDataFinal.getValue();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(dataFim.getTime());
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);

        dataFim = calendar2.getTime();

        double totalVenda = 0;
        double totalGeral = 0;

        try {
            String campoOrdem = "";
            switch (OrderComboBox.getSelectedItem().toString()) {
                case "Data":
                    campoOrdem = "Data";
                case "Cliente":
                    campoOrdem = "idCliente";
            }

            List<Venda> listaRelatorio = ServicoVenda.ConsultaVendaRelatorio(dataIni, dataFim,
                    OrderComboBox.getSelectedItem().toString(), AscRadioButton.isSelected());

            if (listaRelatorio == null || listaRelatorio.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Não há dados "
                        + "de reserva para exibição do relatório", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel modelRelatorio = (DefaultTableModel) tableReport.getModel();
            modelRelatorio.setRowCount(0);

            double total = 0;
            for (Venda venda : listaRelatorio) {
                Cliente clienteVenda = venda.getCliente();

                if (clienteVenda != null) {
                    //Se um cliente foi definido, monta uma linha da tabela
                    //para exibição de seu nome e a adiciona na tabela
                    Object[] linhaVenda = new Object[6];
                    String stringCliente = clienteVenda.getCodCliente() + " - " + clienteVenda.getNome();
                    linhaVenda[0] = new SimpleDateFormat("dd/MM/yyyy").format(venda.getDataVenda().getTime());
                    linhaVenda[1] = stringCliente;
                    modelRelatorio.addRow(linhaVenda);
                }

                //Obtém a lista de itens de reserva
                List<ItensVenda> listaProdutos = DAO.VendaDAO.getItensVenda(venda.getId());
                //Verifica se há itens de reserva antes de iterá-los
                if (listaProdutos != null || !listaProdutos.isEmpty()) {
                    //Itera pelos itens de reserva
                    for (ItensVenda item : listaProdutos) {

                        Produto p = DAO.ProdutoDAO.procurarProdutoById(item.getCodProduto());

                        Object[] linhaItem = new Object[6];

                        String prod = p.getCodProduto() + " - " + p.getNome();

                        linhaItem[2] = prod;
                        linhaItem[3] = round(item.getPreco(), 2);
                        linhaItem[4] = item.getQuantidade();
                        linhaItem[5] = round((item.getPreco() * item.getQuantidade()), 2);
                        totalVenda += (double) linhaItem[5];

                        modelRelatorio.addRow(linhaItem);
                    }
                }

                Object[] linhaTotalPedido = new Object[6];
                linhaTotalPedido[4] = "Total Pedido:";
                linhaTotalPedido[5] = totalVenda;
                totalGeral += totalVenda;
                totalVenda = 0;
                modelRelatorio.addRow(linhaTotalPedido);

                Object[] linhaBranca = new Object[6];
                modelRelatorio.addRow(linhaBranca);
            }

            Object[] linhaTotal = new Object[6];
            linhaTotal[4] = "Total Geral";
            linhaTotal[5] = totalGeral;
            modelRelatorio.addRow(linhaTotal);
        } catch (Exception e) {
            //Trata caso aconteça algum erro de fonte de dados (ou outro)
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro", e.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

//Não me lembro o que tinha que fazer com isso  (:

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AscRadioButton;
    private javax.swing.JRadioButton DescRadioButton;
    private javax.swing.JFormattedTextField FieldDataFinal;
    private javax.swing.JFormattedTextField FieldDataInicial;
    private javax.swing.ButtonGroup OrderButtonGroup;
    private javax.swing.JComboBox<String> OrderComboBox;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableReport;
    // End of variables declaration//GEN-END:variables
}
