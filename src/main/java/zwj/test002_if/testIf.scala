package zwj.test002_if

/**
 * Created by Administrator on 2016/2/9 0009.
 */
object testIf {
  def main(args:Array[String]){
    val x = readLine("input a number:").toInt;
    val s = if(x>0)1 else -1  //if expression return a value
    println("s="+s)

    val s1 = if(x>0)"positive" else -1  //s1 is a Any type
    println("s1="+s1)

    val s2 = if(x>0)"positive" else () //() is Unit type
    println("s2="+s2)

    val s3 = if(x>0) 1
             else if (x==0) 0
             else -1
    println("s3="+s3)
    //if using REPL, use :paste  to paste code

    //block expression
    val test={
      s;s1;s2;s3  //the last expression's value
    }
    println("test="+test)

    import scala.math._
    var s4=
    if(x>0){
      val temp = s+2+s3; sqrt(temp)
    }
    else if (x==0){
      0
    }
    else{
      -1
    }
    println("s4="+s4)

    val s5 = s4 = 1
    println("s5="+s5) //  s5=()

  }
}
