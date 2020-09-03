
public class StringBuilderTest {
	/*
	 * 	select EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_NAME
		from EMPLOYEES e, DEPARTMENTS d
		where e.EMPLOYEE_ID = d.DEPARTMENT_ID
		order by EMPLOYEE_ID desc
	 * */
	
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		builder.append("select EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_NAME ")
			.append("from EMPLOYEES e, DEPARTMENTS d ")
			.append("where e.EMPLOYEE_ID = d.DEPARTMENT_ID ")
			.append("order by EMPLOYEE_ID desc");
		String sql = builder.toString();
		System.out.println(sql);
	}

}
