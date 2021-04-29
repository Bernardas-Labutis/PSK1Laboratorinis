package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.security.SecureRandom;

@ApplicationScoped
public class GunNumberGenerator implements Serializable {
    private SecureRandom secureRandom = new SecureRandom();

    public Integer generateGunNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Integer generatedGunNumber = 10000 + secureRandom.nextInt(20000);
        return generatedGunNumber;
    }
}
