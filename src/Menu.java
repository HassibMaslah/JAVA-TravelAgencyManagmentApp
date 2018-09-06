import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static ArrayList<Client> client= new ArrayList<Client>();
	private static ArrayList<AffectVoyage> AffectV= new ArrayList<AffectVoyage>();
	private static ArrayList<Particulier> Particulier= new ArrayList<Particulier>();
	private static ArrayList<Entreprise> Entreprise= new ArrayList<Entreprise>();
	private static ArrayList<Pack_Voyage> PVoyage= new ArrayList<Pack_Voyage>();
	String[][] AffectVoyage;
	static int id=1;
	
//==============Function Inscription=========
public static void	Inscription() throws VoyageException{
	System.out.println("Inscrit Vous pour benificer de Nous Offres ! \n");	
	int choix=0;
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	do{
		System.out.println("Si Vous étes Entreprise tapez 1 sinon 2: \n");
		choix=sc.nextInt();
		if(choix==1){
		ajouterClient("Entreprise");
		}
		else if(choix==2){
		ajouterClient("particulier");
		}
	}while((choix!=1)&&(choix!=2));
	MenuPrincipale();
}
//==============Function ajouterClient=========	
	public static void ajouterClient(String type ){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	 if(type.equals("particulier")){
		System.out.println("Indiquer les données du " + type);
		System.out.println("Donner le nom :");
		String nom = sc.nextLine();
		System.out.println("Donner le prenom :");
		String prenom = sc.nextLine();
		System.out.println("Donner le cin :");
		 int cin = sc.nextInt();
		 Particulier p=new Particulier(id,cin, prenom,nom);
		 Particulier.add(p);
		 client.add(p);
			id++;
	}
	 else{
			System.out.println("Indiquer les données du " + type);
			System.out.println("Donner le nom :");
			String nom = sc.nextLine();
			System.out.println("Donner l'Adresse :");
			String adr = sc.nextLine();
			System.out.println("Donner la mission :");
			String mission = sc.nextLine();
			Entreprise e= new Entreprise(id, nom, adr, mission);
			Entreprise.add(e);
			client.add(e);
			id++; 
	 }
		System.out.println("client ajouter ");
	}	
//==============Function MenuPrincipale=========
public static void	MenuPrincipale() throws VoyageException{
	int choix=0;
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	do{
		System.out.println("Tapez 1 : Afficher les Pack Voyage disponible ! \n");
		System.out.println("Tapez 2 : Rechercher un client ! \n");
		System.out.println("Tapez 3 : Afficher la liste des client ! \n");
		System.out.println("Tapez 4 : Rechercher les pack en cour ! \n");
		System.out.println("Tapez 5 : Affecter un voyage ! \n");
		System.out.println("Tapez 6 : Afficher la liste des clients par voyage ! \n");
		choix=sc.nextInt();
		
		switch(choix){
		case 1:AfficherPacks();break;
		case 2:RechercheClient();break;
		case 3:AffichelistClient();break;
		case 4:RechercherlesPack();break;
		case 5:AffecterVoyage();break;
		case 6:Afficher_liste_clients_par_voyage();break;
		}
	}while((choix<1)&&(choix>4));
}
//==============Function Afficher_liste_clients_par_voyage()=========
public static void Afficher_liste_clients_par_voyage() throws VoyageException{
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Donner le voyage à chercher: \n");
	String voy=sc.nextLine();
	try{
	if(AffectV.size()==0){
		throw new VoyageException();	
	}
	for(int i=0;i<AffectV.size();i++){
		if((AffectV.get(i).dest).equals(voy)){
		System.out.println(AffectV.get(i).dest);
		for(int j=0;j<AffectV.size();j++){
			if(AffectV.get(i).dest.equals(AffectV.get(j).dest)){
				chercherClient(AffectV.get(i).id);
			}
		}
		}else
			System.out.println("Désolé voyage introuvable ");		
	}
	}catch(VoyageException e){
		System.out.println (e.messageAffectV());
	}
	System.out.println("Tapez 0 : Retourner vers le Menu ! \n");
	int choix=sc.nextInt();
	if(choix==0){
		MenuPrincipale();
	}	
}
public static void chercherClient(int id){
	for(int i=0;i<client.size();i++){
		if(client.get(i).id==id){
		System.out.println("le client est: "+client.get(i));
		}
	}
}

//==============Function ChoixClient=========
public static void	ChoixClient() throws VoyageException{
	int choix=0;
	Scanner sc = new Scanner(System.in);
	do{
		System.out.println("Tapez 1 : Affecter un voyage ! \n");
		System.out.println("Tapez 2 : Retourner vers le Menu ! \n");
		choix=sc.nextInt();
		if(choix==1){
		AffecterVoyage();
		}
		else if(choix==2){
		MenuPrincipale();
		}
	}while((choix!=1)&&(choix!=2));
}
//==============Function AffecterVoyage=========	
	public static void	AffecterVoyage() throws VoyageException{
		int test=-1;
		Pack_Organiser po=new Pack_Organiser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner votre Nom/Nom Entreprise :");
		String nom = sc.nextLine();
		int nomChercher=-1;
		for(int i=0;i<client.size();i++){
			if(client.get(i) instanceof Entreprise ){
				if(nom.equals(Entreprise.get(i).nomEntp)){
					nomChercher=Entreprise.get(i).id;
				}
			}
			if(client.get(i) instanceof Particulier ){
				if(nom.equals(Particulier.get(i).nom)){
					nomChercher=Particulier.get(i).id;
				}
			}
		}
		System.out.println("Donner votre Destination :");
		String dest = sc.nextLine();
		String destChercher=null;
		for(int i=0;i<PVoyage.size();i++){
			if(nom.equals(PVoyage.get(i).destination)){
				if(PVoyage.get(i) instanceof Pack_Organiser ){
					po=(Pack_Organiser)PVoyage.get(i);
					if(po.getNbrMax()>AffectV.size()){
						destChercher=PVoyage.get(i).destination;
					}else
						System.out.println("Capacités d'accueil de voyage à "+dest+" déjà atteinte !");
				}else
					destChercher=PVoyage.get(i).destination;
			}
		}
		if(nomChercher!=-1&&destChercher!=null){
		AffectVoyage a=new AffectVoyage(nomChercher,destChercher);
		AffectV.add(a);
		MenuPrincipale();
		}else{
			System.out.println("Nom ou Destinatin chercher introuvable !");
			AffecterVoyage();
		}
	}
//==============Function AfficherPacks=========	
	public static void	AfficherPacks(){
		System.out.println("Pack Voyage en cour: "+PVoyage.toString());
	}
//==============Function rechercherEntreprise=========
public static void	rechercherEntreprise() throws VoyageException{
	String RechEnt;
	int test=-1;
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Ecrire le nom de client a rechercher:  \n");
	RechEnt=sc.nextLine();
		for(int i=0;i<Entreprise.size();i++){
			if(RechEnt.equals(Entreprise.get(i).nomEntp)){
				test=i;
			}
		}
		if(test!=-1){
			System.out.println(Entreprise.get(test));
		}else
			System.out.println("Client introuvable !");
		
		System.out.println("Tapez 0 : Retourner vers le Menu ! \n");
		int choix=sc.nextInt();
		if(choix==0){
			MenuPrincipale();
		}
	}
//==============Function rechercherParticulier=========
public static void	rechercherParticulier() throws VoyageException{
	String RechEnt;
	int test=-1;
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Ecrire le nom de client a rechercher:  \n");
	RechEnt=sc.nextLine();
		for(int i=0;i<Particulier.size();i++){
			if(RechEnt.equals(Particulier.get(i).nom)){
				test=i;
			}
		}
		if(test!=-1){
			System.out.println(Particulier.get(test));
		}else
			System.out.println("Client introuvable !");
		
		System.out.println("Tapez 0 : Retourner vers le Menu ! \n");
		int choix=sc.nextInt();
		if(choix==0){
			MenuPrincipale();
		}
}
//==============Function RechercheClient=========
	public static void	RechercheClient() throws VoyageException{
		int Rechclient;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Tapez 1 : Rechercher un client Entreprise ! \n");
		System.out.println("Tapez 2 : Rechercher un client Particulier ! \n");
		Rechclient=sc.nextInt();
		if(Rechclient==1){
			rechercherEntreprise();
		}
		else if(Rechclient==2){
			rechercherParticulier();
		}
		else{
			RechercheClient();
		}
			
	}
	public static void	AffichelistClient() throws VoyageException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("La liste de client Particulier: \n");
		for(int i=0;i<Particulier.size();i++){
			System.out.println(Particulier.get(i));
		}
		System.out.println("La liste de client Entreprise: \n");
		for(int i=0;i<Entreprise.size();i++){
		System.out.println(Entreprise.get(i));
		}
		System.out.println("Tapez 0 : Retourner vers le Menu ! \n");
		int choix=sc.nextInt();
		if(choix==0){
			MenuPrincipale();
		}
	}
//==============Function RechercherlesPack=========
	public static void	RechercherlesPack() throws VoyageException{
		String RechVoyage;
		int test=-1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Rechercher un Voyage: \n");
		RechVoyage=sc.nextLine();
		for(int i=0;i<PVoyage.size();i++){
			if(RechVoyage.equals(PVoyage.get(i).destination)){
				test=i;
			}
		}
		if(test!=-1){
			System.out.println(PVoyage.get(test));
		}else
			System.out.println("Pack Voyage introuvable !");
		
		System.out.println("Tapez 0 : Retourner vers le Menu ! \n");
		int choix=sc.nextInt();
		if(choix==0){
			MenuPrincipale();
		}
	}

public static void main(String[]Args) throws VoyageException{
	//==============Pack_Organiser=========
	Pack_Organiser po=new Pack_Organiser(1, 7, "Istanbul&Bursa", "28/04/2018", " 04/05/2018", "Istanbul & Bursa: Départ en Groupe", 1577f,20,"20/04/2018");
	po.AjoutIterenaire("Tunis / Istanbul");
	po.AjoutIterenaire("Journée complète à Bursa avec téléphérique (sans déjeuner)");
	po.AjoutIterenaire("Journée Siècle Magnifique : Palais de TopKapi (Demi-journée sans déjeuner)");
	po.AjoutIterenaire("Istanbul journée Libre");
	po.AjoutIterenaire(" Bosphore, Une Ville à Deux Continents (Demi-journée sans déjeuner) ");
	po.AjoutIterenaire("Istanbul journée Libre");
	po.AjoutIterenaire("Istanbul/Tunis");
	//==============Pack_Personnalise=========
	Pack_Personnalise pp=new Pack_Personnalise(2, 7, "Istanbul", "29/04/2018" , "06/05/2018", " Istanbul. Toute l'année: elle charme les visiteurs avec son centre historique", 1447f);
	pp.AjoutIterenaire("Tunis / Istanbul");
	pp.AjoutIterenaire("Journée Siècle Magnifique : Palais de TopKapi (Demi-journée sans déjeuner)");
	pp.AjoutIterenaire("Iles Aux Princes et Asie (Journée complète sans déjeuner)");
	pp.AjoutIterenaire("Bosphore Une Ville à Deux Continents (Demi-journée sans déjeuner)");
	pp.AjoutIterenaire("Istanbul journée Libre");
	pp.AjoutIterenaire("Istanbul journée Libre");
	pp.AjoutIterenaire("Istanbul journée Libre");
	pp.AjoutIterenaire("Istanbul/Tunis");

	PVoyage.add(po);
	PVoyage.add(pp);

	//==============Inscription=========
	Inscription();
}



}
