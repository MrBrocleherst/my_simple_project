package org.example.role;

public class Role {
    private String name;
    private int priority;

    public Role(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

