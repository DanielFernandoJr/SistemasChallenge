import java.util.ArrayList;

class Animal{
    String nome;
    String especie;
    int idade;
    String dono;
    public Animal(){}
    public Animal(String nome, String especie, int idade, String dono, PetShop gerente){
        this.nome = nome;
        this.idade = idade;
        this.dono = dono;
        //this.especie = especie;
        if (verificarEspecie(especie, gerente) > -1) {
            this.especie = especie/*.toUpperCase()*/;
            int index = verificarEspecie(especie, gerente);
            gerente.especies.get(index).quantidadeAnimais += 1;
            gerente.especies.get(index).nomes.add(nome);
        }else{
            this.especie = "Desconhecido";
            System.out.println("Especie nao encontrada, tente novamente!\nDefinido como ''Desconhecido''");
        }
    }
    int verificarEspecie(String nomeEspecie, PetShop gerente){
        //PetShop shop = new PetShop();
        for(int i = 0; i < gerente.especies.size(); i++){
            if(nomeEspecie.equalsIgnoreCase(gerente.especies.get(i).nomeEspecie)){
                return i;
            }
        }
        return -1;
    }
}
class Especie{
    String nomeEspecie;
    int quantidadeAnimais = 0;
    ArrayList <String> nomes = new ArrayList<>();
    public Especie(){}
    public Especie(String nomeEspecie){
        this.nomeEspecie = nomeEspecie;
    }
}
class PetShop{
    ArrayList<Animal> animais = new ArrayList<>();
    /*static*/ ArrayList<Especie> especies = new ArrayList<>();
    void adicionarAnimal(String nome, String especie, int idade, String dono, PetShop gerente){
        animais.add(new Animal(nome, especie, idade, dono, gerente));
    }
    void adicionarEspecie(String nomeEspecie){
        especies.add(new Especie(nomeEspecie.toUpperCase()));   //TESTE com UperCase()
    }
    //PROTOTIPO NAO FUNCIONAL
    /*void listarNomesPorEspecies(Especie a){
        for(Especie e: especies){
            System.out.println("Especie: "+e.nomeEspecie);
            if (!especies.isEmpty()) {
                for(int i=0; i<a.nomes.size(); i++){
                    System.out.println("\t"+i+1+": "+a.nomes.get(i));
                }
            }else{
                System.out.println("Sem Animais!");
            }
        }
    }*/
    void listarAnimais(){
        if(!animais.isEmpty()){
            System.out.println("-----LISTA DE ANIMAIS-----");
            for(int i=0; i<animais.size(); i++){//Animal a: animais){
                System.out.println("Animal "+(i+1)+"\n\tNome: "+animais.get(i).nome+"\n\tEspecie: "+animais.get(i).especie+"\n\tIdade: "+animais.get(i).idade+"\n\tDono: "+animais.get(i).dono);
            }
        }else{
            System.out.println("Sem animais no PetShop!");
        }
    }
    void procurarPorNome(String nome){
        //Busca por nome
        for(int i=0; i<animais.size(); i++){
            if (nome.equalsIgnoreCase(animais.get(i).nome)) {
                System.out.println("Encontrado!\nNome: "+animais.get(i).nome+"\nEspecie: "+animais.get(i).especie+"\nIdade: "+animais.get(i).idade+"\nDono: "+animais.get(i).dono);
                return;
            }
        }
        System.out.println("Nome não Encontrado");
    }
    void procurarPorEspecie(String especie){
        for(Especie e: especies){
            if (especie.equalsIgnoreCase(e.nomeEspecie)) {
                System.out.println("Encontrado!\nEspecie: "+e.nomeEspecie);
                if(!especies.isEmpty()){
                    System.out.println("Nomes de animais da especie:");
                    for(int i = 0; i<e.nomes.size(); i++){
                        System.out.println(e.nomes.get(i));
                    }
                }else{
                    System.out.println("Sem animais para essa Especie!");
                }
                return;
            }
        }
    }
}

public class Main{
    public static void main(String[] args) {
        PetShop gerente = new PetShop();
        /*Funcoes do gerente:
            Adicionar especie (os animais devem estar dentro de especies ja definidas)
            Adicionar Animais (Adicionar animais ao Petshop)
            Listar animais
            Procurar por nome
            Procurar por especie.
        */
        gerente.adicionarEspecie("Cao");
        gerente.adicionarEspecie("Gato");
        gerente.adicionarAnimal("Rex", "cao", 2, "Daniel", gerente);
        gerente.adicionarAnimal("Tom", "gatinho", 1, "Fernando", gerente);
        gerente.adicionarAnimal("Bull", "cao", 2, "Junior", gerente);
        gerente.listarAnimais();
        gerente.procurarPorNome("Tom");
        gerente.procurarPorEspecie("cao");

    }
}