package test;

import java.sql.SQLException;
import java.sql.SQLTransientException;

public class ExceptionEx1 {
	
 public void main() {
	 A a = new B();

		try {
			a.method();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
  }
}

class B implements A{

	@Override
	public void method() throws SQLTransientException{// 기존 메서드의 하위클래스 엑셉션만 던질 수 있다.
		
	}//기존메서드 보다 상위 익셉션을 던질시 컴파일 에러가 난다.
	
}

interface A{
	 void method() throws SQLException;
}
