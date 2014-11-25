package ru.qatools.school.twister.service;

/*
 * Created by ashchogoleva on 25.11.14.
 */

import ru.qatools.school.twister.context.AuthUser;
import ru.qatools.school.twister.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import java.io.IOException;

public class AuthUserProvider implements ContainerRequestFilter {

    @Context
    HttpServletRequest request;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        HttpSession session = request.getSession(true);
        Long userId = (Long) session.getAttribute("userId");

        User user = null;
        if (userId != null) {
            user = User.findById(userId);
        }

        requestContext.setSecurityContext(new AuthUser(user));
    }


}


