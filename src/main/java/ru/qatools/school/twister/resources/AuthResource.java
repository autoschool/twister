package ru.qatools.school.twister.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
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

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processRegister(@FormParam("register-name") String name,
                                  @FormParam("register-login") String login,
                                  @FormParam("register-pass") String hash) throws IOException {

        if ( !dataIsValid( name, login, hash ) ) {
            response.sendRedirect( "/auth/register/error" );
            return "";
        }

        if ( userExists( login ) ) {
            response.sendRedirect( "/auth/register/userExists" );
            return "";
        }

        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassHash(hash);
        user.saveIt();

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", user.getId());

        response.sendRedirect( "/user/" + user.getId() );

        return "";
    }


    @GET
    @Path("/register/error")
    @Template(name = "/partials/register/error.ftl")
    public ViewData showRegisterError() {
        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;
    }

    @GET
    @Path("/register/userExists")
    @Template(name = "/partials/register/userExistsError.ftl")
    public ViewData showUserExistsError() {
        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return new ViewData();
    }

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processLogin(@FormParam("signin-login") String login,
                               @FormParam("signin-pass") String hash) throws IOException {

        User user = User.findFirst("login = ? and pass_hash = ?", login, hash);

        if (user == null) {
            System.out.println("processLogin | name or password is wrong");
            response.sendRedirect( "/auth/signin/error" );

            return "";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute( USER_ID_ATTRIBUTE , user.getId() );

        String referer = request.getHeader( "referer" );
        response.sendRedirect( IndexResource.isSystemPage(referer) ? "/" : referer );

        return "";
    }

    @GET
    @Path("/signout")
    public String processLogout() throws IOException {
        HttpSession session = request.getSession(true);
        session.removeAttribute( USER_ID_ATTRIBUTE );

        response.sendRedirect("/");

        return "";
    }

    @GET
    @Path("/signin/error")
    @Template(name = "/partials/login/error.ftl")
    public ViewData showLoginError() {
        return new ViewData();
    }

    private boolean dataIsValid(String name, String login, String hash) {
        return !name.trim().isEmpty() && !login.trim().isEmpty() && !hash.isEmpty();
    }

    private boolean userExists( String login ) {
        User tmpUser = User.findFirst("login = ?", login);
        return tmpUser != null;
    }

    final static String USER_ID_ATTRIBUTE = "userId";

    @Context
    SecurityContext securityContext;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

}
