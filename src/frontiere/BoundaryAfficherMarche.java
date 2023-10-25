package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfosMarche();
		if(infoMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		} else {
			StringBuilder strb = new StringBuilder();
			String vendeur, quantite, produit;
			strb.append(String.format("%s vous trouverez au marché :\n", nomAcheteur));
			for(int i = 0; i < infoMarche.length; i++) {
				vendeur = infoMarche[i];
				i++;
				quantite = infoMarche[i];
				i++;
				produit = infoMarche[i];
				strb.append(String.format("- %s qui vend %s %s\n", vendeur, quantite, produit));
			}
				
			System.out.println(strb);
		}
	}
}
