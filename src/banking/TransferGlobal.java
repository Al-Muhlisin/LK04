package banking;

/**
 * Multiple inheritance interface.
 */
public interface TransferGlobal extends TransaksiDigital, LayananInternasional {

    /**
     * Menjalankan transfer global.
     * @return true bila berhasil
     */
    boolean transferGlobal();

    /**
     * Verifikasi tambahan untuk transfer internasional.
     * @return true bila lolos verifikasi
     */
    boolean verifikasiInternasional();
}
