package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GunDto {
    private String name;
    private String actionType;
    private List<GunshopDto> gunshops;
}
