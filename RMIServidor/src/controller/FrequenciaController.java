package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FrequenciaModel;
import util.Conexao;

public class FrequenciaController extends UnicastRemoteObject implements InterfaceFrequencia {

    public FrequenciaController() throws RemoteException {
        super();
    }

    @Override
    public boolean inserir(FrequenciaModel frequencia) throws RemoteException {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "INSERT INTO Frequencia (id_aluno, id_disciplina, data_aula, presente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setInt(1, frequencia.getIdAluno());
            ps.setInt(2, frequencia.getIdDisciplina());
            ps.setString(3, frequencia.getDataAula()); // formato: "2025-04-05"
            ps.setBoolean(4, frequencia.isPresente());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir frequência: " + e.getMessage());
            return false;
        } finally {
            c.desconectar();
        }
    }

    @Override
    public ArrayList<FrequenciaModel> listarFrequencias(int idAluno) throws RemoteException {
        ArrayList<FrequenciaModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT id_frequencia, id_aluno, id_disciplina, data_aula, presente " +
                     "FROM Frequencia WHERE id_aluno = ? ORDER BY data_aula";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setInt(1, idAluno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FrequenciaModel f = new FrequenciaModel();
                    f.setId(rs.getInt("id_frequencia"));
                    f.setIdAluno(rs.getInt("id_aluno"));
                    f.setIdDisciplina(rs.getInt("id_disciplina"));
                    f.setDataAula(rs.getString("data_aula"));
                    f.setPresente(rs.getBoolean("presente"));
                    lista.add(f);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar frequência: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return lista;
    }

    @Override
    public boolean editar(FrequenciaModel frequencia) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public boolean excluir(int id) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public boolean pesquisar(FrequenciaModel frequencia) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }
}