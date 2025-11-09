/**
 * Merepresentasikan satu item menu pada restoran.
 * Setiap item memiliki kode unik, nama, dan harga satuan dalam rupiah.
 *
 * Kelas ini bersifat immutable: nilai atribut tidak dapat diubah
 * setelah objek dibuat.
 *
 * @author Ilham Fauzan
 */
public class MenuItem {

    /**
     * Kode unik untuk membedakan setiap item menu.
     */
    private final int kode;

    /**
     * Nama menu yang akan ditampilkan ke pengguna.
     */
    private final String nama;

    /**
     * Harga satuan menu dalam rupiah.
     */
    private final int harga;

    /**
     * Membuat objek {@code MenuItem} baru.
     *
     * @param kode  kode unik untuk item menu (misalnya 1, 2, dst.)
     * @param nama  nama menu
     * @param harga harga satuan dalam rupiah
     */
    public MenuItem(int kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mengembalikan kode menu.
     *
     * @return kode menu
     */
    public int getKode() {
        return kode;
    }

    /**
     * Mengembalikan nama menu.
     *
     * @return nama menu
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan harga menu.
     *
     * @return harga menu dalam rupiah
     */
    public int getHarga() {
        return harga;
    }
}
