package a02_object.a07_oneVsmulti;

import java.util.ArrayList;

public class Z04_Travel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 ex) 1:다 관계 내용을 아래의 구조로 처리하세요 
 	 Travel : 필드 - 여행타이틀(여름휴가/취업여행/...), 
 	 				ArrayList<Location>
 	 		  메서드 - 여행지 객체 추가 
 	 		  		 전체 여행일정 리스트 메서드 
 	 		  
 	 Location(여행지) 위치, 수단(배,비행기,차량), 기간
 	 
 */
		Travel t1 = new Travel("여름휴가");
		t1.addLocation(new Location("태국","비행기","1달"));
		t1.addLocation(new Location("호주","비행기","1달"));
		t1.allSchedule();
		Travel t2 = new Travel("크리스마스여행");
		t2.addLocation(new Location("뉴욕","비행기","2달"));
		t2.allSchedule();
		
	}
}
class Travel{
	private String title;
	private ArrayList<Location>list;
	
	public Travel(String title) {
		this.title = title;
		list = new ArrayList<Location>();
	}
	public void addLocation(Location l) {
		list.add(l);
		System.out.println("여행지 추가: "+l.getLoc());
	}
	public void allSchedule() {
		System.out.println(title+" 일정");
		System.out.println("여행지\t이동수단\t여행기간");
		for(Location l: list) {
			l.schedule();
		}
		
	}
	
}
class Location{
	private String loc;
	private String trans;
	private String term;
	public Location(String loc, String trans, String term) {
		super();
		this.loc = loc;
		this.trans = trans;
		this.term = term;
	}
	
	public void schedule() {
		
		System.out.println(loc+"\t"+trans+"\t"+term);
	}

	public String getLoc() {
		return loc;
	}
	
}
