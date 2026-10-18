package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Turma {
	private String identificador;
	private Disciplina disciplina;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	
	public Turma(String identificador, Disciplina disciplina) {
		if (identificador != null && !identificador.isBlank()) {
			this.identificador = identificador;
		}
		if (disciplina != null) {
			this.disciplina = disciplina;
		}
	}
	
	public boolean cadastrarAluno(Aluno aluno) {
		if (aluno != null && !alunos.contains(aluno) && aluno.matriculado(disciplina) && aluno.estaCursando(disciplina)) {
			alunos.add(aluno);
			return true;
		}
		return false;
	}
	public boolean removerAluno(int index) {
		if (1 <= index && index <= alunos.size()) {
			alunos.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean aula(Lecionador lecionador) {
		if (lecionador != null && lecionador.leciona(disciplina)) {
			return lecionador.lecionar(disciplina, alunos) > 0;
		}
		return false;
	}

	public void listarAlunos() {
		System.out.println("Alunos:");
		for (Aluno aluno : alunos) {
			System.out.print("\t");
			aluno.exibirMatricula(disciplina);
		}
	}
	
	public boolean ehDisciplina(Disciplina disciplina) {
		return this.disciplina.equals(disciplina);
	}
	
	public boolean temIdentificador(String identificador) {
		return this.identificador.equals(identificador);
	}
	
	@Override
	public String toString() {
		return "Turma [identificador=" + identificador + ", disciplina=" + disciplina + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(identificador, other.identificador);
	}
	
	
}
