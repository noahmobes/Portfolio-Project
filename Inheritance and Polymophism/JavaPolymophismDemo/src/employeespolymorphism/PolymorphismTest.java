package employeespolymorphism;

import java.util.ArrayList;
import java.util.List;

/** PolymorphismTest.java
*  Assigning superclass and subclass references to superclass and
*  subclass variables.
 *  */

public class PolymorphismTest  
{
   public static void main(String[] args) 
   {
      //Create a list of employee objects
      List<Employee> emp = new ArrayList<>();

      // CommissionEmployee
      CommissionEmployee commissionEmployee = new CommissionEmployee(
              "Sue", "Jones", "222-22-2222", 10000, .06);
      emp.add(commissionEmployee);

      // BasePlusCommissionEmployee
      BasePlusCommissionEmployee basePlusCommissionEmployee =
              new BasePlusCommissionEmployee(
                      "Bob", "Lewis", "333-33-3333", 5000, .04, 300);
      emp.add(basePlusCommissionEmployee);

      //SalariedEmployee
      SalariedEmployee salaryEmployee = new SalariedEmployee("Bob", "White", "555-55-5555", 1200.00 );
      emp.add(salaryEmployee);

      // invoke toString on subclass object using superclass variable
      System.out.println("Call subclass's toString() methods with superclass reference");
      System.out.println("Call subclass’s  toString with superclass reference");
      for(Employee e : emp)
      {
         System.out.println(e.toString());
      }


   } // end main
} // end class PolymorphismTest


