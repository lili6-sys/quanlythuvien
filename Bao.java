public class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(String ma, String nxb, int soBan, String ngay) {
        super(ma, nxb, soBan);
        this.ngayPhatHanh = ngay;
    }

    @Override
    public void hienThi() {
        System.out.print("[Báo] ");
        super.hienThi();
        System.out.println("   Ngày phát hành: " + ngayPhatHanh);
    }
}
