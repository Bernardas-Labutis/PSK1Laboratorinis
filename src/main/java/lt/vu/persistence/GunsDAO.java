package lt.vu.persistence;

import lt.vu.entities.Gun;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GunsDAO {

    @Inject
    private EntityManager em;

    public List<Gun> loadAll() {
        return em.createNamedQuery("Gun.findAll", Gun.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Gun gun){
        this.em.persist(gun);
    }

    public Gun findOne(Integer id) {
        return em.find(Gun.class, id);
    }
}
