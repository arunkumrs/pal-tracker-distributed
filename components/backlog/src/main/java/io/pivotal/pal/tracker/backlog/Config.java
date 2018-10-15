package io.pivotal.pal.tracker.backlog;

import io.pivotal.pal.tracker.projectclient.ProjectClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

@Configuration
public class Config {

    @Bean
    ProjectClient<ProjectInfo> projectClient(
            RestOperations restOperations,
            @Value("${registration.server.endpoint}") String registrationEndpoint
    ) {
        return new ProjectClient<>(restOperations, registrationEndpoint, ProjectInfo.class);
    }
}