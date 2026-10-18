package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Monitor extends Aluno implements Lecionador {
	private Disciplina disciplinaLecionada = null;
	
	public Monitor(String nome, String cpf) {
		super(nome, cpf);
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
	public boolean descadastrarDisciplina(Disciplina disciplina) {
		if (disciplinaLecionada != null && disciplinaLecionada.equals(disciplina)) {
			disciplinaLecionada = null;
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
		return Objects.equals(disciplinaLecionada, disciplina);
	}
	
	public void monitorar(ArrayList<Aluno> alunos) {
		int alunosValidos = lecionar(disciplinaLecionada, alunos);
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplinaLecionada)) {
				matricula.ganharNota(0.01f * alunosValidos);
			}
		}
	}

	@Override
	public boolean identificacao(String cpf) {
		return temMesmoCpf(cpf);
	}
}
