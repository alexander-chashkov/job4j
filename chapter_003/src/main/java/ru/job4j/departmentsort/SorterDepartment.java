package ru.job4j.departmentsort;

import java.util.*;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.03
 *  @author Chashkov Alexander
 */
public class SorterDepartment  {
    private Set<Department> depsSet;

    public SorterDepartment() {
        this.depsSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    public void addDepartment(String dep) {
        String[] keys = dep.split("\\\\");
        StringBuilder strKey =  new StringBuilder();
        for (String tmpName : keys) {
            strKey.append(tmpName);
            this.depsSet.add(new Department(strKey.toString()));
            strKey.append("\\");
        }
    }

    public String getAscDeps() {
        StringBuilder res = new StringBuilder();
        for (Department dep : this.depsSet) {
            res.append(dep.toString() + System.lineSeparator());
        }
        return res.toString();
    }

    public String getDescDeps() {
        StringBuilder res = new StringBuilder();
        Set<Department> temp = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        temp.addAll(this.depsSet);
        for (Department dep : this.depsSet) {
            res.append(dep.toString() + System.lineSeparator());
        }
        return res.toString();
    }
}

