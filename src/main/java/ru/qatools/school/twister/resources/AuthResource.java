package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Comment;
import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.view.ViewData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/*
 * Created by ashchogoleva on 23.11.14.
 */
@Path("auth")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class AuthResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/register")
    @Template(name = "/auth/register.ftl")
    public ViewData showRegisterForm() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;
    }

    @Context
    HttpServletRequest request;
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

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", user.getId());

        response.sendRedirect("/user/" + user.getId());

        return "";
    }

    @GET
    @Path("/signin")
    @Template(name = "/auth/login.ftl")
    public ViewData showLoginForm() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;

    }

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processLogin(@FormParam("name") String name,
                               @FormParam("pass") String hash) throws IOException {

        User user = User.findFirst("name = ? and pass_hash = ?", name, hash);

        if (user == null) {
            System.out.println("name or password is wrong");

            return "";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", user.getId());

        response.sendRedirect("/user/" + user.getId());

        return "";
    }

    @GET
    @Path("/signout")
    public String processLogout() throws IOException {


        HttpSession session = request.getSession(true);
        session.setAttribute("userId", null);

        response.sendRedirect("/");

        return "";
    }
}
