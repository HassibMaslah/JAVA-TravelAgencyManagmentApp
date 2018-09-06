import java.util.Arrays;

public class Pack_Voyage {
int ref,nbrJour,nbrActJour=0;
String destination,date_dep,date_ret,descriptif,descIterenaire;
float prix_p_p;
String[] iterenaire ;
public int getRef() {
	return ref;
}
public void setRef(int ref) {
	this.ref = ref;
}
public int getNbrJour() {
	return nbrJour;
}
public void setNbrJour(int nbrJour) {
	this.nbrJour = nbrJour;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getDate_dep() {
	return date_dep;
}
public void setDate_dep(String date_dep) {
	this.date_dep = date_dep;
}
public String getDate_ret() {
	return date_ret;
}
public void setDate_ret(String date_ret) {
	this.date_ret = date_ret;
}
public String getDescriptif() {
	return descriptif;
}
public void setDescriptif(String descriptif) {
	this.descriptif = descriptif;
}
public float getPrix_p_p() {
	return prix_p_p;
}
public void setPrix_p_p(float prix_p_p) {
	this.prix_p_p = prix_p_p;
}
public String getDescIterenaire() {
	return descIterenaire;
}
public void setDescIterenaire(String descIterenaire) {
	this.descIterenaire = descIterenaire;
}

public Pack_Voyage(int ref, int nbrJour, String destination, String date_dep,
	String date_ret, String descriptif, float prix_p_p) {
	super();
	this.ref = ref;
	this.nbrJour = nbrJour;
	this.destination = destination;
	this.date_dep = date_dep;
	this.date_ret = date_ret;
	this.descriptif = descriptif;
	this.prix_p_p = prix_p_p;
	iterenaire = new String[nbrJour];
}

public Pack_Voyage() {
}
public void AjoutIterenaire(String descIterenaire){
	if(nbrActJour<nbrJour){
		iterenaire[nbrActJour++]="Jour "+nbrActJour+" "+descIterenaire+"\n";
	}
	else
		System.out.println("L'itinéraire est Complet!");
}

@Override
public String toString() {
	return "Pack_Voyage [ref=" + ref + ", nbrJour=" + nbrJour
			+ ", destination=" + destination + ", date_dep=" + date_dep
			+ ", date_ret=" + date_ret + ", descriptif=" + descriptif
			+ ", prix_p_p=" + prix_p_p + ", iterenaire="
			+ Arrays.toString(iterenaire) + "]\n";
}


}
