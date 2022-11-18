/**
 * christmas
 */
public class christmas {

    public static void main(String[] args) {

        int height = 4;
        int width = 4;
        
        int space = width * height;

        int x = 1;

        for(int a =1;a <= height; a++){
            for(int i = x;i<=width; i++){
                for(int j = space; j >= i; j--){
                    System.out.print(" ");
                }
                
            }
        }
        
    }
}