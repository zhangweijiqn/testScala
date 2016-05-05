package zwj.test003_for_while

/**
 * Created by Administrator on 2016/2/9 0009.
 */
object test_for {
  def main(args: Array[String]) {
    var n =3
    for(i <- 1 to n){ //val/var is not necessary in for    <-    to
      println("i="+i) //1,2,3
    }

    for(i <- 1 until n){ //  <-  to
      println("i="+i) //1,2
    }

    val s ="hello"
    for(i <- 0 until s.length){ //until to length
      println(s(i))
    }

    for(ch <- s){
      println(ch)
    }

    //to break
    //(1) Boolean variable  (2)return
    /*var isOver:Boolean=true
    for(i <- 1 to 100 ;isOver<-true){
      if(i==10){
        isOver=false; // or directly return
      }
      print(i+" ")
    }*/

    //(2)Breaks object
    import scala.util.control.Breaks._
    breakable{  //breakable module
      for(i <- 1 to 100 ){
        if(i==10){
          break;  //throw a exception to break;
        }
        print(i+" ")
      }
    }

    //multi generator
    for(i<- 1 to 3;j<- 1 to 3){
      println("("+i+","+j+")")  //(1,1)(1,2)(1,3)(2,1)(2,2)(2,3)(3,1)(3,2)(3,3)
    }
    //guard: if
    for(i<- 1 to 3;j<- 1 to 3 if i!=j){
      println("("+i+","+j+")")  //(1,2)(1,3)(2,1)(2,3)(3,1)(3,2)
    }

    //for推导式
    val data = for(i<- 1 to 10)yield i%3
    println("data = "+data) //data = Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  }
}
