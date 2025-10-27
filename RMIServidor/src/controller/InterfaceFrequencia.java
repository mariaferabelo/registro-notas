package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.FrequenciaModel;

public interface InterfaceFrequencia extends Remote {
    boolean inserir(FrequenciaModel frequencia) throws RemoteException;
    ArrayList<FrequenciaModel> listarFrequencias(int idAluno) throws RemoteException;
    boolean editar(FrequenciaModel frequencia) throws RemoteException;
    boolean excluir(int id) throws RemoteException;
    boolean pesquisar(FrequenciaModel frequencia) throws RemoteException;
}