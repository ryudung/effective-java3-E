package ch08.item49;


public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName(){
        return customName(name);
    }

    private String customName(String name) {
        assert name != null;
        return "my " + name;
    }
}
