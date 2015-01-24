package ru.qatools.school.twister.service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by dima on 21.01.15.
 */
@Provider
public class NotAllowedExceptionMapper implements ExceptionMapper<NotAllowedException> {
    @Override
    public Response toResponse(NotAllowedException e) {
        try {
            response.sendRedirect( "/404");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                .entity("No such resource")
                .build();
    }

    @Context
    HttpServletResponse response;
}