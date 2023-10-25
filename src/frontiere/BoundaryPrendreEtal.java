package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(!nomVendeurConnu) {
			System.out.println(String.format(
					"Je suis désolé %s mais il faut être un habitant de notre village pour commercer ici", nomVendeur
					));
		} else {
			StringBuilder question = new StringBuilder();
			question.append(String.format("Bonjour %s, je vais regarder si je peux vous trouver un etal.\n", nomVendeur));
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				question.append(String.format(
					"Désolé %s je n'ai plus plus d'étals qui ne soit pas déjà occupé", nomVendeur
					));
				System.out.println(question);
			}
			else
				installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		int nbProduit;
		String produit;
		int numeroEtal;
		question.append("C'est parfait, il me rest un etal pour vous !\n");
		question.append("Il me faudrait quelques rensignements :\n");
		question.append("Quel produit souhaitez vous vendre ?");
		System.out.println(question);
		produit = scan.nextLine();
		nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		numeroEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println(String.format("Le vendeur %s s'est instalé à l'étal n°%d", nomVendeur, numeroEtal));
		}
	}
}
