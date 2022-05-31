package main;

public class main {
    public static void main(String[] args){
        double xl= args.length!=0? Double.parseDouble(args[0]): 0;
        double xu =args.length!=0 ? Double.parseDouble(args[1]): 4;
        boolean max= args.length == 0 || Boolean.parseBoolean(args[2]);
        System.out.println("Maximo? "+ max);
        razonDorada(max, xl, xu);
    }

    public static void razonDorada(boolean max, double xl, double xu){
        System.out.println("|iteración|    xl     |    xu     |    d      |    x1     |    x2     |   f(x1)   |   f(x2)   |   Error   |");
        double razonDorada, error, d, x1, x2;
        razonDorada = 0.618339;
        int iteracion = 1;
        do{
            d= razonDorada*(xu-xl);
            x1 = xl + d;
            x2 = xu - d;
            error= Math.abs(x2-x1);
            print(iteracion, xl, xu, d, x1, x2, f(x1), f(x2), error);
            if (max){
                if(f(x2)>f(x1)){
                    xu = x1;
                }else{
                    xl = x2;
                }
            }else {
                if(f(x2)<f(x1)){
                    xu = x1;
                }else{
                    xl = x2;
                }
            }
            iteracion++;
        }while (error>0.001);
    }

    public static double f(double x){
        return 2*Math.sin(x)- (Math.pow(x,2)/10);
    }

    public static void print(int iteracion, double xl, double xu, double d, double x1, double x2, double fx1, double fx2, double error){
        System.out.printf("| %-2s      | %+,.6f | %+,.6f | %+,.6f | %+,.6f | %+,.6f | %+,.6f | %+,.6f | %+,.6f |%n",iteracion, xl,xu,d,x1,x2,fx1,fx2,error);
    }
}
