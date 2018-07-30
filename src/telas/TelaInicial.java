
package telas;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpManutencao = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menuProduto = new javax.swing.JMenuItem();
        listProduto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpManutencao.setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout jdpManutencaoLayout = new javax.swing.GroupLayout(jdpManutencao);
        jdpManutencao.setLayout(jdpManutencaoLayout);
        jdpManutencaoLayout.setHorizontalGroup(
            jdpManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        jdpManutencaoLayout.setVerticalGroup(
            jdpManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        menuCadastrar.setText("Cadastro ");
        menuCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarActionPerformed(evt);
            }
        });

        menuProduto.setText("Cadastro de Produtos");
        menuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuProduto);

        listProduto.setText("Lista de Produtos");
        listProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProdutoActionPerformed(evt);
            }
        });
        menuCadastrar.add(listProduto);

        jMenuBar1.add(menuCadastrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpManutencao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpManutencao, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarActionPerformed
           
    }//GEN-LAST:event_menuCadastrarActionPerformed

    private void menuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutoActionPerformed
FrmProduto frm = new FrmProduto();
        jdpManutencao.add( frm );
        frm.setVisible(true);         
    }//GEN-LAST:event_menuProdutoActionPerformed

    private void listProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listProdutoActionPerformed
        FrmProduto frm = new FrmProduto();
        jdpManutencao.add( frm );
        frm.setVisible(true);          
    }//GEN-LAST:event_listProdutoActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpManutencao;
    private javax.swing.JMenuItem listProduto;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuProduto;
    // End of variables declaration//GEN-END:variables
}
