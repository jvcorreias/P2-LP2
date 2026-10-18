package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Instituicao {
	private String nome;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Reprovavel> reprovaveis = new ArrayList<>();
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
	public boolean excluirAluno(Aluno aluno) {
		if (alunos.contains(aluno)) {
			if (lecionadores.contains(aluno)) {
				lecionadores.remove(aluno);
			}
			aluno.cancelarCurso();
			alunos.remove(aluno);
			return true;
		}
		return false;
	}
	
	public boolean criarReprovavel(String nome, String codigo, int avaliacoes, int faltas) {
		if (codigo != null && !codigo.isBlank()) {
			Reprovavel nova = new Reprovavel(nome, codigo, avaliacoes, faltas);
			if (nova != null && !reprovaveis.contains(nova)) {
				reprovaveis.add(nova);
				System.out.println("Disciplina Reprovável criada com sucesso!");
				Collections.sort(reprovaveis);
				return true;
			}
		}
		System.out.println("Falha ao criar Disciplina Reprovável...");
		return false;
	}
	
	public boolean criarEletiva(String nome, String codigo, int presencas) {
		if (codigo != null && !codigo.isBlank()) {
			Eletiva nova = new Eletiva(nome, codigo, presencas);
			if (nova != null && !eletivas.contains(nova)) {
				eletivas.add(nova);
				System.out.println("Disciplina Eletiva criada com sucesso!");
				Collections.sort(eletivas);
				return true;
			}
		}
		System.out.println("Falha ao criar Disciplina Eletiva...");
		return false;
	}
	public boolean excluirDisciplina(Disciplina disciplina) {
		ArrayList<Disciplina> disciplinas = obtemTodasDisciplinas();
		if (disciplinas.contains(disciplina)) {
			disciplina.cancelarDisciplina();
			removeDisciplina(disciplina);
			return true;
		}
		return false;
	}
	private void removeDisciplina(Disciplina disciplina) {
		if (reprovaveis.contains(disciplina)) {
			reprovaveis.remove(disciplina);
		}
		else {
			eletivas.remove(disciplina);
		}
	}
	
	public boolean criarTurma(String identificador, Disciplina disciplina) {
		if (identificador != null && !identificador.isBlank() && reprovaveis.contains(disciplina)) {
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
	public boolean excluirTurma(Turma turma) {
		return turmas.remove(turma);
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
	public boolean excluirProfessor(Professor professor) {
		return lecionadores.remove(professor);
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
	public boolean excluirMonitor(Monitor monitor) {
		return alunos.remove(monitor) && lecionadores.remove(monitor);
	}
	
	public boolean excluirLecionador(Lecionador lecionador) {
		if (alunos.contains(lecionador)) {
			alunos.remove(lecionador);
		}
		return lecionadores.remove(lecionador);
	}
	
	public void exibirAlunos() {
		System.out.println("Alunos:");
		for (int i = 0; i < alunos.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(alunos.get(i));
		}
	}
	
	public Aluno getAluno(String cpf) {
		for (Aluno aluno : alunos) {
			if (aluno.temMesmoCpf(cpf)) {
				return aluno;
			}
		}
		return null;
	}
	
	public Aluno getAluno(int index) {
		if (1 <= index && index <= alunos.size()) {
			return alunos.get(index-1);
		}
		return null;
	}
	
	public void exibirReprovaveis() {
		System.out.println("Disciplinas Reprováveis:");
		for (int i = 0; i < reprovaveis.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(reprovaveis.get(i));
		}
	}
	public Reprovavel getReprovavel(String codigo) {
		for (Reprovavel reprovavel : reprovaveis) {
			if (reprovavel.temMesmoCodigo(codigo)) {
				return reprovavel;
			}
		}
		return null;
	}
	public Reprovavel getReprovavel(int index) {
		if (1 <= index && index <= reprovaveis.size()) {
			return reprovaveis.get(index-1);
		}
		return null;
	}
	
	public void exibirEletivas() {
		System.out.println("Disciplinas Eletivas");
		for (int i = 0; i < eletivas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(eletivas.get(i));
		}
	}
	public Eletiva getEletiva(int index) {
		if (1 <= index && index <= eletivas.size()) {
			return eletivas.get(index-1);
		}
		return null;
	}
	
	public ArrayList<Disciplina> obtemTodasDisciplinas() {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		for (Disciplina disciplina : reprovaveis) {
			disciplinas.add(disciplina);
		}
		for (Disciplina disciplina : eletivas) {
			disciplinas.add(disciplina);
		}
		return disciplinas;
	}
	public boolean haDisciplinas() {
		return obtemTodasDisciplinas().size() > 0;
	}
	public void exibirTodasDisciplinas() {
		ArrayList<Disciplina> disciplinas = obtemTodasDisciplinas();
		System.out.println("Disciplinas:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(disciplinas.get(i));
		}
	}
	public Disciplina getDisciplina(String codigo) {
		ArrayList<Disciplina> disciplinas = obtemTodasDisciplinas();
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.temMesmoCodigo(codigo)) {
				return disciplina;
			}
		}
		return null;
	}
	public Disciplina getDisciplina(int index) {
		ArrayList<Disciplina> disciplinas = obtemTodasDisciplinas();
		if (1 <= index && index <= disciplinas.size()) {
			return disciplinas.get(index-1);
		}
		return null;
	}

	public void exibirTurmas() {
		System.out.println("Turmas:");
		for (int i = 0; i < turmas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(turmas.get(i));
		}
	}
	public Turma getTurma(int index) {
		if (1 <= index && index <= turmas.size()) {
			return turmas.get(index-1);
		}
		return null;
	}
	
	public void exibirLecionadores() {
		System.out.println("Lecionadores:");
		for (int i = 0; i < lecionadores.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(lecionadores.get(i));
		}
	}
	public Lecionador getLecionador(int index) {
		if (1 <= index && index <= lecionadores.size()) {
			return lecionadores.get(index-1);
		}
		return null;
	}
	
	
	

	@Override
	public String toString() {
		return nome;
	}
}
