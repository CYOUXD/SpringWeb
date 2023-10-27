package org.zerock.member.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter	//getter 생성
//@Setter	//setter 생성
//@NoArgsConstructor //기본생성자 생성
//@AllArgsConstructor //전체 필드생성자 생성
//@ToString //toString 생성
@Data //전체 필드 생성자 제외 전체 생성 getter, setter, 기본생성자, equals, toString...등 생성
@NoArgsConstructor
@AllArgsConstructor //이것만 쓰면 기본생성자가 사라지기 때문에 @NoArgsConstructor도 추가해줘야 한다
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private Timestamp regdata;
	
}
