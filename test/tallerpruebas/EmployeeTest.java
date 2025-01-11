package tallerpruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private static LocalDate currentDate;
	private static Employee workerUSD;
    private static Employee workerCAD;
    private static Employee supervisorUSD;
    private static Employee supervisorCAD;
    private static Employee managerUSD;
    private static Employee managerCAD;


    @BeforeAll
    public static void setup() {
        supervisorUSD = new Employee(2200, "USD", 0.12F, EmployeeType.Supervisor);
        supervisorCAD = new Employee(2200, "CAD", 0.12F, EmployeeType.Supervisor);
    	
    	currentDate = LocalDate.now();
        
        workerUSD = new Employee(1200, "USD", 0, EmployeeType.Worker);
        workerCAD = new Employee(1200, "CAD", 0, EmployeeType.Worker);


        managerUSD = new Employee(3200, "USD", 0.22F, EmployeeType.Manager);
        managerCAD = new Employee(3200, "CAD", 0.22F, EmployeeType.Manager);
    }
    
    // Casos de prueba para cs()
    
    @Test
    public void testManagerCADEvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = (float) (3200 * 0.95) + (0.22F * 0.7F);
        assertEquals(expected, managerCAD.cs(), 0.01);
    }
    
    @Test
    public void testWorkerCADOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = (float) (1200 * 0.95) + (386.0F / 12 * 2);
        assertEquals(expected, workerCAD.cs(), 0.01);
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
    public void testSupervisorCADEvenMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expected = (float) (2200 * 0.95) + (0.12F * 0.35F);
        assertEquals(expected, supervisorCAD.cs(), 0.01);
    }

    @Test
    public void testSupervisorCADOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = (float) (2200 * 0.95) + (0.12F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expected, supervisorCAD.cs(), 0.01);
    }

    

    @Test
    public void testManagerUSDOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expected = 3200 + (0.22F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expected, managerUSD.cs(), 0.01);
    }


    @Test
    public void testManagerCADOddMonth() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0);
        float expected = (float) (3200 * 0.95) + (0.22F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expected, managerCAD.cs(), 0.01);
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

    // Casos de prueba para CalculateYearBonus()
    @Test
    public void testYearBonusManagerUSD() {
        float expectedBonus = 3200 + 386.0F;
        assertEquals(expectedBonus, managerUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testYearBonusWorkerUSD() {
        float expectedBonus = 386.0F;
        assertEquals(expectedBonus, workerUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testYearBonusManagerCAD() {
        float expectedBonus = (float) (3200 * 0.95) + 386.0F;
        assertEquals(expectedBonus, managerCAD.CalculateYearBonus(), 0.01);
    }
    
    @Test
    public void testYearBonusSupervisorUSD() {
        float expectedBonus = 2200 + 386.0F * 0.5F;
        assertEquals(expectedBonus, supervisorUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testYearBonusWorkerCAD() {
        float expectedBonus = 386.0F;
        assertEquals(expectedBonus, workerCAD.CalculateYearBonus(), 0.01);
    }    
    
}

