package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class UserResource {

    @GET
    @Path("/{id}")
    @Template(name = "/user/profile.ftl")
    public User showUser(@PathParam("id") int id) {
        return User.findById(id);
    }

}

