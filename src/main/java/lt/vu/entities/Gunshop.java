package lt.vu.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Gunshop {
    private long id;
    private String name;
    private String licencetype;
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
    @Column(name = "LICENCETYPE")
    public String getLicencetype() {
        return licencetype;
    }

    public void setLicencetype(String licencetype) {
        this.licencetype = licencetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gunshop gunshop = (Gunshop) o;
        return id == gunshop.id &&
                Objects.equals(name, gunshop.name) &&
                Objects.equals(licencetype, gunshop.licencetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, licencetype);
    }

    @OneToMany(mappedBy = "gunshop")
    public Collection<Gunshopgun> getGunshopguns() {
        return gunshopguns;
    }

    public void setGunshopguns(Collection<Gunshopgun> gunshopguns) {
        this.gunshopguns = gunshopguns;
    }
}
