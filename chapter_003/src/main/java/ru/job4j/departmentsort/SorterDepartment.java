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
                int len1 = o1.toString().length();
                int len2 = o2.toString().length();
                int lim = Math.min(len1, len2);
                char[] v1 = o1.toString().toCharArray();
                char[] v2 = o2.toString().toCharArray();

                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (c1 != c2) {
                        return (c1 - c2) * -1;
                    }
                    k++;
                }
                return len1 - len2;
            }
        });
        temp.addAll(this.depsSet);
        for (Department dep : temp) {
            res.append(dep.toString() + System.lineSeparator());
        }
        return res.toString();
    }
}

