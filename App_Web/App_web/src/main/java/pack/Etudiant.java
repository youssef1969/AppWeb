package pack;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

@Entity
public class Etudiant {
	
	@Id
	private int id;
	private String nom;
	private String prenom;
	
//	private Groupe gTP;
	private String classe;
	
	
//	public Etudiant(String nom, String prenom) {
//		this.nom = nom;
//		this.prenom = prenom;
//	}
//	
	@JsonbCreator
    public Etudiant(@JsonbProperty("id") int id, 
                 @JsonbProperty("nom") String nom, 
                 @JsonbProperty("prenom") String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
//        this.classe = "GROUPE TEST";
    }
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
//	public String getTP() {
//		return classe;
//	}
	
//	public void ajouterTP(Groupe g) {
//		classe = g;
//	}
	
	@Override
	public String toString() {
		return "Etudiant{"
				+ "prenom=\"" + prenom + "\"" + ","
				+ "nom=\"" + nom + "\"" + ","
//				+ "groupe=\"" + this.classe + "\""
				+ "}";
	}
	
	
}
