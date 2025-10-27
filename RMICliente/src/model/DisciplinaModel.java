package model;
import java.io.Serializable;

/**
 *
 * @author Maria
 */
public class DisciplinaModel implements Serializable {
    private int idDisciplina;
    private String nome;

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getDisciplina() {
        return nome;
    }

    public void setDisciplina(String disciplina) {
        this.nome = disciplina;
    }
}
