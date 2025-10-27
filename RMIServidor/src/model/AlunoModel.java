package model;
import java.io.Serializable;

/**
 *
 * @author Maria
 */
public class AlunoModel implements Serializable{
    private int id;
    private String nome;
    private String matricula;

    public int getIdAluno() {
        return id;
    }

    public void setIdAluno(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}