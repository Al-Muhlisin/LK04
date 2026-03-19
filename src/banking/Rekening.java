package banking;

import java.util.Date;

public class Rekening {
    
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
        this("", 0, "");
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
    
    public void setSaldo(double saldo) {
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
    
    public void setorTunai(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("✓ Setor tunai Rp" + jumlah + " berhasil");
            System.out.println("  Saldo baru: Rp" + saldo);
        } else {
            System.out.println("✗ Jumlah setor harus lebih dari 0");
        }
    }
    
    public void tarikTunai(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("✓ Tarik tunai Rp" + jumlah + " berhasil");
            System.out.println("  Saldo baru: Rp" + saldo);
        } else if (jumlah > saldo) {
            System.out.println("✗ Saldo tidak cukup. Saldo Anda: Rp" + saldo);
        } else {
            System.out.println("✗ Jumlah tarik harus lebih dari 0");
        }
    }
    
    public double cekSaldo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        return saldo;
    }
    
    public void transfer(String rekeningTujuan, double jumlah) {
        System.out.println();
    }
    
    public void proses() {
        System.out.println();
    }
    
    public boolean validasi() {
        System.out.println();
        return true;
    }
    
    public String getJenisTransaksi() {
        System.out.println();
        return "Transaksi Umum";
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
