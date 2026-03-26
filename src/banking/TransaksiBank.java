package banking;

public class TransaksiBank extends RekeningValas {

    private final ProtocolKeamanan protocolKeamanan;
    private String nomorTujuanTerakhir;
    private double nominalTerakhir;

    public TransaksiBank(String nomorRekening, double saldo, String namaPemilik,
                         String jenisMataUang, double kursRate, ProtocolKeamanan protocolKeamanan) {
        super(nomorRekening, saldo, namaPemilik, jenisMataUang, kursRate);
        this.protocolKeamanan = protocolKeamanan;
        this.nomorTujuanTerakhir = "-";
        this.nominalTerakhir = 0.0;
    }

    public boolean transferAmanGlobal(String nomorTujuan, String negaraTujuan, double jumlah, String pin) {
        setNegaraTujuan(negaraTujuan);
        this.nomorTujuanTerakhir = nomorTujuan;
        this.nominalTerakhir = jumlah;

        if (!protocolKeamanan.verifikasiPin(pin)) {
            System.out.println("✗ PIN tidak valid.");
            return false;
        }

        if (!protocolKeamanan.validasiTransaksi(this)) {
            System.out.println("✗ Data transaksi tidak valid.");
            return false;
        }

        setTokenDigital(protocolKeamanan.generateToken());
        prosesOnline();
        prosesInternasional();

        if (!verifikasiInternasional()) {
            System.out.println("✗ Verifikasi internasional gagal.");
            return false;
        }

        boolean ok = transferAntarNegara(nomorTujuan, jumlah);
        if (!ok) {
            return false;
        }

        String payload = "TX|" + getNomorRekening() + "|" + nomorTujuan + "|" + jumlah + "|" + negaraTujuan;
        String encrypted = protocolKeamanan.enkripsiData(payload);
        System.out.println("Audit terenkripsi: " + encrypted);
        System.out.println("Audit terdekripsi: " + protocolKeamanan.deskripsiData(encrypted));
        return true;
    }

    @Override
    public boolean transferGlobal() {
        if (nominalTerakhir <= 0) {
            return false;
        }
        return transferAntarNegara(nomorTujuanTerakhir, nominalTerakhir);
    }
}
