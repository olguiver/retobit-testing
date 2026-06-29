import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	 private Calculator calculator;

	    @BeforeEach
	    public void setup() {
	        calculator = new Calculator();
	    }

	    @Test
	    @DisplayName("Suma dos números con error de punto flotante")
	    public void testAddFloatingPoint() {
	        double result = calculator.add(20.20, 40.20);
	        assertEquals(60.40, result);
	    }
	    
	    @Test
	    @DisplayName("Suma dos números sin decimales")
	    public void testAddSimple() {
	        double result = calculator.add(20.0, 40.0);
	        assertEquals(60.0, result);
	    }
	    
	    @Test
	    @DisplayName("Resta dos números sin decimales")
	    public void testSubSimple() {
	        double result = calculator.subtract(20.0, 40.0);
	        assertEquals(-20.0, result);
	    }
	    
	    @Test
	    @DisplayName("Resta dos números con error de punto flotante")
	    public void testSubFloatingPoint() {
	        double result = calculator.subtract(20.20, 40.20);
	        assertEquals(-20.0, result);
	    }
	    
	    @Test
	    @DisplayName("Multiplica dos números con error de punto flotante")
	    public void testMulFloatingPoint() {
	        double result = calculator.multiply(20.20, 40.20);
	        assertEquals(812.04, result);
	    }
	    
	    @Test
	    @DisplayName("Multiplica dos números sin decimales")
	    public void testMulSimple() {
	        double result = calculator.multiply(2.0, -4.0);
	        assertEquals(-8.0, result);
	    }
	    
	    @Test
	    @DisplayName("Multiplica por cero")
	    public void testMulZero() {
	        double result = calculator.multiply(0, 23.0);
	        assertEquals(0.0, result);
	    }
	    
	    @Test
	    @DisplayName("Divide por cero y lanza exception")
	    public void testDivZero() {
	        assertThrows(ArithmeticException.class, ()-> {
	        	calculator.divide(30, 0);
	        });
	    }
	    
	    @Test
	    @DisplayName("numeros pares e impares correctos")
	    public void testIsEven() {
	        assertTrue(calculator.isEven(4));
	        assertFalse(calculator.isEven(3));
	    }
	    
	    @Test
	    @DisplayName("valor absoluto correcto")
	    public void testAbsoluteValue() {
	        int value1 = calculator.absoluteValue(-20);
	        		assertEquals(20,value1);
	        int value2 = calculator.absoluteValue(-20);
	        		assertEquals(20,value2);
	    }
	    
	    @Test
	    @DisplayName("Average")
	    public void testAverage() {
	    	List<Double> numbers = Arrays.asList(50.0,50.0,50.0);
	    	assertEquals(50.0,calculator.average(numbers));
	    }
	    
	    @Test
	    @DisplayName("Minimun deberia ser 10")
	    public void testMinimum() {
	    	List<Double> numbers = Arrays.asList(10.0,560.0,50.0);
	    	assertEquals(10.0,calculator.minimum(numbers));
	    }
	    
	    @Test
	    @DisplayName("Maximum deberia ser 560")
	    public void testMaximum() {
	    	List<Double> numbers = Arrays.asList(10.0,560.0,50.0);
	    	assertEquals(560.0,calculator.maximum(numbers));
	    }
	    
	    @Test
	    @DisplayName("Mandar lista vacia lanza exception")
	    public void testEmptyList() {
	    	List<Double> numbers = List.of();
	    	assertThrows(IllegalArgumentException.class, ()-> {
	        	calculator.maximum(numbers);
	        });
	    	try
	    	{
	    		calculator.maximum(numbers);
	    	}
	    	catch(IllegalArgumentException exception)
	    	{
	    		assertEquals("List cannot be empty or null", exception.getMessage());
	    	}
	    }
}
