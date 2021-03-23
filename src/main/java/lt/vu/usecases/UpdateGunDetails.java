package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.persistence.GunsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@RequestScoped
@Named
@Getter @Setter
public class UpdateGunDetails implements Serializable {

    private Gun gun;

    @Inject
    private GunsDAO gunsDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long gunId = Long.parseLong(requestParameters.get("gunId"));
        this.gun = gunsDAO.findOne(gunId);
    }

    @Transactional
    public String updateGunName() {
        try{
            gunsDAO.update(this.gun);
        } catch (OptimisticLockException e) {
            return "/playerDetails.xhtml?faces-redirect=true&playerId=" + this.gun.getId() + "&error=optimistic-lock-exception";
        }
        return "gunshops.xhtml?gunId=" + this.gun.getId() + "&faces-redirect=true";
    }
}
