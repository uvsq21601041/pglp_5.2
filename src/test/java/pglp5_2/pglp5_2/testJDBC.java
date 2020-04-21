package pglp5_2.pglp5_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class testJDBC {

	 public static void main(String[] args) {
		 ArrayList<Integer> list=new ArrayList<Integer>();
			for(int i = 0;i<10;i++){
				list.add(i);
			}
		  Personnel per = new Personnel();
		  per.setNom("toto");
		  per.setPrenom("tutu");
		  per.setFonction("2019-03-03");
		  per.setTelephone(list);
		  try
		  {
		   FileOutputStream fileOut = new FileOutputStream("personnel.ser");
		   ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
		   outStream.writeObject(per);
		   outStream.close();
		   fileOut.close();
		  }catch(IOException i)
		  {
		   i.printStackTrace();
		  }
		 }
		}