public class TokoKue {
    public static void main (String[] args) {
        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Lapis Legit", 100000, 0.5);
        daftarKue[1] = new KueJadi("Nastar", 5000, 10);
        daftarKue[2] = new KuePesanan("Brownies", 120000, 0.3);
        daftarKue[3] = new KueJadi("Putri Salju", 6000, 15);
        daftarKue[4] = new KuePesanan("Cubit", 80000, 0.4);
        daftarKue[5] = new KueJadi("Pukis", 7000, 20);
        daftarKue[6] = new KuePesanan("Pancong", 90000, 0.6);
        daftarKue[7] = new KueJadi("Bolu", 15000, 5);
        daftarKue[8] = new KuePesanan("Putu", 85000, 0.45);
        daftarKue[9] = new KueJadi("Lemper", 10000, 8);
        daftarKue[10] = new KuePesanan("Serabi", 75000, 0.35);
        daftarKue[11] = new KueJadi("Pancong", 12000, 7);
        daftarKue[12] = new KuePesanan("Pancong", 95000, 0.55);
        daftarKue[13] = new KueJadi("Cubit", 11000, 9);
        daftarKue[14] = new KuePesanan("Apem", 70000, 0.25);
        daftarKue[15] = new KueJadi("Lapis", 13000, 6);
        daftarKue[16] = new KuePesanan("Talam", 65000, 0.2);
        daftarKue[17] = new KueJadi("Pancong", 14000, 4);
        daftarKue[18] = new KuePesanan("Putri Salju", 105000, 0.5);
        daftarKue[19] = new KueJadi("Nastar", 9000, 12);


        System.out.println("Daftar Semua Kue:");
        for (Kue kue : daftarKue) {
            System.out.println(kue.toString());
        }


        double totalHarga = 0;
        for (Kue kue : daftarKue) {
            totalHarga += kue.hitungHarga();
        }
        System.out.println("\nTotal Harga Semua Kue: Rp" + totalHarga);


        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) kue;
                totalHargaPesanan += kp.hitungHarga();
                totalBeratPesanan += kp.getBerat();
            }
        }
        System.out.println("\nTotal Harga Kue Pesanan: Rp" + totalHargaPesanan);
        System.out.println("Total Berat Kue Pesanan: " + totalBeratPesanan + " kg.");

        
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                KueJadi kj = (KueJadi) kue;
                totalHargaJadi += kj.hitungHarga();
                totalJumlahJadi += kj.getJumlah();
            }
        }
        System.out.println("\nTotal Harga Kue Jadi: Rp" + totalHargaJadi);
        System.out.println("Total Jumlah Kue Jadi: " + totalJumlahJadi + " kue.");


        Kue kueTermahal = daftarKue[0];
        for (Kue kue : daftarKue) {
            if (kue.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }
        }
        System.out.println("\nKue dengan Harga Terbesar:");
        System.out.println(kueTermahal.toString());
    }
}

abstract class Kue {
    private String nama;
    private double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }
    public double getHarga() {
        return harga;
    }

    public abstract double hitungHarga();
    
    @Override
    public String toString() {
        return "Nama kue: " + nama + ", Harga: Rp" + hitungHarga();
    }
}

class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga()*berat;
    }
    @Override
    public String toString() {
        return "[Kue Pesanan] Nama kue: " + getNama() + ", Harga: Rp" + getHarga() + ", Berat: " + berat + " kg.";
    }
}

class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public double hitungHarga() {
        return getHarga()*jumlah*2;
    }
    @Override
    public String toString() {
        return "[Kue Jadi] Nama kue: " + getNama() + ", Harga: Rp" + getHarga() + ", Jumlah: " + jumlah + " kue.";
    }
}
