package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GunsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@LoggedInvocation
@RequestScoped
@Named
@Getter
@Setter
public class UpdateGunDetails implements Serializable, IUpdateGunDetails {

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

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String updateGunName() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        try {
            gunsDAO.update(this.gun);
        } catch (OptimisticLockException e) {
            return "gunshops.xhtml?gunId=" + this.gun.getId() + "&faces-redirect=true" + "&error=optimistic-lock-exception";
        }
        return "gunshops.xhtml?gunId=" + this.gun.getId() + "&faces-redirect=true";
    }

    @Transactional
    public String updateGunNumber() {
        gunsDAO.update(this.gun);
        return "gunshops.xhtml?gunId=" + this.gun.getId() + "&faces-redirect=true";
    }
}
