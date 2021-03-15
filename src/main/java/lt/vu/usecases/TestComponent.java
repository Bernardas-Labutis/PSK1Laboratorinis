package lt.vu.usecases;

import lombok.var;
import lt.vu.entities.Gunshop;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class TestComponent {

    @PersistenceUnit
    private EntityManagerFactory emf;


    public String getGunshopGuns(){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.createQuery("select g from Gun g").getResultList();
        var a = new Gunshop().getGunshopguns();
        return "ok" + getClass().getSimpleName();
    }
}
