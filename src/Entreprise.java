
public class Entreprise extends Client{
	public String nomEntp ;
	public String adr;
	private String mission;
	
	public Entreprise(int id, String nomEntp, String adr, String mission) {
		super(id);
		this.nomEntp = nomEntp;
		this.adr = adr;
		this.mission = mission;
	}

	public String getNomEntp() {
		return nomEntp;
	}

	public void setNomEntp(String nomEntp) {
		this.nomEntp = nomEntp;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	@Override
	public String toString() {
		return "Entreprise [NomEntreprise=" + getNomEntp() + ", Adresse="
				+ getAdr() + ", Mission=" + getMission() + "]";
	}
	
	
	

}
