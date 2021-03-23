package lt.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.entities.Gunshop;
import lt.vu.persistence.GunsDAO;
import lt.vu.persistence.GunshopsDAO;

@Model
public class GunshopsForGun implements Serializable {

    @Inject
    private GunsDAO gunsDAO;

    @Inject
    private GunshopsDAO gunshopsDAO;

    @Getter @Setter
    private Gun gun;

    @Getter @Setter
    private Gunshop gunshopToCreate = new Gunshop();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long gunId = Long.parseLong(requestParameters.get("gunId"));
        this.gun = gunsDAO.findOne(gunId);
    }

    @Transactional
    public String createGunshop() {
        gunshopToCreate.getGunshopGuns().add(this.gun);
        gunshopsDAO.persist(gunshopToCreate);
        return "gunshops?faces-redirect=true&gunId=" + this.gun.getId();
    }
}