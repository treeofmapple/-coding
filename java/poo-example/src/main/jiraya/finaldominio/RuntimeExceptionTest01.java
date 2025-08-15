package modificador.finaldominio;

public class RuntimeExceptionTest01 {
	
	int[] nums = new int[10];
	
    public static void main(String[] args) {
        // Checked e Unchecked
        int[] nums = new int[10];
        for(int i = 0; i <= 7; i++) {
        	nums[i] += i;
        	System.out.println(nums[i]);
        }

    }

    public void resizer() {
    	if(nums.length < 10) {
    		int[] newa = new int [12];
    	}
    }
}


// Try to do a proper reziser
