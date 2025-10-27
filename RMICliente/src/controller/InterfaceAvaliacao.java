package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.AvaliacaoModel;
/**
 *
 * @author Maria
 */
public interface InterfaceAvaliacao extends Remote {
    boolean inserir(AvaliacaoModel avaliacao) throws RemoteException;
    boolean editar(AvaliacaoModel avaliacao) throws RemoteException;
    boolean excluir(int id) throws RemoteException;
    boolean pesquisar(AvaliacaoModel avaliacao) throws RemoteException;
    List<AvaliacaoModel> listarAvaliacoesPorAluno(int idAluno) throws RemoteException;
}