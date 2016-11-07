package hotelbooking;

import java.io.Serializable;

public abstract class IndexEntity implements Serializable {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
