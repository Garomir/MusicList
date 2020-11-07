package com.ramich.MusicList.entities;

public enum Permission {
    SONGS_READ("songs:read"),
    SONGS_WRITE("songs:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
