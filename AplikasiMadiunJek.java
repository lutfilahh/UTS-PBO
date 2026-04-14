// Abstract Class
abstract class LayananTransportasi {
    protected String namaDriver;
    protected double jarak;
    protected double saldoUser;

    public LayananTransportasi(String namaDriver, double jarak, double saldoUser) {
        this.namaDriver = namaDriver;
        if (jarak <= 0) {
            this.jarak = 1;
        } else {
            this.jarak = jarak;
        }
        this.saldoUser = saldoUser;
    }

    public abstract double hitungTarif();
    public abstract void prosesTransaksi();
}

class MadiunMotor extends LayananTransportasi {
    
    public MadiunMotor(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
    }

    @Override
    public double hitungTarif() {
        return jarak * 2500; 
    }

    @Override
    public void prosesTransaksi() {
        System.out.println("=== Transaksi oleh Lutfilah Ahmad - 254311020 ===");
        System.out.println("Saldo Awal: Rp " + saldoUser);
        
        double tarif = hitungTarif();
        
        if (saldoUser >= tarif) {
            saldoUser -= tarif;
            System.out.println("Nama Driver: " + namaDriver);
            System.out.println("Jarak: " + jarak + " km");
            System.out.println("Total Bayar: Rp " + tarif);
            System.out.println("Sisa Saldo: Rp " + saldoUser);
            System.out.println();
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
            System.out.println();
        }
    }
}

class MadiunMobil extends LayananTransportasi {
    private double biayaAdmin;
    
    public MadiunMobil(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
        int nim = 20;
        this.biayaAdmin = 3000 + (nim * 100); 
    }

    @Override
    public double hitungTarif() {
        double tarifDasar = jarak * 5000; 
        return tarifDasar + biayaAdmin;
    }

    @Override
    public void prosesTransaksi() {
        System.out.println("=== Transaksi oleh Lutfilah Ahmad - 254311020 ===");
        System.out.println("Saldo Awal: Rp " + saldoUser);
        
        double tarif = hitungTarif();
        
        if (saldoUser >= tarif) {
            saldoUser -= tarif;
            System.out.println("Nama Driver: " + namaDriver);
            System.out.println("Jarak: " + jarak + " km");
            System.out.println("Total Bayar (Tarif + Biaya Admin Rp " + biayaAdmin + "): Rp " + tarif);
            System.out.println("Sisa Saldo: Rp " + saldoUser);
            System.out.println();
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
            System.out.println();
        }
    }
}

public class AplikasiMadiunJek {
    public static void main(String[] args) {
        LayananTransportasi[] layanan = new LayananTransportasi[2];
        
        layanan[0] = new MadiunMotor("Budi", 10, 50000);
        layanan[1] = new MadiunMobil("Andi", 5, 100000);
        
        for (LayananTransportasi l : layanan) {
            l.prosesTransaksi();
        }
    }
}