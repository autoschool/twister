package ru.qatools.school.twister.service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by dima on 21.01.15.
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException exception) {
        try {
            response.sendRedirect( "/404");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("No such resource")
                .build();
    }

    @Context
    HttpServletResponse response;
}