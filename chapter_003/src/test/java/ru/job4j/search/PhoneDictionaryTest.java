package ru.job4j.search;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {
    /**
     * find Petr test
     */
    @Test
    public void whenFindByNamePetr() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "BryanskTown"));
        phones.add(new Person("Alexandro", "Chashkov", "705453", "OrenburgTown"));
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * find Alexandro test
     */
    @Test
    public void whenFindByNameAlexandro() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "BryanskTown"));
        phones.add(new Person("Alexandro", "Chashkov", "705453", "OrenburgTown"));
        List<Person> persons = phones.find("Alexandro");
        assertThat(persons.iterator().next().getAddress(), is("OrenTown"));
    }

    /**
     * find town address test
     */
    @Test
    public void whenFindByAddressTown() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "BryanskTown"));
        phones.add(new Person("Alexandro", "Chashkov", "705453", "OrenburgTown"));
        List<Person> persons = phones.find("Town");
        assertTrue(CollectionUtils.isEqualCollection(persons, phones.getPersons()));
    }
}