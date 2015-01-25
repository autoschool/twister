package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Comment;
import ru.qatools.school.twister.models.Post;
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
        view.posts = Post.find("user_id = ?", id);
        view.comments = Comment.find("user_id = ?", id);

        return view;

    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String saveUser(
            @FormParam("user-profile-avatar") String picture,
            @FormParam("user-profile-name") String name,
            @FormParam("user-profile-password") String password
    ) throws IOException {
        User authUser = (User) securityContext.getUserPrincipal();

        if ( name.length() > 50 ) {
            response.sendRedirect("/user/save/error");
        }

        if ( !name.trim().isEmpty() ) {
            authUser.setName( name );
        }

        if ( !password.trim().isEmpty() ) {
            authUser.setPassHash( password );
        }

        if ( !picture.trim().isEmpty() ) {
            authUser.setPicture( picture );
        }

        System.out.println( "picture:" + picture + " | name: " + name + " | password: " + password);
        authUser.saveIt();

        response.sendRedirect("/user/" + authUser.getId());

        return "";
    }

    @GET
    @Path("/save/error")
    @Template(name = "/partials/user/tooLongNameError.ftl")
    public ViewData tooLongNameError() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        return view;
    }

    @GET
    @Path("/profile/sessionExpiredError")
    @Template(name = "/partials/user/sessionExpired.ftl")
    public ViewData sessionExpired() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        return view;
    }

}

