package modelo;

public final class Pediatra extends Medico {
	private final int cargaMaxima = 15;

	public Pediatra(String nome, Data dataNascimento, String CRM) {
	       super(nome, dataNascimento, CRM);
	}

	@Override
	public boolean adicionarAtendimento(Atendimento novoAtendimento) {
		if (novoAtendimento != null && !atendimentos.contains(novoAtendimento)) {
			atendimentos.add(novoAtendimento);
			return true;
		}
		return false;
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
		if (0 <= paciente.calcularIdade() && paciente.calcularIdade() < 18) {
			return true;
		}
		return false;
	}

	@Override
	public boolean realizarConsulta(Consulta consulta, boolean acompanhar) {
		if (consulta == null || !atendimentos.contains(consulta)) return false;
		consulta.realizar();
		if (acompanhar) {
			consulta.marcarAcompanhamento();
		}
		return true;
	}
}
