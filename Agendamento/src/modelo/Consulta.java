package modelo;

public class Consulta implements Comparable<Consulta> {

	private Data data;
	private Paciente paciente;
	private Medico medico;
	private StatusConsulta status = StatusConsulta.PENDENTE;
	
	public Consulta(Paciente paciente, Medico medico, Data data) {
		if (paciente != null) {
			this.paciente = paciente;
		}
		if (medico != null)) {
			this.medico = medico;
		}
		if (data != null && Data.agora().compareTo(data) < 1) {
			this.data = data;
		}
	}
	
	public boolean realizar() {
		if (possivel()) {
			status = StatusConsulta.REALIZADA;
			return true;
		}
		return false;
	}

	public boolean cancelar() {
		if (possivel()) {
			status = StatusConsulta.CANCELADA;
			return true;
		}
		return false;
	}
	
	public boolean temMesmaData(Data dia) {
		return data.equals(dia);
	}

	public boolean possivel() {
		return status.equals(StatusConsulta.PENDENTE);
	}

	@Override
	public String toString() {
		return status + ", Paciente: " + paciente + ", Médico: " + medico + ", Data: " + data;
	}
	
	@Override
	public int compareTo(Consulta outra) {
		if (status.compareTo(outra.status) != 0) return status.compareTo(outra.status);
		return data.compareTo(outra.data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Consulta outra = (Consulta) obj;
		if (!data.equals(outra.data)) return false;
		if (!paciente.equals(outra.paciente)) return false;
		if (!medico.equals(outra.medico)) return false;
		return true;
	}
}
