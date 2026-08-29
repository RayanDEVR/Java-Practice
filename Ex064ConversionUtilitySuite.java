/*
Conversion Utility Suite   [Build from Scratch | Intermediate]
Create overloaded or separately named methods for Celsius/Fahrenheit, kilometers/miles and 
kilograms/pounds. Choose overloading only when the call remains understandable.
Done when: Round-trip tests and negative/zero cases are recorded. 
*/

class UnitConvertion {
    public void celsiusToFahrenheit(double celsius) {
        System.out.println("The Fahrenheit Value: " + (9 / 5 * celsius) + 32); 
    }

    public void fahrenheitToCelsius(double fahrenheit) {
        System.out.println("The Celsious Value: " + ((fahrenheit - 32) / 9) * 5);
    }
    
    public void kilometersToMiles(double km) {
        System.out.println("The Miles Value: " + km * 0.62137119);
    }

    public void milesToKilometers(double miles) {
        System.out.println("The KM Value: " + miles / 0.62137119); 
    }
    
    public void kilogramsToPounds(double kg) {
        System.out.println("The Pounds Value: " + kg * 2.20462262); 
    }

    public void poundsToKilograms(double pounds) {
        System.out.println("The KG Value: " + pounds / 2.20462262);
    }
}

public class Ex64conversionUtilitySuite {
    public static void main(String[] args) {
        UnitConvertion unit = new UnitConvertion();

        unit.celsiusToFahrenheit(40);
        unit.fahrenheitToCelsius(100);
        unit.kilometersToMiles(2);
        unit.milesToKilometers(3);
        unit.kilogramsToPounds(3);
        unit.poundsToKilograms(100);
    }
}
