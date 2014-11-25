package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.Comment;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.view.ViewData;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.List;

/**
 * eroshenkoam
 * 15/11/14
 */
@Path("post")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class PostResources {

    @Context
    HttpServletResponse response;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    public ViewData showPost(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @GET
    @Path("/all")
    @Template(name = "/post/showPosts.ftl")
    public ViewData showPosts() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.posts = Post.findAll();
        return view;
    }

    @GET
    @Path("/new")
    @Template(name = "/post/newPost.ftl")
    public ViewData newPost() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = new Post();

        return view;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createPost(@FormParam("title") String title,
                           @FormParam("body") String body) throws IOException {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.saveIt();

        response.sendRedirect("/post/" + post.getId());

        return "";
    }

    @POST
    @Path("/{id}/addComment")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addComment(@PathParam("id") String fPostId,
                           @FormParam("commentBody") String fCommentBody) throws IOException {
        
    	Comment comment = new Comment();
        comment.setPost(Integer.parseInt(fPostId));
        comment.setBody(fCommentBody);
        comment.saveIt();

        response.sendRedirect("/post/" + fPostId);

        return "";
    }
}
