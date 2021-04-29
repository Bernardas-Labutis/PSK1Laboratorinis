package lt.vu.rest.contracts;

import lt.vu.entities.Gun;
import lt.vu.entities.Gunshop;

import java.util.stream.Collectors;

public class Mapper {
    public static GunDto convertToGunDto(Gun gun) {
        if (gun != null) {
            GunDto gunDto = new GunDto();
            gunDto.setName(gun.getName());
            gunDto.setActionType(gun.getActiontype());
            gunDto.setGunshops(
                    gun.getGunshops().stream()
                            .map(Mapper::convertToGunshopDto)
                            .collect(Collectors.toList())
            );
            return gunDto;
        }
        return null;
    }

    public static GunshopDto convertToGunshopDto(Gunshop gunshop) {
        if (gunshop != null) {
            GunshopDto gunshopDto = new GunshopDto();
            gunshopDto.setName(gunshop.getName());
            gunshopDto.setLicenceType(gunshop.getLicencetype());
            return gunshopDto;
        }
        return null;
    }
}
