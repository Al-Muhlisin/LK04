package banking;

public class RekeningValas extends Rekening implements TransferGlobal {

      private final String jenisMataUang;
      private final double kursRate;
      private String negaraTujuan;
      private String tokenDigital;
      private String nomorTujuanGlobal;
      private double nominalGlobal;

      public RekeningValas(String nomorRekening, double saldo, String namaPemilik,
                                     String jenisMataUang, double kursRate) {
            super(nomorRekening, saldo, namaPemilik);
            this.jenisMataUang = jenisMataUang;
            this.kursRate = kursRate;
            this.negaraTujuan = "-";
            this.tokenDigital = "TOKEN-AWAL";
            this.nomorTujuanGlobal = "-";
            this.nominalGlobal = 0.0;
      }

      public String getJenisMataUang() {
            return jenisMataUang;
      }

      public double getKursRate() {
            return kursRate;
      }

      public void setNegaraTujuan(String negaraTujuan) {
            this.negaraTujuan = negaraTujuan;
      }

      public void setTokenDigital(String tokenDigital) {
            this.tokenDigital = tokenDigital;
      }

      public void siapkanTransferGlobal(String nomorTujuan, double nominal) {
            this.nomorTujuanGlobal = nomorTujuan;
            this.nominalGlobal = nominal;
      }

      public double konversiKeMataUangLokal() {
            double totalIDR = getSaldo() * kursRate;
            System.out.println("Konversi saldo " + jenisMataUang + " ke IDR: Rp" + totalIDR);
            return totalIDR;
      }

      public boolean transferAntarNegara(String nomorTujuan, double jumlahValuta) {
            System.out.println("[SYSTEM] Memulai transfer internasional...");
            if (jumlahValuta <= 0) {
                  System.out.println("✗ Nominal harus lebih dari 0.");
                  return false;
            }
            if (jumlahValuta > getSaldo()) {
                  System.out.println("✗ Saldo valas tidak mencukupi.");
                  return false;
            }
            setSaldo(getSaldo() - jumlahValuta);
            System.out.println("✓ Berhasil mengirim " + jumlahValuta + " " + jenisMataUang + " ke " + nomorTujuan);
            return true;
      }

      @Override
      public void proses() {
            System.out.println("Memproses transaksi valas internasional...");
      }

      @Override
      public boolean validasi() {
            return super.validasi()
                        && jenisMataUang != null && !jenisMataUang.trim().isEmpty()
                        && kursRate > 0;
      }

      @Override
      public String getJenisTransaksi() {
            return "Transfer Global Valas";
      }

      @Override
      public void prosesOnline() {
            System.out.println("Proses online aktif dengan token: " + tokenDigital);
      }

      @Override
      public String getTokenDigital() {
            return tokenDigital;
      }

      @Override
      public void prosesInternasional() {
            System.out.println("Proses internasional ke negara: " + negaraTujuan);
      }

      @Override
      public String getNegaraTujuan() {
            return negaraTujuan;
      }

      @Override
      public boolean transferGlobal() {
            if (nominalGlobal <= 0 || nomorTujuanGlobal == null || nomorTujuanGlobal.trim().isEmpty() || "-".equals(nomorTujuanGlobal)) {
                  return false;
            }
            return transferAntarNegara(nomorTujuanGlobal, nominalGlobal);
      }

      @Override
      public boolean verifikasiInternasional() {
            boolean negaraValid = negaraTujuan != null && !negaraTujuan.trim().isEmpty() && !"-".equals(negaraTujuan);
            boolean tokenValid = tokenDigital != null && tokenDigital.length() >= 8;
            return negaraValid && tokenValid;
      }
}
  
