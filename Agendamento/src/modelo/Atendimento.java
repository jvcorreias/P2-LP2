package modelo;

public abstract class Atendimento implements Comparable<Atendimento> {

	private Data data;
	private Paciente paciente;
	private Medico medico;
	private StatusAtendimento status = StatusAtendimento.PENDENTE;
	
	public Atendimento(Paciente paciente, Medico medico, Data data) {
		if (paciente != null) {
			this.paciente = paciente;
		}
		if (medico != null) {
			this.medico = medico;
		}
		if (data != null && Data.agora().compareTo(data) < 1) {
			this.data = data;
		}
	}
	
	public boolean realizar() {
		if (possivel()) {
			status = StatusAtendimento.REALIZADA;
			return true;
		}
		return false;
	}

	public boolean cancelar() {
		if (possivel()) {
			status = StatusAtendimento.CANCELADA;
			return true;
		}
		return false;
	}
	
	public boolean temMesmaData(Data dia) {
		return data.equals(dia);
	}

	public boolean possivel() {
		return status.equals(StatusAtendimento.PENDENTE);
	}

	public boolean cancelada() {
		return status.equals(StatusAtendimento.CANCELADA);
	}

	@Override
	public String toString() {
		return status + ", Paciente: " + paciente + ", Médico: " + medico + ", Data: " + data;
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
		if (!medico.equals(outra.medico)) return false;
		return true;
	}
}
