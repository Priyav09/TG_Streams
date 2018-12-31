import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program_3 {

	private void readWord(File file) {
		try(Stream<String> lines = Files.lines(Paths.get(file.getPath()))) {
			List<String> longWord = lines.map(s -> s.split("\\s")).flatMap(Arrays::stream).filter(w -> w.matches("\\w+")).collect(Collectors.toList());
			String s = longWord.stream().max(Comparator.comparing(String::length)).get();
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Program_3 program = new Program_3();
		program.readWord(new File("C:\\Users\\pr318741\\Desktop\\sample.txt"));
	}
}
