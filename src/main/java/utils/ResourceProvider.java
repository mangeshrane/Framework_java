package utils;

public class ResourceProvider {
	
    public String getResource(String filename){
    	System.out.println(getClass().getName());
    	
        ClassLoader loader = getClass().getClassLoader();
        String file = loader.getResource(filename).getFile();
        return file;
    }
}
