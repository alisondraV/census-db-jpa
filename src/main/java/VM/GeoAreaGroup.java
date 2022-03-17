package VM;

public class GeoAreaGroup {
    private Long count;
    private int level;

    public GeoAreaGroup(int level, Long count) {
        setLevel(level);
        setCount(count);
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
