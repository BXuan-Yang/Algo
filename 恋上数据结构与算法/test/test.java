//package Nine_集合.com.BXuan.set;
//
//import Nine_集合.com.BXuan.tree.BinaryTree;
//import Nine_集合.com.BXuan.tree.RBTree;
//
//public class TreeSet<E> implements Set<E> {
//    // 运用红黑树进行实现
//    private RBTree<E> tree = new RBTree<>();
//
//    @Override
//    public int size() {
//        return tree.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return tree.isEmpty();
//    }
//
//    @Override
//    public void clear() {
//        tree.clear();
//    }
//
//    @Override
//    public boolean contains(E element) {
//        return tree.contains(element);
//    }
//
//    @Override
//    public void add(E element) {
//        // 红黑树的功能：相同的就覆盖，不相同的就加到左边或者右边的分支
//        tree.add(element);
//    }
//
//    @Override
//    public void remove(E element) {
//        tree.remove(element);
//    }
//
//    @Override
//    public void traversal(final Visitor<E> visitor) {
//        // 中序遍历就是从小到大进行遍历
//        // 树要求传进去的visitor是BinaryTree中的visitor
//        // 遍历的visitor是外面传进去的visitor
//        tree.inorder(new BinaryTree.Visitor<E>() {
//            @Override
//            public boolean visit(E element) {
//                return visitor.visit(element);
//            }
//        });
//    }
//}