package banking;

/**
 * Kontrak layanan lintas negara.
 */
public interface LayananInternasional extends Transaksi {

    /**
     * Menjalankan alur internasional.
     */
    void prosesInternasional();

    /**
     * Negara tujuan transaksi.
     * @return negara tujuan
     */
    String getNegaraTujuan();
}
