public class simpleBoolean{
    public static void main(String[] args){
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        System.out.println(equal(x, y, z));
    }
    public static boolean equal(int x, int y, int z){
        boolean equal = z == 3 || z == x + y;
        return equal;
    }
}