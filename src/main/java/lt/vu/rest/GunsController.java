package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Gun;
import lt.vu.persistence.GunsDAO;
import lt.vu.rest.contracts.GunDto;
import lt.vu.rest.contracts.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/guns")
public class GunsController {

    @Inject
    @Setter
    @Getter
    private GunsDAO gunsDAO;

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getALl() {
        List<Gun> guns = gunsDAO.loadAll();
        if (guns.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<GunDto> gunDtos = guns.stream()
                .map(Mapper::convertToGunDto)
                .collect(Collectors.toList());

        return Response.ok(gunDtos).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Gun gun = gunsDAO.findOne(id);
        if (gun == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Mapper.convertToGunDto(gun)).build();
    }

    @Path("/put/{id}/{name}/{actionType}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Long gunId,
            @PathParam("name") final String name,
            @PathParam("actionType") final String actionType) {
        try {
            Gun existingGun = gunsDAO.findOne(gunId);
            if (existingGun == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingGun.setName(name);
            existingGun.setActiontype(actionType);
            gunsDAO.update(existingGun);
            return Response.ok(Response.Status.OK).build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/post/{name}/{actionType}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(
            @PathParam("name") final String name,
            @PathParam("actionType") final String actionType) {
        Gun newGun = new Gun();
        newGun.setName(name);
        newGun.setActiontype(actionType);
        gunsDAO.persist(newGun);
        return Response.ok(Response.Status.OK).build();
    }
}