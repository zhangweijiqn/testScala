package zwj.test008_class

/**
 * Created by Administrator on 2016/2/11 0011.
 */

class Personal(val id:Int,var name:String){
  //overide non-abstract method must use override
  override def toString = getClass.getName+":"+"id="+id+",name="+name
}

class Employee(id:Int,name:String,age:Int) extends Personal(id,name){ //id,name前面不用val var
  override def toString  = super.toString+  //super
    "->"+getClass.getName+":"+"id="+id+",name="+name+",age="+age
}

//abstract class
abstract class Personal_base(val name:String){
  val age:Int //define abstract variable
  def id:Int  //define abstract method
}
class Personal_inher(name:String) extends Personal_base(name){
   val age: Int = 27  //可以不写override关键字

  //define abstract variable
   def id: Int = name.hashCode
}
object testInherient extends App{

  //test Personal
  val p = new Personal(1,"zhang")
  println(p)
  //test Employee
  val e = new Employee(2,"wang",20)
  println(e)
  //test isInstanceOf
  if(e.isInstanceOf[Employee]){
    val s = e.asInstanceOf[Employee]  //s的类型为Employee,否则抛异常
    println("s="+s)
  }

  //test 匿名子类
  val alien = new Personal(2,"Fred"){
    def greeting = "My name is Fred"
  }
  println(alien.greeting)

  //test abstract
  val emp = new Personal_inher("Joy")
  println(emp.id)

}
