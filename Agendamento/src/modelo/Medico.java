package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Pessoa{

	private String CRM;
	private Especialidade especialidade;
	private ArrayList<Consulta> consultas;
	
	
	public Medico(String nome, LocalDate dataNascimento, String cRM, Especialidade especialidade, ArrayList<Consulta> consultas) {
		super(nome, dataNascimento);
		if(cRM != null && especialidade != null && consultas != null) {
			CRM = cRM;
			this.especialidade = especialidade;
			this.consultas = consultas;
	}
	}

	public void adicionarConsulta(Consulta c) {
		
	}
	
	public boolean estaDisponivel(LocalDate dia) {
		int consultasDia = 0;	
		for(Consulta consAtual : consultas) {
				if(consAtual.temMesmaData(dia)) {
					consultasDia++;
			}
		}
		return consultasDia<=15;
	}

	public void obterIdentificacao() {
		System.out.printf("%s, CRM: %s, Especialidade: %s\n", this.obterDados(), this.CRM, this.especialidade);
	}
	
	
}
