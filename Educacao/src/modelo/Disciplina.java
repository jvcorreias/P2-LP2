package modelo;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Disciplina {
	protected String nome;
	protected String codigo;
	
	protected ArrayList<Matricula> alunos = new ArrayList<>();

	public Disciplina(String nome, String codigo) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
		if (codigo != null && !codigo.isBlank()) {
			this.codigo = codigo;
		}
	}
	
	public abstract boolean encerrar(Aluno aluno);
	
	public boolean adicionarPresencas(Aluno aluno, int qtd) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null) {
			alvo.cadastrarPrensencas(qtd);
			return true;
		}
		return false;
	}
	
	public void adicionarMatricula(Matricula matricula) {
		alunos.add(matricula);
	}
	
	public void removerMatricula(Matricula matricula) {
		alunos.remove(matricula);
	}
	
	protected Matricula obterMatricula(Aluno aluno) {
		for (Matricula matricula : alunos) {
			if (matricula.ehMesmoAluno(aluno)) {
				return matricula;
			}
		}
		return null;
	}

	public void listarAlunos() {
		for (Matricula matricula : alunos) {
			matricula.dadosAluno();
		}
	}
	
	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", codigo=" + codigo + "]";
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
