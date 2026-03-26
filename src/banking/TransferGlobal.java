package banking;

public interface TransferGlobal extends TransaksiDigital, LayananInternasional {

    boolean transferGlobal();

    boolean verifikasiInternasional();
}
