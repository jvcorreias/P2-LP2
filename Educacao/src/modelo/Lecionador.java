package modelo;

import java.util.ArrayList;

public interface Lecionador {
	public boolean cadastrarDisciplina(Disciplina disciplina);
	public boolean descadastrarDisciplina(Disciplina disciplina);
	public int lecionar(Disciplina disciplina, ArrayList<Aluno> alunos);
	public boolean leciona(Disciplina disciplina);
	public boolean identificacao(String id);
}
