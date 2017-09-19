package ofo;

import java.util.*;

/**
 * Created by Xingfeng on 2017-09-14.
 */
public class Test4 {

    static class Department {

        int id;
        String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            handle(line);


        }

    }

    private static void handle(String line) {

        String[] array = line.split(";");
        if (array.length < 3) {
            System.out.println("incorrect data");
            return;
        }

        boolean error = false;

        Map<Integer, List<Department>> maps = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            String[] data = array[i].split(",");
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int parendId = Integer.parseInt(data[2]);

            List<Department> departments = maps.get(id);
            if (departments == null) {
                departments = new ArrayList<>();
                maps.put(id, departments);
            }

            Department department = new Department(parendId, name);
            departments.add(department);

        }

        List<Department> root = maps.get(0);
        if (root == null || root.size() != 1) {
            System.out.println("incorrect data");
            return;
        }

        String result="";
       getString(0, 0, maps,result);


    }

    private static void getString(int parentId, int index, Map<Integer, List<Department>> maps,String result) {


        List<Department> departments = maps.get(parentId);







    }


}
