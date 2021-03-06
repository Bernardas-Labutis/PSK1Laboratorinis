package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Gunshop;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GunshopsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@LoggedInvocation
@Model//@Named and @RequestScoped
public class Gunshops {

    @Inject
    private GunshopsDAO gunshopsDAO;

    @Getter
    private List<Gunshop> allGunshops;

    @PostConstruct
    public void init() {
        loadAllGuns();
    }

    private void loadAllGuns() {
        this.allGunshops = gunshopsDAO.loadAll();
    }
}
