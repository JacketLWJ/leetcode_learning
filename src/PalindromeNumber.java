/**
 * @author 罗文俊
 * 2022/1/25
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new MyPalindromeNumberSolution1().isPalindrome(2012));
    }
}

class MyPalindromeNumberSolution1 {
    public boolean isPalindrome(int x) {
        // 用于记录反转一半的数字
        int revertHalf = 0;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        while(revertHalf < x){
            // 每一次循环都将其中一位
            revertHalf = revertHalf * 10 + (x % 10);
            x /= 10;
            if(revertHalf == x){
                // 如果是偶数位数
                return true;
            }
            if(revertHalf / 10 == x){
                // 如果是奇数位数
                return true;
            }
        }
        return false;
    }
}