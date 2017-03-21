package thongtin;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLy  implements InterFace {
	ArrayList<NhanVienHanhChinh> listNVHC=new ArrayList<NhanVienHanhChinh>();
  public void Menu() {
	   do{
		   try{
			   do {    
				    System.out.println("-------------MENU(mời chọn phím chức năng)---------------");
			        System.out.println("Phím 1: Nhập một giảng viên mới và ghi vào file.");
			        System.out.println("Phím 2: Nhập một nhân viên hành chính mới.");
			        System.out.println("Phím 3: Đọc dữ liệu từ file và In danh sách giảng viên.");
			        System.out.println("Phím 4: Sắp xếp danh sách giảng viên.");
			        System.out.println("Phím 5: Tìm kiếm nhân viên hành chính theo tên,phòng ban.");
			        System.out.println("Phím 0: thoát.");
			        System.out.println("--------------------------------------------------------");
			        System.out.println("--------------------------------------------------------");
			        System.out.print("Mời nhập lựa chọn: ");
			        
				   @SuppressWarnings("resource")
				   Scanner sc = new Scanner(System.in);
				   int c = sc.nextInt(6);
				   
				   switch (c) {
				     case 1:
					   System.out.println("*Nhập một giảng viên mới và ghi vào file:");
					   GiangVien GV = new GiangVien();
					   GV.nhap();
					   	FileOutputStream f = new FileOutputStream("Danh Sách Giảng Viên.txt",true);
				    	Writer out = new OutputStreamWriter(f, "utf-8");
				    	GV.ghiFile(out);
				    	out.close();
					   break;
				     case 2:
					   System.out.println("*Nhập một nhân viên hành chính mới:");
					   NhanVienHanhChinh NVHC = new NhanVienHanhChinh();
					   NVHC.nhap();
					   listNVHC.add(NVHC);
					   break;
				     case 3:
					   try{	
						    System.out.println("*Đọc dữ liệu từ file và In danh sách giảng viên:");
						   	FileInputStream f1 = new FileInputStream("Danh Sách Giảng Viên.txt");
				         	Reader f2 = new InputStreamReader(f1);
				         	BufferedReader in = new BufferedReader(f2);
				         	String line;
				         	while ((line = in.readLine()) != null) {
				             System.out.println(line);
				         	}
				         	in.close();
				         }catch(Exception e){
				        	 System.out.println("Chưa nhập giảng viên nào");
				         }
						 break;
				     case 4:
				    	 try{
				    		 System.out.println("*Sắp xếp danh sách giảng viên:");
				    		 FileInputStream f11 = new FileInputStream("Danh Sách Giảng Viên.txt");
				    		 Reader f21 = new InputStreamReader(f11);
				    		 @SuppressWarnings("resource")
				    		 BufferedReader in1= new BufferedReader(f21);
				    		 int i=0;
				    		 while (in1.readLine() != null) {
				    			 i++;
				    		 }
				        
				    		 FileInputStream f12 = new FileInputStream("Danh Sách Giảng Viên.txt");
				    		 Reader f22 = new InputStreamReader(f12);
				    		 BufferedReader in2= new BufferedReader(f22);
				    		 String[] ar=new String[i];
				    		 int k=-1;
				    		 String line1;
				    		 while ((line1=in2.readLine())!= null) {
				    			 k++;
				    			 ar[k]=line1;
					         }
				    		 in2.close();
				         
				    		 ArrayList<GiangVien> listGV=new ArrayList<GiangVien>();
				    		 for(int h=0;h<i/9;h++){
				        		String [] gvArray = new String [9];
				        		for(int g=0;g<9;g++){
				        			gvArray[g] = ar[9*h+g];
				        		}
				        		GiangVien gv = new GiangVien();
				        		gv.docFile(gvArray);
				        	    listGV.add(gv);
				    		 }
				    		 Collections.sort(listGV, new Comparator<GiangVien>() {
							   	 public int compare(GiangVien gv1, GiangVien gv2) {
								   int result = gv1.getHoTen().compareTo(gv2.getHoTen());
								   if (result == 0) {
									   if (gv1.getLuong() < gv2.getLuong()) {
										   return 1;
									   } else {
										   if (gv1.getLuong() == gv2.getLuong()) {
											   return 0;
										   } else {
											   return -1;
										   }
									   }
								   }	
								   return gv1.getHoTen().compareTo(gv2.getHoTen());
							   	 }
						   });
          		
				    		 for(int i1=0;i1<listGV.size();i1++){
				    			 ((GiangVien)listGV.get(i1)).hienThi();
				    		 }
				       }catch(Exception e){
				        	 System.out.println("không tìm thấy file ");
				       }
					   break;
				     case 5:
				    		System.out.println("*Nhập tên hoặc phòng ban của nhân viên hành chính cần tìm:");
				    		NhanVienHanhChinh [] lts = listNVHC.toArray(new NhanVienHanhChinh[listNVHC.size()]);
				    		Scanner nh = new Scanner(System.in);
				    		String id=nh.nextLine();
				    		  if(lts.length!=0){
				    			 for(int j=0;j<lts.length;j++){
				    				 if(id.equals(lts[j].getHoTen())||id.equals(lts[j].getPhongBan())){
				    					 System.out.println("+Nhân viên hành chính cần tìm:");
				    					 System.out.println("-Họ tên:"+lts[j].getHoTen()+" "+"Phòng ban:"+lts[j].getPhongBan()+" "+
				    							 "Số công:"+lts[j].getSoNgayCong()+" "+"Hệ số lương:"+lts[j].getHeSoLuong()+" "+
				    							 "Phụ cấp:"+lts[j].getPhuCap()+" "+"Chức vụ:"+lts[j].getChucVu()+"Chức vụ:"+" "+ "Lương:"+lts[j].getLuong());
				    				 }else {
				    				 System.out.println("Không tìm thấy nhân viên nào");
				    				 }
				    			 }
				    		}else{
				    			 System.out.println("Chưa nhập nhân viên nào");
				    		}
				    	 break;
				    }
				   
				    if (c == 0) {
					   break;
				    }
			   }while(true); 
	 
		   }catch(Exception e){
			   System.out.println("Bạn phải nhập số từ 0 tới 5");
		   }
	   }while(true);  
	   
  	}
}