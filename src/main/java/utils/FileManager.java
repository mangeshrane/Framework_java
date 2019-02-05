package utils;

import java.io.File;
import java.io.IOException;

public class FileManager {

	public static void createNewFolder(String path) {
		new File(path).mkdirs();
	}

	public static void createFileWithDirs(String path) {
		File file = new File(path);
		String pathVar = file.getParent();
		new File(pathVar).mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createArchive(String targetPath, String outputPath){
		new Zipper(targetPath, outputPath);
	}
	
	public static void extractArchive(String zipPath, String outputPath){
		new Zipper(zipPath, outputPath);
	}
	
}
