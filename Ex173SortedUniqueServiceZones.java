/*
Sorted Unique Service Zones   [Build from Scratch | Advanced]
Use TreeSet for unique numeric zone IDs that must be displayed sorted. Compare with HashSet behavior using 
the same values.
Done when: Both uniqueness and ordering expectations are accurately described.
*/

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex173SortedUniqueServiceZones {
    public static void main(String[] args) {
        int[] zoneId = { 301, 137, 216, 173, 918 };

        Set<Integer> hashZones = new HashSet<>();
        Set<Integer> sortedZones = new TreeSet<>();

        for (int id : zoneId) {
            hashZones.add(id);
            sortedZones.add(id);
        }
        
        System.out.println("Hash Set (uniqueness only, no guarenteed order): " + hashZones);
        System.out.println("Tree Set (unique and naturally sorted): " + sortedZones);
    }
}
