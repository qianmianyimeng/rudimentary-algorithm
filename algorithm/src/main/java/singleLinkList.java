class singleLinkedList {
    //合并两个有序链表，合并之后链表依然有序
    public static void main(String[] args) {

        //测试
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4=new HeroNode(4,"卡","西");
        HeroNode heroNode5=new HeroNode(50,"pi","ko");
        HeroNode heroNode6=new HeroNode(55,"pg","ko");
        SingleLinkList singleLinkList1=new SingleLinkList();
        SingleLinkList singleLinkList2=new SingleLinkList();

/*
        singleLinkList.add(heroNode1);
        singleLinkList.add(heroNode2);
        singleLinkList.add(heroNode3);
        singleLinkList.add(heroNode4);
*/
        singleLinkList1.addByOrder(heroNode1);
        singleLinkList1.addByOrder(heroNode3);
        singleLinkList2.addByOrder(heroNode5);
        singleLinkList1.addByOrder(heroNode2);
        singleLinkList1.addByOrder(heroNode4);
        singleLinkList2.addByOrder(heroNode6);

//        singleLinkList1.show();

        //展示合并后的链表
        SingleLinkList andList=new SingleLinkList().and(singleLinkList1,singleLinkList2);
        andList.show();

    }
}
    //定义英雄链表
        class SingleLinkList {

        //初始化头结点
        private HeroNode head = new HeroNode(0, "", "");

        //添加节点
        public void add(HeroNode heroNode) {
            //需要一个辅助节点
            HeroNode temp = head;

            //遍历节点，找到最后
            while (true) {

                //当temp的下一个指针为空时
                if (temp.next == null) {
                    break;
                }
                //如果没有找到最后，就将temp后移，继续找
                temp = temp.next;
            }
            //当退出循环时，表示已经找到最后节点的位置
            temp.next = heroNode;
        }
        //有序添加节点
        public void addByOrder(HeroNode heroNode) {
            //需要一个辅助节点
            HeroNode temp = head;
            HeroNode cur;
            Boolean flag = false;
            //遍历节点，找到最后
            while (true) {

                //当temp的下一个指针为空时
                if (temp.next == null) {
                    break;
                }

                if (heroNode.no<temp.next.no) {
                    flag=true;
                    break;
                }

                //如果没有找到最后，就将temp后移，继续找
                temp=temp.next;

            }
            if (flag){
                cur=temp.next;
                temp.next=heroNode;
                heroNode.next=cur;
            }
            if (!flag){
                temp.next = heroNode;
            }
        }

        //显示链表情况
        public void show() {

            //当链表为空时，直接返回为空语句
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //辅助节点
            HeroNode temp = head.next;

            while (true){
                if(temp==null){
                    break;
                }
                System.out.println(temp);
                temp=temp.next;
            }
        }

        //合并链表
        public SingleLinkList and(SingleLinkList singleLinkList1,SingleLinkList singleLinkList2){
            SingleLinkList andList=new SingleLinkList();

            //先取出链表2的头指针，临时标记为temp
            HeroNode temp2=singleLinkList2.head.next;
            HeroNode temp1=singleLinkList1.head.next;
            HeroNode curr=null;

            //先用合并后的链表的头指针指向链表1
            andList.head=singleLinkList1.head;

            //设置一个flag，当为true时，添加在temp1的中间，为false时，追加在temp的最后
            boolean flag2=false;

            //添加链表2的数据进入链表1

            //取出singLinkList2的所有数据
            while(true){

                //当temp2的下一个节点是空时，直接break
                if(temp2.next==null){
                    break;
                }

                //插入在temp中间的话，为true
                while (true) {

                    if (temp1.next==null){
                        break;
                    }
                    //寻找temp2的数在temp1中可插入的位置
                    if (temp2.no<temp1.next.no) {
                        flag2 = true;
                        break;
                    }

                    temp1=temp1.next;
                }

                //在temp1中插入temp的数
                if(flag2){

                    curr=temp1.next;
                    temp1.next=temp2;
                    temp2.next=curr;
                }

                //在temp1的最后追加temp2的数
                if (!flag2) {

                    temp1.next = temp2;
                }

                temp2=temp2.next;
            }

            return andList;
        }

    }

    //创建hero链表
    class HeroNode{
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;

        //使用构造器创建链表
        public HeroNode(int no,String name,String nickname){
            this.no=no;
            this.name=name;
            this.nickname=nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }



