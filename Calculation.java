package Calculator;

public class Calculation{

    public static void main(String[] args){
    
    }
    
    //method for basic operations like addition, subtraction, multiplication and division
    static String calc(String a, String b, String operation){
        double diva = Double.valueOf(a);
        double divb = Double.valueOf(b);
            
        if (a.contains(".") | b.contains(".")){
            double da = Double.valueOf(a);
            double db = Double.valueOf(b);
            
            switch (operation) {
                case "+":
                    double sum = da + db;
                    return String.valueOf(sum);
                case "-":
                    double sub = da - db;
                    return String.valueOf(sub);
                case "x":
                    double mult = da * db;
                    return String.valueOf(mult);
                case "÷":
                    double div = diva / divb;
                    return String.valueOf(div);
                default:
                    return "Error";
            }
            
        } else {
                int ia = Integer.valueOf(a);
                int ib = Integer.valueOf(b);

                switch (operation) {
                    case "+":
                        int sum = ia + ib;
                        return String.valueOf(sum);
                    case "-":
                         int sub = ia - ib;
                        return String.valueOf(sub);
                    case "x":
                        int mult = ia * ib;
                        return String.valueOf(mult);
                    case "÷":
                        double div = diva / divb;
                        return String.valueOf(div);
                    default:
                        return "Error";
                }
            }
    }

   //method for power
    static String power(String nums, float i){
        double num = Math.pow(Double.valueOf(nums), i);
        return String.valueOf(num);
    }

    //negate method
    static String negate(String nums){
        if (nums.contains(".")){
            double num = Double.valueOf(nums) * (-1);
            return String.valueOf(num);
        }

        int num = Integer.valueOf(nums) * (-1);
        return String.valueOf(num);
    }

    

}
