import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Program_4 {
	
	private void readAndCountChar(File file) throws IOException {
		
		try(Stream<String> lines = Files.lines(Paths.get(file.getPath()))){
			int Count = (int)lines.map(s -> s.split("\\s")).flatMap(Arrays::stream).filter(line -> line.contains("the")).count();
			System.out.println(Count);
		}
	}

	public static void main(String[] args) {
		Program_4 program = new Program_4();
		try {
			program.readAndCountChar(new File("C:\\Users\\pr318741\\Desktop\\sample.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
