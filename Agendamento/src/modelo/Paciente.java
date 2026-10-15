package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Pessoa {

	private ArrayList<Consulta> consultas;
	private Triagem ultimaTriagem;
	
	
	
	
	public Paciente(String nome, LocalDate dataNascimento, ArrayList<Consulta> consultas, Triagem ultimaTriagem) {
		super(nome, dataNascimento);
		if(consultas!=null && ultimaTriagem!=null)
		this.consultas = consultas;
		this.ultimaTriagem = ultimaTriagem;
	}

	public void agendarConsulta(){
		
	}
	
	public void realizarTriagem(int sintomas, EstadoSaude e) {
		ultimaTriagem = new Triagem(this, sintomas, e);
	}

	public void obterIdentificacao() {
		System.out.println("%s, ");
	}
	
}
