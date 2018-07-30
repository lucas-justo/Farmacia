
package classes;

import java.util.Date;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;
    private Date fabricacao;
    private Date validade;
    private Categoria categoria;
    private String lote;

    public Produto() {
    }

    public Produto(int codigo, String nome , int quantidade, double preco, Date fabricacao, Date validade, Categoria categoria, String lote) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.fabricacao = fabricacao;
        this.validade = validade;
        this.categoria = categoria;
        this.lote = lote;
    }
    
    @Override
    public String toString() {
        return nome;
    }  
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
        

    
   
    
}
