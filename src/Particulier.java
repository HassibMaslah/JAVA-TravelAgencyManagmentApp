
public class Particulier extends Client{

	private int cin ;
	public String prenom;
	public String nom;
	
	public Particulier(int id, int cin, String prenom, String nom) {
		super(id);
		this.cin = cin;
		this.prenom = prenom;
		this.nom = nom;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "Particulier [cin=" + cin + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
}


