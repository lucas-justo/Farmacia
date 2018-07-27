
package classes;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classes.Produto;


public class ProdutoDAO {
    
    public static boolean inserir(Produto produto){
       
        String sql = "INSERT INTO produtos "
            + " ( nome, quantidade, preco , lote , fabricacao, validade , codCategoria ) "
            + " VALUES ( "
            + " '" + produto.getNome()                  + "' , "
            + " "  + produto.getQuantidade()            + "  ,"
            + " "  + produto.getPreco()                 + "  ,"
            + " '" + produto.getLote()                  + "'  ,"
            + " "  + produto.getFabricacao()            + "  ,"
            + " "  + produto.getValidade()              + "  ,"
            + "  " + produto.getCategoria().getCodigo() + "    "
            + " );";
        return Conexao.executar(sql);
    }
    
      
    public static boolean editar(Produto produto){
        String sql = "UPDATE produtos SET "
            + " nome =  '" + produto.getNome()                          + "' , "
            + " quantidade =  " + produto.getQuantidade()               + " , "
            + " preco = " + produto.getPreco()                          + " , "
            + " lote = '" + produto.getLote()                           + "' , "
            + " fabricacao = " + produto.getFabricacao()                + " , "
            + " validade = " + produto.getValidade()                    + " , "
            + " codCategoria = " + produto.getCategoria().getCodigo()   + " , "  
            + " WHERE codigo = " + produto.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static boolean excluir(Produto produto){
        String sql = "DELETE FROM produtos "
            + " WHERE codigo = " + produto.getCodigo();
        return Conexao.executar(sql);
    }
    
    public static List<Produto> getProdutos(){
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos ORDER BY nome";
        //
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Produto pro = new Produto();
                    pro.setCodigo( rs.getInt(1) );
                    pro.setNome( rs.getString(2) );
                    pro.setQuantidade( rs.getInt(3) );
                    pro.setPreco( rs.getInt(4) );
                    pro.setLote( rs.getString(5) );
                    pro.setFabricacao( rs.getDate(6) );
                    pro.setValidade( rs.getDate(7) );
                    //
                    Categoria cat = new Categoria();
                    cat.setCodigo( rs.getInt(8) );
                    cat.setNome( rs.getString(9) );
                    //
                    pro.setCidade(cat);
                    lista.add(pro);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    
    
}

