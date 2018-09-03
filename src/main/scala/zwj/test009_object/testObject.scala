package zwj.test009_object

/**
 * Created by Administrator on 2016/2/10 0010.
 */
class testObject{
  val id = testObject.newUniqueNumber()   //call companoin object's method
  println("id="+id)
}

object testObject { //companoin object
  //object 单例 静态  伴生对象（与类同名）
  private var lastNumber = 0
  def newUniqueNumber()={lastNumber+=1;lastNumber}

  def main(args:Array[String]): Unit ={
    println(testObject.newUniqueNumber())   //调用方法：   对象.method
    val to = new testObject
  }
}

object SingleObject{  //singleton object
  def main(args:Array[String]): Unit ={
    //main方法类似静态方法
    val actions = Map("open"->DoNothingAction,"save"->DoNothingAction)
    actions("open").redo()
  }
}

//object extends class
abstract class UndoableAction(val description:String){
  def undo():Unit
  def redo():Unit
}

object DoNothingAction extends UndoableAction("Do nothing"){
  override def undo(){println("undo")}
  override def redo(){println("redo")}
}

//test companion object's apply method
class Account private (val id:Int,initialBalance:Double){
  private var balance = initialBalance
  println("id="+id+",balance="+balance)
}
object Account{
  private var lastNumber = 0
  def newUniqueNumber()={lastNumber+=1;lastNumber}
  def apply(initialBalance:Double)=   //利用apply方法来构造Account, var(arg1,arg2,...)会自动调用apply，var不是方法或函数
    new Account(newUniqueNumber(),initialBalance)   //第一个参数由伴生对象生成
  def unapply(input:Account): Unit ={ //同时要定义isEmpty方法
    if(input.balance>0.5)Some(0.5) else Some(input.balance)
  }


  def main(args:Array[String]): Unit ={
    val account = Account(0.6)  //把对象当做函数处理的时候，会自动调用apply函数,Account(0.6)==> Account.apply(0.6)
    val arr = Array("hello","world")  //调用伴生对象apply方法，这里没有使用new Array()
//    val Account(balance) = account  //调用Account.unapply,返回一个balance值赋给Account参数
  }
}

//test main or App
object hello extends App{   //App中包含了main(args:Array[String])
  if(args.length>0)
    println("hello"+args(0))
  else println("hello,world")
}