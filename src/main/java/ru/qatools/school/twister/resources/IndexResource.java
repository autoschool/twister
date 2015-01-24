package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.view.ViewData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/**
 * eroshenkoam
 * 15/11/14
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class IndexResource {

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/")
    @Template(name = "/post/showPosts.ftl")
    public ViewData showIndex() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();
        view.posts = Post.findAll();

        return view;
    }

    @GET
    @Path("/profile")
    public String profile() throws IOException {

        User authUser = (User) securityContext.getUserPrincipal();

        String redirectUrl;
        if (authUser != null) {
            redirectUrl = "/user/" + authUser.getId();
        } else {
            redirectUrl = "/profile/sessionExpiredError";
        }

        response.sendRedirect(redirectUrl);

        return "";
    }

    @GET
    @Path("/404")
    @Template(name = "/404.ftl")
    public ViewData notFound() throws IOException {
        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;
    }

}
