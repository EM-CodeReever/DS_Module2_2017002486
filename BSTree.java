//Name: Elliot Morrison
//ID: 2017002486
public class BSTree {
    private Node root;

    public BSTree() {
        root = null;
    }

    public BSTree(Node root) {
        this.root = root;
    }

    public BSTree(BSTree t) {
        root = t.root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insertNode(Node n){
        Node temp = new Node(n);
        if (temp == null) {
            throw new NullPointerException("Node is null");
        }
        if(root == null){
            root = n;
            System.out.println("Root node created");
        }else{
            Node tempRoot = root;
            while(true){
                if(n.getPicture().getPictureSize() < tempRoot.getPicture().getPictureSize()){
                    if(tempRoot.getLeftSubTree() == null){
                        tempRoot.setLeftSubTree(n);
                        System.out.println("Node inserted left");
                        return;
                    }
                    tempRoot = tempRoot.getLeftSubTree();
                }else{
                    if(tempRoot.getRightSubTree() == null){
                        tempRoot.setRightSubTree(n);
                        System.out.println("Node inserted right");
                        return;
                    }
                    tempRoot = tempRoot.getRightSubTree();
                }
            }
        }
    }


    public float preOrderTraversalToFindTotalPictureSize(Node n){ // returns the total size of all pictures in the tree
        float pictureSize = 0;
        if(n != null){
            pictureSize += n.getPicture().getPictureSize();
            pictureSize += preOrderTraversalToFindTotalPictureSize(n.getLeftSubTree());
            pictureSize += preOrderTraversalToFindTotalPictureSize(n.getRightSubTree());
        }
        return pictureSize;
    }

    public int preOrderTraversalToFindTotalNumberOfPictures(Node n){ // returns the total number of pictures in the tree
        int numberOfPictures = 0;
        if(n != null){
            numberOfPictures++;
            numberOfPictures += preOrderTraversalToFindTotalNumberOfPictures(n.getLeftSubTree());
            numberOfPictures += preOrderTraversalToFindTotalNumberOfPictures(n.getRightSubTree());
        }
        return numberOfPictures;
    }

    public void postOrderTraversalOver20(Node n){
        if(n != null){
            postOrderTraversalOver20(n.getLeftSubTree());
            postOrderTraversalOver20(n.getRightSubTree());
            if (n.getPicture().getPictureSize() >= 20){
                System.out.println(n + "\n ==> \n");
            }
        }
    }


    public void searchNode(Integer pictureId){
        Node temp = root;
        int count = 0;
        while(temp != null){
            if(temp.getPicture().getPictureId() == pictureId){
                System.out.println("Node found after "+ count + " iterations\n ==>" + temp);
                return;
            }else if(temp.getPicture().getPictureId() > pictureId){
                temp = temp.getLeftSubTree();
            }else{
                temp = temp.getRightSubTree();
            }
            count++;
        }
        throw new NullPointerException("Node not found");
    }

    public Node getSuccessor(Node n){ // gets the successor of the node to aid in deletion
        Node successor = null;
        Node successorParent = null;
        Node current = n.getRightSubTree();
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftSubTree();
        }
        if(successor != n.getRightSubTree()){
            successorParent.setLeftSubTree(successor.getRightSubTree());
            successor.setRightSubTree(n.getRightSubTree());
        }
        return successor;
    }

    public void deleteFromTree(String pictureName) {
        Node temp = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (!temp.getPicture().getPictureName().equals(pictureName)) {
            parent = temp;
            if (temp.getPicture().getPictureName().compareTo(pictureName) > 0) {
                isLeftChild = true;
                temp = temp.getLeftSubTree();
            } else {
                isLeftChild = false;
                temp = temp.getRightSubTree();
            }
            if (temp == null) {
                throw new IllegalArgumentException("Node not found");
            }
        }
        if (temp.getLeftSubTree() == null && temp.getRightSubTree() == null) {
            if (temp == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.setLeftSubTree(null);
            } else {
                parent.setRightSubTree(null);
            }
        } else if (temp.getRightSubTree() == null) {
            if (temp == root) {
                root = temp.getLeftSubTree();
            } else if (isLeftChild) {
                parent.setLeftSubTree(temp.getLeftSubTree());
            } else {
                parent.setRightSubTree(temp.getLeftSubTree());
            }
        } else if (temp.getLeftSubTree() == null) {
            if (temp == root) {
                root = temp.getRightSubTree();
            } else if (isLeftChild) {
                parent.setLeftSubTree(temp.getRightSubTree());
            } else {
                parent.setRightSubTree(temp.getRightSubTree());
            }
        } else if (temp.getLeftSubTree() != null && temp.getRightSubTree() != null) {
            Node successor = getSuccessor(temp);
            if (temp == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftSubTree(successor);
            } else {
                parent.setRightSubTree(successor);
            }
            successor.setLeftSubTree(temp.getLeftSubTree());
        }
        System.out.println("Node deleted");
    }

    public void getAveragePictureSize(){
        if (root == null){
            throw new IllegalArgumentException("Tree is empty");
        }else{
            float totalSize = preOrderTraversalToFindTotalPictureSize(root);
            int count = preOrderTraversalToFindTotalNumberOfPictures(root);
            System.out.println("Average picture size is: " + totalSize/count);
        }
    }
    public boolean checkIfIDExists(Integer pictureId){
        Node temp = root;
        while(temp != null){
            if(temp.getPicture().getPictureId() == pictureId){
                return true;
            }else if(temp.getPicture().getPictureId() > pictureId){
                temp = temp.getLeftSubTree();
            }else{
                temp = temp.getRightSubTree();
            }
        }
        return false;
    }

}
