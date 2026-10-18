package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Professor implements Lecionador {
	private String nome;
	private String cadastro;
	
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	
	public Professor(String nome, String cadastro, Disciplina disciplina) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
		if (cadastro != null && !cadastro.isBlank()) {
			this.cadastro = cadastro;
		}
		if (disciplina != null) {
			disciplinas.add(disciplina);
		}
	}
	
	@Override
	public boolean cadastrarDisciplina(Disciplina disciplina) {
		if (disciplina != null && !disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
			return true;
		}
		return false;
	}
	@Override
	public boolean descadastrarDisciplina(Disciplina disciplina) {
		return disciplinas.remove(disciplina);
	}
	
	@Override
	public int lecionar(Disciplina disciplina, ArrayList<Aluno> alunos) {
		int alunosPresentes = 0;
		if (disciplina != null && leciona(disciplina)) {
			for (Aluno aluno : alunos) {
				disciplina.adicionarPresencas(aluno, 1);
				alunosPresentes++;
			}
		}
		return alunosPresentes;
	}
	
	@Override
	public boolean leciona(Disciplina disciplina) {
		return disciplinas.contains(disciplina);
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", cadastro=" + cadastro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadastro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(cadastro, other.cadastro);
	}

	@Override
	public boolean identificacao(String cadastro) {
		return cadastro.equals(cadastro);
	}
}
