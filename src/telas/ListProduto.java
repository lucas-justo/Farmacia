package telas;

import classes.Produto;
import classes.ProdutoDAO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListProduto extends javax.swing.JInternalFrame {

  
    private JDesktopPane painelTelaInicial; 
    
    public ListProduto(){
        
    }
    
    public ListProduto( JDesktopPane painelTelaInicial ) {
        initComponents();
        carregarTabela();
        this.painelTelaInicial = painelTelaInicial;
    }

    private void carregarTabela(){
        
        String[] colunas = { "Código", "Nome", "Quantidade", "Preco", "Fabricação", "Validade", "Categoria", "Lote"};
        List<Produto> listaDeProdutos = ProdutoDAO.getProdutos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(colunas);
        
        for( Produto pro : listaDeProdutos ){
            Object[] obj = { pro.getCodigo() , pro.getNome(), pro.getQuantidade(), pro.getPreco(), pro.getFabricacao(), pro.getValidade(), pro.getCategoria(), pro.getLote() };
            modelo.addRow( obj );
        }
        
        tableProdutos.setModel( modelo );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista de Produtos");

        jLabel1.setFont(new java.awt.Font("Estrangelo Edessa", 1, 18)); // NOI18N
        jLabel1.setText("Produtos Cadastrados:");

        tableProdutos.setForeground(new java.awt.Color(204, 204, 204));
        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7", "Título 8"
            }
        ));
        tableProdutos.setPreferredSize(new java.awt.Dimension(490, 400));
        jScrollPane1.setViewportView(tableProdutos);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 494, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if( linha == -1 ){
            JOptionPane.showMessageDialog(this, 
                    "Você deve selecionar um produto!");
        }else{
            String nome = (String) tableProdutos.getValueAt(linha, 1);
            int resposta = JOptionPane.showConfirmDialog(this,
                    "Confirma a exclusão do produto " + nome + "?", 
                    "Excluir Produto", 
                    JOptionPane.YES_NO_OPTION);
            
            if( resposta == JOptionPane.YES_OPTION ){
                int codigo = (int) tableProdutos.getValueAt(linha, 0);
                Produto pro = new Produto();
                pro.setCodigo(codigo );
                ProdutoDAO.excluir( pro );
                carregarTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if( linha == -1 ){
            JOptionPane.showMessageDialog(this, 
                    "Você deve selecionar um produto!");
        }else{
            int codigo = (int) tableProdutos.getValueAt(linha, 0);
            FrmProduto formulario = new FrmProduto();
            this.painelTelaInicial.add( formulario );
            formulario.setVisible( true );
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProdutos;
    // End of variables declaration//GEN-END:variables
}