import java.time.LocalDate;

public class Produto {
    private int codigo;
    private String descricao;
    private double custo;
    private LocalDate dataAquiscao;
    private int quantidade;
    private boolean estoque;
    private double preco;

    //metodos


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public LocalDate getDataAquiscao() {
        return dataAquiscao;
    }

    public void setDataAquiscao() {
        this.dataAquiscao = LocalDate.now();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto:" + "\n" +
                "Codigo=" + codigo + "\n" +
                "Descricao='" + descricao + "\n" +
                "Custo=" + custo + "\n" +
                "Data de Aquisção=" + dataAquiscao + "\n" +
                "Quantidade=" + quantidade +"\n" +
                "Preço=" + preco +"\n" +
                (estoque ? "Tem Estoque!" : "Não Possui Estoque!");
    }
    public void valorDeVenda(double lucro){
        if(lucro < 0){
            throw new IllegalArgumentException(
                    "O lucro não pode ser negativo!!!"
            );
        }
        custo += lucro;
    }




}
