import java.util.ArrayList;

class Tarefa{
    String descricao;
    int nivelPrioridade; //(1-3) 1-Mais importante, 2-Medio, 3-Menos importante
    String prioridade;
    boolean tarefaConcluida;
    String estado;
    public Tarefa(String descricao, int nivelPrioridade, boolean tarefaConcluida){
        this.descricao = descricao;
        //this.nivelPrioridade = nivelPrioridade;
        //this.tarefaConcluida = tarefaConcluida;
        setNivelPrioridade(nivelPrioridade);
        setTarefaConcluida(tarefaConcluida);
    }
    void setTarefaConcluida(boolean tarefaConcluida){
        if(tarefaConcluida){
            this.tarefaConcluida = true;
            this.estado = "Concluido";

        }else{
            this.tarefaConcluida = false;
            this.estado = "Nao Concluido";
        }
    }
    void setNivelPrioridade(int nivelPrioridade){
        this.nivelPrioridade = nivelPrioridade;
        switch (nivelPrioridade) {
            case 1:
                this.prioridade = "Mais Importante";
                break;
            case 2:
                this.prioridade = "Medio";
                break;
            case 3:
                this.prioridade = "Menos Importante";
            default:
                //throw new AssertionError("Nivel nao permitido.");
                System.out.println("Nivel nao permitido");
                this.prioridade = "Desconhecido";
                this.nivelPrioridade = 0;
        }
    }
}
class GestorDeTarefas{
    ArrayList <Tarefa> tarefas = new ArrayList<>();
    void adicionarTarefas(String descricao, int prioridade, boolean tarefaConcluida){
        tarefas.add(new Tarefa(descricao, prioridade, tarefaConcluida));
    }
    void adicionarTarefas(Tarefa t){
        tarefas.add(t);
    }
    void listarTarefas(){
        if (!tarefas.isEmpty()) {
            for(int i=0; i<tarefas.size(); i++){
                System.out.println("Tarefa "+(i+1)+"\nPrioridade: "+tarefas.get(i).prioridade+"\nDescricao: "+tarefas.get(i).descricao+"\nEstado: "+tarefas.get(i).estado);
            }
        }else{
            System.out.println("Sem tarefas no Gestor!");
        }
    }
    void marcarComoConcluida(String descricao){
        if (buscarDescricao(descricao) > -1) {
            int index = buscarDescricao(descricao);
            tarefas.get(index).setTarefaConcluida(true);
            System.out.println("Tarefa: '"+tarefas.get(index).descricao+"' Concluida com Sucesso!");
        }else{
            System.out.println("Tarefa nao encontrada, tente outra palavra-chave.");
        }
    }
    int buscarDescricao(String descricao){
        for(int i=0; i<tarefas.size(); i++){
            if(descricao.equalsIgnoreCase(tarefas.get(i).descricao)){
                return i;
            }
        }
        return -1;
    }
    void mostrarEstadoTarefas(){
        System.out.print("Tarefas Concluidas: ");
        if (contarConcluidas() > 0) {
            for(int i=0; i<tarefas.size(); i++){
                if (tarefas.get(i).tarefaConcluida) {
                    System.out.print("\nTarefa "+(i+1)+"\nDescricao: "+tarefas.get(i).descricao);
                }
            }
        }else{
            System.out.println("\nSem tarefas Concluidas.");
        }
        System.out.print("\nTarefas Nao Concluidas: ");
        if (contarNaoConcluidas() > 0) {
            for(int i=0; i<tarefas.size(); i++){
                if (!tarefas.get(i).tarefaConcluida) {
                    System.out.print("\nTarefa "+(i+1)+"\nDescricao: "+tarefas.get(i).descricao);
                }
            }
        }else{
            System.out.println("\nSem tarefas Nao Concluidas");
        }
    }
    int contarConcluidas(){
        int nr=0;
        for(int i=0; i<tarefas.size(); i++){
            if (tarefas.get(i).tarefaConcluida) {
                nr++;
            }
        }
        return nr;
    }
    int contarNaoConcluidas(){
        int nr=0;
        for(int i=0; i<tarefas.size(); i++){
            if (!tarefas.get(i).tarefaConcluida) {
                nr++;
            }
        }
        return nr;
    }
}
public class Main{
    public static void main(String[] args){
        GestorDeTarefas gestor = new GestorDeTarefas();
        gestor.adicionarTarefas("Cozinhar", 1, false);
        gestor.adicionarTarefas("Codar", 1, true);
        //gestor.listarTarefas();
        gestor.marcarComoConcluida("cozinhar");
        //gestor.mostrarEstadoTarefas();
        Tarefa t1 = new Tarefa("Dormir", 2, false);
        Tarefa t2 = new Tarefa("Acordar", 3, false);
        gestor.adicionarTarefas(t1);
        gestor.adicionarTarefas(t2);
        gestor.listarTarefas();
    }
}