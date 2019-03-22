package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class FileUtil {
	
	public static String readGoodsContentFile(String fileName){
		BufferedReader br=null;
		String goodsIntroContent="";
		String realPath=ServletActionContext.getServletContext().getRealPath("/goods")+"\\content"+"\\"+fileName;
		try {
			br = new BufferedReader(new FileReader(realPath));
			String str = null;
		      while((str = br.readLine()) != null){
		    	  goodsIntroContent+=(str+"<br>");
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodsIntroContent;
	}
	public static void writeFile(File file,String fileName,String type){
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			String realPath=ServletActionContext.getServletContext().getRealPath("/goods")+"\\"+type;
			String realPathFile=realPath+"\\"+fileName;
			File realPathFileD=new File(realPath);
			if(!realPathFileD.exists())realPathFileD.mkdirs();
			System.out.println("realPathFile="+realPathFile);
			fos = new FileOutputStream(realPathFile);
			bos = new BufferedOutputStream(fos);
			byte b[] = new byte[1024];
			int length;
            while( (length = bis.read( b ) )!= -1 ){
                //length 代表实际读取的字节数
                bos.write(b, 0, length );
            }
            //缓冲区的内容写入到文件
            bos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				fis.close();
				fos.close();
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void deleteFile(String fileName,String type){
		String realPath=ServletActionContext.getServletContext().getRealPath("/goods")+"\\"+type+"\\"+fileName;;
		File deleteFile = new File(realPath);
		System.out.println("deleteFile:"+realPath); 
		boolean result=false; 
	    result = deleteFile.delete();  
		System.out.println("deleteStatus:"+result);
	}

}
