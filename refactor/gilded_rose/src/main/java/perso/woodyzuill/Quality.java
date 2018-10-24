package perso.woodyzuill;

public class Quality {
    public static final Quality ZERO = new Quality(0);
    public final int quality;

    public Quality(int quality) {
        this.quality = quality;
    }

    public Quality increment() {
        if (quality < 50) {
            return new Quality(quality + 1);
        }
        return new Quality(quality);
    }

    public Quality decrement() {
        if (quality > 0) {
            return new Quality(quality - 1);
        }
        return new Quality(quality);
    }
}
