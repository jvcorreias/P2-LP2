package modelo;

public final class Reprovavel extends Disciplina {

	private final int totalAvaliacoes;
	private final int limiteFaltas;
	
	public Reprovavel(String nome, String codigo, int totalAvaliacoes, int limiteFaltas) {
		super(nome, codigo);
		if (totalAvaliacoes >= 1) {
			this.totalAvaliacoes = totalAvaliacoes;
		}
		else {
			this.totalAvaliacoes = 1;
		}
		if (limiteFaltas >= 0) {
			this.limiteFaltas = limiteFaltas;
		}
		else {
			this.limiteFaltas = 0;
		}
	}

	public boolean cadastrarAvaliacao(Aluno aluno, float nota) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null && !alvo.concluiuAvaliacoes(totalAvaliacoes)) {
			obterMatricula(aluno).realizarAvaliacao();
			obterMatricula(aluno).ganharNota(nota);
			return true;
		}
		return false;
	}

	public boolean adicionarFaltas(Aluno aluno, int qtd) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null) {
			alvo.cadastrarFaltas(qtd);
			return true;
		}
		return false;
	}

	public float obterMedia(Aluno aluno) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null) {
			return alvo.getMedia();
		}
		return 0f;
	}

	@Override
	public boolean encerrar(Aluno aluno) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null && alvo.concluiuAvaliacoes(totalAvaliacoes)) {
			if (obterMedia(aluno) >= 6f && !alvo.faltou(limiteFaltas + 1)) {
				return alvo.aprovar();
			}
			else {
				return alvo.reprovar();
			}
		}
		return false;
	}

	public void checarEstado(Aluno aluno) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null) {
			if (obterMedia(aluno) >= 6f && !alvo.faltou(limiteFaltas + 1)) {
				System.out.println("Aluno será aprovado!");
			}
			else {
				System.out.println("Aluno será reprovado...");
			}
		}
	}
}
