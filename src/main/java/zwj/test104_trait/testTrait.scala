package zwj.test104_trait

import java.util.Date

import zwj.test008_class.Person

/**
 * Created by Administrator on 2016/2/11 0011.
 */
//test trait (特质)，类比java中interface
trait Logger {
  def log(msg:String) //abstract method

  def log2(msg:String): Unit ={ //带有实现的方法
    println("logger:"+msg)
  }
}

class ConsoleLogger extends Logger with Serializable{  //class继承特质,多个特质第一个特质extends，其他with
  def log(msg:String){println("ConsoleLogger:"+msg)}   //不要override
}

class LoggedPerson extends Person with Logger {  //
  def log(msg: String): Unit = {
    println("loggedPerson:"+msg)
  }
}

trait TimestampLogger extends Logger{ //在特质中重写抽象方法,
  abstract override def log(msg:String): Unit ={ //抽象方法需要声明为abstract且要override
    super.log(new Date()+" "+msg)   //重写log，这里调用的是super.log
  }
}

trait ShortLogger extends Logger{
  val maxLength = 10
  abstract override def log(msg:String): Unit ={
    super.log( if(msg.length<=maxLength) msg else msg.substring(0,maxLength))
  }
}

object testTrait{

  def main(args:Array[String]): Unit ={
    val doSomeThing = new ConsoleLogger;
    doSomeThing.log("hello")
    doSomeThing.log2("log2")

    val person1 = new LoggedPerson with TimestampLogger with ShortLogger //构造对象的时候加入特质，新的特质log方法会覆盖原有
    person1.log("hello")

    val person2 = new LoggedPerson  with ShortLogger with TimestampLogger//注意执行顺序
    person2.log("hello")  //从最后一个开始被处理
  }

}