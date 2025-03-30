package workspace_management.event;

import org.springframework.context.ApplicationEvent;

public class WorkspaceDeletedEvent extends ApplicationEvent {
    private final int workspaceID;

    public WorkspaceDeletedEvent(Object source, int workspaceID) {
        super(source);
        this.workspaceID = workspaceID;
    }

    public int getWorkspaceID() {
        return workspaceID;
    }
}
