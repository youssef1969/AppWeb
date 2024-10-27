package pack;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

@Entity
public class Professeur {
	@Id
	private int id;
	private String nom;
	private String prenom;
	
	@JsonbCreator
    public Professeur(@JsonbProperty("id") int id, 
                 @JsonbProperty("nom") String nom, 
                 @JsonbProperty("prenom") String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
