
package roundrobin;

public class RR {

    public static void main(String[] args) {
        int p[]={1,2,3,4,5};
        int b_t[]={8,2,7,3,5};
        int q=3;
        findAvgTime(p,b_t,q);
    }

    private static void findAvgTime(int[] p, int[] b_t, int q) {
        int wait_time[]=new int [p.length];
        int total_wait_time=0;
        findWaitingTime(p,b_t,wait_time,q);
        for (int i = 0; i < p.length; i++) {
            total_wait_time=total_wait_time+wait_time[i];
        }
        System.out.println("Avarege waiting time = "+(float)total_wait_time/(float)p.length);
        
    }

    private static void findWaitingTime(int[] p, int[] b_t, int[] wait_time, int q) {
        int remainBurstTime[]=new int[p.length];
        for (int i = 0; i < p.length; i++) {
            remainBurstTime[i]=b_t[i];
        }
            int t=0;
            while (true) {
               boolean done=true;
                for (int i = 0; i < p.length; i++) {
                    if(remainBurstTime[i]>0){
                        done=false;
                        if(remainBurstTime[i] > q){
                            t+=q;
                            remainBurstTime[i]-=q;
                        }else{
                            t=t+remainBurstTime[i];
                            wait_time[i]=t- b_t[i];
                            remainBurstTime[i]=0;
                        }
                    }
                    
                }
                if(done==true){
                    break;
                }
            }
            
        
    }
    
}
