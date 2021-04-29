package lt.vu.persistence;

import lt.vu.entities.Gun;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Alternative
public class SemiAutomaticGunsDAO extends GunsDAO implements IGunsDAO {

    @Inject
    EntityManager em;

    @Override
    public List<Gun> loadAll() {
        return em
                .createQuery("select g from Gun g where g.actiontype='semi-automatic'", Gun.class)
                .getResultList();
    }
}