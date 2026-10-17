package modelo;

import java.util.ArrayList;

public class Monitor extends Aluno implements Lecionador {
	private Disciplina disciplinaLecionada;
	
	public Monitor(String nome, String cpf, Disciplina disciplinaLecionada) {
		super(nome, cpf);
		if (disciplinaLecionada != null) {
			this.disciplinaLecionada = disciplinaLecionada;
		}
	}

	@Override
	public boolean cadastrarDisciplina(Disciplina disciplina) {
		if (disciplina != null && (concluiu(disciplina) || estaCursando(disciplina))) {
			disciplinaLecionada = disciplina;
			return true;
		}
		return false;
	}
	
	@Override
	public int lecionar(Disciplina disciplina, ArrayList<Aluno> alunos) {
		if ((!concluiu(disciplina) && !estaCursando(disciplina)) || alunos.contains(this)) return 0;
		int alunosPresentes = 0;
		for (Aluno aluno : alunos) {
			disciplina.adicionarPresencas(aluno, 1);
			alunosPresentes++;
		}
		return alunosPresentes;
	}
	
	@Override
	public boolean leciona(Disciplina disciplina) {
		return disciplinaLecionada.equals(disciplina);
	}
	
	public void monitorar(ArrayList<Aluno> alunos) {
		int alunosValidos = lecionar(disciplinaLecionada, alunos);
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplinaLecionada)) {
				matricula.ganharNota(0.01f * alunosValidos);
			}
		}
	}
}
