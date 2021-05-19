package chart;

/**
 * @author BAZINGA
 * 单链表
 * root为当前对象的节点
 * 每个节点都包含了下一个节点的对象
 * size为链表节点总数量
 * position用来表示下标
 * 不像C++一样是指针指向，而是用对象来替代指针达到链表效果
 */
public class LinkedListOne<T> {

    private Node root=new Node();
    private Integer size=0;
    private Integer position=0;

//链表初始化

    public LinkedListOne(){
        root.setValue(null);
        root.next=null;
    }

    public LinkedListOne(T obj){
        root.setValue(obj);
        size++;
        root.next=null;
    }

    //单个数据添加

    public void add(T obj){
        if(root.value==null){
            root.setValue(obj);
            return;
        }
        else{
        root.add(obj);}
    }

    //多个数据添加

    public void addList(T[] obj){
        root.addList(obj);
    }

    //获取链表长度

    public Integer getSize(){
        return size;
    }


    //打印整个链表

    public void printList(){
        System.out.println(root.toString());
    }

    //根据下标删除节点

    public void delete(Integer index){
        if(index < 0 || this.size <= index){
            return ;
        }
        if(index == 0){
            Node save = root.next;
            root=null;
            root=save;
            size--;
            return ;
        }else{
            position = 0;
            root.delete(root, index);
        }
    }

    //根据下表查找节点值

    public T getByIndex(Integer index){
        this.position=0;
       return root.getByIndex(index);
    }

    //根据下表插入值

    public void insert(Integer index,T obj){
        this.position=0;
        if(index==0){
            Node in=new Node(obj);
            Node save=new Node();
            save=this.root;
            this.root=in;
            in.next=save;
            return;
        }
        root.insert(obj, index);
    }

    //根据值返回下标

    public Integer getByValue(T obj){
        this.position=0;
        return root.getByValue(obj);
    }


    //判断链表是否为空

    public boolean isEmpty(){
        if(this.root.value==null){
            return true;
        }
        else {
            return false;
        }
}

    /*Node作为一个内部类保存值及下个节点的对象*/

    public class Node {
        private  T value;
        private Node next;

        //节点初始化
        public Node(){
            this.value=null;
            this.next=null;
        }
        public Node(T value) {
            this.value=value;
            this.next=null;
            LinkedListOne.this.size++;
        }

        //在表尾添加单个节点
        public void add(T obj){
            if(this.getNext()==null){
                this.next=new Node(obj);
            }
            else {
                this.next.add(obj);
            }
        }

        //根据下标在特定位置添加节点
        public void insert(T obj,Integer index){

            if((LinkedListOne.this.position++).equals(index-1)){
                Node in=new Node(obj);
                Node save=new Node();
                save.next=this.next;
                this.next=in;
                in.next=save;
            }
            else {
                this.next.insert(obj,index);
            }
        }

        //在链表尾部添加多个节点
        public void addList(T[] obj){
            for(int i=0;i< obj.length;i++){
                if(this.getNext()==null){
                    this.next=new Node(obj[i]);
                }
                else{
                    this.next.add(obj[i]);
                }
            }
        }

        //根据下标删除节点
        public void delete(Node previous,Integer index){
            if((LinkedListOne.this.position++).equals(index)){
                //将下一个节点转交给上一节点
                previous.next=this.next;
                //删除操作
                this.next=null;
                //链表节点数-1
                LinkedListOne.this.size--;
                return;
            }
            else {
                this.next.delete(this,index);
            }
        }

        //按位查找
        public T getByIndex(Integer index){
            if(index.equals(LinkedListOne.this.position++)){
                return this.value;
            }
            else {
                return this.next.getByIndex(index);
            }

        }

        //按值查找
        public Integer getByValue(T obj){
            if(this.value==obj){
                return LinkedListOne.this.position;
            }
            else {
                LinkedListOne.this.position++;
                return this.next.getByValue(obj);
            }

        }

        //设置值
        public void setValue(T value) {
            this.value = value;
        }
        //返回下个对象
        public Node getNext() {
            return next;
        }

        //按顺序打印整个链表
        @Override
        public String toString() {
            if(this.next==null){
                return this.value+" ";
            }
            else
            { return this.value+" "+this.next.toString();}
        }
    }
}
