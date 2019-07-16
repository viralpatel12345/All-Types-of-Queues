import java.util.*;
import java.io.*; 

class arrayQueue
{
    Scanner sc=new Scanner(System.in);
    protected int queue[] ;
    protected int front, rear, max, len;
     int val;
    
    public arrayQueue(int n) 
    {
        max = n;
        len = 0;
        queue = new int[max];
        front = -1;
        rear = -1;
    }

  public void insert()
 {
   int num;
   System.out.print("\n    Enter the value :- ");
   num=sc.nextInt();
   if(rear==max-1)
  {
      System.out.print("\n    OVERFLOW\n");
  }
   else if(front==-1 && rear==-1) 
  {
  front=rear=0;
  queue[rear]=num;      
  }
  else 
  {     
   rear++;
   queue[rear]=num;        
  }    
}
 

   public void delete()
  {
      
    if(front==-1 || front>rear)
    {
        System.out.print("\n    UNDERFLOW\n");
    }
    else 
   {
      val=queue[front];
      front++;
      if(front>rear)
      front=rear=-1;
      System.out.print("\n\n-------<< VALUE DELETED IS : "+val+" >>--------\n");
     }
       
  }      
  

   public void display()
  { 
         int i;
 
      System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n  QUEUE :-   ");
      if(front==-1)
     {   
       System.out.print("Queue is empty.");
     }

       else {  
               for(i=front;i<=rear;i++) 
                 { 
                     System.out.print("    "+queue[i]);  
                  }                         }
System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
 }
 
    public void peek()
   {
     if(front==-1 || front>rear)
     {
        System.out.print("\n    QUEUE IS EMPTY\n");
     }
      else 
        {  System.out.print("\nThe first value in Queue :- "+queue[front]\n\n");                     
        }     
   }

public void clear()
{

front=rear=-1;

}

}







class Circularqueue
{
   Scanner sc=new Scanner(System.in);
    protected int queuee[] ;
    protected int frontt, rearr, maxx;
    
    
    public Circularqueue(int m) 
    {
        maxx = m;
      
        queuee = new int[maxx];
        frontt = -1;
        rearr = -1;
    }

  public void insert()
 {
   int numm;
   System.out.print("\n    Enter the value :- ");
   numm=sc.nextInt();
   if(frontt==0 && rearr==maxx-1)
  {
      System.out.print("\n    OVERFLOW\n");
  }
   else if(frontt==-1 && rearr==-1) 
  {
  frontt=rearr=0;
  queuee[rearr]=numm;      
  }
  else if(rearr==maxx-1 && frontt!=0) 
  {     
      rearr=0;
     
   queuee[rearr]=numm;        
  }
  else
  {
     rearr++;
      queuee[rearr]=numm;
  }    
}
 

   public int delete()
  {
      int value;   
     if(frontt==-1 && rearr==-1)
    {
        System.out.print("\n    UNDERFLOW\n");  return -1;
    }
      value=queuee[frontt];
    if(frontt==rearr)
   {
      frontt=rearr=-1;
   }
   else if(frontt==maxx-1)  {  frontt=0;    }  else { frontt++; }
   return value; 
       
  }      
  

   public void display()
  { 
         int i;
 
      System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n  QUEUE :-   ");
  if(frontt==-1 && rearr==-1)
  {   
       System.out.print("Queue is empty.");
  }

  else
   {  
                if(frontt < rearr)
              {
             
                for(i=frontt;i<=rearr;i++) 
                   { 
                      System.out.print("    "+queuee[i]);  
                  
                   }                         
              }  
             else
            {

            for(i=frontt;i<maxx-1;i++)
            {
              System.out.print("    "+queuee[i]);
            }
           for(i=0;i<=rearr;i++)
           {
           System.out.print("    "+queuee[i]);
           }
         } 
      }
     

            
System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
 }
 
    public void peek()
   {
      if(frontt==-1 && rearr==-1)
     {
        System.out.print("\n    QUEUE IS EMPTY\n");
     }
      else 
         {
           System.out.print("\n----------<< The first value in Queue :- "+queuee[frontt]+" >>-----------\n\n");                     
         }     
   }

public void clear()
{

frontt=rearr=-1;

}

}











class Task
{
    String d;
    int priority;
    
    
    public Task(String d, int priority)
    {
        this.d = d;
        this.priority = priority; 
    }
    
    public String toString() 
    {
        return "Data : "+ d +"\nPriority : "+ priority;
    }
}
 

class PriorityQueue
{
    private Task[] heap; 
    private int heapSize, capacity;
    int flag=0;  
   
    public PriorityQueue(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }
    
   
   
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
  
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
   
    public int size()
    {
        return heapSize;
    }
    
    public void insert(String d, int priority)
    {
        Task newJob = new Task(d, priority);
 
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;
       System.out.print("\n  data inserted Successfully !");                     
    }
    
    public Task remove()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty())
        {   
            flag=1;
            System.out.println("\n    QUEUE is empty .");
            return null;
        }     
        flag=0;
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
       
        return item;
    }

 
 public void clear()
    {
        heap = new Task[capacity];
        heapSize = 0;
    }   
   
        
}
 







class Dequeue
{
    Scanner ss=new Scanner(System.in);
    protected int q[] ;
    protected int left, right, max;
     int val;
    
    public Dequeue(int dq) 
    {
        max = dq;
       
        q = new int[max];
        left = -1;
        right = -1;
    }
 
public void insert_right()
 {
   int no;
   System.out.print("\n   >> Enter the value to be added :- ");     no=ss.nextInt();
   if((left==0 && right==max-1) || left==right+1)
   {
      System.out.print("\n\n    OVERFLOW\n");
  }
   if(left==-1)
    {
       left=right=0;
    }
   else 
   {
        if(right==max-1)
        {
           right=0;
        }
        else 
        { 
        right=right+1;
        }
    }
    
    q[right]=no;
}

 public void insert_left()
  {
      int no;
      System.out.print("\n   >> Enter the value to be added :- ");     no=ss.nextInt();
   if((left==0 && right==max-1) || left==right+1)
   {
      System.out.print("\n\n    OVERFLOW\n");
  }
   if(left==-1)
    {
       left=right=0;
    }
   else 
   {
        if(left==0)
        {
           left=max-1;
        }
        else 
        { 
          left=left-1;
        }
    }
    
    q[left]=no;
}      

 public void delete_right()
 {
     if(left==-1)
    {
       System.out.print("\n\n   UNDERFLOW\n");
       return;
    }
    System.out.print("\n  Element deleted is "+q[right]);
   if(left==right)
    {
         left=right=-1;    
    }
    else
    {
         if(right==0)
         {
            right=max-1;
         }
         else
         {
             right=right-1;
         }
    }
 }

 public void delete_left()
 {
    if(left==-1)
    {
       System.out.print("\n\n   UNDERFLOW\n");
       return;
    }
    System.out.print("\n  Element deleted is "+q[left]);
   if(left==right)
    {
         left=right=-1;    
    }
    else
    {
         if(left==max-1)
         {
            right=0;
         }
         else
         {
             left=left+1;
         }
    }
 }
    
public void display()
 {
    int f=left,r=right;
   if(f==-1)
   {
     System.out.print("Queue is Empty.");
     return;
   }
   
      System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n  QUEUE :-   ");  
   if(f<=r)
   {
        while(f<=r)
       {
           System.out.print("     "+q[f]);
           f++;
       }
   }  
    else
    {

        while(f<=max-1)
        {
          System.out.print("     "+q[f]);
          f++;
        }
            f=0; 
        while(f<=r)
        {
           System.out.print("     "+q[f]);
           f++;
        }
     }
    System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
 
 } 

 public void clear()
 {

  left=-1;
  right=-1;
 }

}   
 














   
class Project
{
    public static void main(String args[])throws IOException
    {  
      Scanner p=new Scanner(System.in);
      int del,s,sigee,size,choice,ch=0,cho=0,choo=0,chooo=0,choooo=0;
      System.out.print("\n\n------------------------------------------------------------------------<< QUEUE >>------------------------------------------------------------------------\n");
     System.out.print("\n1. LINEAR QUEUE        2. PRIORITY QUEUE        3. CIRCULAR QUEUE      4. DEQUEUE    >> PRESS ANY KEY TO EXIT.");
   System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
    
     System.out.print("\n     Enter your Choice >> ");   choice=p.nextInt();

  if(choice==1)
  {  
      System.out.print("\nEnter the size of the Queue (ARRAY SIZE) :- ");
      s=p.nextInt();
  
       
     arrayQueue e=new arrayQueue(s);
 do
 {

   System.out.print("\n--------------------------------------------------------------------<< LINEAR QUEUE >>---------------------------------------------------------------------\n\n 1. INSERT     2. DISPLAY    3. DELETE      4. PEEK      5. CLEAR      >> PRESS ANY TO EXIT\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
       
          System.out.print("\n\n   >> Enter your choice :- ");  ch=p.nextInt();
          switch(ch)
         {  
    
           case 1:  e.insert();   break;
           case 2: e.display();   break;
           case 3: e.delete();    break;
           case 4: e.peek();      break;
           case 5:e.clear();  System.out.print("\n   Cleared Successfully !\n");   break;   
        } 
    }while(ch==1 || ch==2 || ch==3 || ch==4 || ch==5);
  }
  else if(choice==2)
  {    
          
        System.out.print("\nEnter the size of priority queue :- ");
         sigee=p.nextInt(); 
        
        PriorityQueue pq = new PriorityQueue( sigee );  
 
       
        do    
        {
                   
            System.out.print("\n-------------------------------------------------------------------<< PRIORITY QUEUE >>--------------------------------------------------------------------\n\n");
            System.out.print("1. Insert      ");
            System.out.print("2. Remove      ");
            System.out.print("3. Check empty      ");
            System.out.print("4. Check full      ");
            System.out.print("5. clear     ");
            System.out.print("6. size      >> PRESS ANY KEY TO EXIT.\n-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");   
           
            System.out.print("\n   >> Enter Your choice :- ");
            cho=p.nextInt();            
            switch (cho) 
            {
            case 1 :  
                String v;  int daa; 
                System.out.print("\n  >> DATA =  ");
                v=p.next();
               System.out.print("  >> PRIORITY =  ");
               daa=p.nextInt();
                  pq.insert(v,daa);                                 
                break;                          
            case 2 : 
                pq.remove();      if(pq.flag==0){
                 System.out.print("\n   Data deleted successfully.");}        
               break;        
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
            case 5 : 
                System.out.println("\nPriority Queue Cleared");
                pq.clear();
                break;    
            case 6 : 
                System.out.println("\nSize = "+ pq.size() );
                break;         
                        
            }    
       
       } while (cho==1 || cho==2 || cho==3 || cho==4 || cho==5 || cho==6);               
    }
  else if(choice==3)
   {
          
      System.out.print("\nEnter the size of the Queue (ARRAY SIZE) :- ");
      size=p.nextInt();
     Circularqueue cq=new Circularqueue(size);
   do
   {
    System.out.print("\n------------------------------------------------------------------<< CIRCULAR QUEUE >>-------------------------------------------------------------------\n\n 1. INSERT     2. DISPLAY    3. DELETE      4. PEEK      5. CLEAR      >> PRESS ANY TO EXIT\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
  
          System.out.print("\n   >> Enter your choice :- "); chooo=p.nextInt();
          switch(chooo)
         {  
    
           case 1:  cq.insert();   break;
           case 2:  cq.display();   break;
           case 3:  del=cq.delete(); System.out.print("\n  Value deleted = "+del);    break;
           case 4:  cq.peek();      break;
           case 5:  cq.clear();  System.out.print("\n   Cleared Successfully !\n");   break;   
        } 
    }while(chooo==1 || chooo==2 || chooo==3 || chooo==4 || chooo==5);
      

 }
 else if(choice==4)
 { 
     System.out.print("\n------------------------------------------------------------------------<< DEQUEUE >>-------------------------------------------------------------------------\n\n");
    System.out.print("1. INPUT RESTRICTED DEQUEUE          2. OUTPUT RESTRICTED DEQUEUE              >> PRESS ANY KEY TO EXIT");
System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
   
    System.out.print("\n   >> Enter your choice >> ");
    choo=p.nextInt();
     System.out.print("\nEnter the size of the Queue (ARRAY SIZE) :- ");
      size=p.nextInt();
     Dequeue dqi=new Dequeue(size);
    if(choo==1)
   { 
        
   do
   {
    System.out.print("\n--------------------------------------------------------------<< INPUT RESTRICTED DEQUEUE >>---------------------------------------------------------------\n\n 1. INSERT RIGHT    2. DELETE RIGHT     3. DELETE LEFT      4. DISPLAY      5. CLEAR     >> PRESS ANY TO EXIT\n--------------------------------------------------------------------------------------------------------------------------------------------------\n");
  
          System.out.print("\n   >> Enter your choice :- "); choooo=p.nextInt();
          switch(choooo)
         {  
    
           case 1:  dqi.insert_right();   break;
           case 2:  dqi.delete_right();   break;
           case 3:  dqi.delete_left();    break;
           case 4:  dqi.display();        break;
           case 5:  dqi.clear();  System.out.print("\n   Cleared Successfully !\n");   break;   
        } 
    }while(choooo==1 || choooo==2 || choooo==3 || choooo==4 || choooo==5);
      
       
 }
  else if(choo==2)
  {    

    do
   {
    System.out.print("\n--------------------------------------------------------<< OUTPUT RESTRICTED DEQUEUE >>---------------------------------------------------------\n\n 1. INSERT RIGHT      2. INSERT LEFT      3. DELETE LEFT      4. DISPLAY      5. CLEAR     >> PRESS ANY TO EXIT\n--------------------------------------------------------------------------------------------------------------------------------------------------\n");
  
          System.out.print("\n\n   >> Enter your choice :- "); choooo=p.nextInt();
          switch(choooo)
         {  
    
           case 1:  dqi.insert_right();   break;
           case 2:  dqi.insert_left();   break;
           case 3:  dqi.delete_left();    break;
           case 4: dqi.display(); break; 
           case 5:  dqi.clear();  System.out.print("\n   Cleared Successfully !\n");   break;   
        } 
    }while(choooo==1 || choooo==2 || choooo==3 || choooo==4 || choooo==5);
      
 } 
 else {    System.out.println();    }

}

  else  {   System.out.println();   } 




 }

}
