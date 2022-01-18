package chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Center {
	
	List<UserVo> comments = new ArrayList<>();

	@SuppressWarnings("resource")
	public void register(List<String> swearWords) throws Exception{
		UserVo userVo = new UserVo();
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디: ");
		userVo.setId(sc.nextLine());
		System.out.print("댓글");
		String comment = sc.nextLine();
		
		for(String swearWord : swearWords) {
			if(comment.indexOf(swearWord) >= 0) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; swearWord.length() > i; i++) {
					sb.append("*");
				}
				comment = comment.replaceAll(swearWord, sb.toString());
			}
		}
		userVo.setComment(comment);
		
		comments.add(userVo);
		
		System.out.println(userVo.getId() + ": " + userVo.getComment());
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void showComment() {
		for(UserVo comment : comments) {
			System.out.println(comment.getId() + ": " + comment.getComment());
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void exit() {
		System.out.println("종료되었습니다");
		System.exit(0);
	}
}
