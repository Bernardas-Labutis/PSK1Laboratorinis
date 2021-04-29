package lt.vu.persistence;

import lt.vu.entities.Gun;

import java.util.List;

public interface IGunsDAO {
    List<Gun> loadAll();

    Gun findOne(Long gunId);

    void persist(Gun gunToCreate);

    Gun update(Gun gun);
}
