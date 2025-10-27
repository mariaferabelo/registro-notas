package view;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import controller.*;
/**
 *
 * @author Maria
 */
public class Servidor {
    public static void main(String[] args) {
        try{
            Registry conexao = LocateRegistry.createRegistry(1100);
            System.out.println("Servidor Iniciado!");
            InterfaceAluno servAluno = new AlunoController();
            System.out.println("Serviço Aluno pronto!");
            conexao.bind("aluno", servAluno);
            InterfaceDisciplina servDisciplina = new DisciplinaController();
            System.out.println("Serviço Disciplina pronto!");
            conexao.bind("disciplina", servDisciplina);
            InterfaceAvaliacao servAvaliacao = new AvaliacaoController();
            System.out.println("Serviço Avaliacao pronto!");
            conexao.bind("avaliacao", servAvaliacao);
            InterfaceFrequencia servFrequencia = new FrequenciaController();
            System.out.println("Serviço Frequencia pronto!");
            conexao.bind("frequencia", servFrequencia);
        }catch(RemoteException e){
            System.out.println("Erro na criação do serviço: "+ e.getMessage());
        }catch(AlreadyBoundException e){
            System.out.println("Erro na resposta do serviço: "+ e.getMessage());
        }
    }
}