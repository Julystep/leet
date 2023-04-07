package programmer.interview.golden.code;

/**
 * 三合一
 */
public class Solution18 {

    int[] tripleInOneArray;
    int stackSize;

    public Solution18(int stackSize) {
        this.stackSize=stackSize;
        tripleInOneArray=new int[stackSize*4];
    }

    public void push(int stackNum, int value) {
        if(stackSize==0) return;
        if(tripleInOneArray[stackNum]==stackSize) return;
        tripleInOneArray[tripleInOneArray[stackNum]+stackSize*(stackNum+1)]=value;
        tripleInOneArray[stackNum]++;
    }

    public int pop(int stackNum) {
        if(stackSize==0) return -1;
        if(tripleInOneArray[stackNum]<1) return -1;
        return (tripleInOneArray[stackNum]<1)?-1:tripleInOneArray[tripleInOneArray[stackNum]--+stackSize*(stackNum+1)-1];
    }

    public int peek(int stackNum) {
        if(stackSize==0) return -1;
        return (tripleInOneArray[stackNum]<1)?-1:tripleInOneArray[tripleInOneArray[stackNum]+stackSize*(stackNum+1)-1];
    }

    public boolean isEmpty(int stackNum) {
        if(stackSize==0) return true;
        return tripleInOneArray[stackNum]==0;
    }

}
