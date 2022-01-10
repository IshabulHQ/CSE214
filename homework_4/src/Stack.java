public class TreeStack {

    public final int capacity  = 50;
    private TreeNode[] stack;
    private int top;

    public TreeStack() {
        top = -1;
        stack = new TreeNode[capacity];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public void push(TreeNode node){

        if(top == capacity - 1){
            System.out.println("Full Stack");
        }
        top++;
        stack[top] = node;
    }

    public TreeNode pop(){
        TreeNode result;
        if(top == -1){
            System.out.println("Empty Stack");
        }
        result = stack[top];
        top--;
        return result;
    }

    public TreeNode peek(){
        TreeNode result;
        if(top == -1){
            System.out.println("Empty Stack");

        }
        result = stack[top];
        return result;
    }

}
