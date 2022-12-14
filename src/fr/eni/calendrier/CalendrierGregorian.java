package fr.eni.calendrier;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendrierGregorian {
	
	public static void main(String[] args) {
		
		GregorianCalendar dateDuJour = new GregorianCalendar();
		
		System.out.printf("Aujourd'hui nous sommes le %d %s %d et voici le calendrier du mois :%n",
			dateDuJour.get(GregorianCalendar.DAY_OF_MONTH),
			dateDuJour.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
			dateDuJour.get(GregorianCalendar.YEAR));
		
		afficherMois(dateDuJour.get(GregorianCalendar.YEAR), dateDuJour.get(GregorianCalendar.MONTH));
		
		System.out.println();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Choisissez une année :");
		int year = s.nextInt();
		System.out.println("Choisissez maintenant le numéro d'un mois compris entre 1 et 12 :");
		int month = s.nextInt() - 1;
		
		System.out.println();
		System.out.println("Voici le calendrier du mois :");
		
		afficherMois(year,month);
		
		s.close();
	}
	
	public static void afficherMois(int year, int month) {
		GregorianCalendar date = new GregorianCalendar(year, month, 1);
		int numDay = 1;
		int nbDayPerMonth = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		// Affichage mois / année
		System.out.printf(" * %s %d *%n",
			date.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
			date.get(GregorianCalendar.YEAR));
		
		// Affichage entête calendrier
		System.out.println("L  Ma Me J  V  S  D");
		
		// Début mois
		int beginDay = 0;
		switch (date.get(GregorianCalendar.DAY_OF_WEEK)) {
		case GregorianCalendar.MONDAY -> beginDay = 0;
		case GregorianCalendar.TUESDAY -> beginDay = 1;
		case GregorianCalendar.WEDNESDAY -> beginDay = 2;
		case GregorianCalendar.THURSDAY -> beginDay = 3;
		case GregorianCalendar.FRIDAY -> beginDay = 4;
		case GregorianCalendar.SATURDAY -> beginDay = 5;
		case GregorianCalendar.SUNDAY -> beginDay = 6;
		}
		for (int i=0;i<beginDay;i++) {
			System.out.print("   ");
		}
		for (int d=beginDay;d<7;d++) {
			System.out.printf("%02d ", numDay);
			numDay++;
		}
		System.out.println();
		
		// Remplissage mois
		for (int j=1;j<=5;j++) {
			for (int k=1;k<=7;k++) {
				System.out.printf("%02d ", numDay);
				numDay++;
				if (numDay > nbDayPerMonth) {
					j = 5;
					k = 7;
				}
			}
			System.out.println();
		}
	}

}