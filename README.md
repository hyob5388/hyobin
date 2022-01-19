# hyobin

안녕하세요 김효빈입니다.
간단한 필터링 프로그램을 작성해보았습니다.

----------------------------------

### 프로젝트 계획이유

만들게된 솔직한 이유는 대학교에서 내주신 과제를 하기 위해서 입니다.
그 중에서도 이 주제를 선정하게 된 이유는 평소 인터넷 서치나 게임을 주로하는 저에게 인터넷 문화중 욕설이나 비방어는 제 눈에 종종 띄었던 요소 중 하나였습니다. 
그래서 어떤 프로젝트를 만들지 선정하게 된 것이 바로 '욕설&비방어 필터링 프로그램' 입니다.

-----------------------------------

-----------------------------------

### 프로그램 설명

사용 언어 : JAVA
사용 프로그램 : Eclipse IDE for JAVA Developers - 2021-12
필수 사항 : txt의 한국어 단어를 필터링 하기 위해선 이클립스를 "UTF-8"인코딩 설정으로 변경해주어야
-----------------------------------

-----------------------------------

### Filtering 기능 설명

+ [1] : 댓글 입력하기
+ [2] : 채팅창 보기
+ [3] : 종료

[1]에서 댓글을 입력하면 자동으로 txt파일에 있는 단어를 필터링 해주는 간단한 프로그램 입니다.
[1]에서 작성했던 댓글은 [2]에서 한눈에 확인 가능합니다.


-----------------------------------
### Code 설명
UserVo 클래스
``` JAVA
public class UserVo {
	
	String id;
	
	String comment;

	public String getId() {	//아이디 저장
		return id;
	}

	public void setId(String id) {	인스턴스 멤버인 필드의 아이디
		this.id = id;
	}

	public String getComment() {	//댓글 저장
		return comment;
	}

	public void setComment(String comment) {	인스턴스 멤버인 필드의 댓글
		this.comment = comment;
	}
	
}
```

Center 클래스
``` JAVA
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Center {
	
	List<UserVo> comments = new ArrayList<>();	//기능1의 작성했던 댓글들을 관리하는 리스트

	@SuppressWarnings("resource")
	public void register(List<String> swearWords) throws Exception{
		UserVo userVo = new UserVo();
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디: ");
		userVo.setId(sc.nextLine());	//아이디를 입력받음
		System.out.print("댓글");
		String comment = sc.nextLine();	//댓글을 입력받음
		
		for(String swearWord : swearWords) {	//텍스트 파일의 비속어와 댓글의 비속어를 비교
			if(comment.indexOf(swearWord) >= 0) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; swearWord.length() > i; i++) {
					sb.append("*");	//비속어를 변경해줌
				}
				comment = comment.replaceAll(swearWord, sb.toString());	
				//필터링 된 댓글로 댓글창에 저장
			}
		}
		userVo.setComment(comment);
		
		comments.add(userVo);
		
		System.out.println(userVo.getId() + ": " + userVo.getComment());
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void showComment() {	//기능2의 댓글창을 보여줌
		for(UserVo comment : comments) {
			System.out.println(comment.getId() + ": " + comment.getComment());
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public void exit() {	//기능3 종료
		System.out.println("종료되었습니다");
		System.exit(0);
	}
}
```

Starter 클래스
``` JAVA
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {
	
	private static Center center = new Center();
	
	private static String FileDirectory = "텍스트 파일 경로";

	public static void main(String[] args) throws Exception{
		while (true) {
			Scanner sc = new Scanner(System.in);
			int num = 0;	//num이라는 변수에 기능 값을 입력받음
			
			System.out.println("[1] :댓글 입력하기 ");
			System.out.println("[2] : 채팅창 보기");
			System.out.println("[0] : 종료");
			System.out.print("기능을 선택해주세요: ");
			
			try {
				num = sc.nextInt();	
			}catch(Exception e) {
				System.out.println("[error: 번호 입력 오류]");	
				//[1][2][0] 숫자 외에 다른 숫자 입력시
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
			file = new FileReader("텍스트 파일 경로");
			BufferedReader reader = new BufferedReader(file);
			String word = "";
			
			while ((word = reader.readLine()) != null) {	//txt파일의 비속어를 list에 저장
				swearWord.add(word);
			}
			reader.close();
		} catch (FileNotFoundException e) {	//txt파일 읽어오는데 문제시 예외 발생
			e.printStackTrace();
		}
		return swearWord;
	}
}
```
---------------------------
