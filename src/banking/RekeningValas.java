package banking;

public class RekeningValas extends Rekening implements TransferGlobal{
      private String jenisMataUang;
      private final double kursRate;

  public RekeningValas(String nomorRekening, double saldo, String namaPemilik, String jenisMataUang, double kursRate) {
        super(nomorRekening, saldo, namaPemilik);
        this.jenisMataUang = jenisMataUang;
        this.kursRate = kursRate;
  }
  
