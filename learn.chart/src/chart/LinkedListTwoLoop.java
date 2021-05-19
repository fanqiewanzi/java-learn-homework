package chart;

/**
 * @author BAZINGA
 * 单链表
 * root为当前对象的节点
 * 每个节点都包含了下一个节点的对象
 * size为链表节点总数量
 * position用来表示下标
 * 不像C++一样是指针指向，而是用对象来替代指针达到链表效果
 * 双向循环列表
 */
public class LinkedListTwoLoop<T> {

    private Node root=new Node();
    private Integer size=-1;
    private Integer position=0;
    private String button="\0";

//链表初始化

    public LinkedListTwoLoop(){
        root.setValue(null);
        Node save=new Node(button);
        root.right=save;
        save.left=root;
        save.right=root;
        root.left=null;
        size++;
    }

    public LinkedListTwoLoop(T obj){
        root.setValue(obj);
        Node save=new Node(button);
        root.right=save;
        save.left=root;
        save.right=root;
        root.left=null;
        size++;
    }

    //单个数据添加

    public void add(T obj){
        if(size==1){
            this.root.setValue(obj);

        }else {root.add(obj);}
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
            Node temp = root;
            root = root.right;
            root.left=null;
            this.size--;
            return ;
        }else{
            this.position = 0;
            this.root.delete(root, index);
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
            Node save=root;
            root.right=in;
            in.right=save.right;
            in.left=root;
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
        private Node left;
        private Node right;
        //节点初始化
        public Node(){
            this.value=null;
            this.left=null;
            this.right=null;
        }
        public Node(T value) {
            this.value=value;
            this.left=this;
            this.right=null;
            LinkedListTwoLoop.this.size++;
        }

        public Node(String value) {
            this.value=(T)value;
            this.left=this;
            this.right=null;
            LinkedListTwoLoop.this.size++;
        }

        //在表尾添加单个节点
        public void add(T obj){
            //在表尾添加节点其值必为button
            //当下个对象的值为button时在button前进行插入增加
            if(button.equals(this.right.value)){
                Node save=new Node(obj);
                save.right=this.right;
                save.left=this;
                this.right=save;
            }
            else {
                this.right.add(obj);
            }
        }

        //根据下标在特定位置添加节点
        public void insert(T obj,Integer index){

            if((LinkedListTwoLoop.this.position++).equals(index-1)){
                Node in=new Node(obj);
                //将新增节点的左节点赋值为前一节点
                in.left=this;
                //将新增节点的右节点赋值为前一节点的右节点
                in.right=this.right;
                //将下一节点的左节点赋值为新增节点
                this.right.left=in;
                //将前一节点的右节点赋值为新增节点
                this.right=in;
            }
            else {
                this.right.insert(obj,index);
            }
        }

        //在链表尾部添加多个节点
        public void addList(T[] obj){
            for(int i=0;i< obj.length;i++){
                if(button.equals(this.value)||this.right==null){
                    this.right=new Node(obj[i]);
                }
                else{
                    this.right.add(obj[i]);
                }
            }
        }

        //根据下标删除节点
        public void delete(Node previous,Integer index){
            if((LinkedListTwoLoop.this.position++).equals(index)){
                //将下一个节点转交给上一节点
                previous.left=this.left;
                previous.right=this.right;
                //删除操作
                this.left=null;
                this.right=null;
                //链表节点数-1
                LinkedListTwoLoop.this.size--;
                return;
            }
            else {
                this.right.delete(this,index);
            }
        }

        //按位查找
        public T getByIndex(Integer index){
            if(index.equals(LinkedListTwoLoop.this.position++)){
                return this.value;
            }
            else {
                return this.right.getByIndex(index);
            }

        }

        //按值查找
        public Integer getByValue(T obj){
            if(this.value==obj){
                return LinkedListTwoLoop.this.position;
            }
            else {
                LinkedListTwoLoop.this.position++;
                return this.right.getByValue(obj);
            }

        }

        //设置值
        public void setValue(T value) {
            this.value = value;
        }
        //返回下个对象
        public Node getLeft() {
            return left;
        }

        public Node getRight(){
            return right;
        }

        //按顺序打印整个链表
        @Override
        public String toString() {
            if(button.equals(this.right.value)){
                return this.value+" ";
            }
            else
            { return this.value+" "+this.right.toString();}
        }
    }
}
