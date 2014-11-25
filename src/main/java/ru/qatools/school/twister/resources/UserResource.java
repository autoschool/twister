package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.view.ViewData;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("user")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class UserResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/{id}")
    @Template(name = "/user/profile.ftl")
    public ViewData showUser(@PathParam("id") int id) {
        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();
        view.profile = User.findById(id);
        return view;

    }

}

