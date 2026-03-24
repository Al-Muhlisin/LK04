package banking;

public class RekeningValas extends Rekening implements TransferGlobal{
      private String jenisMataUang;
      private final double kursRate;

      public RekeningValas(String nomorRekening, double saldo, String namaPemilik, String jenisMataUang, double kursRate) {
            super(nomorRekening, saldo, namaPemilik);
            this.jenisMataUang = jenisMataUang;
            this.kursRate = kursRate;
      }

      public void konversiKeMataUangLokal() {
            double totalIDR = getSaldo() * kursRate;
            System.out.println("Konversi " + jenisMataUang + " ke IDR: Rp" + totalIDR);
      }

      public void transferAntarNegara(String nomorTujuan, double jumlahValuta) {
            System.out.println("[SYSTEM] Memulai transfer internasional...");
            if (jumlahValuta <= getSaldo()) {
                  setSaldo(getSaldo() - jumlahValuta);
                  System.out.println("Berhasil mengirim " + jumlahValuta + " " + jenisMataUang + " ke " + nomorTujuan);
            } else {
                  System.out.println("Saldo valas tidak mencukupi.");
            }
      }
}
  
