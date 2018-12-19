package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * класс телефонный справочник
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getAllInfo().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersons() {
        return this.persons;
    }
}
