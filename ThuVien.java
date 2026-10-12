import java.util.ArrayList;
import java.util.Scanner;

public class ThuVien {
    private ArrayList<TaiLieu> ds = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private boolean tonTai(String ma) {
        for (TaiLieu t : ds)
            if (t.getMaTaiLieu().equalsIgnoreCase(ma)) return true;
        return false;
    }

    private int docInt(String nhan) {
        System.out.print(nhan);
        return Integer.parseInt(sc.nextLine().trim());
    }

    private String docChuoi(String nhan) {
        System.out.print(nhan);
        return sc.nextLine().trim();
    }

    public void themTaiLieu() {
        System.out.println("1. Sách  2. Tạp chí  3. Báo");
        int loai = docInt("Chọn loại: ");
        String ma = docChuoi("Mã tài liệu: ");
        if (tonTai(ma)) {
            System.out.println("Mã đã tồn tại!");
            return;
        }
        String nxb = docChuoi("Nhà xuất bản: ");
        int soBan = docInt("Số bản phát hành: ");

        switch (loai) {
            case 1:
                String tg = docChuoi("Tác giả: ");
                int trang = docInt("Số trang: ");
                ds.add(new Sach(ma, nxb, soBan, tg, trang));
                break;
            case 2:
                int so = docInt("Số phát hành: ");
                int thang = docInt("Tháng phát hành: ");
                ds.add(new TapChi(ma, nxb, soBan, so, thang));
                break;
            case 3:
                String ngay = docChuoi("Ngày phát hành: ");
                ds.add(new Bao(ma, nxb, soBan, ngay));
                break;
            default:
                System.out.println("Loại không hợp lệ!");
                return;
        }
        System.out.println("Thêm thành công.");
    }

    public void xoaTheoMa() {
        String ma = docChuoi("Nhập mã cần xoá: ");
        boolean xoa = ds.removeIf(t -> t.getMaTaiLieu().equalsIgnoreCase(ma));
        System.out.println(xoa ? "Đã xoá." : "Không tìm thấy mã này.");
    }

    public void hienThiTatCa() {
        if (ds.isEmpty()) {
            System.out.println("Thư viện trống.");
            return;
        }
        for (TaiLieu t : ds) t.hienThi();
    }

    public void timTheoLoai() {
        System.out.println("1. Sách  2. Tạp chí  3. Báo");
        int loai = docInt("Chọn loại cần tìm: ");
        boolean thay = false;
        for (TaiLieu t : ds) {
            if ((loai == 1 && t instanceof Sach)
                    || (loai == 2 && t instanceof TapChi)
                    || (loai == 3 && t instanceof Bao)) {
                t.hienThi();
                thay = true;
            }
        }
        if (!thay) System.out.println("Không có tài liệu thuộc loại này.");
    }

    public void chayChuongTrinh() {
        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Xoá tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin tài liệu");
            System.out.println("4. Tìm tài liệu theo loại");
            System.out.println("0. Thoát");
            try {
                chon = docInt("Chọn: ");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                chon = -1;
                continue;
            }
            try {
                switch (chon) {
                    case 1: themTaiLieu(); break;
                    case 2: xoaTheoMa(); break;
                    case 3: hienThiTatCa(); break;
                    case 4: timTheoLoai(); break;
                    case 0: System.out.println("Tạm biệt!"); break;
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập sai, cần nhập số ở trường này!");
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        new ThuVien().chayChuongTrinh();
    }
}
