package chart;


import java.util.Arrays;


/**
 * @author BAZINGA
 * INITIAL_SIZE  数组长度
 * size     数组长度
 * realSize 数组真实长度  下标最大值
 */
public class ArrayListMan<T>{
        private  static final Integer INITIAL_SIZE=5;
        private Integer size=0;
        private Integer realSize=0;
        private T[] arraylist;

        //初始化数组

        public ArrayListMan(Integer initial, T []array){
            size=initial;
            if(initial<=0){
            initial=INITIAL_SIZE;
            }
            arraylist=(T[]) new Object[initial];
            arraylist= Arrays.copyOf(array,array.length);
            realSize=getSize();
        }

        public T[] getArraylist(){
            return arraylist;
        }
        //求长度

        public Integer getSize(){
            realSize=0;
           for(int i=0;i<size;i++)
           {
               if(this.arraylist[i]!=null) {
                   realSize++;
               }
           }
           return realSize;
        }

        //按位查找

        public T getElementByIndex(Integer index){
             if(index<0||index>=size)
            {
                 throw new IndexOutOfBoundsException("数组下标超出界限");
            }
                    return arraylist[index];
         }

         //按值查找

        public Integer getElementBySource(T source){
            for(int i=0;i<realSize;i++)
            {
                if(source==arraylist[i])
                {
                    return i;
                }
            }
            return -1;
        }

        //插入操作

        public void insert(Integer index,T x){
            if(realSize==size-1)
            {
                this.add();
            }
            if(index>=realSize)
            {
                arraylist[index]=x;
            }
            else {
                for(int i=realSize-1;i>index;i--)
                {
                    arraylist[i+1]=arraylist[i];
                }
                arraylist[index]=x;

            }
            }


        //拓展数组

        public void add(){
            arraylist=Arrays.copyOf(arraylist,arraylist.length*2);
        }

        //删除数组中某位元素

    public void delete(Integer index){
            for(int i=index;i<realSize;i++)
            {
                arraylist[i]=arraylist[i+1];
            }
            arraylist[realSize-1]=null;
    }


    public void printList(){
        for(int i=0;i<realSize;i++){
            System.out.println(arraylist[i]);
        }
    }

}
