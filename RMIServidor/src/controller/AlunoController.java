package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.AlunoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

/**
 *
 * @author Maria
 */
public class AlunoController extends UnicastRemoteObject implements InterfaceAluno {
    public AlunoController() throws RemoteException{}
    
    @Override
    public boolean inserir(AlunoModel aluno) throws RemoteException {
        Conexao c = new Conexao();
        c.conectar();
        
        if (c.conector == null) {
            throw new RemoteException("Não foi possível conectar ao banco de dados.");
        }
        
        String sql = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";
        try (PreparedStatement ps = c.conector.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            int rows = ps.executeUpdate();
            System.out.println("Linhas afetadas: " + rows);
            c.desconectar();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno: " + e.getMessage());
            c.desconectar();
            return false;
        }
    }
    @Override
    public ArrayList<AlunoModel> listarAlunos() throws RemoteException {
        ArrayList<AlunoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        
        if (c.conector == null) {
            throw new RemoteException("Não foi possível conectar ao banco de dados.");
        }
        
        String sql = "select a.nome, a.matricula from aluno a";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                AlunoModel a = new AlunoModel();
                a.setNome(result.getString("nome"));
                a.setMatricula(result.getString("matricula"));
                retorno.add(a);
                System.out.println("Aluno: " + a.getNome() + ", Matrícula: " + a.getMatricula());
            }
            System.out.println("Total: " + retorno.size());
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    @Override
    public boolean editar(AlunoModel livro) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(AlunoModel livro) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoModel pesquisar(AlunoModel livro) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}