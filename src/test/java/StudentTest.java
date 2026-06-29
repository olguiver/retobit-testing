import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {
	Student student;
	
	@BeforeEach
	public void setup()
	{
		student = new Student("Melvin","melvineugine@malpaso.com",21);
	}
	
	@Test
	@DisplayName("Getters")
	public void testGetters() {
		assertEquals("Melvin", student.getName());
		assertEquals("melvineugine@malpaso.com", student.getEmail());
		assertEquals(21, student.getAge());
	}
	
	@Test
	@DisplayName("Setters")
	public void testSetters() {
		student.setName("Tifa");
		student.setEmail("Tifa@correo.com");
		student.setAge(32);
		
		assertEquals("Tifa", student.getName());
		assertEquals("Tifa@correo.com", student.getEmail());
		assertEquals(32, student.getAge());
	}
	
	@Test
	@DisplayName("Nombre incorrecto manda exception")
	public void testIncorrectName()
	{
		try
		{
			student.setName("");
		}
		catch(IllegalArgumentException exception)
		{
			assertEquals("Name cannot be empty", exception.getMessage());
		}
		
		assertThrows(IllegalArgumentException.class, ()-> {
			student.setName("");
        });
	}
	
	@Test
	@DisplayName("Edad incorrecto manda exception")
	public void testIncorrectAge()
	{
		try
		{
			student.setAge(-20);
		}
		catch(IllegalArgumentException exception)
		{
			assertEquals("Age must be between 0 and 120 years", exception.getMessage());
		}
		
		try
		{
			student.setAge(121);
		}
		catch(IllegalArgumentException exception)
		{
			assertEquals("Age must be between 0 and 120 years", exception.getMessage());
		}
		assertThrows(IllegalArgumentException.class, ()-> {
			student.setAge(-20);
        });
	}
	
	@Test
	@DisplayName("Email incorrecto manda exception")
	public void testIncorrectEmail()
	{
		try
		{
			student.setEmail("fsdfdsf");
		}
		catch(IllegalArgumentException exception)
		{
			assertEquals("Email must have a valid format", exception.getMessage());
		}
		assertThrows(IllegalArgumentException.class, ()-> {
			student.setEmail("fsdfdsf");
        });
	}
	
	
	@Test
	@DisplayName("Añadimos un grade correctamente")
	public void TestAddGrade() {
		student.addGrade(10);
		assertFalse(student.getGrades().isEmpty());
		assertEquals(1, student.getGrades().size());
	}
	
	@Test
	@DisplayName("Añadimos un grade negativo y laza exception")
	public void TestAddNegativoGrade() {
		
		assertThrows(IllegalArgumentException.class, ()-> {
			student.addGrade(-10);
        });
	}
	
	@Test
	@DisplayName("Calculo de la media correcto")
	public void TestAverage() {
		student.addGrade(10);
		student.addGrade(10);
		student.addGrade(0);
		student.addGrade(0);
		
		assertEquals(5.0, student.calculateAverage());
	}
	
	@Test
	@DisplayName("Calculo de status")
	public void Teststatus() {
		student.addGrade(10);
		student.addGrade(10);
		student.addGrade(0);
		student.addGrade(0);
		
		assertEquals("Regular", student.getAcademicStatus());
	}
	
}
