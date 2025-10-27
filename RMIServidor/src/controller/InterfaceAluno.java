package controller;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.AlunoModel;
/**
 *
 * @author Maria
 */
public interface InterfaceAluno extends Remote {
    public boolean inserir(AlunoModel aluno) throws RemoteException;
    ArrayList<AlunoModel> listarAlunos() throws RemoteException;
    public boolean editar(AlunoModel aluno) throws RemoteException;
    public boolean excluir (AlunoModel aluno)throws RemoteException;
    public AlunoModel pesquisar(AlunoModel aluno) throws RemoteException;
}