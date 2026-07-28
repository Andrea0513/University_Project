public class matchPerString implements Searchabile<String> {
private String target;

    public matchPerString(String target) {
        this.target = target;
    }

    @Override
    public boolean matches(String n) {
        if (n == null || target == null) return false;
        return n.equalsIgnoreCase(target);
    }
}
