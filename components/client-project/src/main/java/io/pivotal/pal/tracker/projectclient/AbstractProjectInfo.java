package io.pivotal.pal.tracker.projectclient;

public abstract class AbstractProjectInfo {

    public final boolean active;

    private AbstractProjectInfo() {
        this(false);
    }

    public AbstractProjectInfo(boolean active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProjectInfo that = (AbstractProjectInfo) o;

        return active == that.active;
    }

    @Override
    public int hashCode() {
        return (active ? 1 : 0);
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
            "active=" + active +
            '}';
    }
}
