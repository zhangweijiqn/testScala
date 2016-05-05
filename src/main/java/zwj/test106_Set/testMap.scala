package zwj.test106_Set

import scala.collection.mutable.HashMap

/**
 * Created by Administrator on 2016/2/15 0015.
 * 集合Iterable-->Seq,Set,Map ；每个会包含mutable,immutable实现
 */
object testMap {

  def main(args:Array[String]): Unit ={
    val imMap = collection.immutable.Map("Hello"->23)
    val mMap = collection.mutable.Map("Hello"->23)

    mMap.foreach(x=>{
      println("("+x._1+","+x._2)    //tuple取元素的时候用_1,_2,...
    })

    //统计字符串中字母出现的次数
    val freq = collection.mutable.Map[Char,Int]()
    for(c<-"Mississippi")freq(c)=freq.getOrElse(c,0)+1


    // HashMap
    val user1Map = new HashMap[Long,Double]
    user1Map+=(1L->1.0)
    user1Map+=(2L->2.0)
    println(user1Map.contains(1L))
    println(user1Map.get(1L).get)

  }

}
