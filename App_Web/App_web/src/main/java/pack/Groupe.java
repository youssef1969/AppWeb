package pack;
import java.util.ArrayList;
import java.util.List;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

@Entity
public class Groupe {
	
	@Id
    private String nom;
	
	@OneToMany
    private List<Groupe> listeGroupe;
	
	@OneToMany
    private List<Etudiant> listeEtudiant;
	
	
    @JsonbCreator
    public Groupe(@JsonbProperty("nom") String nom) {
    	this.nom = nom;
        this.listeGroupe = new ArrayList<Groupe>();
        this.listeEtudiant = new ArrayList<Etudiant>();
    }

    // Getters et Setters
    public void ajouterEtudiant(Etudiant e) {
    	listeEtudiant.add(e);
    }
    
    public void ajouterGroupe(Groupe g) {
    	listeGroupe.add(g);
    }
    
    public String getNom() {
    	return nom;
    }
}