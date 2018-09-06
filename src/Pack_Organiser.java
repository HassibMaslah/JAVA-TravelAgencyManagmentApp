import java.util.Arrays;

public class Pack_Organiser extends Pack_Voyage{
int nbrMax;
String date_fin_Insct;

public int getNbrMax() {
	return nbrMax;
}
public void setNbrMax(int nbrMax) {
	this.nbrMax = nbrMax;
}
public String getDate_fin_Insct() {
	return date_fin_Insct;
}
public void setDate_fin_Insct(String date_fin_Insct) {
	this.date_fin_Insct = date_fin_Insct;
}

public Pack_Organiser(){super();}
public Pack_Organiser(int ref, int nbrJour, String destination,String date_dep, String date_ret, String descriptif, float prix_p_p,int nbrMax,String date_fin_Insct) {
	super(ref, nbrJour, destination, date_dep, date_ret, descriptif, prix_p_p);
	this.nbrMax = nbrMax;
	this.date_fin_Insct = date_fin_Insct;
}

@Override
public String toString() {
	return "Pack_Organiser [ref=" + ref + ", date_fin_Insct="
			+ date_fin_Insct + ", nbrMax=" + nbrMax + ", nbrJour=" + nbrJour
			+ ", nbrActJour=" + nbrActJour + ", destination=" + destination
			+ ", date_dep=" + date_dep + ", date_ret=" + date_ret
			+ ", descriptif=" + descriptif + ", descIterenaire="
			+ descIterenaire + ", prix_p_p=" + prix_p_p + ",\n iterenaire= \n"
			+ Arrays.toString(iterenaire) + "]\n";
}
public void AffPack_Organiser(){
	System.out.println(this.toString());
}

}
