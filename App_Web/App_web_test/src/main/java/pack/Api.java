package pack;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.time.*;


@Path("/api")
@Singleton
public class Api {

	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/edt")
	public List<Cours> getEdt(@QueryParam("date") LocalDate date, @CookieParam("sessionId") String sessionId) {
		//TODO
		//trouver user en fonction de son cookie ID
		//ensuite trouver tous les cours de l'user en question de la semaine en parametre (le jour)
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public void ajouter(Cours c) {
		//TODO
	}
	
	@PostConstruct
	public void init() {
		Etudiant e = new Etudiant(0,"Roques","Romeo");
		Groupe tp = new Groupe("TP");
		tp.ajouterEtudiant(e);
		List<Groupe> lg = new ArrayList<Groupe>();
		lg.add(tp);
		List<Professeur> lp = new ArrayList<Professeur>();
		Professeur p = new Professeur(1,"Chaput","Emmanuel");
		lp.add(p);
		Cours c = new Cours("TP de Prank",
							lg,
							lp,
							LocalDate.now(),
							LocalTime.now(),
							LocalTime.now(),
							"C203");
		em.persist(c);
		
	}
		
	
}
