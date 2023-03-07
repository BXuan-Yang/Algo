package com.mj;

/**
 * 动态数组
 */
public class ArrayList<E> {
    // 元素的数量
    private int size;
    // 存放所有的元素
    private E[] elements;
    // 指定默认的开辟数组的大小
    private static final int DEFAULT_CAPACITY = 2;
    // 指定找不到元素的时候返回-1
    private static final int ELEMENT_NOT_FOUND = -1;
    // 有参构造函数
    private ArrayList(int capaticy){
        // 需要进行判断
        capaticy = Math.max(capaticy, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capaticy];
    }
    // 无参构造函数
    ArrayList(){
        // 无参的构造函数去调用有参数的构造函数
        this(DEFAULT_CAPACITY);
    }
    /**
     * 清除所有的元素
     */
    public void clear(){
        // 将地址与对象之间的线断开，数组还存在，但是指向的对象不存在
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 元素的数量
     * @return 返回元素的数量
     */
    public int size(){
        return size;
    }

    /**
     * 判断是否为空
     * @return 返回是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 查看链表是否包含该元素
     * @param element 元素
     * @return 是否包含
     */
    public boolean contains(E element){
//        for (int i = 0; i < size; i++) {
//            if (elements[i] == element){
//                return true;
//            }
//        }
//        return false;
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素
     * @param element 添加的元素值
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 得到某个位置上的元素
     * @param index 位置
     * @return 位置上的元素值
     */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位的新元素
     * @param index 位置
     * @param element 新元素的值
     * @return 原来的元素
     */
    public E set(int index, E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 往index位置添加新的元素
     * 需要从后面往前面挪
     * @param index 位置
     * @param element 需要添加的元素值
     */
    public void add(int index, E element){
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size-1; i > index; i--){
            elements[i] = elements[i - 1];
        }
        size++;
        elements[index] = element;
    }

    /**
     * 移除index位置的元素
     * @param index 位置
     * @return 被移除的元素值
     */
    public E remove(int index){
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++){
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     * @param element 需要查看索引的元素
     * @return 索引
     */
    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)){
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        // 字符串拼接建议用StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0){
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
            // 下面这里会进行减法运算，增加运算成本
//            if (i != size-1){
//                stringBuilder.append(",");
//            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    // 封装数组越界函数
    private void outOffBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }
    // 封装数组长度检查函数
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOffBounds(index);
        }
    }
    // 封装数组长度检查函数（添加特殊）
    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOffBounds(index);
        }
    }

    /**
     * 保证要有newSize的容量
     * @param newSize 新的容量
     */
    private void ensureCapacity(int newSize){
        int oldSize = elements.length;
        if (oldSize >= newSize){
            return;
        }else {
            // >> 1 相当于除以2
            int newCapacity = oldSize + (oldSize >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] =  elements[i];
            }
            elements = newElements;
            System.out.println("进行扩容操作！");
            System.out.println("旧容量：" + oldSize + ",新容量：" + newCapacity);
        }
    }
}
