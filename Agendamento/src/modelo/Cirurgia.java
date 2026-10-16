package modelo;

public class Cirurgia extends Atendimento {
	public Cirurgia(Paciente paciente, Cirurgiao cirurgiao, Data data) {
		super(paciente, cirurgiao, data);
	}

	@Override
	public boolean finalizar(Veredito veredito) {
		status = StatusAtendimento.REALIZADO;
		return switch (veredito) {
			case 
}
