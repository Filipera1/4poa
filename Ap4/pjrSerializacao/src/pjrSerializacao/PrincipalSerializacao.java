package pjrSerializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Professor p = new Professor("Claudio", 45, "99999", "Matematica");
		try {
			File f = new File("c:/a/");
			if(!f.exists()) f.mkdir();
			FileOutputStream arqOSer = new FileOutputStream("c:/a/claudio.ser");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(p);
			oOSer.close();
			System.out.println("---------------Antes de alterar idade-------------");
			System.out.println(p);
			p.setIdade(40);
			System.out.println("---------------Depois de alterar idade-------------");
			System.out.println(p);
			FileInputStream arqISer = new FileInputStream("c:/a/claudio.ser");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			p = (Professor) iOSer.readObject();
			iOSer.close();
			System.out.println("---------------Depois de recuperar os valores-------------");
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


