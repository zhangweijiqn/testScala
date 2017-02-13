package zwj.test106_Set

import scala.collection.BitSet

/**
 * Created by Administrator on 2016/2/15 0015.
 * Seq保留元素的插入顺序；List不可变列表，LinkedList不可变列表
 */
object testSeq {
  def sum(lst:List[Int]): Int ={
    if(lst==Nil)0 else lst.head+sum(lst.tail)
  }

  def testList: Unit = {
    //define a list
    val digits = List(2, 4)
    //use :: to get a new list, :: 从右向左结合
    val digits2 = 9 :: List(4, 2)
    println(digits2)
    val digits3 = 9 :: 2 :: 4 :: Nil //Nil代表空表
    println(digits3)
    //使用递归遍历
    println(sum(digits2))
    //list自带很多函数实现
    println(digits3.sum)
  }

  def testLinkedHashSet(): Unit ={
    //define a LinkedHashSet,记住元素被插入的顺序:链表实现
    val weekdays = collection.mutable.LinkedHashSet("Monday","Tuesday","Wednesday","Thursday","Friday")
    println(weekdays)
  }

  def testSortedSet(): Unit ={
    //define a SortedSet,对元素进行排序：红黑树实现
    val srtSet = collection.immutable.SortedSet(4,2,5,1,6,3)
    println(srtSet)
  }

  def testLinkedList(): Unit ={
    //define a LinkedList
    val lst = collection.mutable.LinkedList(1,-2,5,-3)
    var cur = lst
    while(cur!=Nil){
      if(cur.elem<0)cur.elem=0  //elem取得头部元素
      cur = cur.next  //next取得尾部所有元素
    }
  }
  def testBitSet(): Unit ={
    val btSet = BitSet(1,3,5)
    println(btSet(1))
    println(btSet(2))
  }


  def main(args:Array[String]): Unit ={
    testList
    testLinkedList
    testLinkedHashSet
    testSortedSet
    testBitSet

    val digits = Set(1,3,5,6)
    // contains
    println(digits contains 0)  //contains 判断某个集是否包含给定的值
    // subsetOf
    println( Set(1,3) subsetOf(digits)) //subsetOf检查一个集合是否被另一个集合包含

    val primes = Set(2,3,5,7)
    //union  |   ++
    println(digits union primes)
    println(digits | primes)
    println(digits ++ primes)

    //intersect &
    println(digits intersect primes)
    println(digits & primes)

    //diff
    println(digits diff primes)
    println(digits &~ primes)

    //Vector  :表示右操作符，是右侧操作元的方法，用于不可变集合生成新的集合，原来集合不变
    val v = Vector(1,2,3):+5
    val v2 = 1+:Vector(1,2,3)

    var numbers = Set(1,2,3)
    numbers+=4
    println(numbers)

    digits++numbers //++来一次添加多个元素

    val names = List("Peter","Paul","Mary")
    // map：将集合中的元素放到一个集合中
    val names_upper = names.map(_.toUpperCase)
    println(names_upper)

    //flatMap:将所有值放在一个集合中
    def ulcase(s:String)=Vector(s.toUpperCase,s.toLowerCase)
    println(names.map(ulcase))  //List(Vector(PETER, peter), Vector(PAUL, paul), Vector(MARY, mary))
    println(names.flatMap(ulcase))  //List(PETER, peter, PAUL, paul, MARY, mary)

    //collect
    val v3 = "-3+4".collect{ case '+' => 1;case '-' => -1}
    println(v3) //Vector(-1, 1) ???

    //foreach:应用到集合中的每个元素
    names.foreach(println)

    //二元函数
    val testLst = List(1,2,4,5)
    println(testLst.reduceLeft(_ - _))  //从左到右进行二元操作，前一次的结果作为下一次与另一个元素初始值
    println(testLst.reduceRight(_ - _))

    println(testLst.foldLeft(0)(_-_))  //从初始值0开始进行二元操作 (0,1,2,4,5)
    println(   (0 /: testLst)(_-_)  )

    println(testLst.foldRight(0)(_-_))
    println(  (testLst :\ 0)(_-_)    )


  }


}
