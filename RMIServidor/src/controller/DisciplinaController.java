package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DisciplinaModel;
import util.Conexao;

public class DisciplinaController extends UnicastRemoteObject implements InterfaceDisciplina {

    public DisciplinaController() throws RemoteException {
        super();
    }

    @Override
    public boolean inserir(DisciplinaModel disciplina) throws RemoteException {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "INSERT INTO Disciplina (nome) VALUES (?)";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setString(1, disciplina.getDisciplina());
            int rows = ps.executeUpdate();
            c.desconectar();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir disciplina: " + e.getMessage());
            c.desconectar();
            return false;
        }
    }

    @Override
    public ArrayList<DisciplinaModel> listarDisciplinas() throws RemoteException {
        ArrayList<DisciplinaModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT id_disciplina, nome FROM Disciplina ORDER BY nome";
        try (PreparedStatement ps = c.conector.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DisciplinaModel d = new DisciplinaModel();
                d.setIdDisciplina(rs.getInt("id_disciplina"));
                d.setDisciplina(rs.getString("nome"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar disciplinas: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return lista;
    }

    @Override public boolean editar(DisciplinaModel disciplina) throws RemoteException { return false; }
    @Override public boolean excluir(int id) throws RemoteException { return false; }
    @Override public DisciplinaModel pesquisar(DisciplinaModel disciplina) throws RemoteException { return null; }
}