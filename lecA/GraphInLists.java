package comp2011.lecA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import comp2011.lec4.Queue;

public class GraphInLists extends Graph {
	private int order; // the number of vertices
	private List[] aLists;

    public GraphInLists(String inputFile) {
    	File f = new File(inputFile);
    	try {
    		FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            StringTokenizer token = new StringTokenizer(br.readLine()," ");
            token.nextToken();
            int n = Integer.valueOf(token.nextToken());
            aLists= new List[n];
            for(int i=0 ;i<order;i++) {
    			aLists[i] = new List();
    		}
            while((token = new StringTokenizer(br.readLine(),",")) != null ) {
            	int a = Integer.valueOf(token.nextToken());
            	int b = Integer.valueOf(token.nextToken());
            	aLists[a].insertAtFront(b);
            	aLists[b].insertAtFront(a);
            }
            br.close();
    	}catch (Exception e) {
    		
    	}
    }
    public GraphInLists(int order) {
    	aLists= new List[order];
    	for(int i=0 ;i<order;i++) {
			aLists[i] = new List();
		}
    	this.order = order;
    }

	public GraphInLists(boolean[][] aMatrix) {
		this.order = aMatrix.length;
		aLists= new List[order];
		for(int i=0 ;i<order;i++) {
			aLists[i] = new List();
		}
		for(int i = 0;i<order;i++) {
			for(int j = 0;j<order;j++) {
				if(aMatrix[i][j]) {
					aLists[i].insertAtFront(j);
				}
			}
		}
		
	}

	// You need to check whether the edge is arealdy there.
	// It's not a problem for matrix version. Why?
	public void addEdge(int a, int b) {
		if(aLists[a].search(b)!=null)return;
		aLists[a].insertAtFront(b);
		aLists[b].insertAtFront(a);
	}

	public boolean isAdjacent(int a, int b) {
		if(aLists[a].search(b)!=null)return true;
		return false;
		}

	// return the degree of vertex a.
	public int degree(int a) { 
		return aLists[a].length(); }

	// return the total number of edges in the graph.
	public int size() { 
		int sol = 0;
		for(List i:aLists) {
			sol += i.length();
		}
		return sol/2; }

	// check whether the graph contains a triangle
	// i.e., three vertices pairwise adjacent
	public boolean triangle() { 
		for (int i = 0; i < order; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++)
                    if (isAdjacent(i,j) && isAdjacent(i,k) && isAdjacent(j,k))
                        return true;
            	}
            }
		return false; 
		}

	
	// breadth-first search
	public void bfs(int a) {

		Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(a);
        // boolean[] visited = new boolean[order];// in Java, false by default.
        // visited[a] = true;
        int[] visited = new int[order];
        for (int i = 0; i < order; i++) visited[i]=-1;
        visited[a] = 0;
        int count = 1;
        int[] parent = new int[order];
        parent[a] = -1;
        int[] distance = new int[order];
        distance[a] = 0;
        //int countDepth = 1;
        while( !queue.isEmpty() ) {
            int v = (int) queue.dequeue();
            for (int i = 0; i < order; i++) {
                if (isAdjacent(i,v) && visited[i] < 0) {
                    System.out.println(v + " discovers " + i);
                    visited[i] = count++;
                    parent[i] = v;
                    queue.enqueue(i);
                    distance[i] = distance[v] + 1;
                }
            }
        }
        System.out.println("order of visiting: " + Arrays.toString(visited));
        System.out.println("depth:"+Arrays.toString(distance));
        System.out.println("discovered by " + Arrays.toString(parent));
		
		
	}

	// you don't need to write this in lab11.
	// depth-first search
	public void dfs(int a) { }

	// print out the adjacency list
	public void display() {
		for (int i = 0; i < order; i++) {
			System.out.println(aLists[i]);
		}
	}

	public static void main(String[] args) {
		boolean[][] m1 = { { false, false, false, true, false, false, false, false },
				{ false, false, false, true, true, false, false, false },
				{ false, false, false, false, true, false, false, false },
				{ true, true, false, false, false, true, false, false },
				{ false, true, true, false, false, false, true, false },
				{ false, false, false, true, false, false, true, true },
				{ false, false, false, false, true, true, false, true },
				{ false, false, false, false, false, true, true, false } };
		GraphInLists graph1 = new GraphInLists(m1);
		System.out.println("Breadth-first search: ");
		graph1.bfs();
		System.out.println("Depth-first search: ");
		graph1.dfs();

		boolean[][] m2 = new boolean[8][8];
		m2[0][3] = m2[3][0] = true;
		m2[1][3] = m2[3][1] = true;
		m2[1][4] = m2[4][1] = true;
		m2[2][4] = m2[4][2] = true;
		m2[3][5] = m2[5][3] = true;
		m2[4][6] = m2[6][4] = true;
		m2[5][6] = m2[6][5] = true;
		m2[5][7] = m2[7][5] = true;
		m2[6][7] = m2[7][6] = true;
		GraphInLists graph2 = new GraphInLists(m2);
		System.out.println("Breadth-first search: ");
		graph2.bfs();
		System.out.println("Depth-first search: ");
		graph2.dfs();

		GraphInLists graph = new GraphInLists(8);
		System.out.println("The degree of vertex " + 2 + " is " + graph.degree(2) + ".");
		System.out.println(
				"Vertices " + 2 + " and " + 4 + " are" + (graph.isAdjacent(2, 4) ? "" : " not") + " adjacent.");
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.display();
		graph.bfs();
		graph.dfs();
		System.out.println(
				"Vertices " + 2 + " and " + 4 + " are" + (graph.isAdjacent(2, 4) ? "" : " not") + " adjacent.");
		System.out.println("The degree of vertex " + 2 + " is " + graph.degree(2) + ".");
		System.out.println("The graph has " + graph.size() + " edges.");
		// System.out.println(graph.draw());
	}
}
