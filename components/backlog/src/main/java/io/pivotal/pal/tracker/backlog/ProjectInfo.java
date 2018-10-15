package io.pivotal.pal.tracker.backlog;

import io.pivotal.pal.tracker.projectclient.AbstractProjectInfo;

public class ProjectInfo extends AbstractProjectInfo {

    public ProjectInfo(boolean active) {
        super(active);
    }

    private ProjectInfo() {
        this(false);
    }

}
