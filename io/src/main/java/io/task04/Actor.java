package io.task04;

import lombok.Value;

import java.io.Serializable;

@SuppressWarnings("WeakerAccess")
@Value
public class Actor implements Serializable {
    private final String firstName;
    private final String secondName;

    private final Integer yearOfBirth;

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }
}
