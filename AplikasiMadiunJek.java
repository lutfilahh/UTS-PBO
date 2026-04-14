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