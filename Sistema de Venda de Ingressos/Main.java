import java.util.ArrayList;
//-----------------------------CLASSE EVENTO
class Evento{
    //ATRIBUTOS
    String nome;
    String data;    //25-03-2022
    float preco;
    int quantidade;
    //CONSTRUTOR
    public Evento(){}
    public Evento(String nome, String data, float preco, int quantidade){
        this.nome = nome;
        this.data = data;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
class VendaIngressos{
    ArrayList <Evento> ingressos = new ArrayList<>();
    static float totalArecadado = 0;
    void adicionarEvento(Evento e){
        ingressos.add(e);
    }
    int buscarIngresso(String nome){
        for(int i=0; i<ingressos.size(); i++){
            if (nome.equalsIgnoreCase(ingressos.get(i).nome)) {
                return i;
            }
        }
        return -1;
    }
    void venderIngressos(String nome, int numeroIngressos, float valorPago){
        if(buscarIngresso(nome) > -1){  //Nome do ingresso
            int index = buscarIngresso(nome);
            if (numeroIngressos <= ingressos.get(index).quantidade) {   //Numero de ingressos
                if (valorPago >= ingressos.get(index).preco * numeroIngressos) {    //Preco/ValP
                    ingressos.get(index).quantidade -= numeroIngressos;
                    //totalArecadado+=valorPago - ingressos.get(index).preco*numeroIngressos;
                    totalArecadado += ingressos.get(index).preco*numeroIngressos;
                    System.out.println("COMPRA DE "+numeroIngressos+" INGRESSOS FEITO!\nTotal pago "+valorPago+"\tPreco para "+numeroIngressos+" ingressos: "+ingressos.get(index).preco*numeroIngressos+"\nTroco: "+(valorPago - ingressos.get(index).preco*numeroIngressos)+"\nIngressos restantes: "+ingressos.get(index).quantidade);
                }else{
                    System.out.println("Nao e possivel comprar "+numeroIngressos+" ingressos com "+valorPago+"\nCada ingresso custa "+ingressos.get(index).preco+", portanto deve pagar "+ingressos.get(index).preco*numeroIngressos);
                }
            }else{
                System.out.println("Quantidade nao existente!\nPara o ingresso "+ingressos.get(index).nome+" so estao disponiveis "+ingressos.get(index).quantidade+" ingressos!");
            }
        }else{
            System.out.println("Ingresso nao Encontrado!");
        }
    }
    void mostrarArrecadado(){
        System.out.println("Total arrecadado: "+totalArecadado+" Mt");
    }
}

class Main{
    public static void main (String[] args){
        Evento ev1 = new Evento("SunDowns", "14-02-2026", 1200, 100);
        VendaIngressos gerente = new VendaIngressos();
        //gerente.ingressos.add(ev1);
		gerente.adicionarEvento(ev1);
        gerente.venderIngressos("SunDowns", 5, 6500);
        gerente.mostrarArrecadado();
        gerente.venderIngressos("SunDowns", 95, 120000);
        gerente.venderIngressos("SunDowns", 1, 1200);
        
    }
}