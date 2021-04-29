package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.GunNumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateGunNumber implements Serializable {
    @Inject
    private GunNumberGenerator gunNumberGenerator;

    private CompletableFuture<Integer> gunNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewGunNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        gunNumberGenerationTask = CompletableFuture.supplyAsync(() -> gunNumberGenerator.generateGunNumber());

        return "/gunshops.xhtml?gunId=" + requestParameters.get("gunId") + "&faces-redirect=true";
    }

    public boolean isGunNumberGenerationRunning() {
        return gunNumberGenerationTask != null && !gunNumberGenerationTask.isDone();
    }

    public String getGunGenerationStatus() throws ExecutionException, InterruptedException {
        if (gunNumberGenerationTask == null) {
            return null;
        } else if (isGunNumberGenerationRunning()) {
            return "Gun number generation in progress";
        }
        return "Suggested gun number: " + gunNumberGenerationTask.get();
    }
}
