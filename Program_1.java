import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Program_1 {

	public Program_1(File file) {
		System.out.println("Inside constructor - displays only diretcory list");
		try (Stream<Path> list = Files.list(Paths.get(file.getPath()))) {
			list.filter(Files::isDirectory).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void list(File file) {
		System.out.println("\n Inside list method - displays whole list");
		try (Stream<Path> list = Files.list(Paths.get(file.getPath()))) {
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void list(File file, Pattern dir) {
		System.out.println("\n Inside list method - displays subset of diretcory which matches the argument list");
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File f, String name) {
				if (name.endsWith(dir.toString())) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = file.listFiles(textFilter);
		for (File fil : files) {
			if (fil.isDirectory()) {
				try {
					Files.list(Paths.get(fil.getPath())).forEach(System.out::println);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Program_1 dirList = new Program_1(new File("C:\\Users\\pr318741\\Documents"));
		dirList.list(new File("C:\\Users\\pr318741\\Documents"));
		dirList.list(new File("C:\\Users\\pr318741\\Documents"), Pattern.compile("^(.+)dist"));
	}
}
