package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DirectoryWalk {
	
	private HashSet<String> set = new HashSet<>();
	private HashMap<String, List<String>> map = new HashMap<>();
	private HashSet<String> files = new HashSet<>();
	private HashSet<String> absoluteFiles = new HashSet<>();

	public DirectoryWalk(String path) {
		walk(path);
	}

	public DirectoryWalk walk(String path) {
		File root = new File(path);
		if (root.isDirectory()) {
			File[] files = root.listFiles();
			for (File f : files) {
				walk(f.getAbsolutePath());
			}
		} else {
			String fileName = root.getName();
			String path1 = new String(root.getParent());

			files.add(fileName);
			
			absoluteFiles.add(path1 + File.separator + fileName);

			set.add(path1);
			if (!map.containsKey(path1)) {
				ArrayList<String> al = new ArrayList<>();
				al.add(fileName);
				set.add(path1);
				map.put(new String(path1), al);
			} else {
				List<String> a = map.get(path1);
				a.add(fileName);
				set.add(path1);
				map.put(new String(path1), a);
			}
		}
		return this;
	}

	public HashMap<String, List<String>> getDirectoryMap() {
		return map;
	}

	public HashSet<String> getDirectorySet() {
		return set;
	}

	public HashSet<String> getFilesSet() {
		return files;
	}

	public HashSet<String> getAbsoluteFiles() {
		return absoluteFiles;
	}
}
