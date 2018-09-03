package zwj.test007_map

/**
 * Created by Administrator on 2016/2/10 0010.
 *   提醒： tuple 形式： (1,2.0,"aaa")  取值 x._1, x._2, x._3
 *          array/arrayBuffer 形式： (1,2,3,4,5) 取值 x(1),x(2),x(3),...
 */
object testMap {
  def main(args:Array[String]): Unit ={

    // -> operation
    val vMap = "Kenneth"->1 //  -> 操作符用来创建对偶 (String,Int)
    println(vMap)

    // unmutable map  Map[String,Int]  Map底层数据结构tuple2
    val scores = Map("Alice"->10,"Bob"->3,("Cindy",8),vMap)

    //mutable map Map[String,Int]
    val scores_m=scala.collection.mutable.Map("Alice"->10,"Bob"->3,("Cindy",8),vMap)

    println(scores("Alice"))
    println(scores_m("Bob"))

    //check if a key exists
    val bobsScore = if(scores.contains("Bob")) scores("Bob")else 0
    println(bobsScore)

    val joysScore = scores.getOrElse("Joy",0)
    println(joysScore)

    //change mutable map value
    scores_m("Kenneth")=10

    //add map
    scores_m +=("Fred"->7)
    println(scores_m)

    //remove map
    scores_m -=("Alice")
    println(scores_m)

    //val can't be changed, but we can get a new value-changed map
    val scores_new = scores + ("Bob"->5,"Fred"->6)  //得到一个更新值的新映射，bob被更新，fred被添加进来
    println(scores_new)

    //iterate map
    println("keySet:"+scores.keySet)
    println("values:"+scores.values)
    for((k,v)<-scores)print("("+k+","+v+") ")

    //tree map
    val scores_tree = scala.collection.immutable.SortedMap("Alice"->10,"Bob"->3)
    println(scores_tree)


    //tuple 元组,用于函数返回多个值，元组的父类Product
    val t = (1,3.15,"Fred")
    val first = t._1  //使用._Num来得到tuple元素的值
    val second = t._2
    val third = t._3
    println("("+first+","+second+","+third+")")

    val (first2,second2,third2) = t
//    val (first2,second2,_) = t  // if we don't need third, we can use _ instead
    println("("+first2+","+second2+","+third2+")")
    //example
    println(    "New York".partition(_.isUpper)  )  //返回(String,String)

    // zip拉链操作, 调用zip，产生map
    val symbols = Array("<","-",">")
    val counts = Array(2,10,2)
    val pairs = symbols.zip(counts)
    println(pairs)
    for((s,n)<-pairs)Console.print(s*n)
    val map2 = pairs.toMap
    println(map2)

    val indexedCounts = counts.zipWithIndex //zipWithIndex函数将元素和其所在的下标组成一个pair
    println(indexedCounts)
  }
}
