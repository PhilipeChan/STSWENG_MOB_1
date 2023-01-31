package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

import java.util.Objects;

public class Room {
    private final String roomName;

    public Room(String roomName) {
        notBlank(roomName);
        isTrue(isAlphanumeric(roomName), "roomName must be alphanumeric, was: " + roomName);
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Room " + roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomName.equals(room.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName);
    }
}
