package modelo;

import java.time.LocalDate;

public class Atendimento {
	private Paciente paciente;
	private Consulta consulta;
	private LocalDate data;
	private Profissional profissional;

	public Atendimento(Paciente paciente, Consulta consulta, LocalDate data, Profissional profissional) {
		if (paciente != null) {
			this.paciente = paciente;
		}
		if (consulta != null) {
			this.consulta = consulta;
		}
		if (data != null && LocalDate.now().compareTo(data) >= 0) {
			this.consulta = consulta;
		}
		if (profissional != null) {
			this.profissional = profissional;
		}
	}


}
