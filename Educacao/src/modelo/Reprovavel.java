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
	
	public boolean cadastrarAvaliacao(int index, float nota) {
		if (0 <= index && index < alunos.size()) {
			alunos.get(index).ganharNota(nota);
			alunos.get(index).realizarAvaliacao();
			return true;
		}
		return false;
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

	public boolean adicionarFaltas(int index, int qtd) {
		if (0 <= index && index < alunos.size()) {
			alunos.get(index).cadastrarFaltas(qtd);
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
	public boolean encerrar(int index) {
		if (index < 0 || alunos.size() <= index) return false;
		
		Matricula alvo = alunos.get(index);
		if (alvo != null && alvo.concluiuAvaliacoes(totalAvaliacoes)) {
			if (alvo.getMedia() >= 6f && !alvo.faltou(limiteFaltas + 1)) {
				return alvo.aprovar();
			}
			else {
				return alvo.reprovar();
			}
		}
		return false;
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
