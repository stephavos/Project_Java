package contract.model;


public class Example {

    private final int id;

    private String    name;

    public Example(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getId() + " : " + this.getName();
    }
}
