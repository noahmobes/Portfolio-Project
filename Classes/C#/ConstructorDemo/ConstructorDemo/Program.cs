using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConstructorDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Student myStudent = new Student("S001", "John", "Smith");

            Console.WriteLine("Student Number: {0}", myStudent.StudentNumber);
            Console.WriteLine("First Name: {0}", myStudent.FirstName);
            Console.WriteLine("Last Namer: {0}", myStudent.LastName);
            Console.WriteLine("Student Major: {0}", myStudent.Major);
        }
    }
}
