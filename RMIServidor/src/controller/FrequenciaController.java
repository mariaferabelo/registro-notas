package controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import model.FrequenciaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;
/**
 *
 * @author Maria
 */
public class FrequenciaController extends UnicastRemoteObject implements InterfaceFrequencia {
    public FrequenciaController() throws RemoteException{}
    
    @Override
    public boolean inserir(FrequenciaModel frequencia) throws RemoteException {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "insert into frequencia(nome, matricula) values (?, ?)";
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
    public ArrayList<FrequenciaModel> listarFrequencias() {
        ArrayList<FrequenciaModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select l.nome, l.matricula from aluno l";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                FrequenciaModel l = new FrequenciaModel();
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
    public boolean editar(FrequenciaModel frequencia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(FrequenciaModel frequencia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FrequenciaModel pesquisar(FrequenciaModel frequencia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}