package lt.vu.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Gunshop {
    private Long id;
    private String name;
    private String licencetype;
    private Set<Gun> gunshopGuns;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
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

    @ManyToMany
    @JoinTable(
            name = "GUNSHOPGUN",
            joinColumns = @JoinColumn(name = "GUNSHOP_ID"),
            inverseJoinColumns = @JoinColumn(name = "GUN_ID"))
    public Set<Gun> getGunshopGuns(){return gunshopGuns;}
    public void setGunshopGuns (Set<Gun> gunshopGuns) {this.gunshopGuns = gunshopGuns;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gunshop gunshop = (Gunshop) o;

        if (!Objects.equals(id, gunshop.id)) return false;
        if (!Objects.equals(name, gunshop.name)) return false;
        return Objects.equals(licencetype, gunshop.licencetype);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (licencetype != null ? licencetype.hashCode() : 0);
        return result;
    }
}
