package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.AvaliacaoModel;

public interface InterfaceAvaliacao extends Remote {
    boolean inserir(AvaliacaoModel avaliacao) throws RemoteException;
    ArrayList<AvaliacaoModel> listarAvaliacoesPorAluno(int idAluno) throws RemoteException;
    boolean editar(AvaliacaoModel avaliacao) throws RemoteException;
    boolean excluir(int id) throws RemoteException;
    AvaliacaoModel pesquisar(AvaliacaoModel avaliacao) throws RemoteException;
}