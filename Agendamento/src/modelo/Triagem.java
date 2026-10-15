package modelo;

public class Triagem implements Priorizavel{

	private Paciente paciente;
	private int sintomasPreocupantes;
	private EstadoSaude estado;
	
	
	
	
	public Triagem(Paciente paciente, int sintomasPreocupantes, EstadoSaude estado) {
		if(paciente!=null && sintomasPreocupantes>=0 && estado != null) {
			this.paciente = paciente;
			this.sintomasPreocupantes = sintomasPreocupantes;
			this.estado = estado;
		}
	}




	public int calcularPrioridade() {
		int e;
		if(estado == estado.GRAVE) {
			e = 5;
		}else if(estado == estado.MODERADO) {
			e = 2;
		}else {
			e = 0;
		}
		
		return e + sintomasPreocupantes;
	}
	
	
}
