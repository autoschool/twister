package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

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

    @GET
    @Path("/")
    @Template(name = "/post/showPosts.ftl")
    public List<Post> showIndex() {
        return Post.findAll();
    }

    @GET
    @Path("/profile")
    public String profile() throws IOException {

        HttpSession session = request.getSession(true);
        Integer userId = (Integer) session.getAttribute("userId");

        String redirectUrl;
        if (userId != null) {
            redirectUrl = "/user/" + userId;
        } else {
            redirectUrl = "/auth/signin";
        }


        response.sendRedirect(redirectUrl);


        return "";
    }

}
