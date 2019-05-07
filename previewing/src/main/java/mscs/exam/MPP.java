package mscs.exam;

import java.util.*;

class JustFive{

    private static int num = 0;

    JustFive() throws Exception {
        num++;
        if (num>5)
            throw new Exception("instances are more than 5!!!");

    }


}



public class MPP {

    public static void removeDuplicates(List list){
        if (list==null||list.size()<2)
            return;
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i-1)))
                list.remove(i--);
        }
    }

    public static boolean testForSum(int[] arr,int testInt){
        if (arr==null||arr.length<3)
            return false;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int j = i+1;
            int k = arr.length-1;
            while (j<k){
                if (arr[i]+arr[j]+arr[k]<testInt)
                    j++;
                else if (arr[i]+arr[j]+arr[k]>testInt)
                    k--;
                else{
                    System.out.printf("%d,%d,%d\n",arr[i],arr[j],arr[k]);
                    return true;
                }

            }
            
        }
        return false;
    }

    public static class LikedList<E> {
        class Node<E> {

            public E data;
            public Node<E> next = null;

            Node(E _data) {
                data = _data;
            }
        }

        Node<E> head;
        Node<E> tail;

        LikedList() {
            head = null;
            tail = null;
        }

        public void add(E obj) {
            if (head == null) {
                head = new Node<E>(obj);
                tail = head;
            } else {
                tail.next = new Node<E>(obj);
                tail = tail.next;
            }
        }

        public boolean find(E obj) {
            Node node = head;
            while (node != null) {
                if (node.data.equals(obj))
                    return true;
                node = node.next;
            }
            return false;
        }

        public String toString() {
            String str = "";
            Node node = head;
            while (true) {
                str += node.data;
                node = node.next;
                if (node!=null)
                    str+=",";
                else
                    break;
            }
            return str;
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private static void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main( String[] args ) throws Exception {
        //Test
        List<String> list = new ArrayList<>();
        list.add("good");
        list.add("better");
        list.add("better");
        list.add("better");
        list.add("first");
        list.add("last");
        list.add("last");
        list.add("last");
        list.add("good");
        String[] strArr = {"good","better","better","better","first","last","last","last","good"};
        List<String> list2 = new ArrayList<>(Arrays.asList(strArr));
        removeDuplicates(list);

        for (Object obj:list
        ) {
            System.out.println(obj);
        }

        System.out.println(testForSum(new int[]{5,1,23,21,17,2,3,9,12},22));

        LikedList<String> likedList = new LikedList<>();
        likedList.add("Straight");
        likedList.add("Bent");
        likedList.add("Equals");
        likedList.add("Well");
        likedList.add("Storm");
        System.out.println(likedList.find("Well"));
        System.out.println(likedList.find("storm"));
//        System.out.println(likedList.toString());

        JustFive[] justFives = new JustFive[10];
        for (int i = 0; i < 5; i++) {
            justFives[i] = new JustFive();
        }

        for (List<Integer> arr:permute(new int[]{1, 2, 3})
             ) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
