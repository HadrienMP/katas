package pair.tcarpaye;

public class MowItNowBuilder {

    private Mower mower;

    public MowItNowBuilder withFieldWidht(int i) {
        return this;
    }

    public MowItNowBuilder withFieldHeight(int i) {
        return this;
    }

    public MowItNow build() {
        return new MowItNow(mower);
    }

    public MowItNowBuilder addMower(Mower mower) {
        this.mower = mower;
        return this;
    }
}
