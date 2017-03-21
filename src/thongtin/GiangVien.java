package thongtin;


import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class GiangVien extends NhanVien {

	public void nhap(){
		@SuppressWarnings("resource")
		Scanner r= new Scanner(System.in);
		
		System.out.println("-Hãy nhập họ tên giảng viên:");
	    do {	
	    	setHoTen(r.nextLine());
	    } while ( getHoTen().isEmpty());
		
		System.out.println("- Hãy nhập khoa giảng viên:");
		do {	
			setKhoa(r.nextLine());
	    } while (getKhoa().isEmpty());
		
		System.out.println("-Hãy nhập trình độ giảng viên(cử nhân,thạc sĩ,tiến sĩ):");
		do {
			setTrinhDo(r.nextLine());
			if(!(getTrinhDo().equals("cử nhân") || getTrinhDo().equals("thạc sĩ") || getTrinhDo().equals("tiến sĩ"))){
				System.out.println("Chú ý:trình độ giảng viên là cử nhân,thạc sĩ hoặc tiến sĩ");
			}
		}while (!(getTrinhDo().equals("cử nhân") || getTrinhDo().equals("thạc sĩ") || getTrinhDo().equals("tiến sĩ")));	
		
        
		do {
			try{
				error = false;
				System.out.println("-Hãy nhập số tiết dạy của giảng viên:");
				setSoTiet(r.nextInt());
				if(getSoTiet() < 0){
					System.out.println("Số tiết dạy phải là một số nguyên >=0");
				}
			} catch(Exception e){ 
				error = true;
				System.out.println("Số tiết dạy phải là một số nguyên");
				r.nextLine();
			}
		} while (error ||getSoTiet() < 0);
		
		do{
			try{
				error=false;
				System.out.println("-Hãy nhập hệ số lương của giảng viên:");
				setHeSoLuong(r.nextDouble());
				if(getHeSoLuong()<0){
					System.out.println("Hệ số lương phải là một số thực >=0");
				}
			}catch(Exception e){
				error=true;
				System.out.println("Hệ số lương phải là một số thực >=0");
				r.nextLine();
			}
		}while(getHeSoLuong()<0||error);
		
		if(getTrinhDo().equals("cử nhân")){
			setPhuCap(300);
		}else if(getTrinhDo().equals("thạc sĩ")){
			setPhuCap(500);
		}else{
			setPhuCap(1000);
		}
		
		setLuong(getHeSoLuong()*730+getPhuCap()+getSoTiet()*45);
	}
	
	@Override
	public void hienThi() {
		System.out.println("+Đây là một giảng viên---------------------------------");
		System.out.println("-Họ tên :" + getHoTen());
		System.out.println("-Khoa:"+getKhoa());
		System.out.println("-Trình độ:"+getTrinhDo());
		System.out.println("-Số tiết:"+getSoTiet());
		System.out.println("-Hệ số lương:"+getHeSoLuong());
		System.out.println("-Phụ cấp:"+getPhuCap());
		System.out.println("-Tổng lương:"+getLuong());
	}
	
	private String TaoCauTrucGhiFile()
	{
		String cautruc = "-------------------------\r\n";
		cautruc += "Họ tên : " + getHoTen() + "\r\n";
		cautruc += "Khoa : " + getKhoa() + "\r\n";
		cautruc += "Trình độ : " + getTrinhDo() + "\r\n";
		cautruc += "Số tiết : " + getSoTiet() + "\r\n";
		cautruc += "Hệ số lương : " + getHeSoLuong() + "\r\n";
		cautruc += "Phụ cấp : " + getPhuCap() + "\r\n";
		cautruc += "Tổng lương : " + getLuong() + "\r\n";
		cautruc += "-------------------------\r\n";
		return cautruc;
	}
	public void ghiFile(Writer out) throws IOException{
    	out.write(TaoCauTrucGhiFile());
	}
	
	public void docFile(String[] ar){
    	setHoTen(ar[1].substring(9));
		setKhoa(ar[2].substring(7));
		setTrinhDo(ar[3].substring(11));
		setSoTiet(Integer.parseInt(ar[4].substring(10)));
		setHeSoLuong(Double.parseDouble(ar[5].substring(14)));
		setPhuCap(Integer.parseInt(ar[6].substring(10)));
		setLuong(Double.parseDouble(ar[7].substring(13)));
	} 


}
