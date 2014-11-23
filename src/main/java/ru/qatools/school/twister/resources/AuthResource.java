package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @POST
    @Path("/register")
    public void processRegister(@FormParam("name") String name,
                                @FormParam("pass") String pass) {

    }
}
