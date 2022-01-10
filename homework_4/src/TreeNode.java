/**
 * This class stores the data in each node. The data stored is
 * a label, message and prompt
 *
 * @author Ishabul Haque
 **/

public class TreeNode {

    //Private children of the tree

    private TreeNode left;
    private TreeNode right;
    private TreeNode middle;
   // private TreeNode prev;

    //Private string variables

    private String label,message,prompt;

    /**
     * TreeNode() constructs an empty instance of TreeNode class
     * with default values of null
     */

    public TreeNode(){
        this.left = null;
        this.right = null;
        this.label = null;
        this.message = null;
        this.prompt = null;
        //this.prev = null;
    }

    /**
     * This is a Constructor used to create a new TreeNode object
     * which is the first node
     * @param label
     *     The "name" of this TreeNode. It will be used when
     *     constructing the tree.
     * @param message
     *     The message will be displayed to the screen. It
     *     will either be a question or just a normal message.
     * @param prompt
     *     The prompt will be displayed to the screen as a
     *     possible answer to a question.
     */

    public TreeNode(String label, String message, String prompt) {
        this.left = null;
        this.right = null;
        this.middle = null;
       // this.prev = null;
        this.label = label;
        this.message = message;
        this.prompt = prompt;

    }

//    public TreeNode getPrev() {
//        return prev;
//    }
//
//    public void setPrev(TreeNode prev) {
//        this.prev = prev;
//    }

    /**
     * Accessor method for middle node
     *
     * @return Middle Node
     */

    public TreeNode getMiddle() {
        return middle;
    }

    /**
     * Mutator method for info
     *
     * @param middle Middle TreeNode
     * @postcondition Sets middle node
     */

    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    /**
     * Accessor method for left node
     *
     * @return Left Node
     */

    public TreeNode getLeft() {
        return left;
    }

    /**
     * Mutator method for info
     *
     * @param left Left TreeNode
     * @postcondition Sets left node
     */

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Accessor method for right node
     *
     * @return Right node
     */

    public TreeNode getRight() {
        return right;
    }

    /**
     * Mutator method for info
     *
     * @param right Right TreeNode
     * @postcondition Sets right node
     */

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Accessor method for label
     *
     * @return TreeNode label as a String
     */

    public String getLabel() {
        return label;
    }

    /**
     * Mutator method for info
     *
     * @param label TreeNode label as a String
     * @postcondition label is set to input String
     */

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Accessor method for message
     *
     * @return TreeNode message as a String
     */

    public String getMessage() {
        return message;
    }

    /**
     * Mutator method for info
     *
     * @param message TreeNode message as a String
     * @postcondition message is set to input String
     */

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Accessor method for prompt
     *
     * @return TreeNode prompt as a String
     */

    public String getPrompt() {
        return prompt;
    }

    /**
     * Mutator method for info
     *
     * @param prompt TreeNode info as a String
     * @postcondition prompt is set to input String
     */

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * inorder() method for TreeNode
     * @postcondition Prints out the inorder for a tree
     */

    public void inorder(){

        if (this.left != null) {
            left.inorder();
        }

        System.out.println(this);

        if (right != null){
            right.inorder();
        }
    }

    /**
     * preorder() method for TreeNode
     * @postcondition Prints out the preorder for a tree
     */

    public void preorder()
    {
        System.out.println(this);
        if (left != null){
            left.preorder();
        }
        if (middle != null){
            middle.preorder();
        }
        if (right != null){
            right.preorder();
        }
    }

    /**
     * isLeaf() method for TreeNode
     * Checks if a node has any leaves
     *
     * @return True or false if node has a leaf
     */

    public boolean isLeaf() {
        return (
                this.left == null &&
                        this. middle == null &&
                        this.right == null);
    }

    /**
     * toString() method for TreeNode
     * Returns members of TreeNode in a formatted manner
     *
     * @return A String containing the TreeNode members
     */
    @Override
    public String toString() {
        return
                "Label: " + label + "\n" +
                "Prompt: " + prompt + "\n" +
                "Message: " + message + "\n";
    }


}
