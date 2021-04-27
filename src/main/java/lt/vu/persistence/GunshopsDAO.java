package lt.vu.persistence;

import lt.vu.entities.Gun;
import lt.vu.entities.Gunshop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GunshopsDAO {

    @Inject
    private EntityManager em;

    public void persist(Gunshop gunshop){
        this.em.persist(gunshop);
    }

    public Gunshop findOne(Long id){
        return em.find(Gunshop.class, id);
    }

    public Gunshop update(Gunshop player){
        return em.merge(player);
    }

    public List<Gunshop> loadAll() {
        return em.createNamedQuery("Gunshop.findAll", Gunshop.class).getResultList();
    }
}
