import java.util.*;
public class HydMetro {
    static class Edge{
        int src;
        int dest;
        float dist;
        int time;
        public Edge(int src,int dest,float dist,int time){
            this.src=src;
            this.dest=dest;
            this.dist=dist;
            this.time=time;
        }  
    }
    static ArrayList<Edge>[] graph = new ArrayList[56];
    static Map<Integer, String> Stations = new HashMap<>() {{
        put(0, "Miyapur~R");
        put(1, "JNTU College~R");
        put(2, "KPHB Colony~R");
        put(3, "Kukatpally~R");
        put(4, "Balanagar~R");
        put(5, "Moosapet~R");
        put(6, "Bharat Nagar~R");
        put(7, "Erragadda~R");
        put(8, "ESI Hospital~R");
        put(9, "S.R Nagar~R");
        put(10, "Ameerpet~I");
        put(11, "Panjagutta~R");
        put(12, "Irrum Manzil~R");
        put(13, "Khairatabad~R");
        put(14, "Lakdi-Ka-Pul~R");
        put(15, "Assembly~R");
        put(16, "Nampally~R");
        put(17, "Gandhi Bhavan~R");
        put(18, "Osmania Medical College~R");
        put(19, "M.G Bus Station~I");
        put(20, "Malakpet~R");
        put(21, "New Market~R");
        put(22, "Musarambagh~R");
        put(23, "Dilsukhnagar~R");
        put(24, "Chaitanyapuri~R");
        put(25, "Victoria Memorial~R");
        put(26, "L B Nagar~R");
        put(27, "Rayadurg~B");
        put(28, "Hitec City~B");
        put(29, "Durgam Cheruvu~B");
        put(30, "Madhapur~B");
        put(31, "Peddamma Gudi~B");
        put(32, "Jubilee Hills Check Post~B");
        put(33, "Road No 5 Jubilee Hills~B");
        put(34, "Yusufguda~B");
        put(35, "Madhura Nagar~B");
        put(36, "Begumpet~B");
        put(37, "Prakash Nagar~B");
        put(38, "Rasoolpura~B");
        put(39, "Paradise~B");
        put(40, "Parade Grounds~I");
        put(41, "Secundrabad east~B");
        put(42, "Mettuguda~B");
        put(43, "Tarnaka~B");
        put(44, "Habsiguda~B");
        put(45, "NGRI~B");
        put(46, "Stadium~B");
        put(47, "Uppal~B");
        put(48, "Nagole~B");
        put(49, "Secundrabad West~G");
        put(50, "Gandhi Hospitals~G");
        put(51, "Musheerabad~G");
        put(52, "RTC X Roads~G");
        put(53, "Chikkadpally~G");
        put(54, "Narayanaguda~G");
        put(55, "Sultan Bazaar~G");
    }};
    

    public static void main(String[] args){
        for (int i = 0; i < 56; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add (new Edge (0,1,1.8f,3));graph[1].add (new Edge (1,0,1.8f,3));
        graph[1].add (new Edge (1, 2, 1.5f,3));graph[2].add (new Edge (2, 1, 1.5f,3));
        graph[2].add (new Edge (2, 3, 1.5f,3));graph[3].add (new Edge (3, 2, 1.5f,3));
        graph[3].add (new Edge (3, 4, 1.4f,2));graph[4].add (new Edge (4, 3, 1.4f,2));
        graph[4].add (new Edge (4, 5, 0.7f,2));graph[5].add (new Edge (5, 4, 0.7f,2));
        graph[5].add (new Edge (5, 6, 1f,2));graph[6].add (new Edge (6, 5, 1f,2));
        graph[6].add (new Edge (6, 7, 0.8f,2));graph[7].add (new Edge (7, 6, 0.8f,2));
        graph[7].add (new Edge (7, 8, 1.2f,3));graph[8].add (new Edge (8, 7, 1.2f,3));
        graph[8].add (new Edge (8, 9, 0.7f,2));graph[9].add (new Edge (9, 8, 0.7f,2));
        graph[9].add (new Edge (9,10, 0.7f,1));graph[10].add (new Edge (10,9, 0.7f,1));
        graph[10].add (new Edge (10, 11, 1.1f,2));graph[11].add (new Edge (11, 10, 1.1f,2));
        graph[10].add (new Edge (10, 35, 0.7f,1));graph[35].add (new Edge (35, 10, 0.7f,1));
        graph[10].add (new Edge (10, 36, 1.6f,2));graph[36].add (new Edge (36, 10, 1.6f,2));
        graph[11].add (new Edge (11, 12, 1f,2));graph[12].add (new Edge (12, 11, 1f,2));
        graph[12].add (new Edge (12, 13, 1.2f,3));graph[13].add (new Edge (13, 12, 1.2f,3));
        graph[13].add (new Edge (13, 14, 1.1f,3));graph[14].add (new Edge (14, 13, 1.1f,3));
        graph[14].add (new Edge (14, 15, 1f,2));graph[15].add (new Edge (15, 14, 1f,2));
        graph[15].add (new Edge (15, 16, 0.7f,2));graph[16].add (new Edge (16, 15, 0.7f,2));
        graph[16].add (new Edge (16, 17, 0.8f,2));graph[17].add (new Edge (17, 16, 0.8f,2));
        graph[17].add (new Edge (17, 18, 1f,2));graph[18].add (new Edge (18, 17, 1f,2));
        graph[18].add (new Edge (18, 19, 0.6f,2));graph[19].add (new Edge (19, 18, 0.6f,2));
        graph[19].add (new Edge (19, 20, 0.9f,2));graph[20].add (new Edge (20, 19, 0.9f,2));
        graph[19].add (new Edge (19, 55, 0.7f,2));graph[55].add (new Edge (55, 19, 0.7f,2));
        graph[20].add (new Edge (20, 21,1.1f ,2));graph[21].add (new Edge (21, 20,1.1f ,2));
        graph[21].add (new Edge (21, 22, 1f,2));graph[22].add (new Edge (22, 21, 1f,2));
        graph[22].add (new Edge (22, 23, 1.5f,5));graph[23].add (new Edge (23, 22, 1.5f,5));
        graph[23].add (new Edge (23, 24, 1.1f,2));graph[24].add (new Edge (24, 23, 1.1f,2));
        graph[24].add (new Edge (24, 25, 1.2f,2));graph[25].add (new Edge (25, 24, 1.2f,2));
        graph[25].add (new Edge (25, 26, 1.4f,3));graph[26].add (new Edge (26, 25, 1.4f,3));
        graph[26].add (new Edge (26, 27, 1.4f,3));graph[27].add (new Edge (27, 26, 1.4f,3));
        graph[27].add (new Edge (27, 28, 1.5f,3));graph[28].add (new Edge (28, 27, 1.5f,3));
        graph[28].add (new Edge (28, 29, 0.8f,1));graph[29].add (new Edge (29, 28, 0.8f,1));
        graph[29].add (new Edge (29, 30, 6.9f,2));graph[30].add (new Edge (30, 29, 6.9f,2));
        graph[30].add (new Edge (30, 31, 16.9f,7));graph[31].add (new Edge (31, 30, 16.9f,7));
        graph[31].add (new Edge (31, 32, 0.9f,1));graph[32].add (new Edge (32, 31, 0.9f,1));
        graph[32].add (new Edge (32, 33, 0.6f,1));graph[33].add (new Edge (33, 32, 0.6f,1));
        graph[33].add (new Edge (33, 34, 13.4f,5));graph[34].add (new Edge (34, 33, 13.4f,5));
        graph[34].add (new Edge (34, 35, 1.4f,1));graph[35].add (new Edge (35, 34, 1.4f,1));
        graph[36].add (new Edge (36, 37, 1.4f,2));graph[37].add (new Edge (37, 36, 1.4f,2));
        graph[37].add (new Edge (37, 38, 1.1f,2));graph[38].add (new Edge (38, 37, 1.1f,2));
        graph[38].add (new Edge (38, 39, 1f,2));graph[39].add (new Edge (39, 38, 1f,2));
        graph[39].add (new Edge (39, 40, 1.2f,2));graph[40].add (new Edge (40, 39, 1.2f,2));
        graph[40].add (new Edge (40, 41, 1.6f,3));graph[41].add (new Edge (41, 40, 1.6f,3));
        graph[40].add (new Edge (40, 49, 1.3f,2));graph[49].add (new Edge (49, 40, 1.3f,2));
        graph[41].add (new Edge (41, 42, 1.9f,3));graph[42].add (new Edge (42, 41, 1.9f,3));
        graph[42].add (new Edge (42, 43, 1.3f,3));graph[43].add (new Edge (43, 42, 1.3f,3));
        graph[43].add (new Edge (43, 44, 1.6f,3));graph[44].add (new Edge (44, 43, 1.6f,3));
        graph[44].add (new Edge (44, 45, 0.9f,2));graph[45].add (new Edge (45, 44, 0.9f,2));
        graph[45].add (new Edge (45, 46, 1.2f,2));graph[46].add (new Edge (46, 45, 1.2f,2));
        graph[46].add (new Edge (46, 47, 1.1f,2));graph[47].add (new Edge (47, 46, 1.1f,2));
        graph[47].add (new Edge (47, 48, 1f,2));graph[48].add (new Edge (48, 47, 1f,2));
        graph[49].add (new Edge (49, 50, 1.2f,2));graph[50].add (new Edge (50, 49, 1.2f,2));
        graph[50].add (new Edge (50, 51, 0.9f,2));graph[51].add (new Edge (51, 50, 0.9f,2));
        graph[51].add (new Edge (51, 52, 1.2f,2));graph[52].add (new Edge (52, 51, 1.2f,2));
        graph[52].add (new Edge (52, 53, 0.8f,2));graph[53].add (new Edge (53, 52, 0.8f,2));
        graph[53].add (new Edge (53, 54, 0.9f,2));graph[54].add (new Edge (54, 53, 0.9f,2));
        graph[54].add (new Edge (54, 55, 1.3f,2));graph[55].add (new Edge (55, 54, 1.3f,2));

       Scanner sc=new Scanner(System.in);
       System.out.println("\n\t\t\t****WELCOME TO THE HYDERABAD METRO*****");

        while(true){
	        System.out.println("\t\t\t\t\nLIST OF ACTIONS\n");
	        System.out.println("1. LIST ALL THE STATIONS IN THE MAP");
	        System.out.println("2. GET SHORTEST DISTANCE FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
	        System.out.println("3. GET SHORTEST TIME TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
                System.out.println("4. GET FARE TO TRAVEL FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
		System.out.println("5. GET SHORTEST PATH (DISTANCE WISE) TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
		System.out.println("6. GET SHORTEST PATH (TIME WISE) TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
		System.out.println("7. EXIT THE MENU");
		System.out.print("\nENTER YOUR CHOICE FROM THE ABOVE LIST (1 to 7) : ");
		int choice = -1;
                String str1="";
                String str2="";
                String str3="";
                int a;
                int b;
		try {
		        choice = sc.nextInt();
		} catch(Exception e) {
		          
		}
		System.out.print("\n***********************************************************\n");
		if(choice == 7)
		{
		        System.exit(0);
		}
		switch(choice)
		{
		   case 1:
                        display_Map();
                        break;	
		   case 2:
                        System.out.println("enter source station");
                        a=sc.nextInt();
                        System.out.println("enter destination station");
                        b=sc.nextInt();
                        float val=dijkstra(graph,a,b);
                        if(val==-1){
                                System.out.println("\nThere are no such stations exists");
                                break;
                        }
                        str1=Stations.get(a);
                        str2=Stations.get(b);
                        System.out.println("The shortest distance from "+str1.substring(0,str1.length()-2)+" to "+str2.substring(0,str2.length()-2)+" is:"+val+" KM");
                        break;
				
		    case 3:
                        System.out.println("enter source station");
                        a=sc.nextInt();
                        System.out.println("enter destination station");
                        b=sc.nextInt();
                        int num=dijkstraTime(graph,a,b);
                        if(num==-1){
                                System.out.println("\nThere are no such stations exists");
                                break;
                        }
                        str1=Stations.get(a);
                        str2=Stations.get(b);
                        System.out.println("The shortest time taken to travel from "+str1.substring(0,str1.length()-2)+" to "+str2.substring(0,str2.length()-2)+" is:"+num+" Min");
                        break;
		    case 4:
                        System.out.println("enter source station");
                        a=sc.nextInt();
                        System.out.println("enter destination station");
                        b=sc.nextInt();
                        int count=travelCost(graph,a,b);
                        str1=Stations.get(a);
                        str2=Stations.get(b);
                        System.out.println("The fare to travel from "+str1.substring(0,str1.length()-2)+" to "+str2.substring(0,str2.length()-2)+" is:"+count+" INR");
                        break;
		    case 5:
                        System.out.println("enter source station");
                        a=sc.nextInt();
                        System.out.println("enter destination station");
                        b=sc.nextInt();
                        List<Integer> pathList=shortestDistPath(graph, a,b);
                        str1=Stations.get(a);
                        str2=Stations.get(b);
                        System.out.println("The shortest path from "+str1.substring(0,str1.length()-2)+" to "+str2.substring(0,str2.length()-2)+" according to Distance is:\n");
                        for(int li:pathList){
                            str3=Stations.get(li);
                            if(li== pathList.get(pathList.size()-1)){
                                System.out.print(str3.substring(0,str3.length()-2)+"\n");
                            }else{
                                System.out.print(str3.substring(0,str3.length()-2)+"->");
                            }
                         }
                        break;
		    case 6:
                        System.out.println("enter source station");
                        a=sc.nextInt();
                        System.out.println("enter destination station");
                        b=sc.nextInt();
			List<Integer> list=shortestTimePath(graph, a,b);
                        str1=Stations.get(a);
                        str2=Stations.get(b);
                        System.out.println("The shortest path from "+str1.substring(0,str1.length()-2)+" to "+str2.substring(0,str2.length()-2)+" according to Time is:\n");
                        for(int li:list){
                            str3=Stations.get(li);
                            if(li== list.get(list.size()-1)){
                               System.out.print(str3.substring(0,str3.length()-2)+"\n");
                             }else{
                                  System.out.print(str3.substring(0,str3.length()-2)+"->");
                             }
                        }
			break;	
               	    default:
                    	System.out.println("Please enter a valid option! ");
                        System.out.println("The options you can choose are from 1 to 6. ");         
		}
	}

    }
	
    public static void display_Map(){
        System.out.println("\n\t\t\tWELCOME TO HYDERABAD METRO MAP");
        System.out.println("\nRED LINE STATIONS\n");
        String str="";
        for(int val:Stations.keySet()){
            str=Stations.get(val);
            if(str.substring(str.length()-1).equals("R")){
                System.out.println(val+"\t"+str.substring(0,str.length()-2));
            }
        }
        System.out.println("\nGREEN LINE STATIONS\n");
        for(int val:Stations.keySet()){
            str=Stations.get(val);
            if(str.substring(str.length()-1).equals("G")){
                System.out.println(val+"\t"+str.substring(0,str.length()-2));
            }
        }
        System.out.println("\nBLUE LINE STATIONS\n");
        for(int val:Stations.keySet()){
            str=Stations.get(val);
            if(str.substring(str.length()-1).equals("B")){
                System.out.println(val+"\t"+str.substring(0,str.length()-2));
            }
        }
        System.out.println("\nINTERCHANGE STATIONS\n");
        for(int val:Stations.keySet()){
            str=Stations.get(val);
            if(str.substring(str.length()-1).equals("I")){
                System.out.println(val+"\t"+str.substring(0,str.length()-2));
            }
        }
    }
    
    static class Pair implements Comparable<Pair>{
        int node;
        float wt;
        public Pair(int node, float wt){
            this.node = node;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair p2) {
            return  (int)(this.wt-p2.wt);
        }
    }
	
    public static float dijkstra(ArrayList<Edge>graph[],int src,int target)
    {
        if(!Stations.containsKey(src) || !Stations.containsKey(target)){
            return -1;
        }
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       float distance[]=new float[graph.length];
       boolean vis[]=new boolean[graph.length];
       
       for(int i=0;i<distance.length;i++)
       {
           if(i!=src)
           {
             distance[i]=Integer.MAX_VALUE;
           }
       }
       pq.add(new Pair(src,0));
       
       while(!pq.isEmpty())
       {
         Pair curr=pq.remove();
         if(vis[curr.node]==false)
         {
             vis[curr.node]=true;
             
           for(int i=0;i<graph[curr.node].size();i++)
           {
               Edge e= graph[curr.node].get(i);
               int u= e.src;
               int v=e.dest;
               if(!vis[v] && distance[u]+e.dist<distance[v])  
               {
                   distance[v]=distance[u]+e.dist;
                    pq.add(new Pair(v,distance[v]));
               }
               
           }
         }
       }
       return distance[target];
    }
	
    public static int dijkstraTime(ArrayList<Edge>graph[],int src,int target)
    {
        if(!Stations.containsKey(src) || !Stations.containsKey(target)){
            return -1;
        }
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       int times[]=new int[graph.length];
       boolean vis[]=new boolean[graph.length];
       times[src]=0;
       for(int i=0;i<times.length;i++)
       {
           if(i!=src)
           {
             times[i]=Integer.MAX_VALUE;
           }
       }
       pq.add(new Pair(src,0));
       
       while(!pq.isEmpty())
       {
         Pair curr=pq.remove();
         if(vis[curr.node]==false)
         {
             vis[curr.node]=true;
             
           for(int i=0;i<graph[curr.node].size();i++)
           {
               Edge e= graph[curr.node].get(i);
               int u= e.src;
               int v=e.dest;
               if(!vis[v] && times[u]+e.time<times[v]) 
               {
                   times[v]=times[u]+e.time;
                    pq.add(new Pair(v,times[v]));
               }
               
           }
         }
       }
       return times[target];
    }
	
    public static int travelCost(ArrayList<Edge>graph[],int src,int target){
        float len=dijkstra(graph, src, target);
        if(len>0 && len<=2) return 10;
        else if(len>2 && len<=4) return 15;
        else if(len>4 && len<=6) return 25;
        else if(len>6 && len<=8) return 30;
        else if(len>8 && len<=10) return 35;
        else if(len>10 && len<=14) return 40;
        else if(len>14 && len<=18) return 45;
        else if(len>18 && len<=22) return 50;
        else if(len>22 && len<=26) return 55; 
        else if(len>26 && len<=30) return 60;
        else if(len>30 && len<=34) return 65;
        else{
            return -1;
        }
    }
    public static List<Integer> shortestDistPath(ArrayList<Edge> graph[],int src, int target) {
        List<Integer> path = new ArrayList<>();
        if(!Stations.containsKey(src) || !Stations.containsKey(target)){
            path.add(-1);
            return path;
        }
        int n=graph.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        float[] distance = new float[n+1]; 
        int[] parent =new int[n+1]; 
        distance[src]=0;
        for(int i=0;i<distance.length;i++)
       {
           if(i!=src)
           {
             distance[i]=Integer.MAX_VALUE;
           }
           parent[i]=i;
       } 
        pq.add(new Pair(src,0)); 
        while(pq.size() != 0) {
            Pair curr= pq.poll(); 
            
                for(int i=0;i<graph[curr.node].size();i++)
                {
                    Edge e= graph[curr.node].get(i);
                    int u= e.src;
                    int v=e.dest;
                    if( distance[u]+e.dist<distance[v])  
                    {
                        distance[v]=distance[u]+e.dist;
                        pq.add(new Pair(v,distance[v]));
                        parent[v]=curr.node;
                    }
                    
                }
        }  
        if(distance[target] == Integer.MAX_VALUE) {
            path.add(-1); 
            return path; 
        }
        
        int node = target;
        while(parent[node] != node) {
            path.add(node); 
            node = parent[node];   
        }
        path.add(src);
        Collections.reverse(path); 
        return path;
    }
	
    public static List<Integer> shortestTimePath(ArrayList<Edge> graph[],int src, int target) {
        int n=graph.length;
        List<Integer> path = new ArrayList<>();
        if(!Stations.containsKey(src) || !Stations.containsKey(target)){
            path.add(-1);
            return path;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] distance = new int[n+1]; 
        int[] parent =new int[n+1]; 
        distance[src]=0;
        for(int i=0;i<distance.length;i++)
       {
           if(i!=src)
           {
             distance[i]=Integer.MAX_VALUE;
           }
           parent[i]=i;
       } 
        pq.add(new Pair(src,0)); 
        while(pq.size() != 0) {
            Pair curr= pq.poll(); 
            
                for(int i=0;i<graph[curr.node].size();i++)
                {
                    Edge e= graph[curr.node].get(i);
                    int u= e.src;
                    int v=e.dest;
                    if( distance[u]+e.dist<distance[v])  
                    {
                        distance[v]=distance[u]+e.time;
                        pq.add(new Pair(v,distance[v]));
                        parent[v]=curr.node;
                    }
                    
                }
        }
        if(distance[target] == Integer.MAX_VALUE) {
            path.add(-1); 
            return path; 
        }
        
        int node = target;
        while(parent[node] != node) {
            path.add(node); 
            node = parent[node];   
        }
        path.add(src);
        Collections.reverse(path); 
        return path;
    }
        
}
//FARE calculated based on the given info taken from HYD Metro official website
// 0-2 km: 10 INR
// 2-4 km: 15 INR
// 4-6 km: 25 INR
// 6-8 km: 30 INR
// 8-10 km: 35 INR
// 10-14 km: 40 INR
// 14-18 km: 45 INR
// 18-22 km: 50 INR
// 22-26 km: 55 INR
// 26-30 km: 60 INR
// 30-34 km: 65 INR
