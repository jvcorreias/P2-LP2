package app;

public enum OpcoesPrincipais {
	ALUNOS("Alunos"),
	LECIONADORES("Lecionadores"),
	TURMAS("Turmas"),
	DISCIPLINAS("Disciplinas");
	
	private String nome;
	private OpcoesPrincipais(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
