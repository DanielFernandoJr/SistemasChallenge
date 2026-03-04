import java.util.ArrayList;
/*
Objectivo: Simular reservas num pequeno hotel
Especificacoes:
Cadastrar quarto(numero, tipo e status: livre/ocupado);
Fazer reserva (ocupar um quarto);
Cancelar reserva (Libertar o quarto);
Mostrar lista de quartos e estado actual;
Classes: Quarto e Hotel
*/
class Quarto{
    static int num = 1;
    int numero;
    String tipo;
    private boolean livre;  //True se estiver Livre
    String estado;
    public Quarto(String tipo, boolean livre){
        this.numero = num++;
        this.tipo = tipo;
        setLivre(livre);
    }
    public Quarto(String tipo, String estado){
        this.numero = num++;
        this.tipo = tipo;
        if(estado.equalsIgnoreCase("Livre")){
            setLivre(true);
        }else{
            setLivre(false);
        }
    }
    void setLivre(boolean livre){
        this.livre = livre;
        if(livre){
            this.estado = "Livre";
        }else{
            this.estado = "Ocupado";
        }
    }
    boolean getLivre(){return livre;}
    void mostrarQuarto(){
        System.out.println("Quarto numero "+numero+"\nTipo: "+tipo+"\nEstado: "+estado);
    }
}
class Hotel{
    ArrayList <Quarto> quartos = new ArrayList<>();
    void cadastrarQuarto(Quarto q){
        quartos.add(q);
    }
    void cadastrarQuarto(String tipo, boolean livre){
        quartos.add(new Quarto(tipo, livre));
    }
    void cadastrarQuarto(String tipo, String estado){
        quartos.add(new Quarto(tipo, estado));
    }
   void fazerReserva(int numero){
    if(buscarQuarto(numero) >= 0){
        int index = buscarQuarto(numero);
        if(quartos.get(index).getLivre()){
            quartos.get(index).setLivre(false);
            System.out.printf("Reserva no quarto %d efectuada!\n", numero);
        }else{
            System.out.println("Quarto Ocupado!");
        }
    }else{
        System.out.printf("Quarto numero %d nao encontrado!\n", numero);
    }
   }
   void cancelarReserva(int numero){
    if(buscarQuarto(numero)>=0){
        int index = buscarQuarto(numero);
        if(!quartos.get(index).getLivre()){
            quartos.get(index).setLivre(true);
            System.out.println("Cancelou a reserva do quarto "+quartos.get(index).numero);
        }else{
            System.out.println("Nao foi possivel cancelar.\nO quarto "+quartos.get(index).numero+" esta livre");
        }
    }else{
        System.out.println("Quarto nao encontrado!");
    }
   }
    private int buscarQuarto(int numero){
        for(int i=0; i<quartos.size(); i++){
            if(numero == quartos.get(i).numero){
                return i;
            }
        }
        return -1;
    }
    void mostrarQuartos(){
        if(!quartos.isEmpty()){
            for(Quarto q: quartos){
                System.out.println("Quarto no: "+q.numero+"\nTipo: "+q.tipo+"\nEstado: "+q.estado+"\n----------");
            }
        }else{
            System.out.println("Sem quartos no Hotel");
        }
    }
}
public class Main{
    public static void main(String[] args){
        Hotel gerente = new Hotel();
        gerente.cadastrarQuarto("Suite", false);
        gerente.cadastrarQuarto("Simples", true);
        gerente.cadastrarQuarto("Simples", true);
        gerente.cadastrarQuarto("Duplo", "Ocupado");
        gerente.fazerReserva(2);
        gerente.cancelarReserva(4);
        gerente.mostrarQuartos();
    }
}