package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.FrequenciaModel;

/**
 *
 * @author Maria
 */
public interface InterfaceFrequencia extends Remote {
    boolean inserir(FrequenciaModel frequencia) throws RemoteException;
    boolean editar(FrequenciaModel frequencia) throws RemoteException;
    boolean excluir(int id) throws RemoteException;
    boolean pesquisar(FrequenciaModel frequencia) throws RemoteException;
    List<FrequenciaModel> listarFrequenciasPorAluno(int idAluno) throws RemoteException;
}