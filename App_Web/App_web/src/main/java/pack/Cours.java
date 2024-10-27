package pack;
import java.util.List;
import java.time.*;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nom;
	
	@OneToMany
	private List<Groupe> listeGroupeEtudiants;
	@OneToMany
	private List<Professeur> listeProfs;
	private LocalDate jour;
	private LocalTime debut;
	private LocalTime fin;
	
	private String lieu;
	
	 @JsonbCreator
	    public Cours(@JsonbProperty("titre") String nom, 
	                 @JsonbProperty("etudiants") List<Groupe> etudiants, 
	                 @JsonbProperty("profs") List<Professeur> professeurs, 
	                 @JsonbProperty("jour") LocalDate jour,
	                 @JsonbProperty("debut") LocalTime debut, 
	                 @JsonbProperty("fin") LocalTime fin, 
	                 @JsonbProperty("lieu") String lieu) {
	        this.nom = nom;
	        this.listeGroupeEtudiants = etudiants;
	        this.listeProfs = professeurs;
	        this.jour = jour;
	        this.debut = debut;
	        this.fin = fin;
	        this.lieu = lieu;
	    }
	 
	
	
	
	public void ajouterGroupeEtudiants(Groupe g) {
		listeGroupeEtudiants.add(g);
	}
	
	public void ajouterProfesseur(Professeur p) {
		listeProfs.add(p);
	}

	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Groupe> getListeGroupeEtudiants() {
		return listeGroupeEtudiants;
	}

	public void setListeGroupeEtudiants(List<Groupe> listeGroupeEtudiants) {
		this.listeGroupeEtudiants = listeGroupeEtudiants;
	}

	public List<Professeur> getListeProfs() {
		return listeProfs;
	}

	public void setListeProfs(List<Professeur> listeProfs) {
		this.listeProfs = listeProfs;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}
	
	public LocalTime getDebut() {
		return debut;
	}
	
	
}
