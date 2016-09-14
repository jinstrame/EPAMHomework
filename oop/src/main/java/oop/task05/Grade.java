package oop.task05;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grade<T extends Number>{

    T value;

    @Override
    public String toString() {
        return value.toString();
    }
}
