package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Aluno {
	private String nome;
	private String cpf;
	
	protected ArrayList<Matricula> disciplinas = new ArrayList<Matricula>();
	
	public Aluno(String nome, String cpf) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
		if (cpf != null && !cpf.isBlank()) {
			this.cpf = cpf;
		}
	}
	
	public void ordenarMatriculas() {
		Collections.sort(disciplinas);
	}
	
	public boolean matricular(Disciplina disciplina) {
		if (!matriculado(disciplina)) {
			Matricula matriculaNova = new Matricula(this, disciplina);
			disciplinas.add(matriculaNova);
			return true;
		}
		return false;
	}
	
	public boolean desmatricular(Matricula matricula) {
		matricula.cancelar();
		return disciplinas.remove(matricula);
	}
	public boolean desmatricular(int index) {
		if (1 <= index && index <= disciplinas.size()) {
			return desmatricular(disciplinas.get(index-1));
		}
		return false;
	}
	public boolean desmatricular(Disciplina disciplina) {
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplina)) {
				return desmatricular(matricula);
			}
		}
		return false;
	}
	
	public void listarMatriculas() {
		System.out.println("Matrículas:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.print("\t" + (i+1) + ". ");
			System.out.println(disciplinas.get(i));
		}
	}

	public boolean matriculado(Disciplina disciplina) {
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplina)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean concluiu(Disciplina disciplina) {
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplina)) {
				return matricula.concluiu();
			}
		}
		return false;
	}
	public boolean estaCursando(Disciplina disciplina) {
		for (Matricula matricula : disciplinas) {
			if (matricula.ehMesmaDisciplina(disciplina)) {
				return matricula.emCurso();
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nome + ", cpf=" + cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
}
