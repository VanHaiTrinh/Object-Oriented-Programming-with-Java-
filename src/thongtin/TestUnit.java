package thongtin;

import org.junit.Test;

public class TestUnit {

	@Test
	public void testTinhLuong() {
		NhanVien unit=new GiangVien();
		unit.nhap();
		System.out.println("lương giảng viên:"+" "+unit.getLuong());
		System.out.println("kiểm tra kết quả in ra bằng mắt thường");
	}
	
}
