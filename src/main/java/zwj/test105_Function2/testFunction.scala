package zwj.test105_Function2

/**
 * Created by Administrator on 2016/2/12 0012.
 */
object testFunction {

  //函数式编程体验
  def testTry(): Unit ={
    import scala.math._
    val num = 3.14
    val fun = sqrt _  //put a funciton into a variable
    println(fun(num))   //call just like the original function

    Array(3.14,1.42,2.0).map(fun) //map method accept a function

    //匿名函数
    val triple = (x:Double) => 3*x  //匿名函数将传给它的参数乘以3
    Array(3.14,1.42,2.0).map(triple)
    Array(3.14,1.42,2.0).map((x:Double)=>3*x) //告诉map：将每个元素乘以3

  }

  //接受另一个函数作为参数的 高阶函数，函数的返回类型为：参数类型
  //传入函数参数为Double，返回类型为Double
  def OperateValue5(f: (Double)=>Double) ={println(f(5))}   //传入的函数对5进行操作

  //返回类型为函数的 高阶函数，注意函数体是匿名函数，在=后面
  //返回函数(x:Double)=>factor*x,factor由参数传递进来
  def mulBy(factor:Double) = (x:Double) => factor*x

  //一些有用的高阶函数
  def testHighLevelFuncs(): Unit ={

    //map:将一个函数应用到某个集合的所有元素，并返回结果
    //foreach:将函数应用到每个元素，无返回结果
    (1 to 9).map( "+" *_).foreach(println _)  //打印1到9个+号，foreach同样接收参数类型为函数

    //filter:输出所有匹配某个特定条件的元素
    (1 to 9).filter( _%2 == 0).foreach(print _)

    //reduceLeft: 接收二元参数，应用到序列中所有元素，从左到右
    //第一个和第二个  _  代表不同的元素
    (1 to 9).reduceLeft(_+_)  //从做到右： ( ...( (1+2) +3) +4 ...

    //sortWith
    "Mary has a little lamb".split(" ").sortWith( _.length < _.length).foreach(println)
  }

  def main(args:Array[String]): Unit ={

    testTry()

    import scala.math._
    OperateValue5(   (x:Double) => 3*x   )  //传送函数作为参数操作某个值

    val quintuple = mulBy(5)    //5作为乘以的因子
    println(quintuple(20))

    //scala会根据高阶函数OperateValue5的参数来推测传入的函数的参数类型，因此参数类型可以省略
    OperateValue5(   (x)=>3*x   )
    //只有一个参数的函数，可以省略参数的()
    OperateValue5(    x=>3*x    )
    //参数在右侧只出现一次，可以用_替换掉参数
    OperateValue5(      3*_     )     //简单易懂：一个将某个值乘以3的函数

    val f = (_:Int)+(_:Int)   // 通配符_后面带有类型，所以代表两个变量，原型：val f = (x:Int,y:Int)=>x+y
    println(f(2,3))

    //使用以上简写注意： （1）参数类型需要已知；（2）只有一个参数；（3）参数在右侧只出现一次
    //  val fun1 = 3*_       //not ok,无法推断参数类型
    val fun2 = 3*(_:Double)  //ok,对_指定类型，从参数指定了类型
    val fun3:(Double)=>(Double)   = _*3   //ok,对变量fun3指定类型，从返回值指定了类型

    testHighLevelFuncs()

    //柯里化：接收两个参数的函数编程接收一个参数的过程，新的函数返回一个以原有第二个参数作为参数的喊
    def mul(x:Int,y:Int) = x*y
    /*          ||           */
    def mulOneATime(x:Int) = (y:Int)=>x*y
    /*          ||           */
    def mulONeATime2(x:Int)(y:Int)=x*y

    mulOneATime(5)(6) //mulOneATime(5)的结果为函数，继续调用(6)
  }
}
