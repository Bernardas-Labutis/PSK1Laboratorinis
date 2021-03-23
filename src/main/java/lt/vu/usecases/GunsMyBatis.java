package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.GunMapper;
import lt.vu.mybatis.model.Gun;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model//@Named and @RequestScoped
public class GunsMyBatis {
    @Inject
    private GunMapper gunMapper;

    @Getter
    private List<Gun> allGuns;

    @Getter @Setter
    private Gun gunToCreate = new Gun();

    @PostConstruct
    public void init() {
        this.loadAllGuns();
    }

    private void loadAllGuns() {
        this.allGuns = gunMapper.selectAll();
    }

    @Transactional
    public String createGun() {
        gunMapper.insert(gunToCreate);
        return "/myBatis/gunsMyBatis?faces-redirect=true";
    }
}
