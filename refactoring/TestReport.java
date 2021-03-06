package refactoring;

import junit.framework.TestCase;
import java.util.List;
import java.util.Collection;

public class TestReport extends TestCase {

	public TestReport(String name) { 
		super(name); 
	}
	
	public void testEmptyReport() throws Exception {
		ScheduleDAO.deleteAll();
		Report report = new Report();
		StringBuffer buffer = new StringBuffer();
		report.write(buffer);
		assertEquals("Number of scheduled offerings: 0\n", buffer.toString());
	}
	
	public void testReport() throws Exception {
		ScheduleDAO.deleteAll();
		Course cs101 = CourseDAO.create("CS101", 3);
		CourseDAO.update(cs101);
		Offering off1 = OfferingDAO.create(cs101, "M10");
		off1.update();
		Offering off2 = Offering.create(cs101, "T9");
		off2.update();
		Schedule s = Schedule.create("Bob");
		s.add(off1);
		s.add(off2);
		s.update();
		Schedule s2 = Schedule.create("Alice");
		s2.add(off1);
		s2.update();
		Report report = new Report();
		StringBuffer buffer = new StringBuffer();
		report.write(buffer);
		String result = buffer.toString();
		String valid1 = "CS101 M10\n\tAlice\n\tBob\n" + "CS101 T9\n\tBob\n" + "Number of scheduled offerings: 2\n";
		String valid2 = "CS101 T9\n\tBob\n" + "CS101 M10\n\tAlice\n\tBob\n" + "Number of scheduled offerings: 2\n";
		assertTrue(result.equals(valid1) || result.equals(valid2));
	}
}