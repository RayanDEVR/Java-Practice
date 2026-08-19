/*
Temperature Converter   [Build from Scratch | Beginner]
Convert Celsius to Fahrenheit and back using correctly typed expressions. Keep both formulas in one program 
with labeled output.
Done when: Round-trip test values include 0, 100 and a negative temperature; formulas do not lose fractions.
 */

class Temperature
{
    public void celsiousToFahrenheit(double C)
    {
        System.out.println(((C*9)/5)+32);
    }

    public void fahrenheitToCelsious(double F)
    {
        System.out.println(((F-32)*5)/9);
    }
}

public class Ex28temperatureConverter
{
    public static void main(String[] args) {
        Temperature t = new Temperature();
        t.celsiousToFahrenheit(40);
        t.fahrenheitToCelsious(-40);
    }
}