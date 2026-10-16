package modelo;

public final class ClinicoGeral extends Medico implements Cirurgiao {
	private final int cargaMaxima = 15;

	public ClinicoGeral(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento, CRM);
	}

	@Override
	public boolean estaDisponivel(Atendimento novoAtendimento) {
		int cargaDia = novoAtendimento.getCarga();

		for (Atendimento atendimento : atendimentos) {
			if (atendimento.temMesmaData(novoAtendimento)) {
				cargaDia += atendimento.getCarga();
			}
		}

		return cargaDia <= cargaMaxima;
	}

	@Override
	public boolean ehQualificado(Paciente paciente) {
		if (17 < paciente.calcularIdade() && paciente.calcularIdade() < 60) {
			return true;
		}
		return false;
	}

	@Override
	public boolean realizarCirurgia(Cirurgia cirurgia) {
		if (cirurgia != null && atendimentos.contains(cirurgia)) {
			cirurgia.realizar();
			return true;
		}
		return false;
	}

	@Override
	public boolean realizarConsulta(Consulta consulta, boolean escalar) {
		if (consulta == null || !atendimentos.contains(consulta)) return false;
		consulta.realizar();
		if (escalar) {
			consulta.marcarCirurgia();
		}
		return true;
	}
}
