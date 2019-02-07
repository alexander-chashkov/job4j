package ru.job4j.departmentsort;

import java.util.*;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.03
 *  @author Chashkov Alexander
 */
public class SorterDepartment  {
    private Department departments;

    public SorterDepartment() {
        this.departments = new Department("root");
    }

    /**
     * результат сортировки.
     */
    private String res = "";

    /**
     * @param keys ключ
     * @return подразделение в иерархиии
     */
    public Map<String, Department> getDepartmentOnLvlKey(String[] keys) {
        Map<String, Department> tmp = this.departments.getChildDps();
        for (int i = 0; i < keys.length; i++) {
            Department dp = tmp.get(keys[i]);
            tmp = dp != null ? dp.getChildDps() : null;
        }
        return tmp;
    }

    /**
     * Добавляет подразделение
     * @param nameDep название подразделения
     */
    public void addDepartment(String nameDep) {
        int idx = 0;
        String[] keys =  nameDep.split("\\\\");
        for (String tmpName : keys) {
            String[] keysTemp = Arrays.copyOf(keys, idx + 1);
            if (this.getDepartmentOnLvlKey(keysTemp) == null) {
                Department dp = new Department(tmpName);
                String[] keysTempNew = Arrays.copyOf(keys, idx);
                this.getDepartmentOnLvlKey(keysTempNew).put(tmpName, dp);
            }
            idx++;
        }

    }

    /**
     * @return подразделения
     */
    public Department getDepartments() {
        return this.departments;
    }

    /**
     * @return результат сортировки
     */
    public String getResult() {
         return this.res;
    }

    /**
     * @param t  подразделение в иерархии
     * @param st  tmp string
     *  создает результат сортировки по возрастанию
     */
    public void showElements(Map<String, Department> t, String st) {
        for (String str : t.keySet()) {
            this.res = this.res + (st.length() == 0 ? str : st + "\\" + str) + System.lineSeparator();
            String strTemp = st.length() == 0 ? str : st + "\\" + str;
            showElements(t.get(str).getChildDps(), strTemp);
        }
    }

    /**
     * @param t  подразделение в иерархии
     *  создает результат сортировки по возрастанию
     */
    public void showElementsVer2(Map<String, Department> t) {
        for (String str : t.keySet()) {
            this.res = str + System.lineSeparator();

        }
    }
    /**
     * @param t  подразделение в иерархии
     * @param st  tmp string
     * desc
     * создает результат сортировки по убыванию
     */
    public void showElementsDesc(Map<String, Department> t, String st) {
        List<String> l = new ArrayList(t.keySet());
        Collections.reverse(l);
        for (String str : l) {
            this.res = this.res + (st.length() == 0 ? str : st + "\\" + str) + System.lineSeparator();
            String strTemp = st.length() == 0 ? str : st + "\\" + str;
            showElementsDesc(t.get(str).getChildDps(), strTemp);
        }
    }

    /**
     * очищает результаты сортировки
     */
    public void clearResult() {
        this.res = "";
    }
}

