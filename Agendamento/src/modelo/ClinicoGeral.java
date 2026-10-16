package modelo;

public class ClinicoGeral extends Medico implements Cirurgiao {
	private final int limiteConsultas = 9;

	public ClinicoGeral(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento, CRM);
	}

	@Override
	public boolean realizarCirurgia(Consulta consulta) {

	}

	@Override
	public boolean ehQualificado(Paciente paciente) {
		if (18 <= paciente.calcularIdade() && paciente.calcularIdade() <= 60) {
			return true;
		}
		return false;
	}
}
