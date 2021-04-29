package lt.vu.persistence;

import lt.vu.entities.Gun;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Default
@ApplicationScoped
public class GunsDAO implements IGunsDAO {

    @Inject
    private EntityManager em;

    @Override
    public List<Gun> loadAll() {
        return em.createNamedQuery("Gun.findAll", Gun.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void persist(Gun gun) {
        this.em.persist(gun);
    }

    @Override
    public Gun findOne(Long id) {
        return em.find(Gun.class, id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Gun update(Gun gun) {
        gun = em.merge(gun);
        em.flush();
        return gun;
    }
}
