import java.io.*;

public class MyClassLoader extends ClassLoader {
	private String path;
	public MyClassLoader(String path) {
		this.path = path;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = getData(name);
		Class<?> aClass = defineClass(name, data, 0, data.length);
		if (aClass == null) {
			aClass = super.findClass(name);
		}
		return aClass;
	}

	private byte[] getData(String name) {
		String filePath = path + File.separator + name.replace('.', File.separatorChar) + ".class";
		try (FileInputStream fis = new FileInputStream(filePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			int len = 0;
			byte[] buffer = new byte[2048];
			while ((len = fis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}