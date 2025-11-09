/**
 * Kelas {@code Order} merepresentasikan satu pesanan
 * yang terdiri dari sebuah item menu dan jumlah pesanannya.
 *
 * Kelas ini digunakan untuk menghitung total harga berdasarkan
 * harga satuan item menu dan jumlah yang dipesan.
 */
public class Order {

    /**
     * Item menu yang dipesan.
     */
    private final MenuItem menuItem;

    /**
     * Jumlah pesanan untuk item menu.
     */
    private final int jumlah;

    /**
     * Membuat objek {@code Order} baru.
     *
     * @param menuItem item menu yang dipesan
     * @param jumlah   jumlah pesanan
     */
    public Order(MenuItem menuItem, int jumlah) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
    }

    /**
     * Mengembalikan item menu yang dipesan.
     *
     * @return objek {@link MenuItem} yang dipesan
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * Mengembalikan jumlah pesanan.
     *
     * @return jumlah pesanan
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * Menghitung total harga untuk pesanan ini.
     *
     * @return total harga (harga satuan dikali jumlah)
     */
    public int hitungTotal() {
        return menuItem.getHarga() * jumlah;
    }
}
