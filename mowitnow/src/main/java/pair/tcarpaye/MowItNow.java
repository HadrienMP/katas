package pair.tcarpaye;

public class MowItNow {
    private final Mower mower;

    public MowItNow(Mower mower) {
        this.mower = mower;
    }

    public void mow() {

    }

    public String getMower(int i) {
        return mower.toString();
    }
}
