package multithreading.task03;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class SharedResource {

    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}