package controller;
import model.DisciplinaModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maria
 */
public interface InterfaceDisciplina extends Remote {
    boolean inserir(DisciplinaModel disciplina) throws RemoteException;
    boolean editar(DisciplinaModel disciplina) throws RemoteException;
    boolean excluir(int id) throws RemoteException;
    DisciplinaModel pesquisar(DisciplinaModel disciplina) throws RemoteException;
    ArrayList<DisciplinaModel> listarDisciplinas() throws RemoteException;
    //!boolean pesquisar(int id) throws RemoteException;
    //!List<DisciplinaModel> listarDisciplinas() throws RemoteException;
}
