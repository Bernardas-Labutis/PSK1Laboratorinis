package lt.vu.persistence;

import lt.vu.entities.Gunshop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class GunshopsDAO {

    @Inject
    private EntityManager em;

    public void persist(Gunshop gunshop){
        this.em.persist(gunshop);
    }

    public Gunshop findOne(Integer id){
        return em.find(Gunshop.class, id);
    }

    public Gunshop update(Gunshop player){
        return em.merge(player);
    }
}
