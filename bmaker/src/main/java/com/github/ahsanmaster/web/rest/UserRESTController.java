package com.github.ahsanmaster.web.rest;

import com.github.ahsanmaster.model.User;
import com.github.ahsanmaster.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
@Path("/users")
public class UserRESTController implements Serializable {

    @Inject
    UserService userService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return userService.getAll();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.create(user);
    }

    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id) {
        return userService.delete(id);
    }

}
