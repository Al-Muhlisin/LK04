package banking;

/**
 * Interface transaksi dasar.
 */
public interface Transaksi {

    /**
     * Menjalankan proses transaksi.
     */
    void proses();

    /**
     * Memvalidasi kelayakan transaksi.
     * @return true bila valid
     */
    boolean validasi();

    /**
     * Memberi label jenis transaksi.
     * @return jenis transaksi
     */
    String getJenisTransaksi();
}
