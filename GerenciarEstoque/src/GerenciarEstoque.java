import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {

    public List<Produto> produtos = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        GerenciarEstoque ge = new GerenciarEstoque();
        int opcao = 0;
    do{
        System.out.println("    Gerenciamento de Estoque    ");
        System.out.println("================================");
        System.out.println("    [  1.Cadastrar Produto  ]   ");
        System.out.println("    [  2.Entrada Estoque    ]   ");
        System.out.println("    [  3.Saida Estoque      ]   ");
        System.out.println("    [  4.Listar Produtos    ]   ");
        System.out.println("    [  5.Patrimonio Liquido ]   ");
        System.out.println("    [  6.Alterar Cadastro   ]   ");
        System.out.println("    [  9.Sair               ]   ");
        opcao = Integer.parseInt(ge.sc.nextLine());
        switch (opcao){
            case 1:
                ge.execCadastrar();
                break;
            case 2:
                ge.execEntrada();
                break;
            case 3:
                ge.execSaida();
                break;
            case 4:
                ge.execListarProdutos();
                break;
            case 5:
                ge.execPatrimonioLiquido();
                break;
            case 6:
                ge.execAlterarCadastro();
                break;
            case 9:
                System.out.println("Fim do Programa!!!");
                break;
            default:
                System.out.println("Opcão Invalida!!!");
        }
    }while(opcao != 9);
      }
    public void execCadastrar(){
          System.out.println("Cadastrando Produto...");
          Produto produto = new Produto();
          System.out.println("Digite o codigo do produto:");
          produto.setCodigo(Integer.parseInt(sc.nextLine()));
          System.out.println("Digite a Descrição do produto:");
          produto.setDescricao(sc.nextLine());
          System.out.println("Digite o custo do produto:");
          produto.setCusto(Double.parseDouble(sc.nextLine()));
          System.out.println("Digite a % de lucro do produto EX. 10%... :");
          produto.setPreco(((Double.parseDouble(sc.nextLine())/100)* produto.getCusto()) + produto.getCusto());
          produto.setDataAquiscao();
          produtos.add(produto);
          System.out.println("Produto Cadastrado com sucesso!!!");
    }


    public void execEntrada(){
        int codigo;
        System.out.println("Digite código do produto para dar entrada: ");
        codigo = Integer.parseInt(sc.nextLine());
        for(Produto produto: produtos){
            if(produto.getCodigo() == codigo){
                int quantidade;
                System.out.println("Digite a quantidade da entrada: ");
                quantidade = Integer.parseInt(sc.nextLine());
                if (quantidade > 0) {
                    produto.setQuantidade(produto.getQuantidade() + quantidade);
                    produto.setEstoque(true);
                    System.out.println(produto.toString());
                }else {
                    System.out.println("A quantidade tem que ser maior que zero!!!");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado!!!");
    }
    public void execSaida(){
        int codigo;
        System.out.println("Digite código do produto para dar entrada: ");
        codigo = Integer.parseInt(sc.nextLine());
        for(Produto produto: produtos){
            if(produto.getCodigo() == codigo){
                int quantidade;
                System.out.println("Digite a quantidade para dar saida: ");
                quantidade = Integer.parseInt(sc.nextLine());
                if (quantidade <= produto.getQuantidade()) {
                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    System.out.println("Retirada com sucesso!!!");
                }else {
                    System.out.println("Não ha quantidade disponivel em estoque!!!");
                    toString();
                }
                if(produto.getQuantidade() <= 0 ){
                produto.setEstoque(false);
                    System.out.println("Produto acabou no estoque... ESTOQUE ATUAL ZERADO!!!");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado!!!");
    }
    public void execListarProdutos(){
        for(Produto produto: produtos){
            System.out.println(produto.toString());
            System.out.println();
            }
    }
    public void execPatrimonioLiquido(){
        double patrimonio = 0;
        for(Produto produto: produtos){
            double total;
            total = produto.getQuantidade() * produto.getCusto();
            patrimonio += total;
        }
        System.out.println("O Patrimonio total é R$" + patrimonio);
    }
    public void execAlterarCadastro(){
        int codigo;
        System.out.println("Digite código do produto Alterar o cadastro: ");
        codigo = Integer.parseInt(sc.nextLine());
        for(Produto produto: produtos){
            if(produto.getCodigo() == codigo){
                System.out.println("Digite novamente os dados do produto...");
                System.out.println("Digite a Descrição do produto:");
                produto.setDescricao(sc.nextLine());
                System.out.println("Digite o custo do produto:");
                produto.setCusto(Double.parseDouble(sc.nextLine()));
                System.out.println("Digite a % de lucro do produto EX. 10%... :");
                produto.setPreco(((Double.parseDouble(sc.nextLine())/100)* produto.getCusto()) + produto.getCusto());
                System.out.println("Produto Alterado com sucesso!!!");
                System.out.println(produto.toString());
                return;
            }

        }System.out.println("Produto não encontrado!!!");
    }
}