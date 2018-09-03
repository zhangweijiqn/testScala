package zwj.test004_function

/**
 * Created by Administrator on 2016/2/9 0009.
 */
object testFunction {

  //define a function:
  def mul(x:Int,y:Int) = x*y  //没有使用block{  } , =直接定义函数体即可

  def abs(x:Double)={   //parameter type is necessary, notice that there is a symbol =
    if(x>0) x else -x
  }

  //return a value
  def fac(n:Int)={
    var r=1
    for(i<- 1 to n) r=r*i
    r   //  the returned value is the last expression's value：it is a block expression {}
    //we can use 'return r' but it is not necessary
  }

  //recursive funciton with return type
  def fac2(n:Int):Int={  //the type of returned value is needed when the function is a recursive function
    if(n<=0)1 else n*fac2(n-1)
  }

  //defaut param value
  def decorate(str:String,left:String="[",right:String="]")=left+str+right

  //变长参数
  def sum(args:Int*)={
    var result = 0
    for(arg<-args)result+=arg //use for to get each element
    result
  }

  //procedure: no returned value
  def MyPrint(str:String){  //there is no = here
    var  border = "-"*str.length+"--\n"
    println(border+"|"+str+"|\n"+border)
  }

  def sum2(args:Int*):Int={
    if(args.length==0)0
    else args.head+sum2(args.tail:_*) //notice :_*
  }

  def main(args:Array[String]){ //main is a procedure
    println(abs(-1))
    println(fac(5))
    println(fac2(5))

    println(decorate("hello"))
    println(decorate(str="hello",left="<<<",right=">>>")) //指定参数名

    println(sum(1,2,3,4,5))
    println(sum(1 to 5:_*))   // _* treated as sequence

    println(sum2(1,2,3,4,5))
    println(sum2(1 to 5:_*))   // _* treated as sequence

    MyPrint("hello")
  }
}
