/**
 * Kelas {@code Main} berfungsi sebagai titik masuk (entry point)
 * dari aplikasi kasir sederhana.
 *
 * Kelas ini hanya membuat objek {@link CashRegister} dan
 * memanggil metode {@link CashRegister#run()} untuk
 * menjalankan aplikasi.
 */
public class Main {

    /**
     * Metode main yang akan dijalankan pertama kali ketika aplikasi dimulai.
     *
     * @param args argumen baris perintah (tidak digunakan dalam aplikasi ini)
     */
    public static void main(String[] args) {
        CashRegister kasir = new CashRegister();
        kasir.run();
    }
}
