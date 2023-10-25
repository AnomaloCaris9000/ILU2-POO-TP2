package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu)
			System.out.println("Mais vous n'ête pas inscris sur notre marché aujourd'hui !");
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = (donneesEtal[0] == "true");
			if(etalOccupe) {
				System.out.println(
						String.format("Vous avez vendu %s sur %s produit %s\nAu revoir %s, passez une bonne journée", donneesEtal[4], donneesEtal[3], donneesEtal[2], donneesEtal[1])
						);
			}
		}
	}

}
