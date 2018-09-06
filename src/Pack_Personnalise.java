import java.util.Arrays;

public class Pack_Personnalise extends Pack_Voyage {

	public Pack_Personnalise(int ref, int nbrJour, String destination,String date_dep, String date_ret, String descriptif, float prix_p_p) {
		super(ref, nbrJour, destination, date_dep, date_ret, descriptif, prix_p_p);
	}
	@Override
	public String toString() {
		return "Pack_Personnalise [ref=" + ref + ", nbrJour=" + nbrJour
				+ ", nbrActJour=" + nbrActJour + ", destination=" + destination
				+ ", date_dep=" + date_dep + ", date_ret=" + date_ret
				+ ", descriptif=" + descriptif + ", descIterenaire="
				+ descIterenaire + ", prix_p_p=" + prix_p_p + ", \n iterenaire= \n"
				+ Arrays.toString(iterenaire) + "]\n";
	}
public void AffPack_Personnalise(){
	System.out.println(this.toString());
}

}
