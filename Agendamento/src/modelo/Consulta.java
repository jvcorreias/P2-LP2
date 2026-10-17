package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Consulta implements Imprimivel, Comparable<Consulta> {

	private final int carga;
	private Data data;
	private Paciente paciente;
	private Profissional profissional;
	private StatusConsulta status = StatusConsulta.PENDENTE;
	
	public Consulta(Paciente paciente, Profissional profissional, Data data) {
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
	public int compareTo(Consulta outra) {
		if (status.compareTo(outra.status) != 0) return status.compareTo(outra.status);
		return this.data.compareTo(outra.data);
	}

	@Override
	public String gerarFichaParaImpressao(){
		return "--- GUIA DE ATENDIMENTO ---\n" +
				"Data: " + data + "\n" + 
				"Paciente: " + paciente + "\n" + 
				"Atendimento com: " + profissional + "\n" + 
				"Status: " + status; 
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
