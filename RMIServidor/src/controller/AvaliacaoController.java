package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AvaliacaoModel;
import util.Conexao;

public class AvaliacaoController extends UnicastRemoteObject implements InterfaceAvaliacao {

    public AvaliacaoController() throws RemoteException {
        super();
    }

    @Override
    public boolean inserir(AvaliacaoModel avaliacao) throws RemoteException {
        Conexao c = new Conexao();
        c.conectar();
        String sql = "INSERT INTO Avaliacao (id_aluno, id_disciplina, tipo, nota) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setInt(1, avaliacao.getIdAluno());
            ps.setInt(2, avaliacao.getIdDisciplina());
            ps.setString(3, avaliacao.getTipo());
            ps.setDouble(4, avaliacao.getNota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir avaliação: " + e.getMessage());
            return false;
        } finally {
            c.desconectar();
        }
    }

    @Override
    public ArrayList<AvaliacaoModel> listarAvaliacoesPorAluno(int idAluno) throws RemoteException {
        ArrayList<AvaliacaoModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT id_avaliacao, id_aluno, id_disciplina, tipo, nota " +
                     "FROM Avaliacao WHERE id_aluno = ? ORDER BY tipo";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setInt(1, idAluno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AvaliacaoModel a = new AvaliacaoModel();
                    a.setId(rs.getInt("id_avaliacao"));
                    a.setIdAluno(rs.getInt("id_aluno"));
                    a.setIdDisciplina(rs.getInt("id_disciplina"));
                    a.setTipo(rs.getString("tipo"));
                    a.setNota(rs.getDouble("nota"));
                    lista.add(a);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar avaliações: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return lista;
    }

    @Override
    public boolean editar(AvaliacaoModel avaliacao) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public boolean excluir(int id) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public AvaliacaoModel pesquisar(AvaliacaoModel avaliacao) throws RemoteException {
        throw new UnsupportedOperationException("Não implementado.");
    }
}