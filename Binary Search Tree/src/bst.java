//Meg Fernandez myf140030
import java.util.*;
public class bst{
private TreeNode root;
public int del=0;
static Scanner in = new Scanner(System.in);

public bst(){
	root = null;
	
}
	class TreeNode{
		int key; // All keys are in the range 1 to 99
		TreeNode leftChild;
		TreeNode rightChild;
		boolean deleted;
		public TreeNode(int x){
			this.key = x;
			leftChild=null;
			rightChild=null;
			deleted=false;
		}
	}
	void insert(int x){
	//Should insert a new element to a leaf node. If new element is a duplicate then do nothing. If
	//the new element is previously deleted one, then do not add other copy just mark the previous
	//deleted as valid now
			
		TreeNode n = new TreeNode(x);
		if(this.contains(x)){
			TreeNode c = root;
			while(c!=null){
				if(c.key==x){
					c.deleted=false;
				}
				else if(root.key>x){
					c=c.leftChild;
				}
				else{
					c=c.rightChild;
				}
			}
			return;
		}
		if(root == null){
			root = n;
			return;
		}
		TreeNode c = root;
		TreeNode p = null;
		while(true){
			p=c;
			if(c.key>n.key){
				c=c.leftChild;
				if(c==null){
				p.leftChild=n;
				return;
				}
			}
			else{
				c=c.rightChild;
				if(c==null){
					p.rightChild=n;
					return;
				}
			}
		}
	
	}
	
	void delete(int x){
	//Should not remove the element from the tree. It should just mark the element as deleted.
		if(this.contains(x)){
		
		delete(root, x);
		del++;}
		
	}
	TreeNode delete(TreeNode t, int x){
			TreeNode p = t;
			
			if(x<p.key){
				p=delete(p.leftChild,x);
			}
			if(x>p.key){
				p=delete(p.rightChild,x);
			}
			else if(x==p.key){
				
				p.deleted=true;
				return p;
			}
		
		return null;
	}
	TreeNode findMin(){
	//Should return the minimum element, but if it is marked deleted return appropriate minimum
	 return findMin(root);
	}
	TreeNode findMin(TreeNode t){
		
		if(t==null){
			return null;
		}
		TreeNode p=findMin(t.leftChild);
		if(p!=null){
			return p;
		}
		if(t.deleted==false){
			return t;
		}
		return findMin(t.rightChild);
	}
	TreeNode findMax(){
	//Should return the maximum element, but if it is marked deleted return appropriate maximum
		return findMax(root);
	}
	TreeNode findMax(TreeNode t){
		
		if(t==null){
			return null;
		}
		TreeNode p = findMax(t.rightChild);
		if(p!=null){
			return p;
		}
		if(t.deleted==false){
			return t;
		}
		return findMax(root.leftChild);
		
		
	}
	boolean contains(int x){
	//Should return true if a particular element is in the tree and is not marked as deleted
		
		return contains(root, x);
	}
	private boolean contains(TreeNode t, int x){
		if(t==null){
			return false;
		}
		
		if(x==t.key){
			if(t.deleted==true){
				return false;
			}
			return true;
		}
		else if(x<t.key){
			return contains(t.leftChild, x);
		}
		else if(x>t.key)
		{
			return contains(t.rightChild, x);
		}
		return false;
	}
	void InOrderTreeTraversal(){
	//Should print the in order traversal of the tree. Indicating with * symbol for elements that are
	//marked deleted
		inOrder(root);
	}
	void inOrder(TreeNode t){
		if(t!=null){
			inOrder(t.leftChild);
			if(t.deleted==true){
				System.out.println("*"+t.key+" ");
			}
			else{
				System.out.println(t.key+" ");
			}
			inOrder(t.rightChild);
		}
	}
	int Height(){
	//Return the height of the tree, count all the elements even the ones that are marked as deleted
		return height(root);
	}
	int height(TreeNode t){
		if(t==null){
			return 0;
		}
		else{
			return 1+ Math.max(height(t.leftChild), height(t.rightChild));
		}
	}
	int NoOfNodes(){
	//Return size of the tree, count all the elements even the ones that are marked as deleted. And
	//also return the number of deleted elements. 
		int t = NoOfNodes(root);
		int s = this.del;
		System.out.println("The number of nodes is "+t+".\n");
		System.out.println("The number of deleted nodes is "+s+".\n");
	return t;
	}
	int NoOfNodes(TreeNode t){
		if(t==null){
			return 0;
		}
		else{
			int x = 1;
			x +=NoOfNodes(t.leftChild);
			x +=NoOfNodes(t.rightChild);
			return x;
		}
	}
	
	public static void main(String[] args)
	   { bst BST = new bst();
	   String s = "p";
	   while(!(s.equalsIgnoreCase("quit"))){
	   System.out.println("Binary Search Trees:\n"+"1.Insert\n"+
	   "2.Delete\n"+"3.Find Max\n"+"4.Find Min\n"+
		"5.Contains\n"+"6.In order tree traversal\n"+"7.Height\n"+
	   "8. No of nodes\n"+"Please enter a number.\n");
	  
	   
	   s = in.nextLine();
	   
	   if(s.equalsIgnoreCase("1")){
		   System.out.println("What would you like to insert?");
		   s=in.nextLine();
		   BST.insert(Integer.parseInt(s));
		   System.out.println("Done\n");
	   }
	   else if(s.equalsIgnoreCase("2")){
		   System.out.println("What would you like to delete?");
		   s=in.nextLine();
		   BST.delete(Integer.parseInt(s));
		   System.out.println("Done\n");
	   }
	   else if(s.equalsIgnoreCase("3")){
		   TreeNode p = BST.findMax();
		   if(p==null){System.out.println("Nothing in tree.\n");}
		   else{System.out.println("Max is "+p.key+".\n");}
	   }
	   else if(s.equalsIgnoreCase("4")){
		   TreeNode p = BST.findMin();
		   if(p==null){System.out.println("Nothing in tree.\n");}
		   else{System.out.println("Min is "+p.key+".\n");}
	   }
	   else if(s.equalsIgnoreCase("5")){
		   System.out.println("What are you looking for?");
		   s=in.nextLine();
		   System.out.println(BST.contains(Integer.parseInt(s)));
		   
	   }
	   else if(s.equalsIgnoreCase("6")){
		   BST.InOrderTreeTraversal();
	   }
	   else if(s.equalsIgnoreCase("7")){
		   System.out.println(BST.Height());
	   }
	   else if(s.equalsIgnoreCase("8")){
		   System.out.println(BST.NoOfNodes());
	   }
	   else if(s.equalsIgnoreCase("quit")){
		   System.exit(0);
	   }
	   else{
		   System.out.println("Command invalid.\n");
	   }
	   }
	   }
	
	
	
	
	
	
	
	
	
}
