public abstract class TaiLieu {
    private String maTaiLieu;
    private String nhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(String ma, String nxb, int soBan) {
        this.maTaiLieu = ma;
        this.nhaXuatBan = nxb;
        this.soBanPhatHanh = soBan;
    }

    public String getMaTaiLieu() { return maTaiLieu; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public int getSoBanPhatHanh() { return soBanPhatHanh; }

    public void hienThi() {
        System.out.println("Mã: " + maTaiLieu + " | NXB: " + nhaXuatBan
                + " | Số bản phát hành: " + soBanPhatHanh);
    }
}
