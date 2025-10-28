package rmi;
import controller.AlunoController;
import controller.AvaliacaoController;
import controller.DisciplinaController;
import controller.FrequenciaController;
import controller.InterfaceAluno;
import controller.InterfaceAvaliacao;
import controller.InterfaceDisciplina;
import controller.InterfaceFrequencia;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
/**
 *
 * @author Maria
 */
public class Servidor {
    public static void main(String[] args) {
        try{
            Registry conexao = LocateRegistry.createRegistry(1100);
            System.out.println("Servidor Iniciado!");
            //!Interface servico = new InterfaceImplementacao();
            
            // Instancia cada implementação
            InterfaceAluno alunoService = new AlunoController();
            InterfaceDisciplina disciplinaService = new DisciplinaController();
            InterfaceFrequencia frequenciaService = new FrequenciaController();
            InterfaceAvaliacao avaliacaoService = new AvaliacaoController();

            // Faz o bind de cada serviço com uma chave única
            conexao.bind("aluno", alunoService);
            conexao.bind("disciplina", disciplinaService);
            conexao.bind("avaliacao", frequenciaService);
            conexao.bind("frequencia", avaliacaoService);
            
            System.out.println("Serviço pronto!");
            //!conexao.bind("chave",servico);
        }catch(RemoteException e){
            System.out.println("Erro na criação do serviço: "+ e.getMessage());
        }catch(AlreadyBoundException e){
            System.out.println("Erro na resposta do serviço: "+ e.getMessage());
        }
    }
}
