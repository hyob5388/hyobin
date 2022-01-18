package chat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {
	
	private static Center center = new Center();
	
	private static String FileDirectory = "C:/Users/USER/Desktop/fword_list.txt";

	public static void main(String[] args) throws Exception{
		while (true) {
			Scanner sc = new Scanner(System.in);
			int num = 0;
			
			System.out.println("[1] :댓글 입력하기 ");
			System.out.println("[2] : 채팅창 보기");
			System.out.println("[0] : 종료");
			System.out.print("기능을 선택해주세요: ");
			
			try {
				num = sc.nextInt();
			}catch(Exception e) {
				System.out.println("[error: 번호 입력 오류]");
			}
			
			List<String> swearWords = swearWord();
			
			switch (num) {
			case 1:
				center.register(swearWords);
				break;
			case 2:
				center.showComment();
				break;
			case 0:
				center.exit();
				break;
			}
		}
	}
	
	private static List<String> swearWord() throws Exception{
		FileReader file;
		List<String> swearWord = new ArrayList<>();
		try {
			file = new FileReader("C:/Users/USER/Desktop/fword_list.txt");
			BufferedReader reader = new BufferedReader(file);
			String word = "";
			
			while ((word = reader.readLine()) != null) {
				swearWord.add(word);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return swearWord;
	}
}
