class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result=numBottles;
        int emtyWb=numBottles;
        while(emtyWb>=numExchange){
            emtyWb=emtyWb-numExchange;
            numExchange+=1;
            result+=1;
            emtyWb+=1;

        }
        return result;
    }
}