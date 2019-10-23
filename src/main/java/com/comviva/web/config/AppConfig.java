package com.comviva.web.config;
import com.comviva.resources.utils.GeneralExceptionMapper;
import com.mahindracomviva.secm.core.filters.AuthorizationRequestFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;

@Priority(Priorities.AUTHENTICATION)
@Configuration
public class AppConfig {

    @Value("${asecFilter.parameters.asec_path}")
    private String asec_path = "";
    @Value("${asecFilter.parameters.asec_application}")
    private String asec_application = "";
    @Value("${asecFilter.parameters.asec_filter_enable}")
    private boolean asec_filter_enable = false;

    @Bean
    ResourceConfig resourceConfig() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(MultiPartFeature.class);
        AuthorizationRequestFilter.setApplicationName(asec_application);
        AuthorizationRequestFilter.setEnableSecurity(asec_filter_enable);
        AuthorizationRequestFilter.setSecurityServiceURL(asec_path);
        resourceConfig.register(AuthorizationRequestFilter.class);
        resourceConfig.packages("com.comviva.resources");
        resourceConfig.register(GeneralExceptionMapper.class);
        return resourceConfig;
    }

}