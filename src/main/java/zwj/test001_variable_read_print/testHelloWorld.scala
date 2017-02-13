package zwj.test001_variable_read_print

/**
 * Created by Administrator on 2015/12/21 0021.
 */
object testHelloWorld {

  def test(): Unit ={
    //variable define: String (StringOps),Byte,Char,Short,Int,Long,Float,Double,BigInt,BigDecimal: Any
    val counter = 0 //define a constant variable
    //  val counter //error,a variable must be initialized
    //  counter=1 //error, counter can't be changed
    var counter2:Int = 0  //define a variable whose value can be reassigned
    counter2=2
    counter2+=1
    //  counter2++,error,not supported

    //type transfer, use .toXXX, if no parameter,() is not necessary
    val Str = counter2.toString
    Str.toInt

    //lazy value, variable will be initialized the first time we use it
    lazy val words = scala.io.Source.fromFile("D:\\MyProjects\\ScalaTest\\src\\Resources\\words").mkString
    println(words)  //here file words is read

    //three method to print
    print("hello,world!:"+counter)
    println("hello,world:"+counter)
    printf("hello,world:%d\n",counter)

    //methods to read
    val text = readLine("please input a str:")
    println(text)
    println(text(0))  //the first element  = text.apply(0)

    //call functions
    import scala.math._
    sqrt(counter2)
    pow(2,5)
    min(3,Pi)

    //call companion object
    val bigNumber:BigInt=BigInt.probablePrime(100,scala.util.Random)
    println(bigNumber)
    println(bigNumber.toString.charAt(3))
  }
  def main(args: Array[String]) {

    test

  }
}
