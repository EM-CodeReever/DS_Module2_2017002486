//Name: Elliot Morrison
//ID: 2017002486
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);
        BSTree tree = new BSTree();
        try {
            while (continueLoop) {
                System.out.println("=========== BSTree Picture Scenario Menu ============");
                System.out.println("1. \tAdd a picture to the album");
                System.out.println("2. \tDelete a picture from the album");
                System.out.println("3. \tDisplay all pictures in the album with size above or equal to 20");
                System.out.println("4. \tDisplay average picture size in the album");
                System.out.println("5. \tSearch for a picture by ID");
                System.out.println("6. \tExit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter picture ID: ");
                        int pictureId = Integer.parseInt(input.next());
                        System.out.print("Enter picture name: ");
                        String pictureName = input.next();
                        System.out.print("Enter album name: ");
                        String albumName = input.next();
                        System.out.print("Enter picture size: ");
                        float pictureSize = input.nextFloat();
                        if (tree.checkIfIDExists(pictureId)) {
                            System.out.println("Picture ID already exists");
                            break;
                        }
                        Picture picture = new Picture(pictureId, pictureName, albumName, pictureSize);
                        tree.insertNode(new Node(picture));
                        break;
                    case 2:
                        System.out.print("Enter picture name to delete: ");
                        String pictureNameToDelete = input.next();
                        tree.deleteFromTree(pictureNameToDelete);
                        break;
                    case 3:
                        tree.postOrderTraversalOver20(tree.getRoot());
                        break;
                    case 4:
                        tree.getAveragePictureSize();
                        break;
                    case 5:
                        System.out.print("Enter picture ID to search: ");
                        int pID = Integer.parseInt(input.next());
                        tree.searchNode(pID);
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
