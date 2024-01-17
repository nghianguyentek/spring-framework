package vn.kihon.spring.boot;

public class Message {
    private String id;
    private String name;

    public Message id(String id) {
        setId(id);
        return this;
    }

    public Message name(String name) {
        setName(name);
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"name\"=\"" + name + "\"}";
    }
}
