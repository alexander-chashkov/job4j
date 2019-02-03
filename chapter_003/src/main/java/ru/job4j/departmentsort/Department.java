package ru.job4j.departmentsort;

import java.util.*;
/**
 *  @version 0.0.0.1
 *  @since 2019.02.03
 *  @author Chashkov Alexander
 *  Подразделение
 */
public class Department {
    private String name;
    private Map<String, Department> dps;
    public Department(String name) {
        this.name = name;
        this.dps = new HashMap<>();
    }

    @Override
    public String toString() {
        String res = "Department{name=" + this.name + "}";
        return res;

    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    public Map<String, Department> getChildDps() {
        return this.dps;
    }
}
