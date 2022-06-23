import org.hibernate.criterion.CriteriaQuery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BeerService {
    @PersistenceContext(unitName = "beer-pu")
    private EntityManager entityManager;

    public void addBeer(Beer beer){
        entityManager.persist(beer);
    }

    public List<Beer> getAllBeers(){
        CriteriaQuery<Beer> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Beer.class);
        criteriaQuery.select(cq.from(Beer.class));
        return entityManager.createQuery(criteriaQuery);
    }
    public void clear(){
        Query removeAll = entityManager.createQuery("delete from Beer");
        removeAll.executeUpdate();
    }
}
