package modelo;

import java.util.ArrayList;

public class Instituicao {
	private String nome;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Reprovavel> disciplinas = new ArrayList<>();
	private ArrayList<Eletiva> eletivas = new ArrayList<>();
	private ArrayList<Turma> turmas = new ArrayList<>();
	private ArrayList<Lecionador> lecionadores = new ArrayList<>();
	
	public Instituicao(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}
	
	public boolean criarAluno(String nome, String cpf) {
		if (cpf != null && !cpf.isBlank()) {
			Aluno novo = new Aluno(nome, cpf);
			if (novo != null && !alunos.contains(novo)) {
				alunos.add(novo);
				System.out.println("Aluno criado com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Aluno...");
		return false;
	}
	
	public boolean criarDisciplina(String nome, String codigo, int avaliacoes, int faltas) {
		if (codigo != null && !codigo.isBlank()) {
			Reprovavel nova = new Reprovavel(nome, codigo, avaliacoes, faltas);
			if (nova != null && !disciplinas.contains(nova)) {
				disciplinas.add(nova);
				System.out.println("Disciplina criada com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Disciplina...");
		return false;
	}
	
	public boolean criarEletiva(String nome, String codigo, int presencas) {
		if (codigo != null && !codigo.isBlank()) {
			Eletiva nova = new Eletiva(nome, codigo, presencas);
			if (nova != null && !eletivas.contains(nova)) {
				eletivas.add(nova);
				System.out.println("Eletiva criada com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Eletiva...");
		return false;
	}
	
	public boolean criarTurma(String identificador, Disciplina disciplina) {
		if (identificador != null && !identificador.isBlank() && disciplinas.contains(disciplina)) {
			Turma nova = new Turma(identificador, disciplina);
			if (nova != null && !turmas.contains(nova)) {
				turmas.add(nova);
				System.out.println("Turma criada com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Turma...");
		return false;
	}
	
	public boolean criarProfessor(String nome, String cadastro, Disciplina disciplina) {
		if (cadastro != null && !cadastro.isBlank()) {
			Professor novo = new Professor(nome, cadastro, disciplina);
			if (novo != null && !lecionadores.contains(novo)) {
				lecionadores.add(novo);
				System.out.println("Professor criado com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Professor...");
		return false;
	}
	
	public boolean criarMonitor(String nome, String cpf, Disciplina disciplina) {
		if (cpf != null && !cpf.isBlank()) {
			Monitor novo = new Monitor(nome, cpf, disciplina);
			if (novo != null && !alunos.contains(novo) && !lecionadores.contains(novo)) {
				alunos.add(novo);
				lecionadores.add(novo);
				System.out.println("Monitor criado com sucesso!");
				return true;
			}
		}
		System.out.println("Falha ao criar Monitor...");
		return false;
	}
	
	public void exibirAlunos() {
		System.out.println("Alunos:");
		for (int i = 0; i < alunos.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(alunos.get(i));
		}
	}
	public Aluno getAluno(int index) {
		if (1 <= index && index <= alunos.size()) {
			return alunos.get(index-1);
		}
		return null;
	}
	
	public void exibirDisciplinas() {
		System.out.println("Disciplinas:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(disciplinas.get(i));
		}
	}
	public Reprovavel getDisciplina(int index) {
		if (1 <= index && index <= disciplinas.size()) {
			return disciplinas.get(index-1);
		}
		return null;
	}

	@Override
	public String toString() {
		return "Instituicao [nome=" + nome + "]";
	}
}
