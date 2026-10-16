package modelo;

public abstract class Atendimento implements Comparable<Atendimento> {

	private final int carga;
	private Data data;
	private Paciente paciente;
	private Profissional profissional;
	private StatusAtendimento status = StatusAtendimento.PENDENTE;
	
	public Atendimento(Paciente paciente, Profissional profissional, Data data) {
		if (paciente != null) {
			this.paciente = paciente;
		}
		if (profissional != null) {
			this.profissional = profissional;
		}
		if (data != null && Data.agora().compareTo(data) < 1) {
			this.data = data;
		}
	}

	public boolean marcarCirurgia() {
		if (realizado()) {
			Consulta acompanhamento = new Consulta(paciente, profissional, data.avancarDias(35));
			if (consulta != null) {
				paciente.adicionarAtendimento(acompanhamento);
				profissional.adicionarAtendimento(acompanhamento);
				return true;
			}

		}
		return false;
	}

	// apenas chamado por Cirurgiões
	public boolean marcarCirurgia() {
		if (realizado()) {
			Cirurgia cirurgia = new Cirurgia(paciente, profissional, data.avancarDias(56));
			if (cirurgia != null) {
				paciente.adicionarAtendimento(cirurgia);
				profissional.adicionarAtendimento(cirurgia);
				return true;
			}
		}
		return false;
	}

	public int getCarga() {
		return carga;
	}

	public boolean inciar() {
		if (pendente() && !profissional.estaAtendendo()) {
			status = StatusAtendimento.EM_ANDAMENTO;
			return true;
		}
		return false;
	}
	
	public boolean finalizar() {
		if (emAndamento()) {
			status = StatusAtendimento.REALIZADO;
			return true;
		}
		return false;
	}

	public boolean cancelar() {
		if (pendente()) {
			status = StatusAtendimento.CANCELADO;
			return true;
		}
		return false;
	}
	
	public boolean temMesmaData(Atendimento atendimento) {
		if (atendimento == null) return false;
		return data.equals(atendimento.data);
	}

	public boolean pendente() {
		return status.equals(StatusAtendimento.PENDENTE);
	}

	public boolean emAndamento() {
		return status.equals(StatusAtendimento.EM_ANDAMENTO);
	}

	public boolean cancelado() {
		return status.equals(StatusAtendimento.CANCELADO);
	}

	private boolean realizado() {
		return status.equals(StatusAtendimento.REALIZADO);

	@Override
	public String toString() {
		return status + ", Paciente: " + paciente + ", Profissional: " + profissional + ", Data: " + data;
	}
	
	@Override
	public int compareTo(Atendimento outra) {
		if (status.compareTo(outra.status) != 0) return status.compareTo(outra.status);
		return data.compareTo(outra.data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Atendimento outra = (Atendimento) obj;
		if (!data.equals(outra.data)) return false;
		if (!paciente.equals(outra.paciente)) return false;
		if (!profissional.equals(outra.profissional)) return false;
		return true;
	}
}
