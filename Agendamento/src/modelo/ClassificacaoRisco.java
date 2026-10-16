package modelo;

public enum ClassificacaoRisco {
	EMERGENCIA("Emergência", 10),
	MUITO_URGENTE("Muito Urgente", 7),
	URGENTE("Urgente", 5),
	POUCO_URGENTE("Pouco Urgente", 3),
	NAO_URGENTE("Não Urgente", 1);

	private String nome;
	private int prioridade;

	private ClassificacaoRisco(String nome, int prioridade) {
		this.nome = nome;
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return prioridade;
	}

	@Override
	public String toString() {
		return nome;
	}
}
