package banking;

public interface Transaksi {

    void proses();

    boolean validasi();

    String getJenisTransaksi();
}
