package io.pivotal.pal.tracker.projectclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.Map;

public class ProjectClient<PI extends AbstractProjectInfo> {

    private final RestOperations restOperations;
    private final String registrationServerEndpoint;
    private final Class<PI> piClass;
    private final Map<Long, PI> piCache = new HashMap<>();

    public ProjectClient(RestOperations restOperations, String registrationServerEndpoint, Class<PI> piClass) {
        this.restOperations= restOperations;
        this.registrationServerEndpoint = registrationServerEndpoint;
        this.piClass = piClass;
    }

    @HystrixCommand(fallbackMethod = "getProjectFromCache")
    public PI getProject(long projectId) {
        PI newPI = restOperations.getForObject(registrationServerEndpoint + "/projects/" + projectId, piClass);
        piCache.put(projectId, newPI);
        return newPI;
    }

    public PI getProjectFromCache(long projectId){
        return piCache.get(projectId);
    }
}
