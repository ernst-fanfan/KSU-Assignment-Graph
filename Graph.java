import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        int maxNode = 5;
        int [] nodeNum = {0};
        int [] [] temp = new int[maxNode][maxNode];
        boolean exit = false;
        while(!exit) {
            exit = menu(maxNode, temp, nodeNum);
        }
    }

    private static boolean menu(int maxNode, int [] [] temp, int [] nodeNum) {
        int[][] a1;
        System.out.println("\n---MAIN MENU--------\n" +
                "0 – Exit Program\n" +
                "1 – Enter Graph Data\n" +
                "2 – Print Outputs");

        Scanner input = new Scanner(System.in);
        int m_input = input.nextInt();

        boolean exit = false;
        switch (m_input) {
            case 0 -> exit = true;
            case 1 -> nodeNum[0] = enter_data(maxNode, temp);
            case 2 -> {
                int node = nodeNum[0];
                a1 = new int[node][node];
                copy_matrix(temp, a1);
                if (!is_matrix_empty(a1)) {
                    print_output(node, a1);
                } else {
                    System.out.println("\nPlease load matrix!");
                }
            }
            default -> System.out.println("Input out of range. Please select from menu.");
        }
        return exit;
    }

    private static boolean is_matrix_empty(int[][] arr) {
        boolean trig = true;
        for (int[] i : arr) {
            for (int j : i) {
                if (j > 0) {
                    trig = false;
                    break;
                }
            }
        }
        return trig;
    }

    private static void print_output(int nodeNum, int [][] a1){
        int [][] rm = new int[nodeNum][nodeNum];
        int [][] xm = new int[nodeNum][nodeNum];
        copy_matrix(a1, rm);
        copy_matrix(a1, xm);
        xm = build_rm_n(xm, rm, a1, nodeNum);
        System.out.println("\nReachability Matrix:");
        print_matrix(rm);

        //in degrees
        System.out.println("\nIn-degrees:");
        for (int i = 1; i <= nodeNum; i++){
            in_degrees(i, a1);
        }

        //out degrees
        System.out.println("\nOut-degrees:");
        for (int i = 1; i <= nodeNum; i++){
            out_degrees(i, a1);
        }

        //self loops
        System.out.println("\nTotal number of self-loops is " + self_loop(a1));

        //cycles length n
        System.out.println("\nTotal number of cycles of length "+ nodeNum + " edges is " + cycles(nodeNum, xm));

        //paths of length 1
        System.out.println("\nTotal number of paths of length 1 edge is " + paths(1, a1));

        //paths of length n
        System.out.println("\nTotal number of paths of length " + nodeNum + " edge is " + paths(nodeNum, a1));

        //paths of length n
        System.out.println("\nTotal number of paths of length 1 to " + nodeNum + " edge is " + paths(1, rm));

        //cycles length n
        int count = cycles(nodeNum, rm);
        System.out.println("\nTotal number of cycles of length 1 to "+ nodeNum + " edges is " + count);
    }

    private static int paths(int edges, int[][] a1) {
        int count = 0;
        int [][] matrix = new int [a1.length][a1.length];
        copy_matrix(a1, matrix);

        //building boolean matrix
        for(int e = 1; e < edges; e++){
            matrix = multiply_matrix(a1, matrix, a1.length);
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] > 0) {
                    count += ints[j];
                }
            }
        }
        return count;
    }

    private static int cycles(int edges, int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i][i] > 0){
                count += arr[i][i];
            }
        }
        return count;
    }

    private static int self_loop(int[][] a1) {
        int loops = 0;
        for (int i = 0; i < a1.length; i++){
            loops += a1[i][i];
        }
        return loops;
    }

    private static void out_degrees(int i, int[][] a1) {
        int outDegree = 0;
        for(int j = 0; j < a1.length; j++){
            outDegree += a1[i-1][j];
        }
        System.out.println("Node " + i + " out-degree is " + outDegree);
    }

    private static void in_degrees(int i, int[][] a1) {
        int inDegree = 0;
        for (int[] ints : a1) {
            inDegree += ints[i - 1];
        }
        System.out.println("Node " + i + " in-degree is " + inDegree);
    }

    //building N reachability matrix
    private static int[][] build_rm_n(int[][] xm, int[][] rm, int[][] a1, int nodeNum) {
        for (int i = 0; i < nodeNum -1; i++){
            xm = multiply_matrix(a1, xm, nodeNum);
            add_matrix(rm, xm);
        }
        return xm;
    }

    private static void copy_matrix(int[][] a1, int[][] xm) {
        for (int i = 0; i < xm.length; i++){
            System.arraycopy(a1[i], 0, xm[i], 0, xm[i].length);
        }
    }

    private static int[][] multiply_matrix(int[][] a1, int [] [] x, int nodeNum) {
        int [][] arr = new int [nodeNum][nodeNum];
        init_matrix(arr,arr.length);

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                for(int k = 0; k < nodeNum; k++) {
                    arr[i][j] += a1[i][k] * x[k][j];
                }
            }
        }
        return arr;
    }

    private static void print_matrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int [][] add_matrix(int[][] rm, int[][] a1) {
        for (int i = 0; i < rm.length; i++){
            for(int j = 0; j < rm[i].length; j++){
                rm[i][j] = rm[i][j] + a1[i][j];
            }
        }
        return rm;
    }

    private static int enter_data(int maxNodes, int [][] a1) {
        int nodeNum = collect_node_num(maxNodes);
        init_matrix(a1, nodeNum);
        collect_matrix(a1, nodeNum);
        return nodeNum;
    }

    private static void init_matrix(int[][] a1, int nodeNum) {
        for (int i = 0; i < nodeNum; i++ ) {
            for (int j = 0; j < nodeNum; j++) {
                a1[i][j] = 0;
            }
        }
    }

    private static int collect_node_num(int maxNodes){
        int nodeNum = 0;
        boolean validInput = false;
        while(!validInput) {
            System.out.println("How many nodes would you like? (max "+ maxNodes +")");
            Scanner inputNodeNum = new Scanner(System.in);
            nodeNum = inputNodeNum.nextInt();
            if (nodeNum > maxNodes || nodeNum < 1) {
                System.out.println("Invalid input. Please try again.");
            } else {
                validInput = true;
            }
        }
        return nodeNum;
    }
    
    private static void collect_matrix(int [][] a1, int nodeNum){
        for (int i = 0; i < nodeNum; i++ ){
            for (int j = 0; j < nodeNum; j++) {
                boolean goodData = false;
                while (!goodData) {
                    System.out.print("Please enter node data:\t");
                    Scanner inputNodeData = new Scanner(System.in);
                    int data = inputNodeData.nextInt();
                    if (data == 0 || data == 1) {
                        a1[i][j] = data;
                        goodData = true;
                    } else {
                        System.out.println("invalid input");
                    }
                }
            }
        }
    }

}
