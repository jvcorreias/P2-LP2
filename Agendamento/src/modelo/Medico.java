package modelo;

import java.util.ArrayList;

public class Medico extends Pessoa {

	private String CRM;
	private Especialidade especialidade;
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	
	public Medico(String nome, Data dataNascimento, String CRM, Especialidade especialidade) {
		super(nome, dataNascimento);
		if(CRM != null && !CRM.isBlank()) {
			this.CRM = CRM;
		}
		if (especialidade != null) {
			this.especialidade = especialidade;
		}
	}

	public boolean adicionarConsulta(Consulta consulta) {
		if (consulta != null && !consultas.contains(consulta)) {
			consultas.add(consulta);
			return true;
		}
		return false;
	}
	
	public boolean estaDisponivel(Data data) {
		int consultasDia = 0;	
		for(Consulta consulta : consultas) {
			if(consulta.temMesmaData(data)) {
				consultasDia++;
			}
		}
		return consultasDia <= 15;
	}

	public boolean ehQualificado(Especialidade especialidade) {
		return this.especialidade.equals(especialidade);
	}

	public void obterIdentificacao() {
		System.out.printf("%s, CRM: %s, Especialidade: %s\n", this.obterDados(), this.CRM, this.especialidade);
	}
	
	@Override
	public String toString() {
		return super.toString() + " - CRM: " + CRM + " - especialidade: " + especialidade;
	}
}
