package lt.vu.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Gunshopgun {
    private long id;
    private long gunshopId;
    private long gunId;
    private Gunshop gunshop;
    private Gun gun;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gunshopgun that = (Gunshopgun) o;
        return id == that.id &&
                gunshopId == that.gunshopId &&
                gunId == that.gunId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gunshopId, gunId);
    }

    @ManyToOne
    @JoinColumn(name = "GUNSHOP_ID", referencedColumnName = "ID")
    public Gunshop getGunshop() {
        return gunshop;
    }

    public void setGunshop(Gunshop gunshop) {
        this.gunshop = gunshop;
    }

    @ManyToOne
    @JoinColumn(name = "GUN_ID", referencedColumnName = "ID")
    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
