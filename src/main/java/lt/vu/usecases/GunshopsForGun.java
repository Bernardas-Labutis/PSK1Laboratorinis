package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.entities.Gunshop;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GunshopsDAO;
import lt.vu.persistence.IGunsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@LoggedInvocation
@Model
public class GunshopsForGun implements Serializable {

    @Inject
    private IGunsDAO gunsDAO;

    @Inject
    private GunshopsDAO gunshopsDAO;

    @Getter
    @Setter
    private Gun gun;

    @Getter
    @Setter
    private Long selectedGunshopId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long gunId = Long.parseLong(requestParameters.get("gunId"));
        this.gun = gunsDAO.findOne(gunId);
    }

    @Transactional
    public String addGunshop() {
        System.out.println(selectedGunshopId);
        Gunshop gunshop = gunshopsDAO.findOne(selectedGunshopId);
        gun.getGunshops().add(gunshop);
        gunsDAO.update(gun);
        return "gunshops?faces-redirect=true&gunId=" + this.gun.getId();
    }
}
