package tallerpruebas.test;

import tallerpruebas.Employee;
import tallerpruebas.EmployeeType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    // Escenario: Calcular salario mensual para un trabajador en USD en un mes impar
    @Test
    void testCS_Worker_USD_OddMonth() {
        Employee employee = new Employee(1000, "USD", 0.0f, EmployeeType.Worker);
        float expected = 1000 + (386.0f / 12 * 2); // Salario + décimo
        assertEquals(expected, employee.cs(), 0.01f);
    }

    // Escenario: Calcular salario mensual para un trabajador en USD en un mes par
    @Test
    void testCS_Worker_USD_EvenMonth() {
        Employee employee = new Employee(1000, "USD", 0.0f, EmployeeType.Worker);
        float expected = 1000; // Salario sin décimo
        assertEquals(expected, employee.cs(), 0.01f);
    }

    // Escenario: Calcular salario mensual para un supervisor en otra moneda en un mes impar
    @Test
    void testCS_Supervisor_OtherCurrency_OddMonth() {
        Employee employee = new Employee(2000, "EUR", 0.1f, EmployeeType.Supervisor);
        float salario = 2000 * 0.95f;
        float expected = salario + (0.1f * 0.35f) + (386.0f / 12 * 2); // Salario convertido + bono + décimo
        assertEquals(expected, employee.cs(), 0.01f);
    }

    // Escenario: Calcular salario mensual para un manager en USD en un mes par
    @Test
    void testCS_Manager_USD_EvenMonth() {
        Employee employee = new Employee(3000, "USD", 0.2f, EmployeeType.Manager);
        float expected = 3000 + (0.2f * 0.7f); // Salario + bono
        assertEquals(expected, employee.cs(), 0.01f);
    }

    // Escenario: Calcular bono anual para un trabajador en USD
    @Test
    void testCalculateYearBonus_Worker_USD() {
        Employee employee = new Employee(1000, "USD", 0.0f, EmployeeType.Worker);
        float expected = 386.0f; // RMU completo
        assertEquals(expected, employee.CalculateYearBonus(), 0.01f);
    }

    // Escenario: Calcular bono anual para un supervisor en otra moneda
    @Test
    void testCalculateYearBonus_Supervisor_OtherCurrency() {
        Employee employee = new Employee(2000, "EUR", 0.1f, EmployeeType.Supervisor);
        float salario = 2000 * 0.95f;
        float expected = salario + (386.0f * 0.5f); // Salario convertido + 50% RMU
        assertEquals(expected, employee.CalculateYearBonus(), 0.01f);
    }

    // Escenario: Calcular bono anual para un manager en USD
    @Test
    void testCalculateYearBonus_Manager_USD() {
        Employee employee = new Employee(5000, "USD", 0.3f, EmployeeType.Manager);
        float expected = 5000 + (386.0f * 1.0f); // Salario + RMU completo
        assertEquals(expected, employee.CalculateYearBonus(), 0.01f);
    }
}