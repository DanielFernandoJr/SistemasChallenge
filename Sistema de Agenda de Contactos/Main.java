import java.util.ArrayList;
/*
objectivo: Guardar informacoes de pessoas
Especificacoes:
Cadastrar contacto com nome, telefone e email'
Listar todos os contactos;
Buscar por nome;
Remover contacto;
Classes: Contacto e Agenda
*/
class Contacto{
    String nome;
    int telefone;
    String email;
    public Contacto(){}
    public Contacto(String nome, int telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    //Copy construtor
    public Contacto(Contacto c){
        this.nome = c.nome;
        this.telefone = c.telefone;
        this.email = c.email;
    }
}
class Agenda{
    ArrayList <Contacto> contactos = new ArrayList<>();
    void cadastrar(String nome, int telefone, String email){
        contactos.add(new Contacto(nome, telefone, email));
    }
    void cadastrar(Contacto c){
        contactos.add(c);
    }
    void listar(){
        if(!contactos.isEmpty()){
            System.out.println("-----LISTA DE CONTACTOS-----");
            for (Contacto c : contactos) {
                int i=1;
                System.out.println("Nome: "+c.nome+"\nTelefone: "+c.telefone+"\nE-mail: "+c.email+"\n-------------------");
            }
        }else{
            System.out.println("Sem contactos na Agenda!");
        }
    }
    void buscarPorNome(String nome){
        if(buscarNome(nome)>= 0){
            int index = buscarNome(nome);
            System.out.println("Contacto Encontrado!\nNome: "+contactos.get(index).nome+"\nTelefone: "+contactos.get(index).telefone+"\nE-mail: "+contactos.get(index).email);
        }else{
            System.out.println("'"+nome+"' Nao encontrado.");
        }
    }
    void removerContacto(String nome){
        if(buscarNome(nome)>=1){
            int index = buscarNome(nome);
            contactos.remove(index);
            System.out.println("Contacto: "+contactos.get(index).nome+" Eliminado.");
        }else{
            System.out.println("Contacto nao encontrado.");
        }
    }
    int buscarNome(String nome){
        if(!nome.isBlank()){
            for(int i=0; i<contactos.size(); i++){
                if(nome.equalsIgnoreCase(contactos.get(i).nome)){
                    return i;
                }
            }
        }else{
            return -1;
        }
        return -1;
    }
}
public class Main{
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contacto c1 = new Contacto("Fernando", 879912204, "dajuniro@estudante.up.ac.mz");
        agenda.cadastrar(c1);
        agenda.cadastrar("Daniel", 846415160, "daniel@gmail.com");
        agenda.cadastrar("Daniel", 846415160, "daniel@gmail.com");
        //agenda.buscarPorNome("Daniel");
        agenda.removerContacto("Daniel");
        agenda.listar();
    }
}