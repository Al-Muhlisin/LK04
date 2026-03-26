package banking;

/**
 * Kontrak transaksi berbasis digital/online.
 */
public interface TransaksiDigital extends Transaksi {

    /**
     * Menjalankan proses online.
     */
    void prosesOnline();

    /**
     * Mengambil token digital aktif.
     * @return token
     */
    String getTokenDigital();
}
