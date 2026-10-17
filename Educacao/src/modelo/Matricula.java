package modelo;

import java.util.Objects;

public class Matricula implements Comparable<Matricula> {
	private Aluno aluno;
	private Disciplina disciplina;
	private int avaliacoes = 0;
	private float nota = 0f;
	private int presencas = 0;
	private int faltas = 0;
	private Estado estado = Estado.VALIDA;
	
	public Matricula(Aluno aluno, Disciplina disciplina) {
		if (aluno != null) {
			this.aluno = aluno;
		}
		if (disciplina != null) {
			this.disciplina = disciplina;
			this.disciplina.adicionarMatricula(this);
		}
	}
	
	public boolean cancelar() {
		if (estado.equals(Estado.VALIDA)) {
			disciplina.removerMatricula(this);
			estado = Estado.CANCELADA;
			return true;
		}
		return false;
	}
	
	public boolean aprovar() {
		if (estado.equals(Estado.VALIDA)) {
			disciplina.removerMatricula(this);
			estado = Estado.CONCLUIDA;
			return true;
		}
		return false;
	}
	
	public boolean reprovar() {
		if (estado.equals(Estado.VALIDA)) {
			disciplina.removerMatricula(this);
			estado = Estado.REPROVADA;
			return true;
		}
		return false;
	}
	
	public boolean cadastrarPrensencas(int qtd) {
		if (qtd > 0) {
			presencas += qtd;
			return true;
		}
		return false;
	}
	
	public boolean presente(int qtd) {
		return presencas >= qtd;
	}
	
	public boolean cadastrarFaltas(int qtd) {
		if (qtd > 0) {
			faltas += qtd;
			return true;
		}
		return false;
	}
	
	public boolean faltou(int qtd) {
		return faltas >= qtd;
	}
	
	public void realizarAvaliacao() {
		avaliacoes++;
	}
	
	public boolean concluiuAvaliacoes(int qtd) {
		return avaliacoes >= qtd;
	}
	
	public void ganharNota(float nota) {
		if (nota > 0f) {
			this.nota += nota;
		}
	}
	
	public float getMedia() {
		return nota / avaliacoes;
	}
	
	public boolean concluiu() {
		return estado.equals(Estado.CONCLUIDA);
	}
	public boolean emCurso() {
		return estado.equals(Estado.VALIDA);
	}

	public boolean ehMesmaDisciplina(Disciplina disciplina) {
		return this.disciplina.equals(disciplina);
	}
	
	public boolean ehMesmoAluno(Aluno aluno) {
		return this.aluno.equals(aluno);
	}
	
	public void dadosAluno() {
		System.out.println(estado + ", " + aluno + " - Nota: " + nota + " - " + faltas + " faltas");
	}
	
	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", disciplina=" + disciplina + ", avaliacoes=" + avaliacoes + ", nota="
				+ nota + ", presencas=" + presencas + ", faltas=" + faltas + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, disciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(disciplina, other.disciplina);
	}

	
	@Override
	public int compareTo(Matricula outra) {
		if (outra == null) return 1;
		if (!estado.equals(outra.estado)) return estado.compareTo(outra.estado);
		if (nota != outra.nota) return Float.compare(nota, outra.nota);
		return disciplina.compareTo(outra.disciplina);
	}
}
