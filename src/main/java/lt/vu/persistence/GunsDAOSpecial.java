package lt.vu.persistence;

import lt.vu.entities.Gun;

import javax.enterprise.inject.Specializes;

@Specializes
public class GunsDAOSpecial extends GunsDAO {
    @Override
    public Gun update(Gun gun) {
        gun.setActiontype(gun.getActiontype() + " specialized");
        return super.update(gun);
    }
}
