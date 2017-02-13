import scala.collection.mutable.ArrayBuffer

object HelloWorld {
  def main(args: Array[String]) {
    var a=ArrayBuffer(1,2,3,4,5,-1,6,7,-2,-3,8)//移除除第一个负数之外的负数
    var first = true
    val indexes=for( i <- 0 until a.length if first || a(i)>=0) yield {
      if(a(i)<0)first=false;i
    }
    for(j <- 0 until indexes.length)a(j)=a(indexes(j))
    a.trimEnd(a.length - indexes.length)
    for(elem<-a)print(elem+" ")
  }
}