package utils;

import java.io.IOException;

public class JavaIO {
	public static void main(String[] args) throws IOException {
		/*
		 * File file = new File("test.txt"); file.createNewFile();
		 * System.out.println(File.separator);
		 * System.out.println(System.getProperty("file.separator"));
		 * 
		 * System.out.println(file.canExecute());
		 * System.out.println(file.canRead());
		 * System.out.println(file.canWrite());
		 * 
		 * file.setExecutable(false); System.out.println(file.canExecute());
		 * file.setReadable(false); FileInputStream fis = new
		 * FileInputStream(file); int s ; while ((s= fis.read()) != -1){
		 * System.out.print((char) s); } fis.close();
		 * 
		 * String data = new String(Files.readAllBytes(Paths.get("test.txt")));
		 * System.out.println(data);
		 * 
		 * FileWriter writer = new FileWriter(file); writer.write("test");
		 * writer.close();
		 * 
		 * FileWriter wri = new FileWriter(file, true); wri.write("test1");
		 * wri.close();
		 * 
		 * FileOutputStream fos = new FileOutputStream("test.zip");
		 * ZipOutputStream zos = new ZipOutputStream(fos); zos.putNextEntry(new
		 * ZipEntry(""));
		 */
		/*System.out.println(new DirectoryWalk(System.getProperty("user.dir")).getDirectoryMap());
		System.out.println(new DirectoryWalk(System.getProperty("user.dir")).getDirectorySet());
		System.out.println(new DirectoryWalk(System.getProperty("user.dir")).getFilesSet());
		System.out.println(new DirectoryWalk(System.getProperty("user.dir")).getAbsoluteFiles());*/
		
		Class<?> test;
		try {																	
			test = Class.forName("utils.DirectoryWalk");
			System.out.println(test);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*Zipper zip = new Zipper(System.getProperty("user.dir"), "output.zip");
		FileManager.createNewFolder("testFolder/test/");
		FileManager.createFileWithDirs("testFolder/test/tester/test.txt");
		*/
		/*Thread t= new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});*/

	}
	
}
