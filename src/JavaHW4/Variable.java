package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
class Variable implements TripleOperation {
    private String name;

    Variable(String name) {
        this.name = name.toLowerCase();
    }
    
    public Integer evaluate(Integer x, Integer y, Integer z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new IllegalArgumentException("Only x, y or z possible");
        }
    }
}
