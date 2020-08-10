package com.dmlab.bst;

public class BinarySearchTree<Key extends Comparable<? super Key>, E> {

    /**
     * root of this tree
     */
    private BinaryNode<Key, E> root;
    private int nodeCount = 0;

    // Declare more variables HERE

    /**
     * Constructor
     * Do not modify this function.
     */
    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * This function returns the root of the BST.
     * Do not modify this function.
     *
     * @return root of the BinarySearchTree
     */
    public BinaryNode<Key, E> getRoot() {
        return root;
    }

    /**
     * Reinitialize tree
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Insert an item into the tree.
     *
     * @param key   of the item
     * @param value of the item
     */
    public void insert(Key key, E value) {
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        root = insertHelp(root, key, value);
        nodeCount++;
    }

    /**
     * Insert the item <key,value> into the tree rt.
     *
     * @param rt    of the tree.
     * @param key   of the item to be inserted.
     * @param value of the item to be inserted.
     * @return the tree after insertion
     */
    private BinaryNode<Key, E> insertHelp(BinaryNode<Key, E> rt, Key key, E value) {
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        if(rt == null) return new BinaryNode<Key, E>(key, value);
        if(rt.getKey().compareTo(key) > 0)
        {
            rt.setLeft(insertHelp(rt.getLeft(), key, value));
        }
        else rt.setRight(insertHelp(rt.getRight(), key, value));
        rt.increaseSize();
        return rt;
    }

    /**
     * Remove an item from the tree.
     *
     * @param key of the item to be removed.
     * @return the value of the removed item. If no such item, return null.
     */
    public E remove(Key key) { // key가 없을 땐 사이즈 디크리즈 하면 안돼
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        E temp = find(key);
        if(temp != null)
        {
            root = removeHelp(root, key);
            nodeCount--;
        }
        return temp;
    }

    /**
     * Remove a node with given key from the tree rt.
     *
     * @param rt  of the tree.
     * @param key of the item to be removed.
     * @return the tree after removing.
     */
    private BinaryNode<Key, E> removeHelp(BinaryNode<Key, E> rt, Key key) { // findMin 함수 하고 나서
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        //return null;
        if(rt == null) return null;
        if(rt.getKey().compareTo(key) > 0)
        {
            rt.setLeft(removeHelp(rt.getLeft(), key));
        }
        else if(rt.getKey().compareTo(key) < 0)
        {
            rt.setRight(removeHelp(rt.getRight(), key));
        }
        else
        {
            if(rt.getLeft() == null)    return rt.getRight();
            else if(rt.getRight() == null)  return rt.getLeft();
            else
            {
                BinaryNode<Key, E> temp = getMin(rt.getRight());
                rt.setValue(temp.getValue());
                rt.setKey(temp.getKey());
                rt.setRight(deleteMin(rt.getRight()));
                rt.getRight().decreaseSize();
            }
        }
        rt.decreaseSize();
        return rt;
    }

    /**
     * Given a tree rt, get its smallest node.
     * The smallest node is the node with the minimum key.
     *
     * @param rt
     * @return the smallest node.
     */
    private BinaryNode<Key, E> getMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        //return null;
        if(rt.getLeft() == null)
        {
            return rt;
        }
        else
        {
            return getMin(rt.getLeft());
        }
    }

    /**
     * Given a tree rt, delete the smallest node and return this tree.
     *
     * @param rt is the root of the tree
     * @return the tree after deletion.
     */
    private BinaryNode<Key, E> deleteMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        if(rt.getLeft() == null) return rt.getRight();
        else
        {
            rt.setLeft(deleteMin(rt.getLeft()));
            return rt;
        }
    }


    /**
     * Find the item with given key.
     *
     * @param key of the item
     * @return the value if the item. If no such item, return null.
     * Do not modify this function.
     */
    public E find(Key key) {
        return findHelp(root, key);
    }

    /**
     * @return The number of nodes in the tree.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * Find the item with given key in the tree rt.
     *
     * @param rt  is the root of the tree.
     * @param key is the key that we want to find in tree rt.
     * @return the value of the wanted item. If no such item, return null.
     */
    private E findHelp(BinaryNode<Key, E> rt, Key key) {//key가 없을때 문구출력해야하나?
        // TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        if(rt==null) return null;
        if(rt.getKey().compareTo(key) > 0)
        {
            return findHelp(rt.getLeft(), key);
        }
        else if(rt.getKey().compareTo(key) == 0)
        {
            return rt.getValue();
        }
        else return findHelp(rt.getRight(), key);
    }

    /**
     * Prints all keys in the tree in ascending order.
     * Do not modify this function.
     */
    public void printBookList() {
        printBookListHelper(root);
    }

    /**
     * Prints all keys in the tree with given root using inorder traversal.
     *
     * @param rt is the root of the tree. This param is used for the recursion.
     */
    public void printBookListHelper(BinaryNode<Key, E> rt) { //inorder 이용
        ///TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        if(rt == null) return;
        if(rt.getLeft() != null)    printBookListHelper(rt.getLeft());
        System.out.println("BOOK:   " + rt.getKey());
        if(rt.getRight() != null)   printBookListHelper(rt.getRight());
    }

    /**
     * Given the order of the item, find the key of the corresponding item.
     *
     * @param order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    public Key orderSearch(int order) {
        ///TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        return orderSearchHelper(root, order);
    }

    /**
     * Given the order of the item and rt of the tree,
     * find the key of the corresponding item in the tree.
     *
     * @param rt    is the root of the tree.
     * @param order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    private Key orderSearchHelper(BinaryNode<Key, E> rt, int order) {
        ///TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        if(rt == null)  return null;
        int size = 0;
        if(rt.getLeft() == null)
        {
            if(order == 1)  return rt.getKey();
            size = 0;
        }
        else
        {
            size = rt.getLeft().getSize();
        }
        if(size + 1 == order)
        {
            return rt.getKey();
        }
        else if(size + 1 > order)
        {
            return orderSearchHelper(rt.getLeft(), order);
        }
        else if(size + 1 < order)
        {
            return orderSearchHelper(rt.getRight(), order-size-1);
        }
        return null;
    }

    /**
     * Given the key of the item, find the order of the item.
     *
     * @param key of the item
     * @return the order of the item. If no such item, return 0.
     */

    public int orderSearch(Key key) {
        ///TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        int count = 0;
        if(root == null)    return 0;
        if(find(key) == null)
        {
            return 0;
        }
        return orderSearchHelper(root, key, count);
    }

    /**
     * Given the key of the item and the root of the tree,
     * find the order of the item in the tree.
     *
     * @param rt    of the tree
     * @param key   of the item
     * @param count is the number of small items found before.
     * @return the order of the item. If no such item, return 0.
     */
    private int orderSearchHelper(BinaryNode<Key, E> rt, Key key, int count) {
        ///TODO: Fill in this function
        //System.out.println("TODO: Fill in this function");
        int size = 0;
        if(rt.getLeft() == null)
        {
            if(rt.getKey().compareTo(key) == 0)     return 1;
            size = 0;
        }
        else
        {
            size = rt.getLeft().getSize();
        }
        if(rt.getKey().compareTo(key) == 0)
        {
            size = size + 1;
        }
        else if(rt.getKey().compareTo(key) > 0)
        {
            size = orderSearchHelper(rt.getLeft(), key, count);
        }
        else if(rt.getKey().compareTo(key) < 0)
        {
            size = size + 1 + orderSearchHelper(rt.getRight(), key, count);
        }
        return size;
    }
    // Implement more functions HERE
}
