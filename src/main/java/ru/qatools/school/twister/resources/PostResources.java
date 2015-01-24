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
    public ViewData showPost(@PathParam("id") int id) throws IOException {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);

        if ( view.post == null ) {
            response.sendRedirect("/404" );
        }
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
    @Path("/new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createPost(@FormParam("title") String title,
                             @FormParam("body") String body) throws IOException {

        if ( title.trim().isEmpty() || title.length() > 100 || body.trim().isEmpty() ) {
            response.sendRedirect("/post/error" );
            return "";
        }

        User authUser = (User) securityContext.getUserPrincipal();

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUserId((int) authUser.getId());
        post.saveIt();

        response.sendRedirect("/post/" + post.getId());

        return "";
    }

    @POST
    @Path("/{id}/addComment")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addComment(@PathParam("id") String fPostId,
                             @FormParam("commentBody") String fCommentBody) throws IOException {

        if ( fCommentBody.trim().isEmpty() ) {
            response.sendRedirect("/post/" + fPostId + "/emptyComment" );
            return "";
        }

        User authUser = (User) securityContext.getUserPrincipal();

        Comment comment = new Comment();
        comment.setPost(Integer.parseInt(fPostId));
        comment.setBody(fCommentBody);
        comment.setUserId((int) authUser.getId());
        comment.saveIt();

        response.sendRedirect("/post/" + fPostId + "#comment-" + comment.getId() );

        return "";
    }


    @GET
    @Path("/error")
    @Template(name = "/post/postError.ftl")
    public ViewData postError(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @GET
    @Path("/{id}/emptyComment")
    @Template(name = "/post/comments/emptyComment.ftl")
    public ViewData emptyComment(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @GET
    @Path("/{id}/edit")
    @Template(name = "/post/editPost.ftl")
    public ViewData editPost(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePost(@FormParam("title") String title,
                             @FormParam("body") String body,
                             @FormParam("id") int id) throws IOException {

        Post post = Post.findById(id);

        assert post != null;

        post.setTitle(title);
        post.setBody(body);
        post.saveIt();

        response.sendRedirect("/post/" + post.getId());

        return "";
    }

    @POST
    @Path("/{id}/remove")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String removePost( @PathParam("id") String id ) throws IOException {
        Post post = Post.findById(id);
        for ( Comment comment : post.getComments() ) {
            comment.delete();
        }
        post.delete();

        response.sendRedirect( "/post/all" );

        return "";
    }

}
