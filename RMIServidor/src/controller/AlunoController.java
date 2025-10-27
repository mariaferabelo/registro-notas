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
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "insert into aluno(nome, matricula) values (?, ?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            if(!sentenca.execute())
                retorno = true;
        }catch(SQLException e){
            System.err.println("Erro ao inserir: "+e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    @Override
    public ArrayList<AlunoModel> listarAlunos() {
        ArrayList<AlunoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select l.nome, l.matricula from aluno l";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                AlunoModel l = new AlunoModel();
                l.setNome(result.getString("nome"));
                l.setMatricula(result.getString("matricula"));
                retorno.add(l);
            }
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