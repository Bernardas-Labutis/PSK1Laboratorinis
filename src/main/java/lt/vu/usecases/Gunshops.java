package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.entities.Gunshop;
import lt.vu.persistence.GunsDAO;
import lt.vu.persistence.GunshopsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model//@Named and @RequestScoped
public class Gunshops {

    @Inject
    private GunshopsDAO gunshopsDAO;

    @Getter
    private List<Gunshop> allGunshops;

    @PostConstruct
    public void init(){
        loadAllGuns();
    }

    private void loadAllGuns(){
        this.allGunshops = gunshopsDAO.loadAll();
    }
}
