public class matchPerInteger implements Searchabile<Integer> {
private Integer target;

    public matchPerInteger(Integer target) {
        this.target = target;
    }

    @Override
    public boolean matches(Integer n) {
        if (n == null || target == null) return false;
        return n.equals(target);
    }
}
