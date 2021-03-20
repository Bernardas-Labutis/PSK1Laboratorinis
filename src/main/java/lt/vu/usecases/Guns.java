package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.persistence.GunsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model//@Named and @RequestScoped
public class Guns {

    @Inject
    private GunsDAO gunsDAO;

    @Getter @Setter
    private Gun gunToCreate = new Gun();

    @Getter
    private List<Gun> allGuns;

    @PostConstruct
    public void init(){
        loadAllGuns();
    }

    @Transactional
    public String createGun(){
        this.gunsDAO.persist(gunToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllGuns(){
        this.allGuns = gunsDAO.loadAll();
    }
}
