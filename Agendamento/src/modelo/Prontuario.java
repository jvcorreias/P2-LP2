package modelo;

public class Prontuario {
  private String tipoSanguineo;
  private String alergias = "Nenhuma registrada";

  public Prontuario(String tipoSanguineo){
    if (tipoSanguineo != null && !tipoSanguineo.isBlank()) {
	      this.tipoSanguineo = tipoSanguineo;
		}
    
  }

  public void adicionarAlergia(String alergia){
    if (alergias.equals("Nenhuma registrada")) {
	      this.alergia = alergia;
		} else {
        this.alergia += ", " + alergia;
    }
  }
}
