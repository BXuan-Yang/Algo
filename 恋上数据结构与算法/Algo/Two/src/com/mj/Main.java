package com.mj;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{11, 22, 33};
        // 所有的类，都继承java.lang.object
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(21,"BXuan"));
        persons.add(new Person(22,"YBXuan"));
        persons.add(new Person(23,"YYBXuan"));
        persons.clear();
        // 通知JVM进行垃圾回收
        System.gc();
        System.out.println(persons);

        // 自己创建的ArrayList
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(99);
//        arrayList.add(88);
//        arrayList.add(77);
//        System.out.println(arrayList.toString());
//        arrayList.add(3,23);
//        arrayList.set(0,0);
//        System.out.println(arrayList.toString());
    }
}
