import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program_2 {
	
	private void convertToString(File file) {
		try(BufferedReader bufLines = Files.newBufferedReader(Paths.get(file.getPath()))) {
						
			LinkedList<String>	listOfString = bufLines.lines().collect(Collectors.toCollection(LinkedList::new));
			System.out.println("--------------- Printing the content of linkedlist in reverse order -----------\n");
			listOfString.descendingIterator().forEachRemaining(System.out::println);
			System.out.println("\n--------------- Printing the content in Upper case -----------\n");
			listOfString.stream().map(String::toUpperCase).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program_2 program_2 = new Program_2();
		program_2.convertToString(new File("C:\\Users\\pr318741\\Desktop\\spring_sample.txt"));
	}
}
 