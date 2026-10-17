package modelo;

import java.util.ArrayList;

public class Instituicao {
	private String nome;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Reprovavel> disciplinas = new ArrayList<>();
	private ArrayList<Turma> turmas = new ArrayList<>();
	private ArrayList<Lecionador> lecionadores = new ArrayList<>();
	
	public Instituicao(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}
	
	public boolean criarAluno(String nome, String cpf) {
		if (cpf != null && !cpf.isBlank()) {
			alunos.add(new Aluno(nome, cpf));
			return true;
		}
		return false;
	}
	
	public boolean criarDisciplina(String nome, String codigo, int avaliacoes, int faltas) {
		if (codigo != null && !codigo.isBlank()) {
			disciplinas.add(new Reprovavel(nome, codigo, avaliacoes, faltas));
			return true;
		}
		return false;
	}
	
	public boolean criarTurma(String identificador, Disciplina disciplina) {
		if (identificador != null && !identificador.isBlank() && disciplinas.contains(disciplina)) {
			turmas.add(new Turma(identificador, disciplina));
			return true;
		}
		return false;
	}
	
	public boolean criarProfessor(String nome, String cadastro, Disciplina disciplina) {
		if (cadastro != null && !cadastro.isBlank()) {
			lecionadores.add(new Professor(nome, cadastro, disciplina));
		}
		return false;
	}
	
	public boolean criarMonitor(String nome, String cpf, Disciplina disciplina) {
		if (cpf != null && !cpf.isBlank()) {
			Monitor novo = new Monitor(nome, cpf, disciplina);
			alunos.add(novo);
			lecionadores.add(novo);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Instituicao [nome=" + nome + "]";
	}
}
