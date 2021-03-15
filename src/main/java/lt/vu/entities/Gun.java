package lt.vu.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Gun {
    private long id;
    private String name;
    private String actiontype;
    private Collection<Gunshopgun> gunshopguns;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ACTIONTYPE")
    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gun gun = (Gun) o;
        return id == gun.id &&
                Objects.equals(name, gun.name) &&
                Objects.equals(actiontype, gun.actiontype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actiontype);
    }

    @OneToMany(mappedBy = "gun")
    public Collection<Gunshopgun> getGunshopguns() {
        return gunshopguns;
    }

    public void setGunshopguns(Collection<Gunshopgun> gunshopguns) {
        this.gunshopguns = gunshopguns;
    }
}
