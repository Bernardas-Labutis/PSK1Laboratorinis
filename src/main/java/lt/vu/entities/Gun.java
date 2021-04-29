package lt.vu.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Gun.findAll", query = "select g from Gun as g")
})
public class Gun {
    private Long id;
    private String name;
    private String actiontype;
    private Set<Gunshop> gunshops;
    private Integer version;
    private Integer number;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "GUNSHOPGUN",
            joinColumns = @JoinColumn(name = "GUN_ID"),
            inverseJoinColumns = @JoinColumn(name = "GUNSHOP_ID"))
    public Set<Gunshop> getGunshops() {
        return gunshops;
    }

    public void setGunshops(Set<Gunshop> gunshops) {
        this.gunshops = gunshops;
    }

    @Column(name = "VERSION")
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "NUMBER")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gun gun = (Gun) o;

        if (!Objects.equals(id, gun.id)) return false;
        if (!Objects.equals(name, gun.name)) return false;
        return Objects.equals(actiontype, gun.actiontype);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (actiontype != null ? actiontype.hashCode() : 0);
        return result;
    }
}
