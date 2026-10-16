package modelo;

public class Triagem implements Priorizavel{

	private Paciente paciente;
	private int sintomasPreocupantes;
	private ClassificacaoRisco classificacao;
	
	public Triagem(Paciente paciente, int sintomasPreocupantes, ClassificacaoRisco classificacao) {
		if (paciente != null) {
			this.paciente = paciente;
		}
		if (sintomasPreocupantes >= 0) {
			this.sintomasPreocupantes = sintomasPreocupantes;
		}
		if (classificacao != null) {
			this.classificacao = classificacao;
		}
	}

	public int calcularPrioridade() {
		return classificacao.getPrioridade() + sintomasPreocupantes;
	}
}
