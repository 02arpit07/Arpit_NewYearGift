import  java.util.*;
//HERE WE HAVE A MAIN CLASS NAMED NEW YEAR. I HAVE DESIGNED THIS PROGRAM TO MANAGE FOOTBALLS AND CRICKETS TO BE DISTRIBUTED BETWEEN KIDS A DIFFERENT SHOPS
//This is main class
public class Newyear {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Football f=new Football(100,1000,10);
        Bats bat=new Bats(100,1000,5);
        String name[]=new String[4];
        int foot1[]=new int[4];
        int bat1[]=new int[4];
        System.out.println("Enter total 4 entries");
        for (int i=0;i<4;i++)
        {
            System.out.println("enter kid name");
            name[i]=s.next();
            System.out.println("FOOTBALLS??");
            foot1[i]=s.nextInt();
            System.out.println("BATS??");
            bat1[i]=s.nextInt();
        }
        f.classification(foot1,name);
        bat.classification(bat1,name);
        f.print();
        f.print('a');
        bat.print();
        bat.print('a');
    }
}


//FOOTBALL CLASS
class Football extends SportsStuff//INHERITANCE
{
    int total_football;
    int total_weight;
    int d_football[]=new int[Kids.totalKids];
    String nameKids[]=new String[Kids.totalKids];
    private int max;//ENCAPSULATION
    Football(int total,int total_weight,int total_football_weight)
    {
        super(total,total_weight);
        this.total_weight=total_football_weight;
    }
    void classification(int c[],String name[])
    {
        for (int i=0;i<c.length;i++)
        {
            d_football[i]=c[i];
            nameKids[i]=name[i];
        }
    }
    int getTotal_football()
    {
        for (int i=0;i<d_football.length;i++)
            total_football+=d_football[i];
        return total_football;
    }
    int getMax()
    {
        max=d_football[0];
        for (int i=1;i<d_football.length;i++)
        {
            if(d_football[i]>max)
                max=d_football[i];
        }
        return max;
    }
    void print()
    {
        System.out.println("FOOTBALLS");
        System.out.println("Total weight of footballs="+total_weight);
        System.out.println("Total footballs="+getTotal_football());
        System.out.println("Max footballs="+getMax());
        System.out.println("Classification:");
        for (int i=0;i<d_football.length;i++)
        {
            System.out.println(nameKids[i]+" got "+d_football[i]);
        }
    }
    void print(char s)//POLYMORPHISM
    {
        for(int i=0;i<d_football.length;i++)
        {
            for (int j=0;j<d_football.length-i-1;j++)
            {
                if(d_football[j]>d_football[j+1])
                {
                    int temp=d_football[j];
                    d_football[j]=d_football[j+1];
                    d_football[j+1]=temp;
                    String temp1= nameKids[j];
                    nameKids[j]=nameKids[j+1];
                    nameKids[j+1]=temp1;
                }
            }
        }
        System.out.println("After sorting");
        for (int i=0;i<d_football.length;i++)
        {
            System.out.println(nameKids[i]+" got "+d_football[i]);
        }
    }
}

    //BAT CLASS
class Bats extends SportsStuff {
    int total_Bats;
    int total_weight;
    int d_bats[] = new int[Kids.totalKids];
    String KidName[] = new String[Kids.totalKids];
    private int max;
    Bats(int total,int total_weight,int total_bats_weight)
    {
        super(total,total_weight);
        this.total_weight=total_bats_weight;
    }
    void classification(int c[], String name[]) {
        for (int i = 0; i < c.length; i++) {
            d_bats[i] = c[i];
            KidName[i] = name[i];
        }
    }

    public int getMax() {
        max=d_bats[0];
        for (int i=1;i<d_bats.length;i++)
        {
            if(max< d_bats[i])
                max=d_bats[i];
        }
        return max;
    }

    int getTotal_bats()
    {
        for (int i=0;i<d_bats.length;i++)
            total_Bats+=d_bats[i];
        return total_Bats;
    }
    void print() {
        System.out.println("BATS");
        System.out.println("Total weight of bats="+total_weight);
        System.out.println("Total bats="+getTotal_bats());
        System.out.println("Maximum bats"+getMax());
        System.out.println("Classification:");
        for (int i = 0; i < d_bats.length; i++) {
            System.out.println(KidName[i] + " got " + d_bats[i]);
        }
    }

    void print(char s) {
        for (int i = 0; i < d_bats.length; i++) {
            for (int j = 0; j < d_bats.length - i - 1; j++) {
                if (d_bats[j] > d_bats[j + 1]) {
                    int temp = d_bats[j];
                    d_bats[j] = d_bats[j + 1];
                    d_bats[j + 1] = temp;
                    String temp1 = KidName[j];
                    KidName[j] = KidName[j + 1];
                    KidName[j + 1] = temp1;
                }
            }
        }
        System.out.println("After sorting");
        for (int i = 0; i < d_bats.length; i++) {
            System.out.println(KidName[i] + " got " + d_bats[i]);
        }
    }
}


//INTERFACE
interface Kids
{
    static int totalKids=4;
    String name[]=new String[totalKids];
}

//abstract class because it has an abstract method..
abstract class SportsStuff implements Kids
{
    int total;
    int total_weight;

    SportsStuff(){}
    SportsStuff(int total,int total_weight)
    {
        this.total_weight=total_weight;
        this.total=total;
    }
    abstract void classification(int c[],String n[]);
    private void getTotal_weight()//ENCAPSULATION CANT ACCESS THIS METHOD OUTSIDE THIS AND CHILD CLASS
    {
        System.out.println(total_weight);
    }
}
