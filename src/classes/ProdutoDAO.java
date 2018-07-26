
package classes;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    public static boolean inserir(Produto produto){
       /* String sql = "INSERT INTO clientes "
            + " ( nome ) VALUES "
            + " ( '" + cliente.getNome() + "' );";*/
       
        String sql = "INSERT INTO produtos "
            + " ( nome, quantidade, preco , lote , fabricacao, validade , codCategoria ) "
            + " VALUES ( "
            + " '" + produto.getNome()              + "' , "
            + " " + produto.getQuant()           + "  ,"
            + " " + produto.getPreco()           + "  ,"
            + " '" + produto.getLote()           + "'  ,"
            + " " + produto.getFab()           + "  ,"
            + " " + produto.getVal()           + "  ,"
            + "  " + produto.getCategoria().getCodigo()+ "    "
            + " );";
        return conexao.executar(sql);
    }
    
      
    public static boolean editar(Produto produto){
        String sql = "UPDATE produtos SET "
            + " nome =  '" + produto.getNome() + "' , "
            + " quantidade =  " + produto.getQuant() + " , "
            + " preco = " + produto.getPreco() + " , "
            + " lote = '" + produto.getLote() + "' , "
            + " fabricacao = " + produto.getFab() + " , "
            + " validade = " + produto.getVal() + " , "
            + " codCategoria = " + produto.getCategoria().getCodigo() + " , "  
            + " WHERE codigo = " + produto.getCodigo();
        return conexao.executar(sql);
    }
    
    public static boolean excluir(Produto categoria){
        String sql = "DELETE FROM produtos "
            + " WHERE codigo = " + categoria.getCodigo();
        return conexao.executar(sql);
    }
    
    public static List<Produto> getCategoria(){
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos ORDER BY nome";
        //
        ResultSet rs = conexao.consultar( sql );
        
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Produto cid = new Produto();
                    cid.setCodigo( rs.getInt(1) );
                    cid.setNome( rs.getString(2) );
                    cid.setEmail( rs.getString(3) );
                    lista.add(cid);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    
    
}

