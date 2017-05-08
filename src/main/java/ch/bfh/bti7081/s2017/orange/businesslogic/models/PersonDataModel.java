/*
 * Copyright (c) 2015 DV Bern AG, Switzerland
 *
 * Das vorliegende Dokument, einschliesslich aller seiner Teile, ist urheberrechtlich
 * geschuetzt. Jede Verwertung ist ohne Zustimmung der DV Bern AG unzulaessig. Dies gilt
 * insbesondere fuer Vervielfaeltigungen, die Einspeicherung und Verarbeitung in
 * elektronischer Form. Wird das Dokument einem Kunden im Rahmen der Projektarbeit zur
 * Ansicht uebergeben ist jede weitere Verteilung durch den Kunden an Dritte untersagt.
 */
package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import java.util.ArrayList;
import java.util.List;

public class PersonDataModel {

	private PersonService personService = new PersonService();

	public List<Person> getAllPersons(String fromUser){
		return personService.getAllPersonen(fromUser);
	}

	//TODO joy das ist nur mal zum Testen ob das funktionieren würde
	public class Person {
		private String nachname;
		private String vorname;
		private String emailadresse;
		private String telefonnummer;
		private String krankenkasse;


		public String getNachname() {
			return nachname;
		}

		public void setNachname(String nachname) {
			this.nachname = nachname;
		}

		public String getVorname() {
			return vorname;
		}

		public void setVorname(String vorname) {
			this.vorname = vorname;
		}

		public String getEmailadresse() {
			return emailadresse;
		}

		public void setEmailadresse(String emailadresse) {
			this.emailadresse = emailadresse;
		}

		public String getTelefonnummer() {
			return telefonnummer;
		}

		public void setTelefonnummer(String telefonnummer) {
			this.telefonnummer = telefonnummer;
		}

		public String getKrankenkasse() {
			return krankenkasse;
		}

		public void setKrankenkasse(String krankenkasse) {
			this.krankenkasse = krankenkasse;
		}

		public Person(String vorname){
			this.setVorname(vorname);
			this.setNachname(new StringBuilder(vorname).reverse().toString()+"er");
			this.setEmailadresse(getVorname()+"."+getNachname()+"@somedo.com");
			this.setTelefonnummer("031 458 58 65");
			this.setKrankenkasse(getVorname()+"kasse");
					}
	}
	private class PersonService{
		public List<Person> getAllPersonen(String fromUser){
			List<Person> personen = new ArrayList<>();
			Person somePerson1 = new Person("simon");
			Person somePerson2 = new Person("ulrich");
			Person somePerson3 = new Person("annamaria");
			Person somePerson4 = new Person("leonie");


			personen.add(somePerson1);
			personen.add(somePerson2);
			personen.add(somePerson3);
			personen.add(somePerson4);
			return personen;
		}


	}

}
