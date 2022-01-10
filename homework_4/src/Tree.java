/**
 * This class has a reference to the tree and is able to add
 * a node to the tree, traverse through the tree and begin the
 * question and answers session
 *
 * @author Ishabul Haque
 **/

import java.util.Scanner;

public class Tree {

    // Private member variable which is the root
    // of the ternary tree
    private TreeNode root;

    // An empty instance of the Tree class
    // which sets root to nnull

    public Tree(){
        this.root = null;
    }

    // Constructor of the Tree which sets
    // root to input node
    public Tree(TreeNode root){
        this.root = root;
    }

    /**
     * Accessor method for Tree root
     *
     * @return root of Tree
     */

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Mutator method for Tree root
     *
     * @param root root of TreeNode
     * @postcondition Sets root of Tree
     */

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * getNodeReference() Returns a reference to the TreeNode that has the
     * given label. The return value is null if the label is not found.
     * @param label
     * @return Returns a reference to TreeNode
     */

    public TreeNode getNodeReference(String label){

        TreeNode newNode;

        // Visit root and check if it's null
        if(root.getLabel().equals(label)){
            return root;
        }

        else if(root == null){
            return null;

        }

        //Visit left node and check if it's null
        if(root.getLeft() != null){

            newNode = new Tree(root.getLeft()).getNodeReference(label);
            if(newNode != null){
                return newNode;
            }
        }

        //Visit middle node and check if it's null
        if(root.getMiddle() != null){

            newNode = new Tree(root.getMiddle()).getNodeReference(label);
            if(newNode != null){
                return newNode;
            }
        }

        //Visit right node and check if it's null
        if(this.root.getRight() != null){

            newNode = new Tree(root.getRight()).getNodeReference(label);
            if(newNode != null){
                return newNode;
            }
        }

        return null;

    }

    /**
     * addNode() A method to add a TreeNode to the tree. The location
     * will be a child of parentLabel. The child node should be left justified
     * meaning that it should first be placed in the left most TreeNode
     * reference, then the middle, then the right.
     * @param label The "name" of this TreeNode
     * @param prompt The prompt to be displayed to the screen as a
     * possible answer to a question
     * @param message The message to be displayed to the screen
     * @param parentLabel The "name" of the parent of the node
     * @return Returns a value of true or false if a node was added
     * to the tree
     */

    public boolean addNode(String label, String prompt, String message, String parentLabel){

        TreeNode newNode;
        TreeNode cursor;
        boolean status = false;

        if(getNodeReference(parentLabel) == null){
            return status;
        }



        if(label.equals(root)){
            newNode = new TreeNode(label,prompt,message);
            root = newNode;
        }

        else{
            cursor = getNodeReference(parentLabel);
            while(!status){
                if(cursor.getLeft() == null){
                    newNode = new TreeNode(label,prompt,message);
                    cursor.setLeft(newNode);
                    status = true;

                }
                else if(cursor.getMiddle() == null){
                    newNode = new TreeNode(label,prompt,message);
                    cursor.setMiddle(newNode);
                    status = true;
                }
                else if(cursor.getRight() == null){
                    newNode = new TreeNode(label,prompt,message);
                    cursor.setRight(newNode);
                    status = true;
                }
            }
        }
        return status;

    }

    /**
     * preOrder() Traverses the tree in preorder,
     * and prints the contents of the tree to the screen.
     * @return Returns the contents of the tree
     */

    public void preOrder(){

        if(root != null){
            System.out.println(root);
            root.preorder();
            }
        }


    /**
     * beginSession() This method will be used to
     * start the question and answer session.
     * @return Prints the results based on the user's
     * input from the question and answer session
     */

    public void beginSession(){

        Scanner sc = new Scanner(System.in);

        while(root == null){
            System.out.println("Load a File");

        }

        //TreeStack stack = new TreeStack();
        TreeNode cursor = root;
        //stack.push(cursor);


        System.out.println("Help Session Starting...");

        while(!cursor.isLeaf()){

//            int counter = 0;
//            int direction = 0;


//            TreeNode temp = stack.peek();

            System.out.println(cursor.getMessage());




                    if(cursor.getLeft() != null ){
                        System.out.println("1 " + cursor.getLeft().getPrompt());
                    }
                    if(cursor.getMiddle() != null ){
                        System.out.println("2 " + cursor.getMiddle().getPrompt());
                    }
                    if(cursor.getRight() != null ){
                        System.out.println("3 " + cursor.getRight().getPrompt()); }


//                System.out.println("B " + temp.getPrompt());

                System.out.println("0 Exit Session.");



            System.out.println("Choice>");

            char input = sc.next().charAt(0);


            switch(input){

                case '0':

                    System.out.println("Thank you for using this automated help service!");
                    break;
                case '1' :

                    if(cursor.getLeft() != null){
                        cursor = cursor.getLeft();
//                        stack.push(cursor);
//                        direction = 0;
                    }
                    else{
                        System.out.println("Please select another option");
                    }
                    break;

                case '2' :

                    if(cursor.getMiddle() != null){
                        cursor = cursor.getMiddle();
//                        stack.push(cursor);
//                        direction = 1;
                    }
                    else{
                        System.out.println("Please select another option");
                    }
                    break;
                case '3' :

                    if(cursor.getRight() != null){
                        cursor = cursor.getRight();
//                        stack.push(cursor);
//                        direction = 2;
                    }
                    else{
                        System.out.println("Please select another option");
                    }
                    break;
//                case 'B' :
//                    System.out.println("B");
//                    if(direction == 0){
//                        cursor.setLeft(cursor);
//                        cursor = stack.pop();
//
//                    }
//                    if(direction == 1){
//                        cursor.setMiddle(cursor);
//                        cursor = stack.pop();
//
//                    }
//                    if(direction == 2){
//                        cursor.setRight(cursor);
//                        cursor = stack.pop();
//                    }
//
//                    break;

                default:

                    System.out.println("Please input a valid choice");
            }
        }

        System.out.println("\n" + cursor.getMessage());
        System.out.println("\nThank you for using this automated help service!");

        }
    }

























