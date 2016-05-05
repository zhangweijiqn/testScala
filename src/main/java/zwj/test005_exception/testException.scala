package zwj.test005_exception

/**
 * Created by Administrator on 2016/2/9 0009.
 */
object testException {

  import scala.math._
  def sqrt_ex(x:Double)={
    if(x>0)sqrt(x)
    else throw new IllegalArgumentException("x should not be negtive!")
  }
  def main(args:Array[String]){

    try{
      sqrt_ex(-1)
    }catch {
      case ex:IllegalArgumentException =>ex.printStackTrace()
      case _:Exception =>println("unknown exception")
    }

    lazy val words = scala.io.Source.fromFile("words").mkString
    try{
      println(words)  //here words start to read file words and throw exceptions
    }catch {
      case ex:Exception=>println("unknown exception")
    }finally {
      println("error found!")
    }
  }

}
