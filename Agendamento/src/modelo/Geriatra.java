package modelo;

import java.util.ArrayList;

public final class Geriatra extends Profissional implements Cirurgiao {
	private final int cargaMaxima = 10;

	public Geriatra(String nome, Data dataNascimento, String CRM) {
		super(nome, dataNascimento, CRM);
	}

	@Override
	public boolean adicionarAtendimento(Atendimento atendimento) {
		if (atendimento != null && !atendimentos.contains(atendimento) && estaDisponivel(atendimento)) {
			atendimentos.add(atendimento);
			return true;
		}
		return false;
	}

	@Override
	public boolean estaDisponivel(Atendimento novoAtendimento) {
		int cargaDia = novoAtendimento.getCarga();

		for (Atendimento atendimento : atendimentos) {
			if (atendimento.temMesmaData(novoAtendimento)) {
				atendimentosDia += atendimento.getCarga();
			}
		}

		return cargaDia <= cargaMaxima;
	}

	@Override
	public boolean ehQualificado(Paciente paciente) {
		if (paciente.calcularIdade() >= 60) {
			return true;
		}
		return false;
	}

	@Override
	public boolean realizarAtendimento(Veredito veredito) {
		Atendimento alvo = atendimentoAFinalizar();

		if (alvo != null) {
			return alvo.finalizar(veredito);
		}

		return false;
	}

	@Override
	public boolean realizarCirurgia(Cirurgia cirurgia) {
		if (cirurgia != null && atendimentos.contains(cirurgia)) {
			cirurgia.finalizar();
			return true;
		}
		return false;
	}

	@Override
	public boolean realizarConsulta(boolean escalar) {
		if (consulta == null || !atendimentos.contains(consulta)) return false;
		consulta.realizar();
		if (escalar) {
			consulta.marcarCirurgia();
		}
		return true;
	}
}
