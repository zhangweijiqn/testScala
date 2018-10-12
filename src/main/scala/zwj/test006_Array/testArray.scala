package zwj.test006_Array

import scala.collection.mutable
import scala.collection.mutable.{HashSet, ArrayBuffer}
/**
 * Created by Administrator on 2016/2/9 0009.
 * 更多搜索“scala数组操作”
 */
object testArray {

  def getArray(): Unit ={

    val numRuns = 10
    val costs = Array.fill(numRuns)(0.0)  //Array提供的方法，初始化每个元素为0
    costs.foreach(println)


    var activeRuns = new ArrayBuffer[Int] ++ (0 until numRuns)  //初始化元素值为0到numRuns
    activeRuns.foreach(println)

    var parellArr = activeRuns.par    //Returns a parallel implementation of this collection.
  }


  def BaseTest(): Unit ={
    //fixed length array
    val nums = new Array[Int](10) //new Array, Int type , 10 elements, all elements are initilized to 0
    for(i<- 0 until nums.length)nums(i)=i*i //  ()to get element
    for(elem<-nums)print(elem+" ")  //use for to get each element

    val s =Array("Hello","world")
    // 已经提供初始值不需要new, 类型String根据初始值推断出来
    s(0)="goodbye"
    println(s)

    //length changable array
    import scala.collection.mutable.ArrayBuffer
    val b =ArrayBuffer[Int]() //an empty array，调用的是apply方法：apply会new
    val c =new ArrayBuffer[Int] // b and c are the same
    b+=5  //add a element 5 to end of the array b
    b+=(4,3,2,1)  //add elements to end of array b
    b++=Array(-1,-2,-3) //add array to arrayBuffer b
    println(b)

    b.trimEnd(2)  //remove the last 2 elements of arrayBuffer b
    println(b)

    //insert,remove are less effective than += and trimEnd
    b.insert(2,6,7,8) //在下标2之前插入6,7,8
    println(b)

    val arrToString = b.mkString(",")
    println(arrToString)

    b.remove(2) //remove the 3th element
    b.remove(2,2) //remove 3 elements from position 3th
    println(b)

    val d = b.toArray //get array from arrayBuffer
    for(e<-d)print(e+" ")
    println("d="+d.toString)

    val e = d.toBuffer  //get arrayBuffer from array
    println(e)

    //遍历数组
    for(i <- 0.until(b.length).reverse)print(b(i)+" ")  //reverse 反向遍历数组,0.until(b.length)== 0 until b.length
    println
    for(e<-b)print(e+" ")

    //数组去重
    val distinctList = b.distinct

    //判断数组是否可以被重复遍历（scala存在数组遍历完为空的情况）
    println("e is traveled again:"+e.isTraversableAgain)  //false,只能遍历一次
    println("d is traveled again:"+d.isTraversableAgain)  //false,只能遍历一次

    //generate new array from array using guard
    val newArr = for(e<-d if e%2==0)yield 2*e   //for推倒式
    println
    for(e<-newArr)print(e+" ")

    // filter map
    val newArr2 = b.filter(_ % 2==0).map(_*2)   //filter:   ,map:
    println
    for(e<-newArr2)print(e+" ")

    //algorithm
    println("\n"+d.sum)
    println(e.sum)
    println(d.max)
    println(e.min)
    val sorted_d = e.sorted //sort from small to large
    println(sorted_d)
    val eDescending = e.sortWith(_>_) // sort from large to small
    println(eDescending)

    // multi dimension array
    val matrix = Array.ofDim[Double](3,4)
    for(i<- 0 until 3;j<- 0 until 4)
    {
      matrix(i)(j)=i*j
      print(matrix(i)(j)+",")
    }

    //创建不规则的数组
    val triangle = new Array[Array[Int]](10)
    for(i<- 0 until triangle.length)
      triangle(i) = new Array[Int](i+1)
  }

  def testIterable(): Unit ={
    val it = mutable.Iterable(1,2,3,4,69, 90)

    val itb = Iterable(20,40,2,50,69, 90)
    println(existCommon(it.toArray,itb.toArray))

    println("Value of it.size : " + it.size )   //1，注意iterator类型只要被遍历一遍，it就指向了指针末尾，size和length执行后都会

    /*while (it.hasNext){
      println(it.next())
    }*/


  }

  def testIterator(): Unit ={
    val it = Iterator(1,2,3,4,69, 90)

    val itb = Iterator(20,40,2,50,69, 90)

    println("Value of it.length : " + it.length ) //0
    println("Value of it.size : " + it.size )   //1，注意iterator类型只要被遍历一遍，it就指向了指针末尾，size和length执行后都会

    while (it.hasNext){   //it此时遍历为空
      println(it.next())
    }

  }

  def existCommon(iter1: Array[Int],iter2:Array[Int]):Boolean={
    val iter1Set = new HashSet[Int]()
    val smallSet = if(iter1.size>iter2.size)iter2 else iter1
    val bigSet = if(iter1.size>iter2.size)iter1 else iter2
    for(it<-smallSet){
      iter1Set+=it
    }
    for(it<-bigSet){
      if(iter1Set.contains(it))return true
    }
    return false
  }

  def testList(): Unit ={
    //取array中部分数组元素
    (1 to 9).slice(2,6).foreach(print _)
    println

    val list = List(1, 2, 3, 4, 5)
    val combs = list.combinations(3)  //生成2元子列表, C(5,3)=10种组合
    combs.foreach(println)

    val sortData = (1 to 9).map(x=>(x,10-x)).sortBy(_._1).reverse //sortBy默认从小到大，reverse从大到小
    sortData.foreach(println)
    println(list.contains(1))

    val arr = list.toArray
    arr.filterNot(x=>x==1).foreach(println)

  }

  def main(args:Array[String]): Unit ={

//    getArray
//    testIterable
//    testIterable()
    //scala数组与java数组可以相互转换

    testList()


  }

}
