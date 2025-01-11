package tallerpruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private static LocalDate currentDate;
	private static Employee workerUSD;
    private static Employee workerEUR;
    private static Employee supervisorUSD;
    private static Employee supervisorEUR;
    private static Employee managerUSD;
    private static Employee managerEUR;


    @BeforeAll
    public static void setup() {
        supervisorUSD = new Employee(2200, "USD", 0.12F, EmployeeType.Supervisor);
        supervisorEUR = new Employee(2200, "EUR", 0.12F, EmployeeType.Supervisor);
    	
    	currentDate = LocalDate.now();
        
        workerUSD = new Employee(1200, "USD", 0, EmployeeType.Worker);
        workerEUR = new Employee(1200, "EUR", 0, EmployeeType.Worker);


        managerUSD = new Employee(3200, "USD", 0.22F, EmployeeType.Manager);
        managerEUR = new Employee(3200, "EUR", 0.22F, EmployeeType.Manager);
    }
    
    
    
    
    // Casos de prueba para cs()
    
    @Test
    public void testManagerEUREvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = (float) (3200 * 0.95) + (0.22F * 0.7F);
        assertEquals(expected, managerEUR.cs(), 0.01);
    }
    
    @Test
    public void testWorkerEUROddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = (float) (1200 * 0.95) + (386.0F / 12 * 2);
        assertEquals(expected, workerEUR.cs(), 0.01);
    }
    
    
    @Test
    public void testWorkerUSDEvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = 1200;
        assertEquals(expected, workerUSD.cs(), 0.01);
    }

    

    @Test
    public void testSupervisorUSDEvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0);
        float expected = 2200 + (0.12F * 0.35F);
        assertEquals(expected, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorUSDOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = 2200 + (0.12F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expected, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorEUREvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = (float) (2200 * 0.95) + (0.12F * 0.35F);
        assertEquals(expected, supervisorEUR.cs(), 0.01);
    }

    @Test
    public void testSupervisorEUROddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = (float) (2200 * 0.95) + (0.12F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expected, supervisorEUR.cs(), 0.01);
    }

    

    @Test
    public void testManagerUSDOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = 3200 + (0.22F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expected, managerUSD.cs(), 0.01);
    }


    @Test
    public void testManagerEUROddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0);
        float expected = (float) (3200 * 0.95) + (0.22F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expected, managerEUR.cs(), 0.01);
    }
    
    @Test
    public void testWorkerUSDOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = 1200 + (386.0F / 12 * 2);
        assertEquals(expected, workerUSD.cs(), 0.01);
    }
    
    @Test
    public void testManagerUSDEvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = 3200 + (0.22F * 0.7F);
        assertEquals(expected, managerUSD.cs(), 0.01);
    }

      
    
}

