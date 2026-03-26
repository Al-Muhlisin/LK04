package banking;

/**
 * Superclass rekening dasar untuk sistem bank.
 */
public class Rekening implements Transaksi {

    private String nomorRekening;
    private double saldo;
    private String namaPemilik;
    private Date tanggalMembuka;

    public Rekening(String nomorRekening, double saldo, String namaPemilik) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.namaPemilik = namaPemilik;
        this.tanggalMembuka = new Date();
    }

    public Rekening() {
        this("-", 0.0, "-");
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public Date getTanggalMembuka() {
        return tanggalMembuka;
    }

    public void setTanggalMembuka(Date tanggalMembuka) {
        this.tanggalMembuka = tanggalMembuka;
    }

    /**
     * Menambah saldo.
     */
    public void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("✗ Jumlah setor harus lebih dari 0.");
            return;
        }
        saldo += jumlah;
        System.out.println("✓ Setor tunai berhasil. Saldo baru: Rp" + saldo);
    }

    /**
     * Mengurangi saldo bila mencukupi.
     */
    public void tarikTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("✗ Jumlah tarik harus lebih dari 0.");
            return;
        }
        if (jumlah > saldo) {
            System.out.println("✗ Saldo tidak cukup. Saldo saat ini: Rp" + saldo);
            return;
        }
        saldo -= jumlah;
        System.out.println("✓ Tarik tunai berhasil. Saldo baru: Rp" + saldo);
    }

    /**
     * Menampilkan ringkasan saldo.
     */
    public double cekSaldo() {
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Tanggal Buka   : " + tanggalMembuka);
        System.out.println("Saldo          : Rp" + saldo);
        return saldo;
    }

    public boolean transfer(String rekeningTujuan, double jumlah) {
        if (rekeningTujuan == null || rekeningTujuan.trim().isEmpty()) {
            System.out.println("✗ Nomor rekening tujuan tidak valid.");
            return false;
        }
        if (jumlah <= 0 || jumlah > saldo) {
            System.out.println("✗ Transfer gagal. Cek nominal dan saldo.");
            return false;
        }
        saldo -= jumlah;
        System.out.println("✓ Transfer Rp" + jumlah + " ke " + rekeningTujuan + " berhasil.");
        return true;
    }

    @Override
    public void proses() {
        System.out.println("Memproses transaksi rekening reguler...");
    }

    @Override
    public boolean validasi() {
        boolean validNomor = nomorRekening != null && !nomorRekening.trim().isEmpty();
        boolean validNama = namaPemilik != null && !namaPemilik.trim().isEmpty();
        boolean validSaldo = saldo >= 0;
        return validNomor && validNama && validSaldo;
    }

    @Override
    public String getJenisTransaksi() {
        return "Transaksi Rekening Dasar";
    }

    @Override
    public String toString() {
        return "Rekening{" +
                "nomorRekening='" + nomorRekening + '\'' +
                ", saldo=" + saldo +
                ", namaPemilik='" + namaPemilik + '\'' +
                ", tanggalMembuka=" + tanggalMembuka +
                '}';
    }
}
