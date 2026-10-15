package modelo;

import java.time.LocalDate;

public class Consulta {

	private LocalDate data;
	private Paciente paciente;
	private Medico medico;
	private StatusConsulta status;
	
	public int compareTo(Consulta con) {
		
	}
	
	public void realizarConsulta() {
		
	}
	
	public boolean temMesmaData(LocalDate dia) {
		return data.equals(dia);
	}
	
	
}
