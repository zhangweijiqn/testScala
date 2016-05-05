package zwj.test110_Implicit

/**
 * Created by Administrator on 2016/2/29 0029.
 */

import java.io.File
import scala.io.Source
class RichFile(val file:File){
  def read = Source.fromFile(file.getPath()).mkString
}
object Context{
  implicit def file2RichFile(f:File)= new RichFile(f)
}

object testImplicitTransfer {

  def display(input:String):Unit = println(input)

  implicit def typeConvertor(input:Int):String = input.toString

  implicit def typeConvertor(input:Boolean):String = if(input) "true" else "false"


  def testImplicitFunction(){
    /*（1）当表达式的类型与预期的类型不同时*/
    display("1212") //正常调用display，接收的参数类型为String
    display(12)   //传递的参数类型为Int,会调用隐式转换函数typeConvertor(input:Int)
    display(true)  //传递的参数类型为Boolean，会调用隐式转换函数typeConvertor(input:Boolean)
    /*隐式转换的发生：（一）当前作用域的隐式函数*/

    /*（2）当对象访问一个不存在的成员时*/
    import Context.file2RichFile  //隐式转换的发生：（二） 伴生对象中的隐式函数，一定要引入到方法file2RichFile或者类。_，否则隐式转换不会发生
    new File("README").read
    /*（3）当对象调用某个方法时，方法的参数声明与传入的参数不匹配*/
  }

  def testImplicitFunction2(): Unit ={
//    当对象访问一个不存在的成员时
    class A{}
    class RichA(a:A){
      def rich(): Unit ={
        println("rich method.")
      }
    }
    implicit def a2RichA(a:A) = new RichA(a)
    val a = new A
    a.rich()  //a类型A,没有rich方法，会自动调用implicit方法（接收类型为A的对象，返回类型RichA的对象）
  }

  def testImplicitParam(): Unit ={
    case class Delimiters(left:String,right:String)
    def quote(what:String)(implicit delims:Delimiters)=println(delims.left+what+delims.right)
    implicit val quoteDelimiters = Delimiters("<",">")
    //显式调用
    quote("Bonjour le monde")(Delimiters("<<",">>"))

    //隐式转换
    quote("Bonjour le monde") //编译器会自动去查找类型为Delimiters的隐式值，该值必须是被声明为implicit的值

  }

  def main(args: Array[String]) {

    //   隐 式 函 数
    //testImplicitFunction

    //   隐 式 参 数
    testImplicitParam

  }
}
