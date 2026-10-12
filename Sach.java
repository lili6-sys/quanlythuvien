public class Sach extends TaiLieu {
    private String tacGia;
    private int soTrang;

    public Sach(String ma, String nxb, int soBan, String tacGia, int soTrang) {
        super(ma, nxb, soBan);
        this.tacGia = tacGia;
        this.soTrang = soTrang;
    }

    @Override
    public void hienThi() {
        System.out.print("[Sách] ");
        super.hienThi();
        System.out.println("   Tác giả: " + tacGia + " | Số trang: " + soTrang);
    }
}
