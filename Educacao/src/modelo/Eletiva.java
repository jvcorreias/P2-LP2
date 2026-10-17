package modelo;

public class Eletiva extends Disciplina {
	
	private final int minimoAulas;

	public Eletiva(String nome, String codigo, int minimoAulas) {
		super(nome, codigo);
		if (minimoAulas > 0) {
			this.minimoAulas = minimoAulas;
		}
		else {
			this.minimoAulas = 0;
		}
	}

	@Override
	public boolean encerrar(Aluno aluno) {
		Matricula alvo = obterMatricula(aluno);
		if (alvo != null && alvo.presente(minimoAulas)) {
			alvo.aprovar();
			return true;
		}
		return false;
	}
}
