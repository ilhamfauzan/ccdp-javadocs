import java.util.Scanner;

/**
 * Kelas CashRegister menangani proses transaksi kasir sederhana,
 * mulai dari menampilkan menu, menerima input pengguna,
 * menghitung total harga, hingga menampilkan kembalian atau kekurangan.
 *
 * Kelas ini menggunakan Scanner untuk membaca input dari pengguna
 * melalui console.
 */
public class CashRegister {

    /**
     * Scanner untuk membaca input dari pengguna.
     */
    private final Scanner scanner;

    /**
     * Daftar menu yang tersedia di restoran.
     */
    private final MenuItem[] daftarMenu;

    /**
     * Membuat objek CashRegister baru dengan daftar menu awal.
     * Secara default, daftar menu berisi:
     * - Paket Ayam Bakar
     * - Paket Ayam Goreng
     */
    public CashRegister() {
        this.scanner = new Scanner(System.in);

        // Inisialisasi menu (bisa kamu tambah sendiri nanti)
        this.daftarMenu = new MenuItem[] {
                new MenuItem(1, "Paket Ayam Bakar", 15000),
                new MenuItem(2, "Paket Ayam Goreng", 14000)
        };
    }

    /**
     * Menjalankan alur utama aplikasi kasir.
     * Metode ini akan:
     * 1. Menampilkan header aplikasi
     * 2. Menampilkan daftar menu
     * 3. Membaca pilihan menu pengguna
     * 4. Membaca jumlah pesanan
     * 5. Menghitung total harga
     * 6. Membaca jumlah pembayaran
     * 7. Menampilkan kembalian atau kekurangan
     */
    public void run() {
        tampilkanHeader();
        tampilkanMenu();
        MenuItem menuTerpilih = pilihMenu();

        if (menuTerpilih == null) {
            System.out.println("Menu tidak tersedia!");
            return;
        }

        int jumlah = inputJumlahPesanan();
        Order order = new Order(menuTerpilih, jumlah);

        int total = order.hitungTotal();
        System.out.println("Total Harga    : " + total);

        int bayar = inputPembayaran();
        prosesPembayaran(total, bayar);
    }

    /**
     * Menampilkan header aplikasi kasir ke layar.
     * Metode ini hanya menampilkan teks dan tidak mengembalikan nilai.
     */
    private void tampilkanHeader() {
        System.out.println("Aplikasi Kasir Sederhana");
        System.out.println("Karya Ilham F - Kelas XII RPL 2");
        System.out.println();
    }

    /**
     * Menampilkan daftar menu yang tersedia ke layar.
     * Metode ini akan menampilkan kode, nama, dan harga dari setiap
     * item menu, kemudian meminta pengguna memasukkan kode menu.
     */
    private void tampilkanMenu() {
        System.out.println("Silahkan Pilih Menu : ");
        for (MenuItem item : daftarMenu) {
            System.out.println(item.getKode() + ". " + item.getNama()
                    + " (Rp. " + item.getHarga() + ")");
        }
        System.out.print("Pilih Menu (masukkan kode) : ");
    }

    /**
     * Membaca input kode menu dari pengguna dan mengembalikan
     * objek MenuItem yang sesuai dengan kode tersebut.
     *
     * @return objek MenuItem yang dipilih,
     *         atau null jika kode tidak valid
     */
    private MenuItem pilihMenu() {
        int kodeDipilih = scanner.nextInt();
        System.out.println("______________________________");

        for (MenuItem item : daftarMenu) {
            if (item.getKode() == kodeDipilih) {
                System.out.println("Anda memilih: " + item.getNama());
                System.out.println("Harga : Rp. " + item.getHarga());
                System.out.println("______________________________");
                return item;
            }
        }
        return null;
    }

    /**
     * Meminta input jumlah pesanan dari pengguna.
     *
     * @return jumlah pesanan yang dimasukkan pengguna
     */
    private int inputJumlahPesanan() {
        System.out.print("Jumlah Pesanan : ");
        return scanner.nextInt();
    }

    /**
     * Meminta input nominal pembayaran dari pengguna.
     *
     * @return jumlah uang yang dibayarkan oleh pelanggan
     */
    private int inputPembayaran() {
        System.out.print("Bayar          : ");
        return scanner.nextInt();
    }

    /**
     * Memproses pembayaran berdasarkan total harga dan nominal
     * yang dibayarkan pelanggan.
     *
     * Metode ini akan menampilkan:
     * - Kembalian, jika pembayaran lebih besar dari total
     * - Kekurangan, jika pembayaran kurang dari total
     * - Pesan uang pas, jika pembayaran sama dengan total
     *
     * @param total total harga yang harus dibayar
     * @param bayar jumlah uang yang dibayarkan pelanggan
     */
    private void prosesPembayaran(int total, int bayar) {
        int kembalian = bayar - total;
        int kurang = total - bayar;

        if (kembalian > 0) {
            System.out.println("Kembalian      : " + kembalian);
            System.out.println("______________________________");
            System.out.println("Terimakasih telah berbelanja di resto kami");
        } else if (kembalian < 0) {
            System.out.println("______________________________");
            System.out.println("Uang kurang sebanyak: " + kurang);
        } else {
            System.out.println("______________________________");
            System.out.println("Uang pas. Terimakasih telah berbelanja di resto kami");
        }
    }
}
