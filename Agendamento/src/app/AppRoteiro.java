package app;

import modelo.*;

public class AppRoteiro {
	public static void main(String [] args) {
		Hospital posto = new Hospital("Posto de Saúde");
		posto.criarSetor(Especialidade.PEDIATRIA);
		Medico medico1 = new Medico("Sérgio", new Data(12, 11, 1990), "12414-2", Especialidade.valueOf("PEDIATRIA"));
		Paciente paciente1 = new Paciente("Lorena", new Data(18, 8, 2015));
		Paciente paciente2 = new Paciente("Mauro", new Data(30, 11, 1997));

		System.out.println(posto);
		System.out.println(medico1);
		System.out.println(paciente1);
		paciente1.exibirConsultas();

		if(paciente1.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2026))) {
			System.out.println("Sucesso ao agendar consulta!");
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}

		if (posto.cadastrarMedico(medico1)) {
			System.out.println("Médico cadastrado com sucesso!");
		}
		else {
			System.out.println("Falha ao cadastrar médico!");
		}

		if(paciente1.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2026))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente1.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}

		if(paciente1.irAProximaConsulta()) {
			System.out.println("Consulta realizada com sucesso!");
		}
		else {
			System.out.println("Falha ao realizar consulta!");
		}

		paciente1.exibirConsultas();
		
		if(paciente1.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2026))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente1.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}
		if(paciente2.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2026))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente2.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}

		if(paciente1.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2027))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente1.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}
		if(paciente2.agendarConsulta(posto, Especialidade.PEDIATRIA, new Data(29, 12, 2027))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente2.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}

		if(paciente2.agendarConsulta(posto, Especialidade.ORTOPEDIA, new Data(29, 12, 2027))) {
			System.out.println("Sucesso ao agendar consulta!");
			paciente1.exibirConsultas();
		}
		else {
			System.out.println("Falha ao agendar consulta!");
		}
	}
}
