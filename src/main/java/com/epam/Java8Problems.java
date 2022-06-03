package com.epam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Problems {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList( new Person("SACHIN TENDULKAR", 40, "MALE",
                        Arrays.asList(new Address("a20", "Hyderabad", "503001"),
                        new Address("a21", "Delhi", "503002"))),
                new Person("MS DHONI", 36, "MALE",
                        Arrays.asList(new Address("a22", "Mumbai", "50300"),
                        new Address("a23", "Meerut", "503001"))),
                new Person("SURESH RAINA", 32, "MALE",
                        Arrays.asList(new Address("a24", "Ghaziabad", "503001"),
                        new Address("a25", "Gurgaon", "503001"))),
                new Person("SACHIN JHOSHI", 24, "MALE",
                        Arrays.asList(new Address("a26", "Bangalore", "503001"),
                        new Address("a27", "Hyderabad", "503001"))),
                new Person("MANUJ Sangwan", 40, "MALE",
                        Arrays.asList(new Address("a28", "Meerut", "503001"),
                        new Address("a29", "Delhi", "503001"))));
        // List of Persons given, output the array with all persons whose name contain "SACHIN" or
        // whose address in city "Delhi" - Using Java 8 FP or Streams API
        // Example : Person 1: {"SACHIN TENDULKAR", 40, "MALE", { {"a10", "Banglore", 410014}}, {"a11", "Mumbai", 310010}} Person 2: {"MS DHONI", 36, "MALE", { {"a20", "Hyderabad", 503001 }}, {"a21", "Mumbai", 310010}} Person 3: {"SURESH RAINA", 32, "MALE", { {"a30", "Delhi", 110015}}, {"a31", "Chennai", 510010}} Person 4: {"SACHIN JHOSHI", 24, "MALE", { {"a10", "Banglore", 410014}}, {"a11", "Mumbai", 310010}} Output: List with Person 1 , Person 3 and Person 4

        List<Person> resultList = personList.stream().
                filter(person->(person.getName().contains("SACHIN")) ||
                        person.getAddresses().stream().anyMatch(address -> address.getCity().equals("Delhi")))
                .collect(Collectors.toList());
        System.out.println(resultList);

    }
}
