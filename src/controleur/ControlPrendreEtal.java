package controleur;

import frontiere.Clavier;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return false;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		boolean nomVendeurConnu = controlVerifierIdentite.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println(String.format(
					"Je suis désolé %s mais il faut être un habitant de notre village pour commercer ici", nomVendeur
					));
		} else {
			StringBuilder question = new StringBuilder();
			question.append(String.format("Bonjour %s, je vais regarder si je peux vous trouver un etal.\n", nomVendeur));
			boolean etalDisponible = this.resteEtals();
			if(!etalDisponible) {
				question.append(String.format(
					"Désolé %s je n'ai plus plus d'étals qui ne soit pas déjà occupé", nomVendeur
					));
				System.out.println(question.toString());
			}
			else {
				question.append("C'est parfait, il me rest un etal pour vous\n");
				question.append("Ile me faudrait quelques rensignements\n");
				question.append("Quel produit souhaitez vous vendre ?");
				int nbProduit = Clavier.entrerEntier(question.toString());
				ControlPrendreEtal.
			}
		}
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		// ??
		return false;
	}
}
