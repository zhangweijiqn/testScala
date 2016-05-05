package zwj.test106_Set

import scala.collection.mutable

/**
 * Created by Administrator on 2016/2/14 0014.
 * set是不重复元素的集合
 */
object testSet {

  def digits(n:Int):Set[Int]=
    if(n<0)digits(-n)
    else if(n<10)Set(n)
    else digits(n/10)+(n%10)


  def main(args:Array[String]): Unit ={
    //define a set
    val st = Set(5,2,7,3,1)
    //add element
    val st2 = st + 1
    println(st2)  //st中已经存在1，st2不会改变
    val st3 = st + 4
    println(st3)

    println(st)
    println(digits(1234))

    //test HashSet
    val userSet = new mutable.HashSet[String]()
    userSet+="aaa"
    userSet+="bbb"
    println(userSet.contains("aaa"))
  }
}
