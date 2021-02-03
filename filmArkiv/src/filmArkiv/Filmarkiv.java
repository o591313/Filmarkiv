package filmArkiv;

import filmArkivADT.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {

	private Film[] filmTabell;
	private int antall;

	public Filmarkiv(int antall) {
		this.filmTabell = new Film[antall];

	}

	@Override
	public Film[] hentFilmTabell() {

		trimTab(filmTabell, antall);
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (antall == filmTabell.length) {
			utvidKapasitet();
		}

		filmTabell[antall] = nyFilm;
		antall++;
	}

	public Film[] soekTittel(String delstreng) {

		Film[] filmer = new Film[filmTabell.length];
		int antallTitler = 0;

		for (int i = 0; filmTabell.length < antall; i++) {
			if (filmTabell[i].getTittel().contains("delstreng")) {
				filmer[antallTitler] = filmTabell[i];
				antallTitler++;
			}
		}
		trimTab(filmer, antallTitler);

		return filmer;
	}

	public Film[] soekProdusent(String delstreng) {

		Film[] filmer = new Film[filmTabell.length];
		int antallTitler = 0;

		for (int i = 0; filmTabell.length < antall; i++) {
			if (filmTabell[i].getProdusent().contains("delstreng")) {
				filmer[antallTitler] = filmTabell[i];
				antallTitler++;
			}
		}
		trimTab(filmer, antallTitler);

		return filmer;
	}

	@Override
	public boolean slettFilm(int filmnr) {

		for (int i = 0; filmTabell.length < antall; i++) {
			if (filmTabell[i].getFilmnr() == filmnr) {
				filmTabell[i] = null;
				antall--;
				return true;
			}

		}

		return false;
	}

	@Override
	public int antall() {

		return antall;
	}

	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; filmTabell.length < antall; i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	private Film[] trimTab(Film[] tab, int n) { // n er antall elementer

		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}

	private void utvidKapasitet() { // Utvider tabellens kapasitet med 10%

		Film[] hjelpetabell = new Film[(int) Math.ceil(1.1 * filmTabell.length)];
		for (int i = 0; i < filmTabell.length; i++) {
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;
	}

}
