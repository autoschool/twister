package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Comment;
import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.User;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/*
 * Created by ashchogoleva on 23.11.14.
 */
@Path("auth")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class AuthResource {

    @GET
    @Path("/register")
    @Template(name = "/auth/register.ftl")
    public String showRegisterForm() {
        return "";
    }

    @Context
    HttpServletResponse response;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processRegister(@FormParam("name") String name,
                                  @FormParam("pass") String hash) throws IOException {

        User user = new User();
        user.setName(name);
        user.setPassHash(hash);
        user.saveIt();

        response.sendRedirect("/auth/" + user.getId());

        return "";
    }


    @GET
    @Path("/{id}")
    @Template(name = "/auth/user.ftl")
    public User showUser(@PathParam("id") int id) {
        return User.findById(id);
    }

}
