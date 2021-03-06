/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Categoria;
import classes.CategoriaDAO;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListCategoria extends javax.swing.JInternalFrame {

     private JDesktopPane painelTelaInicial; 
     
     public ListCategoria(){
        
    }
            
    public ListCategoria(JDesktopPane painelTelaInicial) {
        initComponents();
        carregarTabela();
        this.painelTelaInicial = painelTelaInicial;
    }

    private void carregarTabela(){
        
        String[] colunas = { "Código", "Nome" };
        List<Categoria> listaDeCategorias = CategoriaDAO.getCategorias();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(colunas);
        
        for( Categoria pro : listaDeCategorias ){
            Object[] obj = { pro.getCodigo() , pro.getNome() };
            modelo.addRow( obj );
        }
        
        tableCategoria.setModel( modelo );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(null);
        setClosable(true);
        setResizable(true);
        setTitle("Lista de Categorias");
        setPreferredSize(new java.awt.Dimension(780, 500));

        jLabel1.setFont(new java.awt.Font("Estrangelo Edessa", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Categoria Cadastradas:");

        tableCategoria.setForeground(new java.awt.Color(204, 204, 204));
        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableCategoria.setPreferredSize(new java.awt.Dimension(648, 400));
        jScrollPane1.setViewportView(tableCategoria);

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setText("Nova Categoria");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(204, 204, 204));
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
                        .addGap(0, 577, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            FrmCategoria formulario = new FrmCategoria();
            this.painelTelaInicial.add( formulario );
            formulario.setVisible( true );

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableCategoria.getSelectedRow();
        if( linha == -1 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar uma categoria!");
        }else{
            String nome = (String) tableCategoria.getValueAt(linha, 1);
            int resposta = JOptionPane.showConfirmDialog(this,
                "Confirma a exclusão da categoria " + nome + "?",
                "Excluir categoria",
                JOptionPane.YES_NO_OPTION);

            if( resposta == JOptionPane.YES_OPTION ){
                int codigo = (int) tableCategoria.getValueAt(linha, 0);
                Categoria pro = new Categoria();
                pro.setCodigo(codigo );
                CategoriaDAO.excluir( pro );
                carregarTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCategoria;
    // End of variables declaration//GEN-END:variables

}
