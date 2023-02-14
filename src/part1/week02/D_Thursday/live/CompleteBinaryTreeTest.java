package part1.week02.D_Thursday.live;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		CompleteBinaryTree tree=new CompleteBinaryTree(9);
		for(char c='A';c<='I';c++)
			tree.add(c);
		
		tree.bfs();
		System.out.println();
		tree.dfs();
	}
}
