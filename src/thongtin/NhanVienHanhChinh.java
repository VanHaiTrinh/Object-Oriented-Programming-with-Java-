package thongtin;

import java.util.Scanner;

public class NhanVienHanhChinh extends NhanVien{

	@Override
	public void nhap(){
		@SuppressWarnings("resource")
		Scanner r= new Scanner(System.in);
		System.out.println("-Hãy nhập họ tên nhân viên hành chính:");
		do {	
	    	setHoTen(r.nextLine());
	    } while ( getHoTen().isEmpty());
		
		System.out.println("-Hãy nhập phòng ban nhân viên hành chính:");
		do {	
			setPhongBan(r.nextLine());
	    } while (getPhongBan().isEmpty());
		
		System.out.println("- Hãy nhập chức vụ của nhân viên hành chính (trưởng phòng,phó phòng,nhân viên)");
		do {
			setChucVu(r.nextLine());
			if(!(getChucVu().equals("trưởng phòng") || getChucVu().equals("phó phòng") || getChucVu().equals("nhân viên"))){
				System.out.println("Chú ý:chức vụ là trưởng phòng,phó phòng hoặc nhân viên");
			}
			
		}while (!(getChucVu().equals("trưởng phòng") || getChucVu().equals("phó phòng") || getChucVu().equals("nhân viên")));	
		
		do {
			try{
				error=false;
				System.out.println("-Hãy nhập số ngày công của nhân viên hành chính:");
				setSoNgayCong(r.nextInt());
				if(getSoNgayCong() < 0){
					System.out.println("Số ngày công phải là một số nguyên >=0");
				}
			} catch(Exception e){
				error=true;
				System.out.println("Số ngày công phải là một số nguyên >=0");
				r.nextLine();
			}
		} while (getSoNgayCong()<0||error);
		
		do {
			try{
				error=false;
				System.out.println("-Hãy nhập hệ số lương của nhân viên hành chính:");
				setHeSoLuong(r.nextDouble());
				if(getHeSoLuong() < 0){
					System.out.println("Hệ số lương phải là một số thực >=0");
				}
			} catch(Exception e){
				error=true;
				System.out.println("Hệ số lương phải là một số thực >=0");
				r.nextLine();
			}
		} while (getHeSoLuong()<0||error);
		
		if(getChucVu().equals("trưởng phòng")){
			setPhuCap(2000);
		}else if(getChucVu().equals("phó phòng")){
			setPhuCap(1000);
		}else{
			setPhuCap(500);
		}
		
		setLuong(getHeSoLuong()*730+getPhuCap()+getSoNgayCong()*30);
	}

	@Override
	public void hienThi() {
		System.out.println("+Đây là một nhân viên hành chính---------------------------------");
		System.out.println("-Họ tên nhân viên hành chính:"+getHoTen());
		System.out.println("-Phòng ban:"+getPhongBan());
		System.out.println("-Chức vụ:"+getChucVu());
		System.out.println("-Số ngày công:"+getSoNgayCong());
		System.out.println("-Hệ số lương:"+getHeSoLuong());
		System.out.println("-Phụ cấp:"+getPhuCap());
		System.out.println("-Tổng lương:"+getLuong());
		
	}
}
