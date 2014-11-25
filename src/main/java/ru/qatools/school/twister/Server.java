package ru.qatools.school.twister;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import ru.qatools.school.twister.service.AuthUserProvider;
import ru.qatools.school.twister.service.DatabaseProvider;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * Team 4
 * 18/11/14
 */
public class Server extends ResourceConfig {

    public Server() {
        register(FreemarkerMvcFeature.class);

        register(new DynamicFeature() {
            @Override
            public void configure(ResourceInfo resourceInfo, FeatureContext context) {

                context.register(DatabaseProvider.class);
                context.register(AuthUserProvider.class);
            }
        });

        packages(Server.class.getPackage().getName());
    }
}
