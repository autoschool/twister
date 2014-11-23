package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.Comment;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

    @GET
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    public Post showPost(@PathParam("id") int id) {
        return Post.findById(id);
    }

    @GET
    @Path("/all")
    @Template(name = "/post/showPosts.ftl")
    public List<Post> showPosts() {
        return Post.findAll();
    }

    @GET
    @Path("/new")
    @Template(name = "/post/newPost.ftl")
    public Post newPost() {
        return new Post();
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
