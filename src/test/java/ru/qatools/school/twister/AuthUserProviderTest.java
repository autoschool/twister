package ru.qatools.school.twister;

import org.glassfish.jersey.internal.PropertiesDelegate;
import org.glassfish.jersey.server.ContainerRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import ru.qatools.school.twister.models.User;
import ru.qatools.school.twister.service.AuthUserProvider;
import ru.qatools.school.twister.service.DatabaseProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;

import org.glassfish.jersey.servlet.*;

import static org.junit.Assert.assertEquals;


public class AuthUserProviderTest {

    @Test
    @Ignore
    public void testFilter() throws Exception {
        DatabaseProvider.openConnection();

        String username = "testuser";

        User user = new User();
        user.setName(username);
        user.setLogin("testUserLogin");
        user.setPassHash("testUserPassHash");
        user.saveIt();


        HttpSession session = Mockito.mock(HttpSession.class);
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        Mockito.stub(request.getSession(true)).toReturn(session);
        Mockito.stub(session.getAttribute("userId")).toReturn(user.getId());

        AuthUserProvider provider = new AuthUserProvider();


        ContainerRequestContext containerRequest =
                new ContainerRequest(null, null, null, null, Mockito.mock(PropertiesDelegate.class));

        provider.setRequest(request);
        provider.filter(containerRequest);

        assertEquals(username, containerRequest.getSecurityContext().getUserPrincipal().getName());
    }


}