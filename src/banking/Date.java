package banking;

/**
 * Representasi tanggal sederhana tanpa dependency eksternal.
 */
public class Date {

    private final long epochMillis;

    public Date() {
        this.epochMillis = System.currentTimeMillis();
    }

    public long getEpochMillis() {
        return epochMillis;
    }

    @Override
    public String toString() {
        return "EpochMillis(" + epochMillis + ")";
    }
}
