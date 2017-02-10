

import java.io.File;
import java.io.IOException;
import java.io.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.*;
import jxl.write.*;

	public class Xlscontrol {
		public static void writemorexls(){
			try{

				Workbook wb=Workbook.getWorkbook(new File("e:\\ldtest.xls"));
				WritableWorkbook book=Workbook.createWorkbook(new File("e:\\ldtest.xls"),wb);
				WritableSheet sheet=book.getSheet(0);
				sheet.addCell(new Label(1,1,"666"));
				
	
				book.write();
				book.close();
			}
			catch(Exception e){
				System.out.println(e);
		}
	}
	
		
	public static void main(String args[]){
		File f=new File("E:"+File.separator+"ldtest.xls");
	//�������Լ����ģ�λ��E:\dataAnalysis�ļ����е�test.xls
		try {
			Workbook book=Workbook.getWorkbook(f);//
			Sheet sheet=book.getSheet(0);   //��õ�һ�����������
			for(int i=0;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell=sheet.getCell(j, i);  //��õ�Ԫ��
					System.out.print(cell.getContents()+" "); 
				}
				System.out.print("\n");
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//writemorexls();
	}
	}



