package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.DisciplinaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

/**
 *
 * @author Maria
 */
public class DisciplinaController extends UnicastRemoteObject implements InterfaceDisciplina {
    public DisciplinaController() throws RemoteException{}
    
    @Override
    public boolean inserir(DisciplinaModel disciplina) throws RemoteException {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "insert into disciplina(id, nome) values (?, ?)";
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
    public ArrayList<DisciplinaModel> listarDisciplinas() {
        ArrayList<DisciplinaModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select l.id, l.nome from disciplina l";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                DisciplinaModel l = new DisciplinaModel();
                l.setIdDisciplina(result.getInt("id"));
                l.setDisciplina(result.getString("nome"));
                retorno.add(l);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    @Override
    public boolean editar(DisciplinaModel disciplina) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(DisciplinaModel disciplina) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DisciplinaModel pesquisar(DisciplinaModel disciplina) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}