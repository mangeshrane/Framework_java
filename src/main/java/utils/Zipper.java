package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper {
	private Set<String> files = new HashSet<>();
	byte[] buffer = new byte[1024];

	public Zipper(String source, String output) {
		setFiles();
		zip(output);
	}

	public void zip(String output) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(output));
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (String file : files) {
				zos.putNextEntry(new ZipEntry(file));
				FileInputStream in = new FileInputStream(file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void unZip(String zipFile, String output) {
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(fis);

			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(output + File.separator + fileName);
				System.out.println("Unzipping to " + newFile.getAbsolutePath());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setFiles() {
		files = new DirectoryWalk(System.getProperty("user.dir")).getAbsoluteFiles();
	}
}
