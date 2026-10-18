package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public abstract class Disciplina implements Comparable<Disciplina> {
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
	
	public abstract boolean encerrar(int index);
	public abstract boolean encerrar(Aluno aluno);
	
	public boolean adicionarPresencas(Aluno aluno, int qtd) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null) {
			alvo.cadastrarPrensencas(qtd);
			return true;
		}
		return false;
	}
	
	public void ordenarMatriculas() {
		Collections.sort(alunos);
	}
	
	public void adicionarMatricula(Matricula matricula) {
		alunos.add(matricula);
		ordenarMatriculas();
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
		System.out.println("Alunos:");
		for (Matricula matricula : alunos) {
			System.out.print("\t");
			matricula.dadosAluno();
		}
	}
	
	public boolean cancelarDisciplina() {
		for (int i = 0; i < alunos.size(); i++) {
			Matricula alvo = alunos.get(0);
			if (!alvo.cancelar()) return false;
		}
		return true;
	}
	
	public boolean temMesmoCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}
	
	@Override
	public String toString() {
		return nome + " [" + codigo + "]";
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
	
	@Override
	public int compareTo(Disciplina outra) {
		if (outra == null) return 1;
		return nome.compareTo(outra.nome);
	}
}
