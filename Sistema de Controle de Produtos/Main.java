import java.util.ArrayList;
import java.util.Scanner;
class Produto {
    String nome;
    float preco;
    int quantidade;
    public Produto(){}
    public Produto(String nome, float preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    void mostrarProduto(){
        System.out.println("Nome: "+nome+"\nPreco"+"\nQuantidade: "+quantidade);
    }
}
class Loja {
    ArrayList <Produto> produtos = new ArrayList<>();
    void adicionarProduto(Produto p){
        produtos.add(p);
        System.out.println("Produto: "+p.nome+" adicionado à loja");
    }
    void listar () {
        if (produtos.isEmpty()){
            System.out.println("Sem produtos na Loja!\nAdicione");
        }else {
            for(int i=0; i<produtos.size();i++){
                System.out.println(i+1+":\n\tNome: "+produtos.get(i).nome+"\n\tPreco: "+produtos.get(i).preco+"\n\tQuantidade: "+produtos.get(i).quantidade);
            }
        }
    }
    int buscarProduto(String nomeBusca){
        for(int i=0; i<produtos.size(); i++){
            if (nomeBusca.equalsIgnoreCase(produtos.get(i).nome)) {
                //System.out.println("Produto Encontrado!\n\tNome: "+produtos.get(i).nome+"\n\tPreco: "+produtos.get(i).nome+"\n\tQuantidade: "+produtos.get(i).quantidade);
                return i;
            }
        }
        //System.out.println("Produto '"+nomeBusca+"' Nao Encontrado!\nTente outra palavra chave.");
        return -1;
    }
    void comprar (String nomeProduto, int quantidade, float totalPago) {
        if(buscarProduto(nomeProduto)>-1){
            int indexProduto = buscarProduto(nomeProduto);
            if(produtos.get(indexProduto).quantidade >= 1 && produtos.get(indexProduto).quantidade >= quantidade){
                if (totalPago >= produtos.get(indexProduto).preco*quantidade) {
                    produtos.get(indexProduto).quantidade -= quantidade;
                    System.out.println("Compra Sucedida!\n------------------RECIBO------------------\nProduto\tQtd\tTotal\n"+produtos.get(indexProduto).nome+"\t"+quantidade+"\t"+(produtos.get(indexProduto).preco*quantidade)+"\n\nTotal pago: "+totalPago+"\t Troco: "+(totalPago-(produtos.get(indexProduto).preco*quantidade))+"\n------------------FIM------------------");
                }else {
                    System.out.println("Dinheiro Insuficiente!\nPara comprar "+quantidade+" "+produtos.get(indexProduto).nome+"'s, precisa de "+(produtos.get(indexProduto).preco*quantidade)+" Meticais");
                }
            }else{
                System.out.println("Quantidade nao disponivel!");
            }
        }else{
            System.out.println("Produto nao encontrado!\nTente outra palavra chave.");
        }
    }
    //MENU
    void menu(){
        Scanner scan = new Scanner(System.in);
        int opc = 0;
        do { 
            System.out.println("MENU DE USUARIO\n1 - Comprar\n2 - Ver Produtos Disponiveis(Stock)\n0 - Sair");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("GUIA DE COMPRA\nDigite o nome do produto:");
                    String nomeCompra = scan.next();
                    System.out.println("Digite a quantidade que pretende:");
                    int quantidadeCompra = scan.nextInt();
                    System.out.println("Digite total a pagar:");
                    float totalPagar = scan.nextFloat();
                    comprar(nomeCompra, quantidadeCompra, totalPagar);
                    break;
                case 2:
                    listar();
                    break;
                default:
                    if (opc!=0) {
                        System.out.println("Opcao Invalida!");
                    }
                    //throw new AssertionError();
                    break;
                }
            } while (opc!=0);
            System.out.println("Obrigado!");
    }
}



public class Main {
    public static void main (String[] args){
        Loja loja = new Loja();
        //Main main = new Main();
        //CRIACAO DE PRODUTOS
        Produto p1 = new Produto("Coca-Cola", 100, 5);
        Produto p2 = new Produto("Pepsi", 95, 10);
        Produto p3 = new Produto("2M", 55, 20);
        //ADICAO A LOJA/STOCK
        loja.adicionarProduto(p1);
        loja.adicionarProduto(p2);
        //loja.listar();
        //COMPRA DE PRODUTOS
        //loja.comprar("2M", 1, 55);
        //loja.comprar("PEPSI", 2, 200);
        Main main = new Main();
        loja.menu();
    }
}