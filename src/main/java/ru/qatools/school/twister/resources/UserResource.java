package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.view.ViewData;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@Path("user")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class UserResource {

    @Context
    SecurityContext securityContext;

    @Context
    HttpServletResponse response;

    @GET
    @Path("/{id}")
    @Template(name = "/partials/user/profile.ftl")
    public ViewData showUser(@PathParam("id") int id) {
        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();
        view.profile = User.findById(id);
        return view;

    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String saveUser(@FormParam("picture") String picture) throws IOException {
        User authUser = (User) securityContext.getUserPrincipal();
        authUser.setPicture(picture);
        authUser.saveIt();

        response.sendRedirect("/user/" + authUser.getId());

        return "";
    }

    @GET
    @Path("/profile/sessionExpiredError")
    @Template(name = "/partials/user/sessionExpired.ftl")
    public ViewData sessionExpired() throws IOException {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        return view;
    }

}

