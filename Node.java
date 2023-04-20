//Name: Elliot Morrison
//ID: 2017002486
public class Node {
    private Picture picture;
    private Node leftSubTree;
    private Node rightSubTree;

    public Node() {
        picture = null;
        leftSubTree = null;
        rightSubTree = null;
    }

    public Node(Picture picture) {
        this.picture = picture;
        leftSubTree = null;
        rightSubTree = null;
    }

    public Node(Node n) {
        picture = n.picture;
        leftSubTree = n.leftSubTree;
        rightSubTree = n.rightSubTree;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Node getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(Node leftChild) {
        this.leftSubTree = leftChild;
    }

    public Node getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(Node rightChild) {
        this.rightSubTree = rightChild;
    }

    @Override
    public String toString() {
        return "NODE:" +
                "\n\tData = " + picture +
                "\n\tleftSubTree = " + leftSubTree +
                "\n\trightSubTree = " + rightSubTree;
    }
}
