package io.pivotal.pal.tracker.allocations;

import io.pivotal.pal.tracker.projectclient.AbstractProjectInfo;

public class ProjectInfo extends AbstractProjectInfo {

    public ProjectInfo(boolean active) {
        super(active);
    }

    private ProjectInfo() {
        this(false);
    }

}
