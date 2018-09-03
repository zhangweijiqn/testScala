package zwj.test107_Match

/**
 * Created by Administrator on 2016/2/16 0016.
 */
abstract class AbstractParams {
  override def toString: String = {
    "AbstractParams"
  }
}

object testMatch {
  //match char
  def testMatchChar(ch:Char): Int ={
    var sign = 0
    val vr = '%'
    sign = ch match{  //match同样有返回值,且可以匹配任何类型
      case '+' =>  1
      case '-' =>  -1
      case '*' =>  2
      case '/' =>  -2
      case `vr` => -3   //注意以小写字母开头的常量要包在反引号中，否则被认为是变量
      case _ if ch.isLetter => println("ch is letter "+ch); 10 //case可以带有守卫]
      case str if Character.isDigit(str)=> println("ch is number "+str);11  //case 变量名，则匹配的表达式会赋值给该变量,str是_ 的一种有变量名的特殊情况
      case _ =>  0  //default,
    }
    sign
  }

  // 类型匹配
  def testMatchType(obj:Any):String={
    obj match{
      case x:Int => "Int"
      case s:String => "String"
      case _:BigInt => "BigInt"
      case _ => "unknown"
    }
  }

  def testCaseClass(): Unit ={
    //简单的将case class用作函数，不用new，继承的 Product类，Product是tuple（元组）的父类
    case class Person(name:String)
    val x = Person("Joy")
    println(x.name)
    println(x.isInstanceOf[Product])

    //样例类用于模式匹配
    abstract class Amount
    case class Dollar(value:Double,unit:String)extends Amount
    case class Currency(value:Double,unit:String)extends Amount
    case object Nothing extends Amount  //case object

    val amt = Currency(1.5,"aaa")
    println(  amt match{
      case Currency(_,u) =>"On noes, I got "+u
//      case Dollar(v,_) => "$"+v
      //      case Nothing => ""
    })
  }

  //case class用于保存参数
  case class Params(
     input: String = null,
     numIterations: Int = 100,
     stepSize: Double = 1.0,
     regParam: Double = 0.01) extends AbstractParams

  val f:PartialFunction[Char,Int]={    case '+' => 1;case '-' => -1; case _ =>0  }

  def main(args: Array[String]) {

    println(testMatchChar('*'))
    println(testMatchChar('0'))
    println(testMatchChar('a'))
    println(testMatchChar('%'))

    //匹配类型 == isInstanceOf
    println(testMatchType("a"))
    println(testMatchType(10))

    //样例类
    testCaseClass
    val defaultParams = Params()
    println("param="+defaultParams.numIterations)
    println(s"param =${defaultParams.stepSize}")  //s""中可以使用变量，形式为：${variable}

    //case用在map中，匹配参数
    (1 to 9).map( x=>(x-1,(x*3).toDouble) ).map{ case (x,y)=> y*10+x }
    (1 to 9).map( x=>(x-1,(x*3).toDouble) ).foreach{ case (x,y)=>println(s"(${x},${y}})")
    }

    //偏函数
    println(f('-'))

  }
}
