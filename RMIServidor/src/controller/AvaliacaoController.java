package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.AvaliacaoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;
/**
 *
 * @author Maria
 */
public class AvaliacaoController extends UnicastRemoteObject implements InterfaceAvaliacao {
    public AvaliacaoController() throws RemoteException{}
    
    @Override
    public boolean inserir(AvaliacaoModel aluno) throws RemoteException {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "insert into avaliacao(nome, matricula) values (?, ?)";
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
    public ArrayList<AvaliacaoModel> listarAvaliacao() {
        ArrayList<AvaliacaoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select l.nome, l.matricula from aluno l";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                AvaliacaoModel l = new AvaliacaoModel();
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
    public boolean editar(AvaliacaoModel avaliacao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(AvaliacaoModel avaliacao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AvaliacaoModel pesquisar(AvaliacaoModel avaliacao) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}