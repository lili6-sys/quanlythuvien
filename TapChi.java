public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String ma, String nxb, int soBan, int soPhatHanh, int thang) {
        super(ma, nxb, soBan);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thang;
    }

    @Override
    public void hienThi() {
        System.out.print("[Tạp chí] ");
        super.hienThi();
        System.out.println("   Số phát hành: " + soPhatHanh + " | Tháng: " + thangPhatHanh);
    }
}
