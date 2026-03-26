package banking;

public interface TransaksiDigital extends Transaksi {

    void prosesOnline();

    String getTokenDigital();
}
