import java.util.ArrayList;

/**
 * This class is a practice for the solution of Water Pouring Puzzle
 * @author Hackerry
 *
 */
public class ThreePouringProblem {
    private int L1, L2, L3, V1, V2, V3, result;
    private ArrayList<Triple> graph;
    private ArrayList<Integer> path;
    private int step, lastIndex;
    private boolean resultFound;
    
    public ThreePouringProblem(int L1, int L2, int L3, int V1, int V2, int V3, int result) {
        this.L1 = L1; this.L2 = L2; this.L3 = L3; this.V1 = V1; this.V2 = V2; this.V3 = V3; this.result = result;
    }
    
    public void solve() {
        if(graph == null) graph = new ArrayList<>();
        else graph.clear();
        if(path == null) path = new ArrayList<>();
        else path.clear();
        
        if(V1 == result || V2 == result || V3 == result) {
            System.out.println("(" + V1 + "," + V2 + "," + V3 + ")");
            System.out.println("Solution is obvious...");
            return;
        }
        
        graph.add(new Triple(V1, V2, V3));
        path.add(-1);
        resultFound = false;
        
        Triple temp;
        int index = 0;
        while(index != graph.size() && !resultFound) {
            temp = graph.get(index);
            generatePossible(temp, index);
            index++;
            System.out.println("============");
        }
        
        if(!resultFound) {
            System.out.println("Unreachable");
            return;
        }
        
        foundResult();
    }
    
    private void generatePossible(Triple now, int index) {
        if(now.V1 != 0) {
            if(now.V2 != L2) {
                if(now.V1 + now.V2 >= L2) addPossible(new Triple(now.V1+now.V2-L2, L2, now.V3), index);
                else addPossible(new Triple(0, now.V1+now.V2, now.V3), index);
            }
            if(now.V3 != L3) {
                if(now.V1 + now.V3 >= L3) addPossible(new Triple(now.V1+now.V3-L3, now.V2, L3), index);
                else addPossible(new Triple(0, now.V2, now.V1+now.V3), index);
            }
        }
        if(now.V2 != 0) {
            if(now.V1 != L1) {
                if(now.V2 + now.V1 >= L1) addPossible(new Triple(L1, now.V2+now.V1-L1, now.V3), index);
                else addPossible(new Triple(now.V2+now.V1, 0, now.V3), index);
            }
            if(now.V3 != L3) {
                if(now.V2 + now.V3 >= L3) addPossible(new Triple(now.V1, now.V2+now.V3-L3, L3), index);
                else addPossible(new Triple(now.V1, 0, now.V3+now.V2), index);
            }
        }
        if(now.V3 != 0) {
            if(now.V1 != L1) {
                if(now.V3 + now.V1 >= L1) addPossible(new Triple(L1, now.V2, now.V3+now.V1-L1), index);
                else addPossible(new Triple(now.V3+now.V1, now.V2, 0), index);
            }
            if(now.V2 != L2) {
                if(now.V3 + now.V2 >= L2) addPossible(new Triple(now.V1, L2, now.V3+now.V2-L2), index);
                else addPossible(new Triple(now.V1, now.V3+now.V2, 0), index);
            }
        }
    }
    
    private void addPossible(Triple pos, int index) {
        boolean newTriple = true;
        for(Triple p: graph) {
            if(p.equals(pos)) {
                newTriple = false;
                break;
            }
        }
        
        if(newTriple) {
            graph.add(pos);
            path.add(index);
            System.out.println("Add: " + pos);
            
            if(pos.V1 == result || pos.V2 == result || pos.V3 == result) {
                resultFound = true;
                lastIndex = graph.size()-1;
                System.out.println("Found Result");
            }
        }
    }
    
    private void foundResult() {
        step = 0;
        StringBuilder sb = new StringBuilder();
        while(lastIndex != -1) {
            sb.insert(0, graph.get(lastIndex) + "->");
            lastIndex = path.get(lastIndex);
            step++;
        }
        sb.delete(sb.length()-2, sb.length());
        
        System.out.println(sb.toString() + "\nTotal: " + step + " steps");
    }
    
    public class Triple {
        private int V1, V2, V3;
        
        public Triple(int V1, int V2, int V3) {
            this.V1 = V1; this.V2 = V2; this.V3 = V3;
        }
        
        public String toString() {
            return "(" + V1 + "," + V2 + "," + V3 + ")";
        }
        
        public boolean equals(Triple other) {
            return this.V1 == other.V1 && this.V2 == other.V2 && this.V3 == other.V3;
        }
    }
    
    public static void main(String[] args) {
        ThreePouringProblem tp = new ThreePouringProblem(25, 37, 7, 0, 30, 0, 17);
        tp.solve();
    }
}
